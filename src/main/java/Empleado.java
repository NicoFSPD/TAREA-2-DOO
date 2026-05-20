public class Empleado implements Invitable{
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Departamento departamento;

    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento){
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }


    @Override
    public void invitar() {
        System.out.println("Invitacion enviada a " + correo);
    }

    //----------- GETTERS Y SETTERS -------------


    public String getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(){
        this.nombre = nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public Departamento getDepartamento(){
        return departamento;
    }

    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }


    @Override
    public String toString(){
        return "Empleado {" + "id= " + id + "/" + " nombre completo= " + nombre + " " + apellidos + "/" + "correo= " + correo + "/" + "departamento" +
                (departamento!= null ? departamento.getNombre() : "ninguno");
    }

}
