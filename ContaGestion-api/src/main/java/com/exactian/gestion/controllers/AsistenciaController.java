package com.exactian.gestion.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactian.gestion.dto.AsistenciaRequestDTO;
import com.exactian.gestion.dto.EgresoResponseDTO;
import com.exactian.gestion.dto.ResponseDTO;
import com.exactian.gestion.enums.TipoAsistencia;
import com.exactian.gestion.services.AsistenciaService;

@RestController
@RequestMapping("api/asistencia")
@CrossOrigin
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @PostMapping("/registrarIngreso")
    public ResponseEntity<ResponseDTO> registrarIngreso(@RequestBody AsistenciaRequestDTO request, Authentication authentication) {
        
        String nombreDeUsuario = authentication.getName();

        request.setTipo(TipoAsistencia.Ingreso);
        request.setNombreDeUsuario(nombreDeUsuario);
        
        return ResponseEntity.ok(asistenciaService.registrarIngreso(request));

    }

    @PostMapping("/registrarEgreso")
    public ResponseEntity<EgresoResponseDTO> registrarEgreso(@RequestBody AsistenciaRequestDTO request, Authentication authentication) {
        String nombreDeUsuario = authentication.getName();

        request.setTipo(TipoAsistencia.Ingreso);
        request.setNombreDeUsuario(nombreDeUsuario);
        
        return ResponseEntity.ok(asistenciaService.registrarEgreso(request));

    }

}
