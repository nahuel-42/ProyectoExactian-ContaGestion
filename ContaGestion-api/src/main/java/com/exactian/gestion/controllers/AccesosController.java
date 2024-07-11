package com.exactian.gestion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactian.gestion.dto.AccesoDTO;
import com.exactian.gestion.services.AccesoService;

@RestController
@RequestMapping("api/historico")
@CrossOrigin
public class AccesosController {
	
	@Autowired
	AccesoService accesoService;

    @GetMapping("/listar")
    public ResponseEntity<List<AccesoDTO>> listarHistorico() {
        return ResponseEntity.ok(accesoService.listarHistorico());
    }
}
