package com.farmacia.medica.medicaCosmo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.medica.medicaCosmo.entities.DTOs.MedicamentoDTO;

@RestController
@RequestMapping("medicamentos")
public class ControllerMedicamento {
	
	//método para cadastrar medicamentos
	@PostMapping
	public void cadastrar(@RequestBody MedicamentoDTO dados) {
		System.out.println(dados);
	}
}
