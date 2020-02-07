package br.com.imperio.alistamento.controller.form;

import br.com.imperio.alistamento.model.Comandante;
import br.com.imperio.alistamento.model.Setor;
import br.com.imperio.alistamento.repository.ComandanteRepository;
import br.com.imperio.alistamento.repository.SetorRepository;

public class SetorFORM {

	private Long id;
	private String nmSetor;
	private String comandanteSetor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNmSetor() {
		return nmSetor;
	}

	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
	}

	public String getComandanteSetor() {
		return comandanteSetor;
	}

	public void setComandanteSetor(String comandanteSetor) {
		this.comandanteSetor = comandanteSetor;
	}

	public Setor convert(ComandanteRepository comandanteR) {
		Comandante comandante = comandanteR.findByNmCompleto(comandanteSetor);
		return new Setor(nmSetor, comandante);

	}

	public Setor update(Long id, SetorRepository setorR, ComandanteRepository comandanteR) {

		Setor setor = setorR.getOne(id);

		if (this.comandanteSetor == null) {
			setor.setNmSetor(this.nmSetor);
		}

		if (this.nmSetor == null) {
			setor.setComandanteSetor(comandanteR.findByNmCompleto(this.comandanteSetor));
		}

		return setor;

	}

}
