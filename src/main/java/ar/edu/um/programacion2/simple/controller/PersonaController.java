/**
 * 
 */
package ar.edu.um.programacion2.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<Persona>(service.findByDocumento(documento), HttpStatus.OK);
	}
}
