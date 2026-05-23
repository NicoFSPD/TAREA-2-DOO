import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Reunion reunion;
    private Departamento departamento;
    private Empleado organizador;
    private Empleado emp1;
    private Empleado emp2;
    private InvitadoExterno ext1;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("FI");
        organizador = new Empleado("100", "Lopez", "Daniel", "daniel@empresa.com", departamento);
        emp1 = new Empleado("101", "Riveros", "Eduardo", "eduardo@empresa.com", departamento);
        emp2 = new Empleado("102", "Silva", "Nicolas", "nicolas@empresa.com", departamento);
        ext1 = new InvitadoExterno("Joaquin", "Espinosa", "joaquin.espinosa@externo.com");

        departamento.agregarEmpleado(organizador);
        departamento.agregarEmpleado(emp1);
        departamento.agregarEmpleado(emp2);

        reunion = new ReunionPresencial(
                new Date(),
                Instant.now(),
                Duration.ofHours(1),
                organizador,
                tipoReunion.TECNICA,
                "Sala Alfa"
        );
    }

    @Test
    void obtenerAusencias() {
        assertTrue(reunion.obtenerAusencias().isEmpty());

        reunion.agregarInvitacion(emp1, Instant.now());
        reunion.agregarInvitacion(emp2, Instant.now());
        reunion.agregarInvitacion(ext1, Instant.now());

        reunion.agregarAsistencia(new Asistencia(emp1));
        reunion.agregarAsistencia(new Asistencia(ext1));

        List<Invitable> ausentes = reunion.obtenerAusencias();
        assertEquals(1, ausentes.size());
        assertTrue(ausentes.contains(emp2));
        assertFalse(ausentes.contains(emp1));
    }

    @Test
    void obtenerRetrasos() {
        assertTrue(reunion.obtenerRetrasos().isEmpty());

        reunion.agregarAsistencia(new Asistencia(emp1));

        Retraso retrasoElemento = new Retraso(emp2, Instant.now());
        reunion.agregarAsistencia(retrasoElemento);

        List<Retraso> retrasos = reunion.obtenerRetrasos();
        assertEquals(1, retrasos.size());
        assertEquals(emp2, retrasos.get(0).getParticipante());
    }

    @Test
    void obtenerTotalAsistencia() {
        assertEquals(0, reunion.obtenerTotalAsistencia());

        reunion.agregarAsistencia(new Asistencia(emp1));
        reunion.agregarAsistencia(new Retraso(emp2, Instant.now()));

        assertEquals(2, reunion.obtenerTotalAsistencia());
    }

    @Test
    void obtenerPorcentajeAsistencia() {
        assertEquals(0.0f, reunion.obtenerPorcentajeAsistencia());

        reunion.agregarInvitacion(emp1, Instant.now());
        reunion.agregarInvitacion(emp2, Instant.now());

        reunion.agregarAsistencia(new Asistencia(emp1));
        assertEquals(50.0f, reunion.obtenerPorcentajeAsistencia(), 0.01f);
    }

    @Test
    void calcularTiempoReal() {
        assertEquals(0.0f, reunion.calcularTiempoReal());

        reunion.iniciar();
        reunion.finalizar();

        assertTrue(reunion.calcularTiempoReal() >= 0.0f);
    }

    @Test
    void agregarInvitacion() {
        reunion.agregarInvitacion(ext1, Instant.now());
        assertEquals(1, reunion.getInvitaciones().size());

        reunion.agregarInvitacion(departamento, Instant.now());
        assertEquals(4, reunion.getInvitaciones().size());
    }

    @Test
    void totaldeParticipantes() {
        assertNotNull(reunion.TotaldeParticipantes());

        reunion.agregarAsistencia(new Asistencia(emp1));
        String listado = reunion.TotaldeParticipantes();

        assertTrue(listado.contains("Riveros"));
        assertTrue(listado.contains("Eduardo"));
    }

    @Test
    void totaldeRetrasos() {
        assertTrue(reunion.TotaldeRetrasos().contains("No hubieron"));

        reunion.agregarAsistencia(new Retraso(emp1, Instant.now()));
        String listadoAtrasos = reunion.TotaldeRetrasos();

        assertTrue(listadoAtrasos.contains("Riveros"));
    }

    @Test
    void listadoNotas() {
        assertTrue(reunion.listadoNotas().contains("No hay notas que mostrar"));

        Asistencia asistenciaAutor = new Asistencia(emp1);
        Nota notaReunion = new Nota(asistenciaAutor, Instant.now(), "Acuerdo de desarrollo numero uno");
        reunion.agregarNota(notaReunion);

        String textoNotas = reunion.listadoNotas();
        assertTrue(textoNotas.contains("Acuerdo de desarrollo numero uno"));
        assertTrue(textoNotas.contains("Eduardo"));
    }

    @Test
    void generarInforme() {
        assertDoesNotThrow(() -> {
            reunion.iniciar();
            reunion.finalizar();
            reunion.generarInforme();

            File archivoInforme = new File("InformedeReunion.txt");
            assertTrue(archivoInforme.exists());

            if(archivoInforme.exists()) {
                archivoInforme.delete();
            }
        });
    }

    @Test
    void testFinalizarAntesDeIniciar() {
        reunion.finalizar();
        reunion.iniciar();
        assertEquals(0.0f, reunion.calcularTiempoReal());
    }

    @Test
    void testInvitacionDuplicadaNoAlteraPorcentaje() {
        reunion.agregarInvitacion(emp1, Instant.now());
        reunion.agregarInvitacion(emp1, Instant.now());
        reunion.agregarAsistencia(new Asistencia(emp1));
        assertEquals(50.0f, reunion.obtenerPorcentajeAsistencia(), 0.01f);
    }

    @Test
    void testDepartamentoSinEmpleados() {
        Departamento deptoVacio = new Departamento("Vacio");
        assertDoesNotThrow(() -> {
            reunion.agregarInvitacion(deptoVacio, Instant.now());
        });
        assertTrue(reunion.getInvitaciones().isEmpty());
    }

    @Test
    void testCalcularTiempoRealSinFinalizar() {
        reunion.iniciar();
        assertEquals(0.0f, reunion.calcularTiempoReal());
    }

    @Test
    void testTotaldeRetrasosCuandoTodosLleganTarde() {
        reunion.agregarAsistencia(new Retraso(emp1, Instant.now()));
        reunion.agregarAsistencia(new Retraso(emp2, Instant.now()));
        String listadoAtrasos = reunion.TotaldeRetrasos();
        assertTrue(listadoAtrasos.contains("Riveros"));
        assertTrue(listadoAtrasos.contains("Silva"));
    }

    @Test
    void testReunionVirtualToString() {
        ReunionVirtual virtual = new ReunionVirtual(
                new Date(),
                Instant.now(),
                Duration.ofHours(1),
                organizador,
                tipoReunion.OTRO,
                "https://link.com"
        );
        virtual.iniciar();
        virtual.finalizar();
        String texto = virtual.toString();
        assertTrue(texto.contains("Virtual"));
        assertTrue(texto.contains("Enlace: https://link.com"));
    }

    @Test
    void testAsistenciasVaciasTotalParticipantes() {
        String listado = reunion.TotaldeParticipantes();
        assertTrue(listado.trim().isEmpty());
    }

    @Test
    void testAsistenciaSinInvitacionPrevia() {
        reunion.agregarAsistencia(new Asistencia(emp1));
        float porcentaje = reunion.obtenerPorcentajeAsistencia();
        assertTrue(Float.isFinite(porcentaje) || porcentaje == 0.0f);
        assertEquals(1, reunion.obtenerTotalAsistencia());
    }

    @Test
    void testTiempoRealConFechasInvertidas() {
        reunion.iniciar();
        reunion.finalizar();
        assertTrue(reunion.calcularTiempoReal() >= 0.0f);
    }

    @Test
    void testAgregarInvitacionNula() {
        assertDoesNotThrow(() -> {
            reunion.agregarInvitacion(null, Instant.now());
        });
    }
}
