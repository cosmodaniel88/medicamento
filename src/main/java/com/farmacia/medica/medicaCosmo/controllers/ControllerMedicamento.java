package com.farmacia.medica.medicaCosmo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.medica.medicaCosmo.DTOs.MedicamentoDTO;
import com.farmacia.medica.medicaCosmo.services.ServicoMedicamento;

@RestController
@RequestMapping("medicamentos")
public class ControllerMedicamento {
	
	@Autowired
	private ServicoMedicamento servMedicamento;
	
	//método para cadastrar medicamentos
	@PostMapping
	public void cadastrar(@RequestBody MedicamentoDTO dados) {
		servMedicamento.cadastrarMedicamento(dados);
		
	}
}