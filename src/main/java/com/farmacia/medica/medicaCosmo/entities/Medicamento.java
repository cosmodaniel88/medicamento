package com.farmacia.medica.medicaCosmo.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.farmacia.medica.medicaCosmo.DTOs.MedicamentoDTO;
import com.farmacia.medica.medicaCosmo.DTOs.UpdateDTO;
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
	private int quantidade;

	private LocalDate validade;

	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;

	private Boolean ativo;

	public Medicamento() {

	}

	public Medicamento(String nome, Via via, String lote, int quantidade, LocalDate validade, Laboratorio laboratorio) {

		this.nome = nome;
		this.via = via;
		this.lote = lote;
		this.quantidade = quantidade;
		this.laboratorio = laboratorio;
		this.validade = validade;
		// o medicamento, assim que cadastrado, já terá o valor ativo como true
		this.setAtivo(true);
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
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

	public void atualizarInformacoes(UpdateDTO dados) {

		if (dados.nome() != null) {
			this.nome = dados.nome();
		}

		if (dados.via() != null) {
			this.nome = dados.nome();
		}

		if (dados.laboratorio() != null) {
			this.laboratorio = dados.laboratorio();
		}

	}

	public void inativar() {
		this.setAtivo(false);

	}

	public void ativar() {

		this.setAtivo(true);

	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
