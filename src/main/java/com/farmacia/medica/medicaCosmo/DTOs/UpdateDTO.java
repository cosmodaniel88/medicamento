package com.farmacia.medica.medicaCosmo.DTOs;

import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

import jakarta.validation.constraints.NotNull;

public record UpdateDTO(
		@NotNull 
		Long id,
		
		String nome,
		Via via,
		Laboratorio laboratorio
) {

}
