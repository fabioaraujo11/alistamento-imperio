package br.com.imperio.alistamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.imperio.alistamento.controller.dto.ComandanteDTO;
import br.com.imperio.alistamento.controller.form.ComandanteFORM;
import br.com.imperio.alistamento.model.Comandante;
import br.com.imperio.alistamento.repository.ComandanteRepository;

@RestController
@RequestMapping("/comandante")
@CrossOrigin("https://astrofabio.herokuapp.com")
public class ComandanteController {

	@Autowired
	private ComandanteRepository comandanteR;

	@GetMapping
	public List<ComandanteDTO> listAll() {
		List<Comandante> comandantes = comandanteR.findAll();

		return ComandanteDTO.convert(comandantes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listByID(@PathVariable("id") Long id) {
		Optional<Comandante> optional = comandanteR.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(ComandanteDTO.convertOne(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ComandanteDTO> save(@RequestBody ComandanteFORM form, UriComponentsBuilder uriBuilder) {
		try {
			Comandante comandante = form.convert();

			comandanteR.save(comandante);

			URI uri = uriBuilder.path("/comandante/{id}").buildAndExpand(comandante.getIdGalaxy()).toUri();
			return ResponseEntity.created(uri).body(new ComandanteDTO(comandante));

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ComandanteDTO> update(@PathVariable Long id, @RequestBody ComandanteFORM form) {
		Optional<Comandante> optional = comandanteR.findById(id);
		if (optional.isPresent()) {
			Comandante comandante = form.update(id,comandanteR);
			return ResponseEntity.ok(new ComandanteDTO(comandante));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Comandante> optional = comandanteR.findById(id);
		if (optional.isPresent()) {
			comandanteR.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
