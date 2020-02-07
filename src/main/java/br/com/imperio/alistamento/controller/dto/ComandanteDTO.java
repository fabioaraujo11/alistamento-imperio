package br.com.imperio.alistamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.imperio.alistamento.model.Comandante;

public class ComandanteDTO {

	private Long idGalaxy;
	private String nmCompleto;

	public ComandanteDTO(Comandante comandante) {
		this.idGalaxy = comandante.getIdGalaxy();
		this.nmCompleto = comandante.getNmCompleto();
	}

	public Long getIdGalaxy() {
		return idGalaxy;
	}

	public String getNmCompleto() {
		return nmCompleto;
	}

	public static List<ComandanteDTO> convert(List<Comandante> comandantes) {
		return comandantes.stream().map(ComandanteDTO::new).collect(Collectors.toList());
	}
	
	public static ComandanteDTO convertOne(Comandante comandante) {
		return new ComandanteDTO(comandante);
	}

}
