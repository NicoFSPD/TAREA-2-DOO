import java.time.Instant;
/**Clase para las invitaciones
 * @author Nicolás Silva
 * @author Daniel Ramirez
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
    //GETTER/SETTER PARA LA HORA

    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    //GETTER/SETTER DE INVITADO
    public Invitable getInvitado() {
        return invitado;
    }
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }
}
