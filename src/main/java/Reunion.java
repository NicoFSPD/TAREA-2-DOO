import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Clase abstracta que representa una Reunion
 * @author Daniel Cristobal Patricio Lopez Ramirez
 * @author Nicolas Fernando Silva Paredes
 * @version 1.0 - 22 de mayo de 2026
 */
public abstract class Reunion{
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

    /**
     * Constructor para inicializar una nueva Reunion con sus parametros base
     * Instancia las listas vacias de invitaciones, asistencias y notas
     * @param fecha Fecha para la reunion
     * @param horaPrevista Hora en formato Instant programada para el inicio
     * @param duracionPrevista Duracion estimada del bloque de la reunion
     * @param organizador Empleado que hace y administra la reunion
     * @param tipo Tipo de reunion (TECNICA, MARKETING, OTRO)
     */
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

    /**
     * Obtiene el listado de personas o entidades invitadas que no asistieron
     * Compara la lista de invitaciones registradas contra las asistencias tomadas
     * @return List de objetos Invitables que se encuentran ausentes
     */
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
    /**
     * Filtra y obtiene la lista de asistencias que corresponden a retrasos
     * @return List con los registros de tipo Retraso encontrados
     */
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
    /**
     * Retorna la cantidad total de participantes que asistieron a la reunion
     * @return Numero entero con el total de asistencias
     */
    public int obtenerTotalAsistencia(){
        return asistencias.size();
    }
    /**
     * Calcula el porcentaje de asistencia en relacion a los invitados de la reunion
     * @return Valor flotante entre 0.0 y 100.0 que representa el porcentaje
     */
    public float obtenerPorcentajeAsistencia(){
        if(invitaciones.isEmpty()){
            return 0.0f;
        }
        return ((float)asistencias.size() / invitaciones.size()) * 100;
    }
    /**
     * Calcula el tiempo real transcurrido entre el inicio y el fin de la reunion
     * @return Cantidad de minutos totales calculados como float
     */
    public float calcularTiempoReal(){
        if(fechaInicio != null && fechaFin != null){
            return (float) Duration.between(fechaInicio, fechaFin).toMinutes();
        }
        return 0.0f;
    }
    /**
     * Procesa y agrega una invitacion a la reunion. Si el participante es un
     * Departamento, itera e invita de manera automatica a todos los Empleados del mismo
     * @param participante Entidad invitable (Empleado, Departamento o Invitado Externo)
     * @param hora Momento exacto en que se realiza o envia la invitacion
     */
    public void agregarInvitacion(Invitable participante, Instant hora){
        if (participante instanceof Departamento) {
            Departamento depto = (Departamento) participante;
            for (Empleado emp : depto.getEmpleados()) {
                Invitacion nuevaInvitacion = new Invitacion(hora, emp);
                this.invitaciones.add(nuevaInvitacion);
                emp.invitar();
            }
        } else if (participante != null) {
            Invitacion nuevaInvitacion = new Invitacion(hora, participante);
            this.invitaciones.add(nuevaInvitacion);
            participante.invitar();
        }
    }
    /**
     * Registra un nuevo control de asistencia para la reunion
     * @param asistencia Objeto Asistencia que se desea incorporar
     */
    public void agregarAsistencia(Asistencia asistencia){
        this.asistencias.add(asistencia);
    }
    /**
     * Incorpora una nueva anotacion o nota a la reunion
     * @param nota Objeto Nota con el contenido y autor respectivo
     */
    public void agregarNota(Nota nota){
        this.notas.add(nota);
    }
    /**
     * Marca el inicio oficial de la reunion guardando el Instant actual
     */
    public void iniciar(){
        this.fechaInicio = Instant.now();
    }
    /**
     * Registra el termino oficial de la reunion guardando el Instant actual
     */
    public void finalizar(){
        this.fechaFin = Instant.now();
    }

