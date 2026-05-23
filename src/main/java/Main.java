import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        //Crear entorno (departamento y empleados)
        Departamento deptoFI = new Departamento("FI");

        Empleado daniel = new Empleado("1", "Lopez", "Daniel", "dani@empresa.com", deptoFI);
        Empleado nicolas = new Empleado("2", "Silva", "Nicolas", "nico@empresa.com", deptoFI);
        Empleado eduardo = new Empleado("3", "Riveros", "Eduardo", "edu@empresa.com", null); //Organizador

        //Crear invitado externo
        InvitadoExterno patricio = new InvitadoExterno("Patricio","Galvarino","pato@empresa.com");

        //Anadir empleados
        deptoFI.agregarEmpleado(daniel);
        deptoFI.agregarEmpleado(nicolas);

        //Crear la reunion
        ReunionPresencial reunion = new ReunionPresencial(
                new Date(),
                Instant.now(),
                Duration.ofHours(1),
                eduardo,
                tipoReunion.OTRO,
                "Sala de Juntas B"
        );

        System.out.println("ENVIANDO INVITACIONES... ");
        //Invitar
        reunion.agregarInvitacion(deptoFI, Instant.now());
        reunion.agregarInvitacion(patricio, Instant.now());

        System.out.println("\n*** DESARROLLO DE LA REUNION ***");
        //Iniciar la reunion
        reunion.iniciar();

        //Daniel llega a la hora
        Asistencia asistenciaDaniel = new Asistencia(daniel);
        reunion.agregarAsistencia(asistenciaDaniel);

        //Nicolas llega tarde (usamos la clase Retraso)
        Retraso retrasoNicolas = new Retraso(nicolas, Instant.now());
        reunion.agregarAsistencia(retrasoNicolas);

        //Patricio llego a la hora
        Asistencia asistenciaPatricio = new Asistencia(patricio);
        reunion.agregarAsistencia(asistenciaPatricio);

        //Eduardo (el organizador) nunca registro su asistencia en este ejemplo, asi que el sistema lo contara como ausente si lo hubieramos invitado

        //Agregar notas
        Nota nota1 = new Nota(asistenciaPatricio,
                Instant.now(),
                asistenciaPatricio.getParticipante().getNombre() + " hace un commit en el archivo.");
        reunion.agregarNota(nota1);

        Nota nota2 = new Nota(retrasoNicolas, Instant.now(), retrasoNicolas.getParticipante().getNombre() + " hace una aseveración respecto del proyecto");
        reunion.agregarNota(nota2);

        //Finalizar reunion
        reunion.finalizar();

        if(reunion.getNotas().isEmpty()){
            System.out.println("No hay notas registradas.");
        }else{
            for (Nota nota : reunion.getNotas()){
                System.out.println("Hora: " + nota.getHora());
                System.out.println("Contenido: " + nota.getContenido());
                System.out.println("------------------------------------");
            }
        }
        System.out.println("Tiempo real de la reunion: " + reunion.calcularTiempoReal() + " minutos");

        reunion.generarInforme();
    }
}
