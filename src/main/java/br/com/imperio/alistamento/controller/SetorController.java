package br.com.imperio.alistamento.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imperio.alistamento.controller.dto.SetorDTO;
import br.com.imperio.alistamento.controller.form.SetorFORM;
import br.com.imperio.alistamento.model.Setor;
import br.com.imperio.alistamento.repository.ComandanteRepository;
import br.com.imperio.alistamento.repository.SetorRepository;

@RestController
@RequestMapping("/setor")
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
		Optional<Setor> setor = setorR.findById(id);
		if (setor.isPresent()) {
			return ResponseEntity.ok(SetorDTO.convertOne(setor.get()));
		}

		return ResponseEntity.badRequest().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> save(@RequestBody SetorFORM form) {
		try {
			Setor setor = form.convert(comandanteR);

			setorR.save(setor);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}
}
