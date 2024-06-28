package com.farmacia.medica.medicaCosmo.DTOs;

import java.time.LocalDate;

import com.farmacia.medica.medicaCosmo.entities.Medicamento;
import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

public record ListagemMedicamentosDTO(Long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
//estamos passando para o nosso record DTO as informaç~eos para instanciação
	public ListagemMedicamentosDTO(Medicamento med) {
		this(med.getId(), med.getNome(), med.getVia(), med.getLote(), med.getLaboratorio(), med.getValidade());
	}
}
