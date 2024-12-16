package com.aluracusos.Buscardor.de.Libros.repository;

import com.aluracusos.Buscardor.de.Libros.modelos.DaAutor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepoAutor extends JpaRepository<DaAutor, Long> {
    //ESTE CODIGO TRAE LA INFORMACION DEL AUTOR//
    Optional<DaAutor> findByNombre(String nombre);
    List<DaAutor> findByNombreContainingIgnoreCase(String nombreAutor);
}
