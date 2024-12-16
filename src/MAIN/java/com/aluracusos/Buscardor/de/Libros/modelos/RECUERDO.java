package com.aluracusos.Buscardor.de.Libros.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosRecord(
        @JsonAlias("results") List<DatosLibros> listaLibros
) {
}
