package com.beerhouse.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.beerhouse.modelo.Cerveja;
import com.beerhouse.repository.CervejaRepository;

class CervejaServiceTest {
	
	@InjectMocks
	CervejaService cervejaService;
	
	@Mock
	private CervejaRepository cervejaRepository;
	
	Cerveja cerveja = new Cerveja(2L, "Teste", "Teste", "Teste", "Teste", "Teste");
	Cerveja cerveja2 = new Cerveja(2L, "Teste", "Teste", "Teste", "Teste", "Teste");
	
	List<Cerveja> cervejas = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		this.cervejaService = new CervejaService(cervejaRepository);
	
	}

	@Test
	void cadastrar() throws Exception {
		Mockito.when(cervejaRepository.save(cerveja)).thenReturn(cerveja);
	}
	
	@Test
	void deletar() throws Exception {
		
		Mockito.when(cervejaRepository.findById(cerveja.getId())).thenReturn(Optional.of(cerveja));
		cervejaService.deletar(cerveja.getId());
		
		verify(cervejaRepository).deleteById(cerveja.getId());

	}
	 
	@Test
	void buscar() throws Exception {
		Mockito.when(cervejaRepository.findById(cerveja.getId())).thenReturn(Optional.of(cerveja));
	}
	
	@Test
	void listar() throws Exception {
		Mockito.when(cervejaRepository.findAll()).thenReturn(cervejas);
	}
	
}
