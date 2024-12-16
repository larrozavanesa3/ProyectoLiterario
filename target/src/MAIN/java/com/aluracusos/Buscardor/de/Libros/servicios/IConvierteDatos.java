package com.aluracusos.Buscardor.de.Libros.servicios;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
