package br.com.imperio.alistamento.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.imperio.alistamento.model.Funcionario;

public class FuncionarioDTO {

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

	public String getNmCompleto() {
		return nmCompleto;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}

	public String getSetor() {
		return setor;
	}

	public String getPlaneta() {
		return planeta;
	}

	public FuncionarioDTO(Funcionario funcionario) {
		this.idGalaxy = funcionario.getIdGalaxy();
		this.nmCompleto = funcionario.getNmCompleto();
		this.dtNasc = funcionario.getDtNasc();
		this.altura = funcionario.getAltura();
		this.peso = funcionario.getPeso();
		this.setor = funcionario.getSetor().getNmSetor();
		this.planeta = funcionario.getPlaneta();
	}

	public FuncionarioDTO() {
	}

	public static List<FuncionarioDTO> convert(List<Funcionario> funcionarios) {
		return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
	}

	public static FuncionarioDTO convertOne(Funcionario func) {
		return new FuncionarioDTO(func);
	}

}
