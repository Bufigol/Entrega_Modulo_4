package testServicios;


import com.bufigol.modelo.Alumno;
import com.bufigol.modelo.Materia;
import com.bufigol.modelo.MateriaEnum;
import com.bufigol.servicios.AlumnoServicio;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;
    private AlumnoServicio alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;
    private Alumno mapu_dos;
    private Alumno alumnoMock;
    private static final String RUT_ALUMNO = "12345678-9";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    HashMap<String,Alumno> listaRecienCreada;

    @BeforeEach
    public void setUp() {
        this.alumnoServicio = new AlumnoServicio();
        this.alumnoServicioMock = mock(AlumnoServicio.class);
        this.matematicas = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
        this.lenguaje = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
        this.mapu = new Alumno();
        this.mapu_dos = new Alumno(RUT_ALUMNO, "Juan", "Perez", "Calle 123", new ArrayList<>());
        this.alumnoMock = mock(Alumno.class);
        System.setOut(new PrintStream(outContent));
        this.listaRecienCreada = new HashMap<String,Alumno>();
    }
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void crearAlumnoTest() {
       Alumno creado = this.alumnoServicio.crearAlummno(mapu_dos);
       assertEquals(creado,mapu_dos);
       assertEquals(creado.getRut(),"12345678-9");
       assertEquals(creado,this.alumnoServicio.listarAlumnos().get("12345678-9"));
    }

    @Test
    public void agregarMateriaTest() {
        Materia matematicas = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
        Materia lenguaje = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
        ArrayList<Materia> materias = new ArrayList<>();
        materias.add(matematicas);
        materias.add(lenguaje);
        when(alumnoMock.getMaterias()).thenReturn(materias);
        verify(alumnoMock, never()).setMaterias(argThat(list -> list.size() == 2));
        alumnoServicio.crearAlummno(mapu_dos);
        alumnoServicio.agregarMateria(RUT_ALUMNO, matematicas);
        alumnoServicio.agregarMateria(RUT_ALUMNO, lenguaje);
        //assertEquals(alumnoServicio.listarAlumnos().get(RUT_ALUMNO).getMaterias(), materias);
        assertNotNull(alumnoServicio.listarAlumnos().get(RUT_ALUMNO).getMaterias());
        assertEquals(2, alumnoServicio.listarAlumnos().get(RUT_ALUMNO).getMaterias().size());

        alumnoServicio.agregarMateria(RUT_ALUMNO, matematicas);
        String expectedMessage = "La materia ya existe para ese alumno";
        assertTrue(outContent.toString().trim().contains(expectedMessage));
    }

    @Test
    public void materiasPorAlumnosTest() {
        String mensaje_error_nulo = "Lista de Alumnos nula, por favor registrar alumno primero";
        alumnoServicio.materiasPorAlumnos(RUT_ALUMNO);
        assertTrue(outContent.toString().trim().contains(mensaje_error_nulo));
        Materia matematicas = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
        Materia lenguaje = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
        ArrayList<Materia> materias = new ArrayList<>();
        materias.add(matematicas);
        materias.add(lenguaje);
        mapu.setRut(RUT_ALUMNO);
        mapu.setMaterias(materias);
        alumnoServicio.crearAlummno(mapu);
        assertEquals(materias,alumnoServicio.materiasPorAlumnos(RUT_ALUMNO));
    }

    @Test
    public void listarAlumnosTest() {
        when(this.alumnoServicioMock.listarAlumnos()).thenReturn(new HashMap<String,Alumno>());

        assertEquals(this.listaRecienCreada,this.alumnoServicioMock.listarAlumnos());
        assertEquals(this.listaRecienCreada,this.alumnoServicio.listarAlumnos());
    }
}
