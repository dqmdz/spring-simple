/**
 * 
 */
package ar.edu.um.programacion2.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.um.programacion2.simple.model.Persona;

/**
 * @author daniel
 *
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
