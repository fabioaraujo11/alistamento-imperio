package br.com.imperio.alistamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.imperio.alistamento.model.Setor;

public class SetorDTO {

	private Long id;
	private String nmSetor;
	private String comandanteSetor;

	public SetorDTO() {

	}

	public SetorDTO(Setor setor) {
		this.id = setor.getId();
		this.nmSetor = setor.getNmSetor();
		this.comandanteSetor = setor.getComandanteSetor().getNmCompleto();
	}

	public Long getId() {
		return id;
	}

	public String getNmSetor() {
		return nmSetor;
	}

	public String getComandanteSetor() {
		return comandanteSetor;
	}

	public static List<SetorDTO> convert(List<Setor> setores) {
		return setores.stream().map(SetorDTO::new).collect(Collectors.toList());
	}

	public static SetorDTO convertOne(Setor setor) {
		return new SetorDTO(setor);
	}

}