    /**
     * Obtiene la fecha programada de la reunion
     * @return Objeto Date con la fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * Modifica la fecha programada de la reunion
     * @param fecha Nueva fecha a establecer
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora prevista de inicio
     * @return Instant con la hora programada
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }
    /**
     * Modifica la hora prevista de inicio
     * @param horaPrevista Nuevo Instant programado
     */
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    /**
     * Obtiene la duracion prevista de la sesion
     * @return Objeto Duration estimado
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }
    /**
     * Modifica la duracion prevista de la sesion
     * @param duracionPrevista Nueva duracion estimada
     */
    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    /**
     * Obtiene el momento real en que inicio la reunion
     * @return Instant del inicio real, o null si no ha iniciado
     */
    public Instant getFechaInicio() {
        return fechaInicio;
    }
    /**
     * Obtiene el momento real en que finalizo la reunion
     * @return Instant del fin real, o null si no ha concluido
     */
    public Instant getFechaFin() {
        return fechaFin;
    }

    /**
     * Obtiene el organizador asignado a la reunion
     * @return Empleado que organiza la reunion
     */
    public Empleado getOrganizador() {
        return organizador;
    }
    /**
     * Asigna un nuevo organizador para la reunion
     * @param organizador Empleado que asumira el rol de organizador
     */
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    /**
     * Obtiene el tipo o categoria de la reunion
     * @return Enumeracion tipoReunion correspondiente
     */
    public tipoReunion getTipo() {
        return tipo;
    }
    /**
     * Establece el tipo o categoria de la reunion
     * @param tipo Nueva categoria de tipoReunion
     */
    public void setTipo(tipoReunion tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el listado de invitaciones vinculadas a la reunion
     * @return List de objetos Invitacion
     */
    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }
    /**
     * Reemplaza el listado completo de invitaciones de la reunion
     * @param invitaciones Nueva lista de invitaciones
     */
    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    /**
     * Reemplaza la lista de asistencias registradas
     * @param asistencias Nueva lista de objetos Asistencia
     */
    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
    /**
     * Obtiene la lista actual de asistencias tomadas
     * @return List con los objetos Asistencia
     */
    public List<Asistencia> getAsistencias() {
        return asistencias;
    }
    /**
     * Obtiene todas las notas asociadas a la reunion
     * @return List de objetos Nota en orden cronologico
     */
    public List<Nota> getNotas() {
        return notas;
    }
    /**
     * Reemplaza el listado de notas de la reunion
     * @param notas Nueva lista de objetos Nota
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    /**Funcion que despliega un listado de los nombres de cada uno de los participantes de la reunión
     * @return Los nombres de todas las personas que asistieron*/
    public String TotaldeParticipantes(){
        String Total = "\t";
        for(Asistencia a : getAsistencias()){
            Total += "- "+a.getParticipante().getNombre().toString()+" "+ a.getParticipante().getApellido().toString() +"\n\t";
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
        for(Retraso r : obtenerRetrasos()){
            Total += "- "+r.getParticipante().getNombre()+" "+r.getParticipante().getApellido()+"\n\t";
        }
        return Total;
    }

    /**Funcion toString que entrega parte de la información relevante sobre la reunion
     * @return Cada uno de los datos que luego serán necesarios para el armado del informe .txt*/
    @Override
    public String toString() {
        return "Reunion programada el " + fecha
                + "\nHora inicio: " + getFechaInicio().atZone(ZoneId.systemDefault()).toLocalTime()
                + "\nHora de termino: " + getFechaFin().atZone(ZoneId.systemDefault()).toLocalTime()
                + "\nDuracion total: " + calcularTiempoReal()
                + "\nOrganizador: " + organizador.getNombre() + " " + organizador.getApellido()
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
            for(Nota n : notas){
                listado += "Autor: "
                        + n.getAutor().getParticipante().getNombre().toString()
                        + " " + n.getAutor().getParticipante().getApellido() +  "\n"
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
    public void generarInforme() {
        try {
            FileWriter archivo = new FileWriter("InformedeReunion.txt");
            archivo.write(toString() + listadoNotas());
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
}