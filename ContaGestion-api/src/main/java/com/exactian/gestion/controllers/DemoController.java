package com.exactian.gestion.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("api/demo") 
public class DemoController {

	
	@PostMapping("/prueba")
    public String demoMetodo() {
        return "Hola mundo";
    }
	
}
