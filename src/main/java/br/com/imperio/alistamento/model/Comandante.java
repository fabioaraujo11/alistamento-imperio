package br.com.imperio.alistamento.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Comandante {

	@Id
	@NotNull
	private Long idGalaxy;

	@NotNull
	@Column(length = 255)
	private String nmCompleto;

	@OneToMany(mappedBy = "comandanteSetor")
	private List<Setor> setores;

	@OneToMany(mappedBy = "comandantePelotao")
	private List<Pelotao> pelotoes;

}
