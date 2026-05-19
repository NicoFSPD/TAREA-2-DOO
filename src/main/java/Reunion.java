import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    //atributos
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Empleado organizador;
    private tipoReunion tipo;
    private List<Invitacion> invitaciones;
    private List<Asistencia> asistencias;
    private List<Nota> notas;

    //clase constructora
    public Reunion(Date fecha,Instant horaPrevista,Duration duracionPrevista,Empleado organizador,tipoReunion tipo) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipo = tipo;
        this.invitaciones = new ArrayList<>();
        this.asistencias = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    //metodos a rellenar
    public List<Asistencia> obtenerAsistencias(){
        return null;
    }
    public List<Invitable> obtenerAusencias(){
        return null;
    }
    public List<Retraso> obtenerRetrasos(){
        return null;
    }
    public int obtenerTotalAsistencia(){
        return 0;
    }
    public float obtenerPorcentajeAsistencia(){
        return 0.0f;
    }
    public float calcularTiempoReal(){
        return 0.0f;
    }
    public void agregarInvitacion(){}
    public void agregarAsistencia(){}
    public void agregarNota(){}
    public void iniciar(){}
    public void finalizar(){}

    //getters y setters
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }
    public Instant getHoraInicio() {
        return horaInicio;
    }
    public Instant getHoraFin() {
        return horaFin;
    }
    public Empleado getOrganizador() {
        return organizador;
    }
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }
    public tipoReunion getTipo() {
        return tipo;
    }
    public void setTipo(tipoReunion tipo) {
        this.tipo = tipo;
    }
    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }
    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }
    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
    public List<Nota> getNotas() {
        return notas;
    }
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    //metodo toString con texto incluido
    @Override
    public String toString() {
        return "Reunion programada el " + fecha + " organizada por " + organizador.getNombreCompleto();
    }
}
