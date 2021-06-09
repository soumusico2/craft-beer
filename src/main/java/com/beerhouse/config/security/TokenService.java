package com.beerhouse.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.beerhouse.modelo.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	public String gerarToken(Authentication authentication) {
		
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		
		return Jwts.builder()
				.setIssuer("API craft-beer")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expiration)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
}
