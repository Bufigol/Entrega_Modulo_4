package com.bufigol.vistas;

import com.bufigol.servicios.AlumnoServicio;
import com.bufigol.servicios.ArchivoServicio;

public class Menu extends MenuTemplate {

    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;

    public Menu() {
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    /**
     *
     */
    @Override
    public void exportarDatos() {

    }

    /**
     *
     */
    @Override
    public void crearAlummno() {

    }

    /**
     *
     */
    @Override
    public void agregarMateria() {

    }

    /**
     *
     */
    @Override
    public void agregarNotaPasoUno() {

    }

    /**
     *
     */
    @Override
    public void listarAlummnos() {

    }

    /**
     *
     */
    @Override
    public void terminarPrograma() {
        System.out.println("Programa terminado");
        System.exit(0);
    }

    /**
     *
     */
    @Override
    public void importarDatos() {

    }
}
