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

import br.com.imperio.alistamento.controller.dto.StormtrooperDTO;
import br.com.imperio.alistamento.controller.form.StormtrooperFORM;
import br.com.imperio.alistamento.model.Stormtrooper;
import br.com.imperio.alistamento.repository.PelotaoRepository;
import br.com.imperio.alistamento.repository.StormtrooperRepository;

@RestController
@RequestMapping("/stormtrooper")
public class StormtrooperController {

	@Autowired
	private StormtrooperRepository stormR;

	@Autowired
	private PelotaoRepository pelotaoR;

	@GetMapping
	public List<StormtrooperDTO> listAll() {
		List<Stormtrooper> stormtroopers = stormR.findAll();

		return StormtrooperDTO.convert(stormtroopers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listByID(@PathVariable("id") Long id) {
		Optional<Stormtrooper> optional = stormR.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(StormtrooperDTO.convertOne(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<StormtrooperDTO> save(@RequestBody StormtrooperFORM form, UriComponentsBuilder uriBuilder) {
		try {
			Stormtrooper storm = form.convert(pelotaoR);

			if (!storm.getPelotao().equals(null)) {
				stormR.save(storm);

				URI uri = uriBuilder.path("/stormtrooper/{id}").buildAndExpand(storm.getIdGalaxy()).toUri();
				return ResponseEntity.created(uri).body(new StormtrooperDTO(storm));
			}

			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StormtrooperDTO> update(@PathVariable Long id, @RequestBody StormtrooperFORM form) {
		Optional<Stormtrooper> optional = stormR.findById(id);
		if (optional.isPresent()) {
			Stormtrooper stormtrooper = form.update(id, stormR, pelotaoR);
			return ResponseEntity.ok(new StormtrooperDTO(stormtrooper));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Stormtrooper> optional = stormR.findById(id);
		if (optional.isPresent()) {
			stormR.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
