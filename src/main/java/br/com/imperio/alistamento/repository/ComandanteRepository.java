package br.com.imperio.alistamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imperio.alistamento.model.Comandante;

public interface ComandanteRepository extends JpaRepository<Comandante, Long>{
	Comandante findByNmCompleto(String nmCompleto);
}
