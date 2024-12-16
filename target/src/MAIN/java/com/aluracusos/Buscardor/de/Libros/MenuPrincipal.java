package com.aluracusos.Buscardor.de.Libros;


import com.aluracusos.Buscardor.de.Libros.modelos.DaAutor;
import com.aluracusos.Buscardor.de.Libros.modelos.DaLibros;
import com.aluracusos.Buscardor.de.Libros.modelos.DatosLibros;
import com.aluracusos.Buscardor.de.Libros.modelos.DatosRecord;
import com.aluracusos.Buscardor.de.Libros.repository.RepoAutor;
import com.aluracusos.Buscardor.de.Libros.repository.RepoLibros;
import com.aluracusos.Buscardor.de.Libros.servicios.ConsumoAPI;
import com.aluracusos.Buscardor.de.Libros.servicios.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

//VARIABLES DE USO GENERAL//

public class MenuPrincipal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private RepoLibros libroRepository;
    private RepoAutor autorRepository;
    private List<DaLibros> libros;
    private List<DaAutor> autores;

    //CONSTRUCTOR DEL REPOCITORIO//
    public MenuPrincipal(RepoLibros libroRepository, RepoAutor autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    //ESTE ES EL MENU DE OPCIONES//
    public void muestraElMenu() {
        var opcion = 1;
        while (opcion != 0) {
            var menu = """
                    
                    -------------------------------------
                    -----BUCADOR DE LIBROS 1.0-----------
                    -------------------------------------
                    ====POR ALEX GONZALEZ DESARROLLOS====
                    -------------------------------------
                    
                              MENU DE OPCIONES
                    
                    -------------------------------------          
                              
                    1 - Ingresar un Libro a la Coleccion.
                    
                    2 - Consulta la lista de Libros.
                    
                    3 - Consulta los Autores Registrados
                    
                    4-  Top libros mas Descargados
                    
                    5-  Caracteristicas de Libros
                                 
                    0 - Salir
                    
                    
                    ------------------------------------
                    """;
            System.out.println(menu);
            String menuOpciones = teclado.nextLine();
            //AQUI VALIDAMOS DATOS(SOLO NUMEROS)//
            try {
                opcion = Integer.parseInt(menuOpciones);
            } catch (NumberFormatException e) {
                System.out.println("""
                        ------------------------------------
                         INGRESE UN VALOR NUMERICO DEL MENU
                              ----EJEMPLO 1 O 2 ;)----
                        ------------------------------------""");
                continuar();
                continue;

            }
            //SWITCH OPCIONES//
            switch (opcion) {
                case 1:
                    escribeLibroWeb();
                    break;
                case 2:
                    motrarLibrosBuscados();
                    break;
                case 3:
                    listaAutoresBuscados();
                case 4:
                    topDescargas();
                    break;
                case 5:
                    caracteristicasLlibros();

                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    //DATOS DE LIBROS BUSCADOS//
    private DatosLibros getDatosLibros() {
        System.out.print("Escribe tu libro Favorito--> ");
        var tituloIngresado = teclado.nextLine();
        String json = consumoApi.obtenerDatosLibros(URL_BASE + "?search=" + tituloIngresado.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, DatosRecord.class);
        return datosBusqueda.listaLibros().stream()
                .filter(datosLibros -> datosLibros.titulo().toUpperCase().contains(tituloIngresado.toUpperCase()))
                .findFirst()
                .orElse(null);
    }

    //OPCIONES SEGUN EL MENU JUNTO CON LA LOGICA DEL FUNCIONAMIENTO//
    public void escribeLibroWeb(){
        DatosLibros datos = getDatosLibros();

        if (datos == null) {
            System.out.println("------------------------------------------------");
            System.out.println("************No Encontre el libro :( *********** ");
            System.out.println("------------------------------------------------");
            continuar();
            return;
        }


        List<DaAutor> autores = datos.autor().stream()
                .map(datosAutor -> autorRepository.findByNombre(datosAutor.nombre())
                        .orElseGet(() -> {

                            DaAutor nuevoAutor = new DaAutor();
                            nuevoAutor.setNombre(datosAutor.nombre());
                            nuevoAutor.setFechaNacimiento(datosAutor.fechaNacimiento());
                            autorRepository.save(nuevoAutor);
                            return nuevoAutor;
                        })
                ).collect(Collectors.toList());
        DaLibros libro = new DaLibros(datos);
        libro.setAutores(autores);
        libroRepository.save(libro);
        System.out.println("El libro buscado es: " + datos);
        continuar();
    }


    private void motrarLibrosBuscados() {
        List<DaLibros> libros = libroRepository.findAll();

        libros.stream()
                .sorted(Comparator.comparing(DaLibros::toString))
                .forEach(System.out::println);
        continuar();

    }
    private void listaAutoresBuscados() {
        List<DaAutor> autores = autorRepository.findAll();

        autores.stream()
                .sorted(Comparator.comparing(DaAutor::toString))
                .forEach(System.out::println);
        continuar();

    }


    private void topDescargas() {
        List<DaLibros> toplibros = libroRepository.findTop10ByOrderByNumeroDeDescargasDesc();
        toplibros.forEach(s->
                System.out.println("""
                        
                        
                        ============================
                        ===TOP DESCARGAS LIBROS=====
                        ============================
                        
                        LIBRO: %s
                        
                        NUMERO DESCARGAS: %s
                        
                        """.formatted(s.getTitulo(), s.getNumeroDeDescargas())));
        continuar();


    }

    private void caracteristicasLlibros() {
        List<DaLibros> caracateristicas = libroRepository.findAll();
        caracateristicas.forEach(s->
                System.out.println("""
                        
                        
                        ============================
                        =======DETALLES LIBRO=======
                        ============================
                        
                        LIBRO:  %s
                        CARACTERISTICAS: %s
                        
                        
                       """.formatted(s.getTitulo(),s.getDetallesLibro())));
        continuar();

    }



    //ESTE CODIGO PERMITE CONTINUAR LA APLICACION SIN QUE PARE POR ALGUN ERROR//
    private void continuar() {
        System.out.println("\nPresione 'Enter' para continuar...");
        teclado.nextLine();
    }



}
