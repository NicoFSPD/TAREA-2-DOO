
/**
 * Representa a un empleado dentro de la organización.
 * <p>
 * Clase que almacena los datos del trabajador,
 * y vinculación al departamento respectivo. Con la implementacion de
 * interfaz "Invitable",al empleado queda disponible para ser invitado
 * y poder asistir a las reuniones.
 * </p>
 * * @author Eduardo Riveros Medina
 * @version 1.0
 */
public class Empleado implements Invitable{
    /** Identificador personal de cada empleado */
    private String id;
    /** Nombre del empleado */
    private String nombre;
    /** Apellidos del empleado */
    private String apellido;
    /** Correo electronico del empleado */
    private String correo;
    /** Departamento al que pertenece el empleado */
    private Departamento departamento;

    public Empleado(String id, String apellido, String nombre, String correo, Departamento departamento){
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    /**
     * Invitacion del empleado a una reunion
     * <p>
     * metodo que implemeta a "Invitable", imprime la confirmacion
     * de la invitacion y "envia una notificacion al correo".
     * <p>
     */
    @Override
    public void invitar() {
        System.out.println("Invitacion enviada a " + correo);
    }

    //----------- GETTERS Y SETTERS -------------

    /**
     * Recibe el ID del empleado.
     * @return String del ID.
     */
    public String getId(){
        return id;
    }

    /**
     * Coloca/modifica un ID a un empleado.
     * @param id ID a asignar.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Recibe el Apellido del empleado.
     * @return String del/los apellidos.
     */
    public String getApellido(){
        return apellido;
    }

    /**
     * Coloca/modifica los apellidos a un empleado.
     * @param apellido apellidos a asignar.
     */
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    /**
     * Recibe el nombre del empleado.
     * @return String del nombre.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Coloca/modifica el nombre a un empleado.
     * @param nombre nombre a asignar.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Recibe el Correo del empleado.
     * @return String de la direccion de correo.
     */
    public String getCorreo(){
        return correo;
    }
    /**
     * Coloca/modifica un correo a un empleado.
     * @param correo Correo a asignar.
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }

    /**
     * Recibe el Departamento al que pertenece del empleado.
     * @return Departamento al que pertenece el empleado.
     */
    public Departamento getDepartamento(){
        return departamento;
    }

    /**
     * Coloca/modifica el departamento de un  empleado.
     * @param departamento Departamento a asignar.
     */
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }


    /**
     * Imprime en texto los datos del empleado
     * <p>
     * Incluye ID, Nombre completo (incluye apellidos), correo,
     * departamento al que pertenece o si es que no pertenece a
     * ninguno.
     * </p>
     * * @return String del empleado con sus datos.
     */
    @Override
    public String toString(){
        return "Empleado {" + "id= " + id + "/ " + " nombre completo= " + nombre + " " + apellido + "/ " + "correo= " + correo + "/ " + "departamento" +
                (departamento!= null ? departamento.getNombre() : "ninguno");
    }

}
