package com.farmacia.medica.medicaCosmo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.medica.medicaCosmo.entities.Medicamento;

public interface RepositorioDeMedicamento extends JpaRepository<Medicamento, Long>{
	
}
