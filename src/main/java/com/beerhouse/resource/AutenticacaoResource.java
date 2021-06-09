package com.beerhouse.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.config.security.TokenService;
import com.beerhouse.dto.TokenDto;
import com.beerhouse.resource.login.LoginForm;


@RestController
@RequestMapping("/auth")
public class AutenticacaoResource {
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TokenDto> autenticar(@RequestBody LoginForm form) {
		
		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getSenha());
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			
			String token = tokenService.gerarToken(authentication);
			
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch(AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
