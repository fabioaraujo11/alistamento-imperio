package br.com.imperio.alistamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pelotao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nmPelotao;

	@ManyToOne
	@JoinColumn(name = "comandante_idGalaxy")
	private Comandante comandantePelotao;

	@OneToMany(mappedBy = "pelotao")
	private List<Stormtrooper> stormtroopers;

	public Pelotao() {
	}

	public Pelotao(String nmPelotao, Comandante comandantePelotao) {
		this.nmPelotao = nmPelotao;
		this.comandantePelotao = comandantePelotao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmPelotao() {
		return nmPelotao;
	}

	public void setNmPelotao(String nmPelotao) {
		this.nmPelotao = nmPelotao;
	}

	public Comandante getComandantePelotao() {
		return comandantePelotao;
	}

	public void setComandantePelotao(Comandante comandantePelotao) {
		this.comandantePelotao = comandantePelotao;
	}

	public List<Stormtrooper> getStormtroopers() {
		return stormtroopers;
	}

	public void setStormtroopers(List<Stormtrooper> stormtroopers) {
		this.stormtroopers = stormtroopers;
	}

}
