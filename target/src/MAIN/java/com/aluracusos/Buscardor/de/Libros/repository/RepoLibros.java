package com.aluracusos.Buscardor.de.Libros.repository;

import com.aluracusos.Buscardor.de.Libros.modelos.DaLibros;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



    @Repository
    public interface RepoLibros extends JpaRepository<DaLibros, Long> {
        //ESTE CODIGO TRAE LA INFORMACION GUARDADA DE NUMERO DE DESCARGAS//
        List<DaLibros> findTop10ByOrderByNumeroDeDescargasDesc();
        //ESTE CODIGO TRAE TODA LA INFORMACION DE LOS LIBROS REGISTRADOS//
        List<DaLibros>  findAll();

    }

