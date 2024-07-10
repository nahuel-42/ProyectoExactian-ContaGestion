package com.exactian.gestion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactian.gestion.dto.AuthResponseDTO;
import com.exactian.gestion.dto.LoginRequestDTO;
import com.exactian.gestion.dto.RegistroRequestDTO;
import com.exactian.gestion.services.LoginService;

@RestController 
@RequestMapping("api/auth") 
public class LoginController{

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request)
    {
        return ResponseEntity.ok(loginService.login(request));
    }
	
	@PostMapping("/logout")
    public String logout() {
        return "Deslogeo desde endpoint publico";
    }
	
	@PostMapping(value = "register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody RegistroRequestDTO request)
    {
        return ResponseEntity.ok(loginService.register(request));
    }
}
