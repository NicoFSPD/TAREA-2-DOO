import java.time.Instant;

public class Nota {

    private Asistencia autor;
    private Instant hora;
    private String contenido;

    public Nota(Asistencia autor, Instant hora, String contenido) {
        this.autor = autor;
        this.hora = hora;
        this.contenido = contenido;
    }

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
