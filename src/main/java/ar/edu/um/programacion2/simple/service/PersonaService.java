/**
 * 
 */
package ar.edu.um.programacion2.simple.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.um.programacion2.simple.exception.PersonaNotFoundException;
import ar.edu.um.programacion2.simple.model.Persona;
import ar.edu.um.programacion2.simple.repository.PersonaRepository;

/**
 * @author daniel
 *
 */
@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository repository;

	public Persona add(Persona persona) {
		return repository.save(persona);
	}

	public List<Persona> findAll() {
		return repository.findAll();
	}

	public Persona findByDocumento(Long documento) {
		return repository.findByDocumento(documento).orElseThrow(() -> new PersonaNotFoundException(documento));
	}

	@Transactional
	public void deleteByDocumento(Long documento) {
		repository.deleteByDocumento(documento);
	}

	public Persona update(Persona newPersona, Long documento) {
		return repository.findByDocumento(documento).map(persona -> {
			persona = new Persona(documento, newPersona.getApellido(), newPersona.getNombre());
			return repository.save(persona);
		}).orElseThrow(() -> new PersonaNotFoundException(documento));
	}

}
