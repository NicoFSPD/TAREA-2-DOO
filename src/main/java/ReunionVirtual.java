import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista,Empleado organizador,tipoReunion tipo,String enlace){
        super(fecha,horaPrevista,duracionPrevista,organizador,tipo);
        this.enlace = enlace;
    }

    //getter/setter enlace
    public String getEnlace(){
        return enlace;
    }

    public void setEnlace(String enlace){
        this.enlace = enlace;
    }

    //descripcion de la reunion
    @Override
    public String toString(){
        return super.toString() + "Virtual\nEnlace: " + enlace + "\n";
    }
}

