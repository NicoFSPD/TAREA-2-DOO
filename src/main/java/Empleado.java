public class Empleado implements Invitable{
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String Departamento departamento;

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
    

}
