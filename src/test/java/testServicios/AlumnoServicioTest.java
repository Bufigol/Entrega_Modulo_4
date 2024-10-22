package testServicios;

import com.bufigol.modelo.Alumno;
import com.bufigol.modelo.Materia;
import com.bufigol.modelo.MateriaEnum;
import com.bufigol.servicios.AlumnoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;
    private AlumnoServicio alumnoServicioMock;
    private Materia matematicas;
    private Materia lenguaje;
    private Alumno mapu;
    private Alumno alumnoMock;

    @BeforeEach
    public void setUp() {
        this.alumnoServicio = new AlumnoServicio();
        this.alumnoServicioMock = mock(AlumnoServicio.class);
        this.matematicas = new Materia(MateriaEnum.MATEMATICAS, new ArrayList<>());
        this.lenguaje = new Materia(MateriaEnum.LENGUAJE, new ArrayList<>());
        this.mapu = new Alumno();
        this.alumnoMock = mock(Alumno.class);
    }

    @Test
    public void crearAlumnoTest() {

    }

    @Test
    public void agregarMateriaTest() {

    }

    @Test
    public void materiasPorAlumnosTest() {

    }
    @Test
    public void listarAlumnosTest() {

    }
}
