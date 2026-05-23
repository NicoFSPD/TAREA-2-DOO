import java.time.Instant;
/**Clase para las invitaciones
 * @author Nicolas Fernando Silva Paredes
 * @author Daniel Cristobal Patricio Lopez Ramirez
 * @version 1.0, 20 de mayo de 2026
 * */
public class Invitacion {

    private Instant hora;
    private Invitable invitado;
    /**Constructor de la clase
     * @param hora
     * @param invitado */
    public Invitacion(Instant hora, Invitable invitado) {
        this.hora = hora;
        this.invitado = invitado;
    }


    /**
     * Getter hora
     * @return hora
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Setter hora
     * @param hora
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Getter invitado
     * @return invitado
     */
    public Invitable getInvitado() {
        return invitado;
    }

    /**
     * Setter invitado
     * @param invitado
     */
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }
}
