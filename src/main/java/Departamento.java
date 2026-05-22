import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado> empleados;   //lista de los empleados que debeerian pertenecer al departamento en cuestion

    public Departamento(String nombre){
        this.nombre= nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado){
        if (empleado != null && !empleados.contains(empleado)){
            empleados.add(empleado);
        }
    }

    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    @Override
    public void invitar(){
        System.out.println("Invitacion a todos los empleados del departamento " + nombre + " enviada");
        for(Empleado emp: empleados){
            emp.invitar();      //el ciclo invita a todos los de la lista del departamento
        }
    }

    //--SETTERS Y GETTERS--

    public String getNombre(){
        return nombre;
    }

    @Override
    public String getApellidos() {
        return "";
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados){
        this.empleados = empleados;
    }

    @Override
    public String toString(){
        List<String> nombresEmpleados = new ArrayList<>();
        for (Empleado emp : empleados){
            nombresEmpleados.add(emp.getNombre() + " " + emp.getApellidos());
        }
        return "Departamento {" + nombre + "/" + " empleados" + nombresEmpleados + "}";
    }
}
