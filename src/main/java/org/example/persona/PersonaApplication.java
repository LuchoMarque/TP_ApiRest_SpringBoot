package org.example.persona;

import org.example.persona.entities.Persona;
import org.example.persona.repositories.PersonaRepository;
import org.example.persona.entities.Domicilio;
import org.example.persona.repositories.DomicilioRepository;
import org.example.persona.entities.Localidad;
import org.example.persona.repositories.LocalidadRepository;
import org.example.persona.entities.Libro;
import org.example.persona.repositories.LibroRepository;
import org.example.persona.entities.Autor;
import org.example.persona.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class PersonaApplication implements CommandLineRunner {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(PersonaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear 2 domicilios
        Domicilio domicilio1 = new Domicilio();
        domicilio1.setCalle("Calle 123");
        domicilio1.setNumero(456);

        Domicilio domicilio2 = new Domicilio();
        domicilio2.setCalle("Avenida Siempreviva");
        domicilio2.setNumero(742);

        domicilioRepository.save(domicilio1);
        domicilioRepository.save(domicilio2);

        // Crear 1 localidad
        Localidad localidad = new Localidad();
        localidad.setDenominacion("Buenos Aires");

        localidadRepository.save(localidad);

        // Asignar la localidad a los domicilios
        domicilio1.setLocalidad(localidad);
        domicilio2.setLocalidad(localidad);
        domicilioRepository.save(domicilio1);
        domicilioRepository.save(domicilio2);

        // Crear 2 personas
        Persona persona1 = new Persona();
        persona1.setNombre("Ramiro");
        persona1.setApellido("Diz");
        persona1.setDni(6534123);
        persona1.setDomicilio(domicilio1);

        Persona persona2 = new Persona();
        persona2.setNombre("German");
        persona2.setApellido("Garmendia");
        persona2.setDni(12345678);
        persona2.setDomicilio(domicilio2);

        personaRepository.save(persona1);
        personaRepository.save(persona2);

        // Crear 2 autores
        Autor autor1 = new Autor();
        autor1.setNombre("Jorge Luis");
        autor1.setApellido("Borges");
        autor1.setBiografia("Autor de Ficciones");

        Autor autor2 = new Autor();
        autor2.setNombre("Julio");
        autor2.setApellido("Cortázar");
        autor2.setBiografia("Autor de Rayuela");

        autorRepository.save(autor1);
        autorRepository.save(autor2);

        // Crear 3 libros
        Libro libro1 = new Libro();
        libro1.setTitulo("Ficciones");
        libro1.setGenero("Fantasía");
        libro1.setFecha(1989);
        libro1.setPaginas(200);

        Libro libro2 = new Libro();
        libro2.setTitulo("Rayuela");
        libro2.setGenero("Realismo mágico");
        libro2.setFecha(1944);
        libro2.setPaginas(600);

        Libro libro3 = new Libro();
        libro3.setTitulo("El Aleph");
        libro3.setGenero("Fantasía");
        libro3.setFecha(1947);
        libro3.setPaginas(150);

        libro1.getAutores().add(autor1);
        libro2.getAutores().add(autor2);
        libro3.getAutores().add(autor1);
        libro3.getAutores().add(autor2);

        libroRepository.save(libro1);
        libroRepository.save(libro2);
        libroRepository.save(libro3);

        System.out.println("Datos añadidos correctamente.");



    }




}
