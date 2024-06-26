package com.farmacia.medica.medicaCosmo.DTOs;

import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

public record MedicamentoDTO(String nome, String lote, Integer quantidade, String validade, Via via,
		Laboratorio laboratorio) {

}
