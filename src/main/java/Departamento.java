import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento al que pertenecen empleados.
 * <p>
 * Clase que agrupa a un conjunto de empleados.
 * Al implementar la interfaz "Invitable", se puede invitar a todos los empleados
 * de un departamento de forma masivas, propagando la invitacion
 * automáticamente a cada uno de los trabajadores registrados.
 * </p>
 * @author Eduardo Alexander Riveros Medina
 * @author Nicolas Fernando Silva Paredes
 * @version 1.0 - 23 de mayo de 2026
 */
public class Departamento implements Invitable {

    /** El nombre del departamento */
    private String nombre;

    /** Lista que almacena los empleados pertenecientes al departamento */
    private List<Empleado> empleados;

    /**
     * Constructor que inicializa el departamento con su nombre
     * y genera una estructura vacía para su lista de empleados.
     * @param nombre El nombre que se le asignara al departamento en cuestion.
     */
    public Departamento(String nombre){
        this.nombre= nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Registra un nuevo empleado en el departamento corresṕondiente.
     * <p>
     * metodo que asegura que el objeto no sea nulo y que no se encuentre
     * ya registrado previamente dentro de la lista para evitar empleados duplicados.
     * </p>
     * @param empleado Objeto "Empleado" que se desea integrar al departamento en cuestion.
     */
    public void agregarEmpleado(Empleado empleado){
        if (empleado != null && !empleados.contains(empleado)){
            empleados.add(empleado);
        }
    }

    /**
     * Calcula y devuelve el numero total de trabajadores que pertenecen actualmente
     * al departamento usando el tamaño de la lista.
     * @return Cantidad de empleados en la lista.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Invitacion a todo el departamento a una reunion.
     * <p>
     * Con la interfaz "Invitable", notifica la acción de invitar al departamento
     * generalmente por consola, uno por uno de forma secuencial el metodo {@code invitar()}
     * individual de cada uno de los empleados adscritos a este departamento
     * </p>
     */
    @Override
    public void invitar(){
        System.out.println("Invitacion a todos los empleados del departamento " + nombre + " enviada");
        for(Empleado emp: empleados){
            emp.invitar();
        }
    }

    /**
     * Recibe el nombre del departamento.
     * @return String con el nombre actual.
     */
    public String getNombre(){
        return nombre;
    }

    @Override
    public String getApellido() {
        return "";
    }

    /**
     * Coloca/Modifica el nombre del departamento.
     * @param nombre Nombre a establecer para el departamento.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Recibe la lista completa de empleados vinculados al departamento.
     * @return Una lista con los empleado.
     */
    public List<Empleado> getEmpleados(){
        return empleados;
    }

    /**
     * Coloca/Modifica una nueva lista completa de empleados al departamento.
     * @param empleados Lista de empleados del departamento.
     */
    public void setEmpleados(List<Empleado> empleados){
        this.empleados = empleados;
    }

    /**
     * Genera una cadena de texto detallando el estado del departamento.
     * <p>
     * Para evitar problemas de recursión infinita con toString()
     * de "Empleado", el método solo llama el nombre y apellido
     * combinados de cada empleado y los concatena junto al nombre del departamento.
     * </p>
     * @return Representación formateada con los datos del departamento.
     */
    @Override
    public String toString(){
        List<String> nombresEmpleados = new ArrayList<>();
        for (Empleado emp : empleados){
            nombresEmpleados.add(emp.getNombre() + " " + emp.getApellido());
        }
        return "Departamento {" + nombre + "/" + " empleados" + nombresEmpleados + "}";
    }
}
