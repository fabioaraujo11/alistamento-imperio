package br.com.imperio.alistamento.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario {

	@Id
	@NotNull
	private Long idGalaxy;

	@NotNull
	@Column(length = 255)
	private String nmCompleto;

	@NotNull
	private LocalDate dtNasc;

	@NotNull
	private double altura;

	@NotNull
	private double peso;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@NotNull
	private String planeta;

	public Funcionario() {

	}

	public Funcionario(@NotNull Long idGalaxy, @NotNull String nmCompleto, @NotNull LocalDate dtNasc,
			@NotNull double altura, @NotNull double peso, String planeta, Setor setor) {
		this.idGalaxy = idGalaxy;
		this.nmCompleto = nmCompleto;
		this.dtNasc = dtNasc;
		this.altura = altura;
		this.peso = peso;
		this.planeta = planeta;
		this.setor = setor;
	}

	public Long getIdGalaxy() {
		return idGalaxy;
	}

	public void setIdGalaxy(Long idGalaxy) {
		this.idGalaxy = idGalaxy;
	}

	public String getNmCompleto() {
		return nmCompleto;
	}

	public void setNmCompleto(String nmCompleto) {
		this.nmCompleto = nmCompleto;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

}
