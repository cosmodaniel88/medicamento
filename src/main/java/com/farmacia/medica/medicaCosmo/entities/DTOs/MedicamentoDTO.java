package com.farmacia.medica.medicaCosmo.entities.DTOs;

import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

public class MedicamentoDTO {
	
	private Long id;
	private String nome;
	private Via via;
	private String lote;
	private Integer quantidade;
	private Laboratorio laboratorio;
	
	public MedicamentoDTO(Long id, String nome, Via via, String lote, Integer quantidade, Laboratorio laboratorio) {
		super();
		this.id = id;
		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.laboratorio = laboratorio;
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

	public Via getVia() {
		return via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return "MedicamentoDTO [nome=" + nome + ", via=" + via + ", lote=" + lote + ", quantidade=" + quantidade
				+ ", laboratorio=" + laboratorio + "]";
	}
	
	
		
}
