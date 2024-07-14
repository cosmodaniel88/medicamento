package com.farmacia.medica.medicaCosmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.medica.medicaCosmo.DTOs.DadosAutenticacao;
import com.farmacia.medica.medicaCosmo.DTOs.DadosTokenJWT;
import com.farmacia.medica.medicaCosmo.entities.Usuario;
import com.farmacia.medica.medicaCosmo.services.TokerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class ControllerAutenticacao {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokerService tokenService;
	
	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);
		
		var tkJwt = tokenService.gerarToken( (Usuario) autenticacao.getPrincipal());
		
		return ResponseEntity.ok(new DadosTokenJWT(tkJwt));
	}
}
