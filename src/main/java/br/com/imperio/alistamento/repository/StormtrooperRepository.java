package br.com.imperio.alistamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.imperio.alistamento.model.Stormtrooper;

@Repository
public interface StormtrooperRepository extends JpaRepository<Stormtrooper, Long> {

	Stormtrooper findByNmCompleto(String nmCompleto);

}
