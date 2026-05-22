/**
 * Interfaz que define el contrato de comportamiento para cualquier entidad
 * que pueda ser convocada o citada a una reunión dentro del sistema.
 * <p>
 * Mediante esta interfaz, se abstracta el concepto de "participante" o "asociado",
 * permitiendo que ,con el uso de polimorfismo, clases con codigo distinto (como Departamento
 * o empleado) puedan ser manejadas de forma distinta.
 * </p>
 * * @author Eduardo Riveros Medina
 * @version 1.0
 */
public interface Invitable {
    /**
     * Notifica la invitación..
     * <p>
     * Las clases que implementen este metodo deben definen su propia logica
     * específica de envío.
     * </p>
     */
    public void invitar();
}
