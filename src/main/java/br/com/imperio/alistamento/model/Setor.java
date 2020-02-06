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
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nmSetor;

	@ManyToOne
	@JoinColumn(name = "comandante_idGalaxy")
	private Comandante comandanteSetor;

	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionarios;

	public Setor() {
	}

	public Setor(String nmSetor, Comandante comandanteSetor) {
		this.nmSetor = nmSetor;
		this.comandanteSetor = comandanteSetor;
	}

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

	public Comandante getComandanteSetor() {
		return comandanteSetor;
	}

	public void setComandanteSetor(Comandante comandanteSetor) {
		this.comandanteSetor = comandanteSetor;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
