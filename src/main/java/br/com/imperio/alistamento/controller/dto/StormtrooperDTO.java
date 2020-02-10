package br.com.imperio.alistamento.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imperio.alistamento.model.Stormtrooper;

public class StormtrooperDTO {

	private Long idGalaxy;
	private String nmCompleto;
	private LocalDate dtNasc;
	private double altura;
	private double peso;
	private String pelotao;
	private String planeta;

	public StormtrooperDTO(Stormtrooper stormtrooper) {
		this.idGalaxy = stormtrooper.getIdGalaxy();
		this.nmCompleto = stormtrooper.getNmCompleto();
		this.dtNasc = stormtrooper.getDtNasc();
		this.altura = stormtrooper.getAltura();
		this.peso = stormtrooper.getPeso();
		this.pelotao = stormtrooper.getPelotao().getNmPelotao();
		this.planeta = stormtrooper.getPlaneta();
	}

	public StormtrooperDTO() {
	}

	public Long getIdGalaxy() {
		return idGalaxy;
	}

	public String getNmCompleto() {
		return nmCompleto;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}

	public String getPelotao() {
		return pelotao;
	}

	public String getPlaneta() {
		return planeta;
	}

	public static List<StormtrooperDTO> convert(List<Stormtrooper> stormtroopers) {
		return stormtroopers.stream().map(StormtrooperDTO::new).collect(Collectors.toList());
	}

	public static StormtrooperDTO convertOne(Stormtrooper storm) {
		return new StormtrooperDTO(storm);
	}

}
