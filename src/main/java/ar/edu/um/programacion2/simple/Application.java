package ar.edu.um.programacion2.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.um.programacion2.simple.model.Persona;
import ar.edu.um.programacion2.simple.service.PersonaService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PersonaService personaService;

	@Override
	public void run(String... args) throws Exception {
		Persona persona = new Persona(22222222L, "Garcia", "Juan");
		persona = personaService.add(persona);
		
	}

}
