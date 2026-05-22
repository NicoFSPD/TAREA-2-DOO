import java.time.Instant;
/**Implementación de la Nota
 *@author Nicolás Silva
 *@version 1.0, 21 de Mayo de 2026
 **/
public class Nota {

    private Asistencia autor;
    private Instant hora;
    private String contenido;
/**Constructor de la clase
 * @param autor Autor de la nota
 * @param hora Hora de publicación
 * @param contenido Cuerpo de la nota*/
    public Nota(Asistencia autor, Instant hora, String contenido) {
        this.autor = autor;
        this.hora = hora;
        this.contenido = contenido;
    }
// GETTERS DE CADA VARIABLE
    public Asistencia getAutor() {
        return autor;
    }

    public Instant getHora() {
        return hora;
    }

    public String getContenido() {
        return contenido;
    }

}
