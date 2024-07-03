package com.farmacia.medica.medicaCosmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.medica.medicaCosmo.DTOs.ListagemMedicamentosDTO;
import com.farmacia.medica.medicaCosmo.DTOs.MedicamentoDTO;
import com.farmacia.medica.medicaCosmo.DTOs.UpdateDTO;
import com.farmacia.medica.medicaCosmo.services.ServicoMedicamento;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("medicamentos")
public class ControllerMedicamento {
	
	@Autowired
	private ServicoMedicamento servMedicamento;
	
	//método para cadastrar medicamentos
	@PostMapping
	@Transactional //faz o rollback em caso de erros
	public void cadastrar(@RequestBody @Valid MedicamentoDTO dados) {
		servMedicamento.cadastrarMedicamento(dados);
		
	}
	/* */
	@GetMapping
	public List<ListagemMedicamentosDTO> listarTodos(){
		return servMedicamento.listarTodos().stream().map(ListagemMedicamentosDTO::new).toList();
	}
	
	@PutMapping //método para dar update
	@Transactional //for roll back
	public void atualizar(@RequestBody @Valid UpdateDTO dados) {
		servMedicamento.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		servMedicamento.deletar(id);
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional //isso aqui elimna a necessidade do reposotory.save
	public void inativar(@PathVariable Long id) {
		servMedicamento.inativarRegistro(id);
	}
	@PutMapping("ativar/{id}")
	@Transactional
	public void ativar(@PathVariable Long id) {
		servMedicamento.ativarRegistro(id);
	}
}