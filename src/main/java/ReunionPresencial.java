import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha,Instant horaPrevista,Duration duracionPrevista,Empleado organizador,tipoReunion tipo,String sala){
        super(fecha,horaPrevista,duracionPrevista,organizador,tipo);
        this.sala = sala;
    }

    //getter/setter sala
    public String getSala(){
        return sala;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    //descripcion de la reunion
    @Override
    public String toString(){
        return super.toString() + "presencial\nSala: " + sala + "\n";
    }
}
