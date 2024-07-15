package com.farmacia.medica.medicaCosmo.infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.farmacia.medica.medicaCosmo.repositorys.RepositorioDeUsuario;
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
	private TokerService tokenService; /* Nome da classe errado */

	@Autowired
	private RepositorioDeUsuario uRep;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var tokenJwt = recuperarToken(request);

		if (tokenJwt != null) {
			var subject = tokenService.getSubject(tokenJwt);
			var usuario = uRep.findByLogin(subject);

			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);

	}

	/*
	 * Esse método vai pegar o token passado no cabeçalho e o retornará como string
	 */
	private String recuperarToken(HttpServletRequest request) {
		var authoHead = request.getHeader("Authorization");
		if (authoHead != null) {
			return authoHead.replace("Bearer ", ""); /* Se o tokem for diferente de null, retorne a autorização */
		}

		return null;
	}

}
