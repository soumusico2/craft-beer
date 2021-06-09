package com.beerhouse.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	public AutenticacaoTokenFilter(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = obterToken(request);
		
		System.out.println(token);
		
		boolean isValid = tokenService.isTokenValido(token) ;
		
		System.out.println(isValid);

		filterChain.doFilter(request, response);
	}
	
	
	
	private String obterToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		String tokenSyso = token.substring(7).trim();
		System.out.println(tokenSyso);
		return tokenSyso;
	}

}
