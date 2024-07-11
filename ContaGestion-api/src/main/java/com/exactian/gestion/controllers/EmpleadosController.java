package com.exactian.gestion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactian.gestion.dto.EmpleadoDTO;
import com.exactian.gestion.services.EmpleadosService;

@RestController
@RequestMapping("api/empleados")
@CrossOrigin
public class EmpleadosController {
	
	@Autowired
    private EmpleadosService empleadosService;

	@GetMapping("/listar")
    public ResponseEntity<List<EmpleadoDTO>> registrarIngreso(Authentication authentication) {
        
        return ResponseEntity.ok(empleadosService.listEmpleados());

    }

}
