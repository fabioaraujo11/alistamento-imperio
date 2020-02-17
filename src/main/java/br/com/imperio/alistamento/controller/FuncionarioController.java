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

import br.com.imperio.alistamento.controller.dto.FuncionarioDTO;
import br.com.imperio.alistamento.controller.form.FuncionarioFORM;
import br.com.imperio.alistamento.model.Funcionario;
import br.com.imperio.alistamento.repository.FuncionarioRepository;
import br.com.imperio.alistamento.repository.SetorRepository;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin("https://astrofabio.herokuapp.com")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcR;

	@Autowired
	private SetorRepository setorR;

	@GetMapping
	public List<FuncionarioDTO> listAll() {
		List<Funcionario> funcionarios = funcR.findAll();

		return FuncionarioDTO.convert(funcionarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listByID(@PathVariable("id") Long id) {
		Optional<Funcionario> optional = funcR.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(FuncionarioDTO.convertOne(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDTO> save(@RequestBody FuncionarioFORM form, UriComponentsBuilder uriBuilder) {
		try {
			Funcionario func = form.convert(setorR);

			if (!func.getSetor().equals(null)) {
				funcR.save(func);

				URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(func.getIdGalaxy()).toUri();
				return ResponseEntity.created(uri).body(new FuncionarioDTO(func));
			}

			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody FuncionarioFORM form) {
		Optional<Funcionario> optional = funcR.findById(id);
		if (optional.isPresent()) {
			Funcionario funcionario = form.update(id, funcR, setorR);
			return ResponseEntity.ok(new FuncionarioDTO(funcionario));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Funcionario> optional = funcR.findById(id);
		if (optional.isPresent()) {
			funcR.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
