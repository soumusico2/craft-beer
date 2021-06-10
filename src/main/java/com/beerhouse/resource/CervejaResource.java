package com.beerhouse.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.beerhouse.modelo.Cerveja;
import com.beerhouse.service.CervejaService;


@RestController
@RequestMapping(value = "/cervejas")
public class CervejaResource {

	@Autowired
	private CervejaService cervejaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Cerveja> cadastrar(@RequestBody @Valid Cerveja cervejaForm) {
		
		Cerveja cerveja = cervejaService.cadastrar(cervejaForm);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cerveja.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception {
		
		cervejaService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cerveja> buscar(@PathVariable Long id) throws Exception {
		
		Cerveja cerveja = cervejaService.buscar(id);
		
		return ResponseEntity.ok().body(cerveja);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Cerveja> atualizar(@PathVariable Long id, @RequestBody Cerveja cervejaForm) {

		ResponseEntity<Cerveja> cerveja = cervejaService.alterar(id, cervejaForm);
		
		return cerveja;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Cerveja>> listar(@RequestParam int pagina, @RequestParam int quantidade){
		
		Page<Cerveja> cervejas = cervejaService.listar(pagina, quantidade);
		
		return ResponseEntity.ok().body(cervejas);
	}
	
}
