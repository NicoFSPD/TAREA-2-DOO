
/**
 * Registro de asistencia de un participante a una reunión.
 * <p>
 * Con el uso de la interfaz "Invitable" es posible que el sistema de
 * asistencia sea flexible y polimórfico, siendo así capaz de registrar
 * tanto a empleados individuales como a departamentos completos.
 * </p>
 * *@author Eduardo Riveros Medina
 * @version 1.0
 */
public class Asistencia{

    /** * El participante asociado al registro de asistencia.
     * Mantenido bajo la abstracción de la interfaz Invitable (Extra en el UML).
     */
    private Invitable participante;         //asosiacion dirigida hacia Empleado en el UML, AGREGADO EXTRA

    /**
     * Constructor para inicializar el registro de asistencia con su participante.
     * @param participante Empleado invitable que asiste a la reunión.
     */
    public Asistencia(Invitable participante){     //constructor
        this.participante = participante;
    }

    /**
     * Recibe el participante registrado en esta asistencia.
     * <p>
     * Este getter es un agregado extra no explícito en el UML original
     * se incorporó para permitir la lectura segura del participante.
     * </p>
     * @return El objeto {@link Invitable} asociado.
     */
    public Invitable getParticipante(){        //getter, AGREGADO EXTRA
        return participante;
    }

    /**
     * Asigna/Modifica  el participante de esta asistencia.
     * <p>
     * Este setter es un agregado extra incorporado al UML original.
     * </p>
     * @param participante Participante {@link Invitable} a asignar.
     */
    public void setParticipante(Invitable participante){       //setter, AGREGADO EXTRA
        this.participante = participante;
    }


    /**
     * Genera una representación con los datos de la asistencia.
     * <p>
     * Solicita el metodo "toString()" del participante en cuestion
     * si este se encuentra inicializado (así evita errores de null).
     * </p>
     * @return String con la información del registro.
     */
    @Override
    public String toString() {      //toString que se pide por enunciado
        return "Asistencia {" +
                "participante=" + (participante != null ? participante.toString() : "null") +
                '}';
    }
}


//todo lo que tenga un "AGREGADO EXTRA" hay que especificalo dpues en el UML
//esta clase está hecha solo para q se pueda tener conocimiento de los q fueron o no fueron a la reunion