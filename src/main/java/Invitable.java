/**Interface para la invitación
 * @author Nicolas Fernando Silva Paredes
 * @version 2.0 - 22 de mayo de 2026*/

public interface Invitable {
    /**
     * Funcion invitar() sacada de lo visto en el UML
     * @return
     */
    void invitar();

    /**
     * Funcionalidad para obtener nombre/apellido de cada participante
     */
    String getNombre();
    String getApellido();
}
