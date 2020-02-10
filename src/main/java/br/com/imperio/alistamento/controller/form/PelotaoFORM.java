package br.com.imperio.alistamento.controller.form;

import br.com.imperio.alistamento.model.Comandante;
import br.com.imperio.alistamento.model.Pelotao;
import br.com.imperio.alistamento.repository.ComandanteRepository;
import br.com.imperio.alistamento.repository.PelotaoRepository;

public class PelotaoFORM {

	private Long id;
	private String nmPelotao;
	private String comandantePelotao;

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

	public String getComandantePelotao() {
		return comandantePelotao;
	}

	public void setComandantePelotao(String comandantePelotao) {
		this.comandantePelotao = comandantePelotao;
	}

	public PelotaoFORM() {
	}

	public Pelotao convert(ComandanteRepository comandanteR) {
		Comandante comandante = comandanteR.findByNmCompleto(comandantePelotao);
		return new Pelotao(nmPelotao, comandante);

	}

	public Pelotao update(Long id, PelotaoRepository pelotaoR, ComandanteRepository comandanteR) {

		Pelotao pelotao = pelotaoR.getOne(id);

		if (this.comandantePelotao == null) {
			pelotao.setNmPelotao(this.nmPelotao);
		}

		if (this.nmPelotao == null) {
			pelotao.setComandantePelotao(comandanteR.findByNmCompleto(this.comandantePelotao));
		}

		return pelotao;

	}

}
