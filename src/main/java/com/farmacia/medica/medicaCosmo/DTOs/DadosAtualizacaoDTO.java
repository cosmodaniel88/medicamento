package com.farmacia.medica.medicaCosmo.DTOs;

import java.time.LocalDate;

import com.farmacia.medica.medicaCosmo.entities.Medicamento;
import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

public record DadosAtualizacaoDTO(
		Long id, 
		String nome, 
		Via via, 
		String lote, 
		int quantidade, 
		LocalDate validade, 
		Laboratorio laboratorio, 
		Boolean ativo)

{
	public DadosAtualizacaoDTO(Medicamento medicamento) {
		this(
				medicamento.getId(),
				medicamento.getNome(),
				medicamento.getVia(),
				medicamento.getLote(),
				medicamento.getQuantidade(),
				medicamento.getValidade(),
				medicamento.getLaboratorio(),
				medicamento.getAtivo()
				);
	}


}
