# TAREA-2-DOO
Desarrollo Orientado a Objetos - Tarea 2

Integrantes:
            - Daniel López Ramirez
            - Eduardo Riveros Medina
            - Nicolás Silva Paredes

#############################################
## ACTUALIZACIONES AL DIAGRAMA UML INICIAL ##
#############################################

Clase Asistencia
- Participante (Atributo)
  A diferencia del UML anterior, ahora con el uso de la interfaz invitable se puede
  invitar a un invitado, un departamento o a otra persona externa sin la necesidad
  de un codigo distinto para cada uno.

- toString() (Metodo)
  evita errores de null si es que no hay ningun participante asignado y además ayuda
  a mostrar los datos de todos si es necesario

---------------------------------------
Clase Empleado
- Departamento (Atributo)
  Se implementó junto a sus metodos para poder trabajarlo con conjunto de los setters
  y getters.

- toString() (Metodo)
  Con el tostring, en caso de que el empleado no tenga departamento asignado
  se imprime "ninguno"

---------------------------------------
Clase Departamento
- List<Empleado>:
  Se usó para poder trabajar con el listado completo de empleados que pertenecieran
  a un departamento

- agregarEmpleado (Metodo):
  Se usa para agregar los empleados y se asegura lógicamente que no se ingrese ningun
  empleado null, ni duplicado

---------------------------------------

Clase Invitacion

-   Invitado (Atributo):

    Es un atributo que se deduce y deriva de la explicita relación de realización 
    con la interface "Invitable", de la cual también hay cosas adicionales. 
    Es necesaria para lograr hacerle llegar una invitación a la reunión a un
    empleado del cual es necesaria su presencia (Asistencia) en la reunion, y además 
    para poder hacer un punto de inflexión entre los objetos que son solamente empleados, 
    y los empleados con calidad de invitado para una reunion como tal.

---------------------------------------

Clase Nota:

- Autor (Atributo):

    La nota va a poseer, además de solo un cuerpo, el Autor que la escribió y envió.


- Fecha (Atributo):
    
    La fecha de creación y envío de la nota, como información adicional respecto de la nota como tal.

Esto induce implementaciones nuevas en la clase Reunión como el contenedor de todas las notas hechas 
durante la reunión 	(List<Nota> notas y el método agregarNota())

- generarInforme (Metodo)
  Automatiza la creacion del archivo de texto "InformedeReunion.txt", usando try-catch y lanzando una
  exception en el caso de error.

---------------------------------------------------------------
Clase ReunionPresencial
- Constructor:
  recibe los parametros para setear la reunion y se los pasa directamente a la clase padre, además,
  inicializando la sala.

- Getters y Setters:
  Ayudan a manejar el atributo "sala".

- toString() (Metodo)
  concatena la informacion de la reunion presencial.

----------------------------------------------------------------
Clase ReunionVirtual (analogo a ReunionPresencial)
- Constructor:
  recibe los parametros para setear la reunion y se los pasa directamente a la clase padre, además,
  inicializando la sala.

- Getters y Setters:
  Ayudan a manejar el atributo "enlace".

- toString() (Metodo)
  concatena la informacion de la reunion virtual.

----------------------------------------------------------------
Clase InvitadoExterno
- Clase completa nueva
  Se agrego la clase completa para poder registrar y gestionar a las personas que no pertenezcan a
  la empresa.

- Interfaz
  Con "Invitable", queda definido invitar(), el cual envia la confirmacion al correo de las personas
  que lo usen. Tambien se implemento su getNombre() y GetApellido() que facilitan el manejo de los
  atributos.

- Getters, Setters y Constructor:
  Constructor ayuda a setear los atributos de la clase, mientras que los getters y setters ayudan al
  trabajo externo de los atributos privados de la clase

- toString() (Metodo)
  Genera una representacion de la informacion de la persona invitada.




 