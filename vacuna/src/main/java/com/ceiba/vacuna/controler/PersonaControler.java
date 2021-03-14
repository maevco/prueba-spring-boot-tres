package com.ceiba.vacuna.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.vacuna.exception.InvalidDataException;
import com.ceiba.vacuna.modelo.Persona;
import com.ceiba.vacuna.service.PersonaServiceDecl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/persona/")
public class PersonaControler {

	@Autowired
	private PersonaServiceDecl personaService;

	@GetMapping
	private List<Persona> listar() {
		return personaService.getAllPersonas();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
		public Persona create(@Valid @RequestBody Persona persona, BindingResult result) {

		if (result.hasErrors()) {
			throw new InvalidDataException(result);
		}

		return personaService.add(persona);
	}

	@GetMapping(path = { "/{id}" })
	private Persona buscarPersonaPorId(@PathVariable("id") Long id) {
		return personaService.findById(id);
	}

	@PutMapping(path = { "/{id}" })
	private Persona editar(@RequestBody Persona persona, @PathVariable("id") Long id) {
		persona.setId(id);
		return personaService.edit(persona);
	}

	@DeleteMapping(path = { "/{id}" })
	private Persona delete(@PathVariable("id") Long id) {
		return personaService.delete(id);
	}

}
