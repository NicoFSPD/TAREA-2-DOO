import java.time.Instant;

public class Retraso extends Asistencia{

    private Instant hora;

    public Retraso(Invitable participante, Instant hora) {
        super(participante);
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }
}
