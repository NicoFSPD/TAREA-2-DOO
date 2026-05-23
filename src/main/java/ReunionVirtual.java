import java.time.Duration;
import java.time.Instant;
import java.util.Date;
/**
 * Representacion de una reunión virtual.
 * <p>
 * Clase que hereda los atributos y comportamientos generales de la clase
 * padre Reunion y que incluye la logica para poder tener encuentros
 * virtuales con la asignacion de enlaces.
 * </p>
 * @author Eduardo Alexander Riveros Medina
 * @version 1.0 - 23 de mayo de 2026
 */
public class ReunionVirtual extends Reunion{

    /** El enlace o link de la plataforma donde se hará la reunión. */
    private String enlace;

    /**
     * Constructor para inicializar la reunión virtual con sus datos
     * @param fecha            Fecha de calendario programada para la reunion.
     * @param horaPrevista     Hora de inicio de la reunion.
     * @param duracionPrevista El tiempo estimado o bloque horario reservado para la reunion.
     * @param organizador      Empleado responsable de convocar y coordinar la reunión.
     * @param tipo             Propósito o del encuentro (puede ser  MARKETING, TECNICA u otra).
     * @param enlace           Enlace o link reservado.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista,Empleado organizador,tipoReunion tipo,String enlace){
        super(fecha,horaPrevista,duracionPrevista,organizador,tipo);
        this.enlace = enlace;
    }

    /**
     * Recibe el identificador (link/url/otro) del enlace asignado a la reunion.
     * @return String con el enlace de la reunion.
     */
    public String getEnlace(){
        return enlace;
    }

    /**
     * Asigna/Modifica el enlace donde se realizará la reunion.
     * @param enlace Link/Identificador del enlace a establecer.
     */
    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    /**
     * Genera una descripción de la reunión virtual.
     * <p>
     * Reutiliza la representación general de la clase base y le agrega la
     * especificación de que es un evento virtual, más el enlace utilizado.
     * </p>
     * @return String con los datos completos de la reunion.
     */
    @Override
    public String toString(){
        return super.toString() + "Virtual\nEnlace: " + enlace + "\n";
    }
}

