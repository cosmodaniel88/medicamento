package com.farmacia.medica.medicaCosmo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.medica.medicaCosmo.DTOs.MedicamentoDTO;
import com.farmacia.medica.medicaCosmo.DTOs.UpdateDTO;
import com.farmacia.medica.medicaCosmo.entities.Medicamento;
import com.farmacia.medica.medicaCosmo.repositorys.RepositorioDeMedicamento;

@Service
public class ServicoMedicamento {

	@Autowired
	private RepositorioDeMedicamento repMedicamento;

	public void cadastrarMedicamento(MedicamentoDTO dadosMedicamento) {
		repMedicamento.save(new Medicamento(dadosMedicamento));
	}
	
	public List<Medicamento> listarTodos(){
		return repMedicamento.findAll();
	}
	
	public void atualizar(UpdateDTO dados) {
		
		var medicamento = repMedicamento.getReferenceById(dados.id());
		
		medicamento.atualizarInformacoes(dados);
		
	}
}
