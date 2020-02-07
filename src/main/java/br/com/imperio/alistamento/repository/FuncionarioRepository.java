package br.com.imperio.alistamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imperio.alistamento.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByNmCompleto(String nmCompleto);

}
