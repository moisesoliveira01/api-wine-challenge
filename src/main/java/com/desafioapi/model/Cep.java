package com.desafioapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cep implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String codigo_loja;
	@Column(nullable = false, unique = true)
	private String faixa_inicio;
	@Column(nullable = false, unique = true)
	private String faixa_fim;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo_loja() {
		return codigo_loja;
	}
	public void setCodigo_loja(String codigo_loja) {
		this.codigo_loja = codigo_loja;
	}
	public String getFaixa_inicio() {
		return faixa_inicio;
	}
	public void setFaixa_inicio(String faixa_inicio) {
		this.faixa_inicio = faixa_inicio;
	}
	public String getFaixa_fim() {
		return faixa_fim;
	}
	public void setFaixa_fim(String faixa_fim) {
		this.faixa_fim = faixa_fim;
	}
	
}
