/**
 * 
 */
package ar.edu.um.programacion2.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.um.programacion2.simple.exception.PersonaNotFoundException;
import ar.edu.um.programacion2.simple.model.Persona;
import ar.edu.um.programacion2.simple.service.PersonaService;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService service;

	@GetMapping("/")
	public ResponseEntity<List<Persona>> findAll() {
		return new ResponseEntity<List<Persona>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{documento}")
	public ResponseEntity<Persona> findByDocumento(@PathVariable Long documento) {
		try {
			return new ResponseEntity<Persona>(service.findByDocumento(documento), HttpStatus.OK);
		} catch (PersonaNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Persona> add(@RequestBody Persona persona) {
		return new ResponseEntity<Persona>(service.add(persona), HttpStatus.OK);
	}
	
	@DeleteMapping("/{documento}")
	public ResponseEntity<Void> deleteByDocumento(@PathVariable Long documento) {
		service.deleteByDocumento(documento);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{documento}")
	public ResponseEntity<Persona> update(@RequestBody Persona persona, @PathVariable Long documento) {
		return new ResponseEntity<Persona>(service.update(persona, documento), HttpStatus.OK);
	}
	
}
