package com.beerhouse.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull 
	@Length(min = 3, max = 15, message = "É necessário informar entre 3 e 15 caracteres - nome")
	private String nome;
	
	@NotNull
	@Length(min = 3, max = 5, message = "É necessário informar entre 3 e 5 caracteres - quantidade")
	private String quantidade;
	
	@NotNull
	@Length(min = 3, max = 15, message = "É necessário informar entre 3 e 15 caracteres - tipo")
	private String tipo;
	
	@NotNull
	@Length(min = 3, max = 15, message = "É necessário informar entre 3 e 15 caracteres - categoria")
	private String categoria;
	
	@NotNull
	@Length(min = 3, max = 15, message = "É necessário informar entre 3 e 15 caracteres- origem")
	private String origem;
	
	public Cerveja() {}
	
	

	public Cerveja(Long id, @Length(min = 3, max = 15) String nome,
			@Length(min = 3, max = 5, message = "É necessário informar entre 3 e 5 caracteres") String quantidade,
			@Length(min = 3, max = 15) String tipo, @Length(min = 3, max = 15) String categoria,
			@Length(min = 3, max = 15) String origem) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.categoria = categoria;
		this.origem = origem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	
	
}
