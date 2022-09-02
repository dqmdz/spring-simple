/**
 * 
 */
package ar.edu.um.programacion2.simple.exception;

/**
 * @author daniel
 *
 */
public class PersonaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3095543865324828748L;

	public PersonaNotFoundException(Long documento) {
		super("Cannot find Persona " + documento);
	}

}
