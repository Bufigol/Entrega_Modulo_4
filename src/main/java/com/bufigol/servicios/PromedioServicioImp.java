package com.bufigol.servicios;

import java.util.List;

public class PromedioServicioImp {

    public double calcularPromedio(List<Double> notas) {
        double promedio = 0;
        for (Double a : notas) {
            promedio = promedio + a;
        }
        promedio = promedio / notas.size();
        return promedio;
    }
}
