package br.com.imperio.alistamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imperio.alistamento.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
	
	Setor findByNmSetor(String nmSetor);

}
