package br.com.imperio.alistamento.controller.form;

import java.time.LocalDate;

import br.com.imperio.alistamento.model.Pelotao;
import br.com.imperio.alistamento.model.Stormtrooper;
import br.com.imperio.alistamento.repository.PelotaoRepository;
import br.com.imperio.alistamento.repository.StormtrooperRepository;

public class StormtrooperFORM {

	private Long idGalaxy;
	private String nmCompleto;
	private LocalDate dtNasc;
	private double altura;
	private double peso;
	private String pelotao;
	private String planeta;

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

	public String getPelotao() {
		return pelotao;
	}

	public void setPelotao(String pelotao) {
		this.pelotao = pelotao;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	public Stormtrooper convert(PelotaoRepository pelotaoR) {
		Pelotao pelotaoObject = pelotaoR.findByNmPelotao(this.pelotao);

		return new Stormtrooper(this.idGalaxy, this.nmCompleto, this.dtNasc, this.altura, this.peso, this.planeta,
				pelotaoObject);

	}

	public Stormtrooper update(Long id, StormtrooperRepository stormR, PelotaoRepository pelotaoR) {

		Stormtrooper storm = stormR.getOne(id);

		if (this.idGalaxy != null)
			storm.setIdGalaxy(this.idGalaxy);
		if (this.nmCompleto != null)
			storm.setNmCompleto(this.nmCompleto);
		if (this.dtNasc != null)
			storm.setDtNasc(this.dtNasc);
		if (this.altura != 0.0)
			storm.setAltura(this.altura);
		if (this.peso != 0.0)
			storm.setPeso(this.peso);
		if (this.planeta != null)
			storm.setPlaneta(this.planeta);
		if (this.pelotao != null)
			storm.setPelotao(pelotaoR.findByNmPelotao(this.pelotao));

		return storm;

	}

	public StormtrooperFORM() {
	}
}
