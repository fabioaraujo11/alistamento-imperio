package br.com.imperio.alistamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imperio.alistamento.model.Pelotao;

@Repository
public interface PelotaoRepository extends JpaRepository<Pelotao, Long> {

	Pelotao findByNmPelotao(String nmPelotao);
}
