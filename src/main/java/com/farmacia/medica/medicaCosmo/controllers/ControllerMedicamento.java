package com.farmacia.medica.medicaCosmo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.medica.medicaCosmo.DTOs.DadosAtualizacaoDTO;
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
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid MedicamentoDTO dados) {
		servMedicamento.cadastrarMedicamento(dados);
		
	}
	/* */
	@GetMapping
	public ResponseEntity< List<ListagemMedicamentosDTO>> listarTodos(){
		var lista = servMedicamento.listarTodos().stream().map(ListagemMedicamentosDTO::new).toList();
			
		return ResponseEntity.ok(lista);
		
		}
	
	@PutMapping //método para dar update
	@Transactional //for roll back
	public ResponseEntity<DadosAtualizacaoDTO> atualizar(@RequestBody @Valid UpdateDTO dados) {
		var medicamento = servMedicamento.atualizar(dados);
		
		return ResponseEntity.ok(new DadosAtualizacaoDTO(medicamento));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		servMedicamento.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional //isso aqui elimna a necessidade do reposotory.save
	public  ResponseEntity<Void> inativar(@PathVariable Long id) {
		servMedicamento.inativarRegistro(id);
		
		//O ResponseEntity é utilizado para retornar um código http.
		/*
		 * Por padrão, o retorno, sem o reponse entity, é 200 ok e 404 e 500 erro interno no servidor
		 * Todavia, com esse método, nós podemos escolher o código retornado*/
			
		return ResponseEntity.noContent().build(); /*204 - No cotent - quando um registro é deletado*/
		
		
	}
	@PutMapping("ativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar(@PathVariable Long id) {
		servMedicamento.ativarRegistro(id);
		
		return ResponseEntity.noContent().build();
	}
}