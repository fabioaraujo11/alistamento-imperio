package br.com.imperio.alistamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.imperio.alistamento.model.Pelotao;

public class PelotaoDTO {

	private Long id;
	private String nmPelotao;
	private String comandantePelotao;

	public Long getId() {
		return id;
	}

	public String getNmPelotao() {
		return nmPelotao;
	}

	public String getComandantePelotao() {
		return comandantePelotao;
	}

	public PelotaoDTO(Pelotao pelotao) {
		this.id = pelotao.getId();
		this.nmPelotao = pelotao.getNmPelotao();
		this.comandantePelotao = pelotao.getComandantePelotao().getNmCompleto();
	}

	public PelotaoDTO() {
	}

	public static List<PelotaoDTO> convert(List<Pelotao> pelotoes) {
		return pelotoes.stream().map(PelotaoDTO::new).collect(Collectors.toList());
	}

	public static PelotaoDTO convertOne(Pelotao pelotao) {
		return new PelotaoDTO(pelotao);
	}

}
