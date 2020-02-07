package br.com.imperio.alistamento.controller.form;

import br.com.imperio.alistamento.model.Comandante;
import br.com.imperio.alistamento.repository.ComandanteRepository;

public class ComandanteFORM {

	private Long idGalaxy;
	private String nmCompleto;

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

	public Comandante convert() {
		return new Comandante(this.idGalaxy, this.nmCompleto);

	}

	public Comandante update(Long id, ComandanteRepository comandanteR) {

		Comandante comandante = comandanteR.getOne(id);

		comandante.setNmCompleto(this.nmCompleto);

		return comandante;

	}

}
