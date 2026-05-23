import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Representacion de una reunión presencial.
 * <p>
 * Clase que hereda los atributos y comportamientos generales de la clase
 * padre Reunion y que incluye la logica para poder tener encuentros
 * fisicos con la asignacion de salas.
 * </p>
 * @author Eduardo Alexander Riveros Medina
 * @version 1.0 - 23 de mayo de 2026
 */
public class ReunionPresencial extends Reunion{
    /** El nombre de la sala donde se hará la reunión. */
    private String sala;

    /**
     * Constructor para inicializar la reunión presencial con sus datos
     * @param fecha            Fecha de calendario programada para la reunion.
     * @param horaPrevista     Hora de inicio de la reunion.
     * @param duracionPrevista El tiempo estimado o bloque horario reservado para la reunion.
     * @param organizador      Empleado responsable de convocar y coordinar la reunión.
     * @param tipo             Propósito o del encuentro (puede ser  MARKETING, TECNICA u otra).
     * @param sala             Nombre de la sala reservada.
     */
    public ReunionPresencial(Date fecha,Instant horaPrevista,Duration duracionPrevista,Empleado organizador,tipoReunion tipo,String sala){
        super(fecha,horaPrevista,duracionPrevista,organizador,tipo);
        this.sala = sala;
    }

    //getter/setter sala
    /**
     * Recibe el identificador (nombre/numero/otro) de la sala asignada a la reunion.
     * @return Stirng con el nombre/numero de la sala de la reunion.
     */
    public String getSala(){
        return sala;
    }

    /**
     * Asigna/Modifica la sala donde se realizará la reunion.
     * * @param sala Nombre/Identificador de la sala a establecer.
     */
    public void setSala(String sala){
        this.sala = sala;
    }

    /**
     * Genera una descripción de la reunión presencial.
     * <p>
     * Reutiliza la representación general de la clase base y le agrega la
     * especificación de que es un evento presencial, más la sala utilizada.
     * </p>
     * * @return String con los datos completos de la reunion.
     */
    @Override
    public String toString(){
        return super.toString() + "presencial\nSala: " + sala + "\n";
    }
}
