
/**
 * Invitado externo.
 * <p>
 * Esta clase almacena los datos de una persona que no es parte de la organización.
 * Al implementar la interfaz "Invitable", queda disponible para ser invitado
 * y poder asistir a las reuniones utilizando el polimorfismo.
 * </p>
 * @author Eduardo Alexander Riveros Medina
 * @version 1.0
 */
public class InvitadoExterno implements Invitable {

    /** Nombre del invitado */
    private String nombre;
    /** Apellido del invitado */
    private String apellido;
    /** Correo del invitado */
    private String correo;

    /**
     * Constructor que inicializa al invitado externo con sus datos
     * @param nombre Nombre del invitado.
     * @param apellido Apellido del invitado.
     * @param correo Direccion de correo del invitado.
     */
    public InvitadoExterno(String nombre, String apellido, String correo){
        this.nombre = nombre;
        this.correo = correo;
        this.apellido = apellido;
    }

    /**
     * Invitacion del invitado a una reunion
     * <p>
     * metodo que implementa a "Invitable" e imprime la confirmacion
     * de la invitacion por consola al correo correspondiente.
     * </p>
     */
    @Override
    public void invitar() {
        System.out.println("Invitacion enviada a " + correo);
    }

    /**
     * Recibe el apellido del invitado.
     * @return String del/los apellidos.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Coloca/Modifica los apellidos al invitado correspondiente.
     * @param apellido Apellidos a asignarle.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Recibe el nombre del invitado.
     * @return String del nombre.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Coloca/Modifica el nombre al invitado.
     * @param nombre Nombre a asignarle.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Recibe el Correo del invitado externo.
     * @return String de la direccion de correo.
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Coloca/modifica un correo a un invitado externo.
     * @param correo Correo a asignar.
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }

    /**
     * Imprime los datos del invitado.
     * <p>
     * Incluye Nombre completo (nombre y apellido/s) junto a su correo.
     * </p>
     * @return String del invitado externo con sus datos.
     */
    @Override
    public String toString(){
        return "InvitadoExterno {" + "nombre completo= " + nombre + apellido + "/" + "correo= " + correo + "}";
    }
}