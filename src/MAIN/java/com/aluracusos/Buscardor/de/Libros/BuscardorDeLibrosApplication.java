package com.aluracusos.Buscardor.de.Libros;



import com.aluracusos.Buscardor.de.Libros.repository.RepoAutor;
import com.aluracusos.Buscardor.de.Libros.repository.RepoLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication


public class BuscardorDeLibrosApplication implements CommandLineRunner {
	@Autowired
	private RepoLibros libroRepository;
	@Autowired
	private RepoAutor autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(BuscardorDeLibrosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		MenuPrincipal menuPrincipal = new MenuPrincipal(libroRepository, autorRepository);
		menuPrincipal.muestraElMenu();
	}
}
