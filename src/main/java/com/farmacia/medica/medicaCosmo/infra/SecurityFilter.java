package com.farmacia.medica.medicaCosmo.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.farmacia.medica.medicaCosmo.services.TokerService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*Nesta classe será implementada a lógica de validação do token
 * Nós primeiramente geramos um token, após a requisição do front
 * após isso, devolvemos esse token para o front
 * agora, o front nos enviará o toke gerado para  implementarmos de fato a lógica da validação
 * */

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokerService tokenService; /*Nome da classe errado*/
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJwt = recuperarToken(request);
		
		var subject = tokenService.getSubject(tokenJwt);
		
		filterChain.doFilter(request, response);

	}
/*Esse método vai pegar o token passado no cabeçalho e 
 * o retornará como string*/
	private String recuperarToken(HttpServletRequest request) {
		var authoHead = request.getHeader("Authorization");
		if (authoHead == null) {
			throw new RuntimeException("Token não enviado");
		}
		
		return authoHead;
	}

}
