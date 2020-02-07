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

	public Comandante(@NotNull Long idGalaxy, @NotNull String nmCompleto) {
		this.idGalaxy = idGalaxy;
		this.nmCompleto = nmCompleto;
	}

	public Comandante() {
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

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public List<Pelotao> getPelotoes() {
		return pelotoes;
	}

	public void setPelotoes(List<Pelotao> pelotoes) {
		this.pelotoes = pelotoes;
	}

}
