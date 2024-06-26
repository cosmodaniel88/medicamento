package com.farmacia.medica.medicaCosmo.entities;

import java.util.Objects;

import com.farmacia.medica.medicaCosmo.DTOs.MedicamentoDTO;
import com.farmacia.medica.medicaCosmo.entities.enums.Laboratorio;
import com.farmacia.medica.medicaCosmo.entities.enums.Via;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "remedio")
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Via via;

	private String lote;
	private Integer quantidade;

	private String validade;

	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;

	public Medicamento() {

	}

	public Medicamento(String nome, Via via, String lote, Integer quantidade, String validade,
			Laboratorio laboratorio) {

		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.laboratorio = laboratorio;
		this.validade = validade;
	}

	// construtor com dados do DTO
	public Medicamento(MedicamentoDTO dadosMedicamento) {
		this.nome = dadosMedicamento.nome();
		this.via = dadosMedicamento.via();
		this.lote = dadosMedicamento.lote();
		this.quantidade = dadosMedicamento.quantidade();
		this.validade = dadosMedicamento.validade();
		this.laboratorio = dadosMedicamento.laboratorio();
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

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(id, other.id);
	}

}
