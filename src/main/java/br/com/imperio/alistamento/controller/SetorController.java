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

import br.com.imperio.alistamento.controller.dto.SetorDTO;
import br.com.imperio.alistamento.controller.form.SetorFORM;
import br.com.imperio.alistamento.model.Setor;
import br.com.imperio.alistamento.repository.ComandanteRepository;
import br.com.imperio.alistamento.repository.SetorRepository;

@RestController
@RequestMapping("/setor")
@CrossOrigin("http://localhost:4200")
public class SetorController {

	@Autowired
	private SetorRepository setorR;

	@Autowired
	private ComandanteRepository comandanteR;

	@GetMapping
	public List<SetorDTO> listAll() {
		List<Setor> setores = setorR.findAll();

		return SetorDTO.convert(setores);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listByID(@PathVariable("id") Long id) {
		Optional<Setor> optional = setorR.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(SetorDTO.convertOne(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<SetorDTO> save(@RequestBody SetorFORM form, UriComponentsBuilder uriBuilder) {
		try {
			Setor setor = form.convert(comandanteR);

			if (!setor.getComandanteSetor().equals(null)) {
				setorR.save(setor);
				URI uri = uriBuilder.path("/setor/{id}").buildAndExpand(setor.getId()).toUri();
				return ResponseEntity.created(uri).body(new SetorDTO(setor));
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SetorDTO> update(@PathVariable Long id, @RequestBody SetorFORM form) {
		Optional<Setor> optional = setorR.findById(id);
		if (optional.isPresent()) {
			Setor setor = form.update(id, setorR, comandanteR);
			return ResponseEntity.ok(new SetorDTO(setor));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Setor> optional = setorR.findById(id);
		if (optional.isPresent()) {
			setorR.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
