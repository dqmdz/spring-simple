/**
 * 
 */
package ar.edu.um.programacion2.simple.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import ar.edu.um.programacion2.simple.model.Persona;

/**
 * @author daniel
 *
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	public Optional<Persona> findByDocumento(Long documento);

	@Modifying
	public void deleteByDocumento(Long documento);

}
