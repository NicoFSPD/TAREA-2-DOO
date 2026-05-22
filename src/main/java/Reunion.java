import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//atributos
public abstract class Reunion implements Serializable {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant fechaInicio;
    private Instant fechaFin;
    private Empleado organizador;
    private tipoReunion tipo;
    private List<Invitacion> invitaciones;
    private List<Asistencia> asistencias;
    private List<Nota> notas;

    //clase constructora
    public Reunion(Date fecha,
                   Instant horaPrevista,
                   Duration duracionPrevista,
                   Empleado organizador,
                   tipoReunion tipo
    ) {
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
        if(fechaInicio != null && fechaFin != null){
            return (float) Duration.between(fechaInicio, fechaFin).toMinutes();
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
        this.fechaInicio = Instant.now();
    }
    public void finalizar(){
        this.fechaFin = Instant.now();
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

    public Instant getFechaInicio() {
        return fechaInicio;
    }
    public Instant getFechaFin() {
        return fechaFin;
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
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    /**Funcion que despliega un listado de los nombres de cada uno de los participantes de la reunión
     * @return Los nombres de todas las personas que asistieron*/
    public String TotaldeParticipantes(){
        String Total = "\t";
        for(Asistencia a : getAsistencias()){
            Total += "- "+a.getParticipante().getNombre().toString()+" "+ a.getParticipante().getApellidos().toString() +"\n\t";
        }
        return Total;
    }

    /**Funcion similar a la de participantes, con enfoque en especificar los atrasos
     * @return Los nombres de todas las personas que asistieron con retraso*/
    public String TotaldeRetrasos(){
        String Total = "\t";

        if(obtenerRetrasos().isEmpty()){
            Total += "No hubieron";
            return Total;
        }
        //CICLO QUE, DE HABER ATRASADOS, LOS VISITARÁ
        for(Retraso r : obtenerRetrasos()){
            Total += "- "+r.getParticipante().getNombre()+" "+r.getParticipante().getApellidos()+"\n\t";
        }
        return Total;
    }

    /**Funcion toString que entrega parte de la información relevante sobre la reunion
     * @return Cada uno de los datos que luego serán necesarios para el armado del informe .txt*/
    @Override
    public String toString() {
        return "\n\nReunion programada el " + fecha
                + "\nHora inicio: " + getFechaInicio().atZone(ZoneId.systemDefault()).toLocalTime()
                + "\nHora de termino: " + getFechaFin().atZone(ZoneId.systemDefault()).toLocalTime()
                + "\nDuracion total: " + calcularTiempoReal()
                + "\nOrganizador: " + organizador.getNombre() + " " + organizador.getApellidos()
                + "\nParticipantes:\n" + TotaldeParticipantes()
                + "\nRetrasos:\n" + TotaldeRetrasos()
                + "\nModalidad: ";
    }

    /**Funcion que entrega en un String, el listado de todas las notas hechas, en orden cronológico
     * @return Un mensaje en caso de no haber notas; la lista en caso contrario*/
    public String listadoNotas(){
        String listado = "\n-------------NOTAS-------------\n\n";
        if(notas.isEmpty()){
            return "\nNo hay notas que mostrar\n\n";
        }else{
            //CICLO PARA VISITAR CADA NOTA
            for(Nota n : notas){
                listado += "Autor: "
                        + n.getAutor().getParticipante().getNombre().toString()
                        + " " + n.getAutor().getParticipante().getApellidos() +  "\n"
                        + "Fecha de publicación: " + n.getHora().toString() + "\n\n"
                        + "\t" + n.getContenido().toString()
                        + "\n\n######################################################\n\n\n";
            }
            return listado;
        }
    }
    /**Funcion para generar un registro que contiene toda la información sobre la propia reunion.
     * Cosas tales como quien la organizó, fecha y hora en que se inició/termino, participantes, etc.
     *
     * @throws IOException en caso de haber un problema en lo que es el stream a tratar */
    public void generarInforme() throws IOException{
        FileOutputStream archivo = new FileOutputStream("InformedeReunion.txt");
        ObjectOutputStream informe = new ObjectOutputStream(archivo);

        informe.write((toString()+listadoNotas().toString()).getBytes());

        informe.close();
        archivo.close();
    }
}