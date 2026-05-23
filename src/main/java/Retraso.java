import java.time.Instant;
/**
 * Clase propia para el caso de asistencia con atraso
 * @author Nicolas Fernando Silva Paredes
 * @version 1.0 - 20 de mayo de 2026
 * */

public class Retraso extends Asistencia{
    /**
     * Se registra la hora de llegada precisa (referencia de cuanto tiempo de atraso)
     */
    private Instant hora;
    /**Constructor de la clase
     * @param participante El participante que llegó atrasado
     * @param hora La hora de llegada*/
    public Retraso(Invitable participante, Instant hora) {
        super(participante);
        this.hora = hora;
    }
    /**
     * Getter de la hora de llegada
     * @return hora
     */
    public Instant getHora() {
        return hora;
    }
}
