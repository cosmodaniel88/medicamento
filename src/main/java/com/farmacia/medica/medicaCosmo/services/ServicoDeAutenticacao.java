package com.farmacia.medica.medicaCosmo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farmacia.medica.medicaCosmo.repositorys.RepositorioDeUsuario;

@Service /*Indica que será um serviço*/
public class ServicoDeAutenticacao implements UserDetailsService{
	@Autowired
	private RepositorioDeUsuario repUser;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		return repUser.findByLogin(login);
	}

}
