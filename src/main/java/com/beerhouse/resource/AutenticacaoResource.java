package com.beerhouse.resource;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.resource.login.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoResource {
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> autenticar(@RequestBody LoginForm login) {
		
		System.out.println(login.getEmail());
		System.out.println(login.getSenha());
		
		return ResponseEntity.ok().build();
	}
}
