/**
 * 
 */
package ar.edu.um.programacion2.simple.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

	@Id
	private Long documento;
	
	private String apellido;
	private String nombre;
	
}
