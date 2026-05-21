import java.time.Instant;
/**Clase para las invitaciones
 * @author Nicolás Silva
 * @author Daniel Ramirez
 * @version 1.0, 20 de mayo de 2026
 * */
public class Invitacion {
    //Implementación interpretada, adicional a lo ya entregado en el UML
    private Instant hora;
    private Invitable invitado;
    /**Constructor de la clase
     * @param hora
     * @param invitado */
    public Invitacion(Instant hora, Invitable invitado) {
        this.hora = hora;
        this.invitado = invitado;
    }
    //Getter y Setter para la hora
    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }
    //Getter y Setter para el Invitado
    public Invitable getInvitado() {
        return invitado;
    }
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }
}
