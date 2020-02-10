package br.com.imperio.alistamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.imperio.alistamento.controller.dto.PelotaoDTO;
import br.com.imperio.alistamento.controller.form.PelotaoFORM;
import br.com.imperio.alistamento.model.Pelotao;
import br.com.imperio.alistamento.repository.ComandanteRepository;
import br.com.imperio.alistamento.repository.PelotaoRepository;

@RestController
@RequestMapping("/pelotao")
public class PelotaoController {

	@Autowired
	private PelotaoRepository pelotaoR;

	@Autowired
	private ComandanteRepository comandanteR;

	@GetMapping
	public List<PelotaoDTO> listAll() {
		List<Pelotao> pelotoes = pelotaoR.findAll();

		return PelotaoDTO.convert(pelotoes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listByID(@PathVariable("id") Long id) {
		Optional<Pelotao> optional = pelotaoR.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(PelotaoDTO.convertOne(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PelotaoDTO> save(@RequestBody PelotaoFORM form, UriComponentsBuilder uriBuilder) {
		try {
			Pelotao pelotao = form.convert(comandanteR);

			if (!pelotao.getComandantePelotao().equals(null)) {
				pelotaoR.save(pelotao);

				URI uri = uriBuilder.path("/pelotao/{id}").buildAndExpand(pelotao.getId()).toUri();
				return ResponseEntity.created(uri).body(new PelotaoDTO(pelotao));
			}

			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PelotaoDTO> update(@PathVariable Long id, @RequestBody PelotaoFORM form) {
		Optional<Pelotao> optional = pelotaoR.findById(id);
		if (optional.isPresent()) {
			Pelotao pelotao = form.update(id, pelotaoR, comandanteR);
			return ResponseEntity.ok(new PelotaoDTO(pelotao));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Pelotao> optional = pelotaoR.findById(id);
		if (optional.isPresent()) {
			pelotaoR.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
