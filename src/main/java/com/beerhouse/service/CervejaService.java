package com.beerhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beerhouse.modelo.Cerveja;
import com.beerhouse.repository.CervejaRepository;
import com.beerhouse.service.exceptions.ObjectNotFoundException;

@Service
public class CervejaService {

	private CervejaRepository cervejaRepository;
	
	@Autowired
	public CervejaService(CervejaRepository cervejaRepository) {
		this.cervejaRepository = cervejaRepository;
	}

	@Transactional
	public Cerveja cadastrar(Cerveja cerveja) {
		
		cervejaRepository.save(cerveja);
		
		return cerveja;
	}
	
	@Transactional
	public void deletar(Long id) throws Exception {
		
		Optional<Cerveja> cerveja = cervejaRepository.findById(id);
		
		if(cerveja.isPresent()) {
			cervejaRepository.deleteById(id);
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo: " +Cerveja.class.getName());
		}
	}

	
	public Cerveja buscar(Long id) throws Exception {
		
		Optional<Cerveja> cerveja = cervejaRepository.findById(id);
		
		if(cerveja.isPresent()) {
			return cerveja.get();
		} else {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +id+ ", Tipo: " +Cerveja.class.getName());
		}
		
	}
	
	@Transactional
	public ResponseEntity<Cerveja> alterar(Long id, Cerveja cervejaForm) {
		
		Optional<Cerveja> cerveja = cervejaRepository.findById(id);
		
		if(cerveja.isPresent()) {
			
			cerveja.get().setNome(cervejaForm.getNome());
			cerveja.get().setOrigem(cervejaForm.getOrigem());
			cerveja.get().setQuantidade(cervejaForm.getQuantidade());
			cerveja.get().setTipo(cervejaForm.getTipo());
			cerveja.get().setCategoria(cervejaForm.getCategoria());
			
			cervejaRepository.save(cerveja.get());
			
			return ResponseEntity.ok(cerveja.get());
		} 
		return ResponseEntity.notFound().build();
	}
	
	public List<Cerveja> listar() {
		
		List<Cerveja> cervejas = cervejaRepository.findAll();
		
		return cervejas;
	}

}
