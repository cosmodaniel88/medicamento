package com.farmacia.medica.medicaCosmo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.farmacia.medica.medicaCosmo.entities.Usuario;

public interface RepositorioDeUsuario extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);
	
}
