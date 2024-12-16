<h1>HOLA BIENVENIDO A MI PROYECTO DE ALURA LITERATURA</h1>

 <h2>Índice</h2>
    <ol>
        <li><a href="#introduccion">Introducción</a></li>
        <li><a href="#descripcion">Descripción de la Aplicación</a></li>
        <li><a href="#etapaDesarrollo">Etapa de Desarrollo</a></li>
        <li><a href="#tecnologias">Tecnologías Implementadas</a></li>
        <li><a href="#erroresYSoluciones">Errores en el Proceso y Soluciones Adoptadas</a></li>
        <li><a href="#etapaPruebas">Etapa de Pruebas</a></li>
        <li><a href="#funcionamiento">Funcionamiento de la Aplicación</a></li>
        <li><a href="#agradecimientos">Agradecimientos</a></li>
    </ol>

    
  <h3 id="introduccion">Introducción</h3>
    <p>hola qué tal, mi nombre es Oscar Alejandro González, soy actual estudiante de alura en el programa one de Oracle
    actualmente no me dedico de profesión al tema de informática y desarrollo de software. este proyecto representa un reto
    por parte de la escuela en la que actualmente estoy cursando los estudios enfocados en la tecnología de Java.
    Este es el segundo de tres proyectos que tengo que entregar antes del 21 de enero del 2025. representó un enorme desafío
    ya que como lo dije en un inicio no me dedico al tema de la informática. espero les guste mi proyecto y les mando un enorme saludo
    en donde quiera que te encuentres</p>

  <h3 id="descripcion">Descripción de la Aplicación</h3>
    <p>esta aplicación se trata acerca de un buscador de libros, así es esta aplicación se encarga
    de buscar tus libros favoritos y de ahí mostrarlos en una pantalla con las informaciones como por ejemplo
    el título del libro el autor del libro el idioma y una breve sinopsis.
    a su vez esta aplicación conecta con una base de datos en la cual tú puedes guardar el libro que has buscado
    para posteriormente volverlo a consultar ya que esta aplicación se compone de varias opciones y una de ellas es
    la de consultar los libros buscados también hay otras opciones cómo mostrar los autores, mostrar el top de los libros descargados
    y también imprime el solo el título y la sinopsis del libro.
    Estas consultas se realizan mediante una api una página que contiene datos acerca de libros la cual se conecta a través de esta aplicación.</p>

  <h3 id="etapaDesarrollo">Etapa de Desarrollo</h3>
  <p>al principio ya tenía conocimiento de cómo empezar a desarrollar la aplicación, según los conocimientos
        adquiridos en los cursos: 
      
  JAVA: trabajando con lambdas streams y spring framework
     JAVA: persistencia de datos y consultas con spring data jpa
      
  Pero una vez iniciando me encontré con el problema de que no sabía cómo traer la información de una lista de un json
     la verdad es que me la pasé casi una semana realizando el proyecto y leyendo mucha de la documentación proporcionada,
     hubo ocasiones en que estaba haciendo lo mismo lo mismo y lo mismo y no me salía hasta que decidí hacer otra cosa
     ni pedí ayuda haciendo unas consultas con chat gtp de cómo de serializar una lista de un json y solo ahí fue cuando
     pude seguir avanzando en el proyecto  
  </p>
    
    
  <h3 id="tecnologias">Tecnologías Implementadas</h3>
    <p> las tecnologías aplicadas para el desarrollo de esta aplicación fueron las siguientes:
    JAVA 17
    SPRIN FRAMEWORK
    SPRING DATA JPA
    DEPENDENCIAS MAVEN
    POSTGRES SQL

  Y LOS PROGRAMAS QUE USÉ PARA SU DESARROLLO:
       INTELIJ
       PgAdmin 4
       postman
       
        
  </p>

  <h3 id="erroresYSoluciones">Errores en el Proceso y Soluciones Adoptadas</h3>
    <p>en el proceso de desarrollo de esta aplicación las principales fallas que tuve fueron de escritura
    había ocasiones en que de un lado de una clase estaba escrito con una mayúscula y del otro lado estaba escrito con una minúscula 
    y por un pequeño error de esos el programa no da marcha se soluciona el error al hacer la corrección
    
  otro de los errores que tuve fue no haber añadido las dependencias adecuadas al
  inicio así que tuve que ir a la página de sprint y descargar las dependencias que me hacían falta
  
  también hay que tener mucho cuidado a la hora de hacer la conexión entre la base de datos
  e intelij ya que si en tu archivo application properties no está bien redactado puede que tengas algún error de conexión
  
  Y el último pero el más tardado en resolver fue que no sabía o no entendía cómo
  traer los datos de una lista que se encuentra dentro de otra lista,  tuve que pedir ayuda a chat gtp  </p>

    
  <h3 id="etapaPruebas">Etapa de Pruebas</h3>
    <p>en esta etapa se tuvieron que corregir diversos errores ya que al principio en el menu 
    pide que ingreses un número pero este también permitía letras lo cual hacía que tuviera un error y la aplicación parara
    fue por eso que tuve que implementar una lógica para que solo aceptara números en lugar de letras
    
   al momento de seguir con la aplicación e ingresar alguna de las opciones la aplicación te daba la consulta pero ya no hacía más
   no te devolvía otra vez al menú principal o simplemente salir de la aplicación se paraba,  ahí tuve que implementar otra lógica
   para que cada vez que uno termine la acción que le pide a la aplicación continúe la marcha  en este caso que vaya nuevamente para el menú
    
   </p>

   <h3 id="funcionamiento">Funcionamiento de la Aplicación</h3>
    <p>esta aplicación se alimenta a partir de una api la cual descarga la información en este caso del libro que estás buscando
     no sé por ejemplo en el buscador eliges la opción número uno "buscar tu libro favorito"  y este a su vez hace una consulta
     a la api y baja la información del libro lo cual sería el título el autor su año de nacimiento el número de descargas del libro y una
     breve descripción de este
    
   esta aplicación también puede guardar la información de las consultas en una base de datos que se aloja en la misma computadora
    una vez configurada.  en la opción número dos y tres podemos encontrar las informaciones de los libros almacenados
     junto con los autores para realizar consultas en un futuro
     
   la aplicación es capaz también demostrar el top de los libros más descargados comenzando por el de mayor descargas
   </p>

   <h3 id="agradecimientos">Agradecimientos</h3>
    <p> como lo dije desde un inicio yo no me dedico al tema de la informática hasta apenas mis 31 años, 
   y fue gracias a que me dieron la oportunidad en alura para demostrar a mí que no importa la edad sino las ganas
     de querer aprender y superarse en la vida en serio que si no fuera por ellos en este momento estaría haciendo otras cosas
     one Oracle alura mi vida ha cambiado bastante me he vuelto una persona más disciplinada más ordenada
     y sobre todo con más fuerza de voluntad gracias a cada uno de los instructores que hacen posible que mi aprendizaje
     cada día sea más y más y más,  gracias a todas las personas en discord del backend a los instructores que me apoyaron a resolver mis dudas
     y sobre todo a ti que estás leyendo este README  muchas gracias por tomarte el tiempo saludos de corazón desde Querétaro a México</p>
