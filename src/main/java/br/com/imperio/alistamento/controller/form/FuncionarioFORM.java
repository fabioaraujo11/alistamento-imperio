package br.com.imperio.alistamento.controller.form;

import java.time.LocalDate;

import br.com.imperio.alistamento.model.Funcionario;
import br.com.imperio.alistamento.model.Setor;
import br.com.imperio.alistamento.repository.FuncionarioRepository;
import br.com.imperio.alistamento.repository.SetorRepository;

public class FuncionarioFORM {

	private Long idGalaxy;
	private String nmCompleto;
	private LocalDate dtNasc;
	private double altura;
	private double peso;
	private String setor;
	private String planeta;

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

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	public Funcionario convert(SetorRepository setorR) {
		Setor setorObject = setorR.findByNmSetor(this.setor);

		return new Funcionario(this.idGalaxy, this.nmCompleto, this.dtNasc, this.altura, this.peso, this.planeta,
				setorObject);

	}

	public Funcionario update(Long id, FuncionarioRepository funcR, SetorRepository setorR) {

		Funcionario func = funcR.getOne(id);

		if (this.idGalaxy != null)
			func.setIdGalaxy(this.idGalaxy);
		if (this.nmCompleto != null)
			func.setNmCompleto(this.nmCompleto);
		if (this.dtNasc != null)
			func.setDtNasc(this.dtNasc);
		if (this.altura != 0.0)
			func.setAltura(this.altura);
		if (this.peso != 0.0)
			func.setPeso(this.peso);
		if (this.planeta != null)
			func.setPlaneta(this.planeta);
		if (this.setor != null)
			func.setSetor(setorR.findByNmSetor(this.setor));

		return func;

	}

	public FuncionarioFORM() {
	}

}
