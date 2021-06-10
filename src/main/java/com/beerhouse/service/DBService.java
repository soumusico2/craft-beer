package com.beerhouse.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.beerhouse.modelo.Cerveja;
import com.beerhouse.modelo.Usuario;
import com.beerhouse.repository.CervejaRepository;
import com.beerhouse.repository.UsuarioRepository;

@Service
public class DBService {
		
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CervejaRepository cervejaRepository;
	
	public void instanciarDb() {
		
		Usuario user1 = new Usuario(null, "Convidado", "Convidado", bCrypt.encode("123456"));
		Usuario user2 = new Usuario(null, "Hebert Nunes", "hebert@gmail.com", bCrypt.encode("123456"));
				
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		
		Cerveja cerveja1 = new Cerveja(null, "Praga Premium Pils", "500ml", "Pilsen", "Lage", "República Tcheca");
		Cerveja cerveja2 = new Cerveja(null, "Corona", "210ml", "Extra", "Lage", "México");
		Cerveja cerveja3 = new Cerveja(null, "Antarctica Original", "600ml", "Pilsen", "Lage", "Brasil");
		Cerveja cerveja4 = new Cerveja(null, "Schornstein Bock", "500ml", "Bock", "Lage", "Brasil");
		Cerveja cerveja5 = new Cerveja(null, "Weizenbier", "355ml", "Bock", "Ale", "Alemanha");
		Cerveja cerveja6 = new Cerveja(null, "IPA 6", "600ml", "IPA", "Ale", "Inglaterra");
	
		cervejaRepository.saveAll(Arrays.asList(cerveja1, cerveja2, cerveja3, cerveja4, cerveja5, cerveja6));
	}
}
