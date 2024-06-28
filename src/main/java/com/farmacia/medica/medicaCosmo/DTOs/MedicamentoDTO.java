package com.farmacia.medica.medicaCosmo.DTOs;

import java.time.LocalDate;

import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record MedicamentoDTO(

		@NotBlank
		String nome,
		
		@NotBlank
		String lote, 
		
		int quantidade,
		
		@Future
		LocalDate validade, 
		@Enumerated
		Via via,
		@Enumerated
		Laboratorio laboratorio) {

}
