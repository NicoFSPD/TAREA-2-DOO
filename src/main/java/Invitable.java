/**Interface para la invitación
 * @author Nicolás Silva
 * @version 2.0 - 22 de mayo de 2026*/

public interface Invitable {
    //Funcion invitar() sacada de lo visto en el UML
    public void invitar();

    //funcionalidad para obtener nombre/apellido de cada participante
    public String getNombre();
    public String getApellido();
}
