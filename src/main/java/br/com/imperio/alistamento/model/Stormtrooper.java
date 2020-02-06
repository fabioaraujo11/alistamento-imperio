package br.com.imperio.alistamento.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Stormtrooper {

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
	
	@NotNull
	private String planeta;

	@ManyToOne
	@JoinColumn(name = "pelotao_id")
	private Pelotao pelotao;

	public Stormtrooper() {
	}

	public Stormtrooper(@NotNull Long idGalaxy, @NotNull String nmCompleto, @NotNull LocalDate dtNasc,
			@NotNull double altura, @NotNull double peso, String planeta, Pelotao pelotao) {
		this.idGalaxy = idGalaxy;
		this.nmCompleto = nmCompleto;
		this.dtNasc = dtNasc;
		this.altura = altura;
		this.peso = peso;
		this.planeta = planeta;
		this.pelotao = pelotao;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
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

	public Pelotao getPelotao() {
		return pelotao;
	}

	public void setPelotao(Pelotao pelotao) {
		this.pelotao = pelotao;
	}

}
