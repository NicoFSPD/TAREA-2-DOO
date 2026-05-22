import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento al que pertenecen empleados.
 * <p>
 * Clase que agrupa a un conjunto de empleados.
 * Al implementar la interfaz "Invitable", se puede invitar a todos los empleados
 * de un departamento de forma masivas, propagando la invitación
 * automáticamente a cada uno de los trabajadores registrados.
 * </p>
 * @author Eduardo Riveros Medina
 * @version 1.0
 */
public class Departamento implements Invitable {

    /** El nombre del departamento */
    private String nombre;

    /** Lista que almacena los empleados pertenecientes al departamento */
    private List<Empleado> empleados;   //lista de los empleados que debeerian pertenecer al departamento en cuestion

    /**
     * Constructor que inicializa el departamento con su nombre
     * y genera una estructura vacía para su lista de empleados.
     * @param nombre El nombre que se le asignará al departamento en cuestion.
     */
    public Departamento(String nombre){
        this.nombre= nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Registra un nuevo empleado en el departamento corresṕondiente.
     * <p>
     * meetodo que asegura que el objeto no sea nulo y que no se encuentre
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
     * Calcula y devuelve el número total de trabajadores que pertenecen actualmente
     * al departamento usando el tamaño de la lista.
     * @return Cantidad de empleados en la lista.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Invitacion a todo el departamento a una reunión.
     * <p>
     * Con la  interfaz "Invitable", notifica la acción de invitar al departamento
     * generalmente por consola, uno por uno de forma secuencial el metodo {@code invitar()}
     * individual de cada uno de los empleados adscritos a este departamento.
     * </p>
     */
    @Override
    public void invitar(){
        System.out.println("Invitacion a todos los empleados del departamento " + nombre + " enviada");
        for(Empleado emp: empleados){
            emp.invitar();      //el ciclo invita a todos los de la lista del departamento
        }
    }

    //--SETTERS Y GETTERS--

    /**
     * Recibe el nombre del departamento.
     * @return String con el nombre actual.
     */
    public String getNombre(){
        return nombre;
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
            nombresEmpleados.add(emp.getNombre() + " " + emp.getApellidos());
        }
        return "Departamento {" + nombre + "/" + " empleados" + nombresEmpleados + "}";
    }
}
