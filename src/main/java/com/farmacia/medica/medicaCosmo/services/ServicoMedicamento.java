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

	public Medicamento cadastrarMedicamento(MedicamentoDTO dadosMedicamento) {
		var medicamento = new Medicamento(dadosMedicamento);
		repMedicamento.save(medicamento);

		return medicamento;
	}

	public List<Medicamento> listarTodos() {
		return repMedicamento.findAllByAtivoTrue();
	}

	public Medicamento atualizar(UpdateDTO dados) {

		var medicamento = repMedicamento.getReferenceById(dados.id());

		medicamento.atualizarInformacoes(dados);

		return medicamento;

	}

	public void deletar(Long id) {
		repMedicamento.deleteById(id);
	}

	public Medicamento buscarPorId(Long id) {
		return repMedicamento.getReferenceById(id);
	}

	public void inativarRegistro(Long id) {
		var med = buscarPorId(id);
		med.inativar();
	}

	public void ativarRegistro(Long id) {
		var med = buscarPorId(id);
		med.ativar();
	}
}
