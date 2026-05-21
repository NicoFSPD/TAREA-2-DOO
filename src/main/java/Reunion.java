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

    //metodos
    public List<Invitable> obtenerAusencias(){
        List<Invitable> ausentes = new ArrayList<>();
        for(int i = 0; i < invitaciones.size(); i++){
            Invitacion inv = invitaciones.get(i);
            boolean asistio = false;
            for (int j = 0; j < asistencias.size(); j++){
                Asistencia asis = asistencias.get(j);
                if(inv.getInvitado().equals(asis.getParticipante())){
                    asistio = true;
                    break;
                }
            }
            if (!asistio){
                ausentes.add(inv.getInvitado());
            }
        }
        return ausentes;
    }
    public List<Retraso> obtenerRetrasos(){ //si las asistencias estan dentro de la clase Retraso se unen a esta lista
        List<Retraso> retrasos = new ArrayList<>();
        for (int i = 0;i < asistencias.size();i++){
            Asistencia asis = asistencias.get(i);
            if (asis instanceof Retraso){
                retrasos.add((Retraso) asis);
            }
        }
        return retrasos;
    }

    public int obtenerTotalAsistencia(){
        return asistencias.size();
    }

    public float obtenerPorcentajeAsistencia(){
        if(invitaciones.isEmpty()){
            return 0.0f;
        }
        return ((float)asistencias.size() / invitaciones.size()) * 100;
    }

    public float calcularTiempoReal(){
        if(horaInicio != null && horaFin != null){
            return (float) Duration.between(horaInicio,horaFin).toMinutes();
        }
        return 0.0f;
    }
    //METODO MODIFICADO: AHORA GESTIONA LOGICA DE DEPARTAMENTOS Y EMPLEADOS
    public void agregarInvitacion(Invitable participante, Instant hora){
        if (participante instanceof Departamento) {
            Departamento depto = (Departamento) participante;
            for (Empleado emp : depto.getEmpleados()) {
                Invitacion nuevaInvitacion = new Invitacion(hora, emp);
                this.invitaciones.add(nuevaInvitacion);
                emp.invitar();
            }
        } else if (participante instanceof Empleado) {
            Invitacion nuevaInvitacion = new Invitacion(hora, participante);
            this.invitaciones.add(nuevaInvitacion);
            participante.invitar();
        }
    }
    public void agregarAsistencia(Asistencia asistencia){
        this.asistencias.add(asistencia);
    }
    public void agregarNota(Nota nota){
        this.notas.add(nota);
    }
    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFin = Instant.now();
    }

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
        return "Reunion programada el " + fecha + " organizada por " + organizador.getNombre() + " " + organizador.getApellidos();
    }
}
