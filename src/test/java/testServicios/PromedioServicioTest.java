package testServicios;

import com.bufigol.servicios.PromedioServicioImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioTest {

    private PromedioServicioImp promediosServicioImp;

    @BeforeEach
    public void setUp() {
        promediosServicioImp = new PromedioServicioImp();
    }

    @Test
    @DisplayName("Calcular promedio")
    public void testCalcularPromedio() {
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(1.0);
        notas.add(2.0);
        notas.add(3.0);
        notas.add(4.0);
        notas.add(5.0);
        double promedio = promediosServicioImp.calcularPromedio(notas);
        assertEquals(3.0, promedio,0.00001,"Error en el promedio");
    }
}
