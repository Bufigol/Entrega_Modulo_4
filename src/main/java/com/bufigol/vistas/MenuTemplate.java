package com.bufigol.vistas;

import java.util.Scanner;
import com.bufigol.utils.Entrada_Por_Teclado;

public abstract class MenuTemplate {

    public abstract void exportarDatos();

    public abstract void crearAlummno();

    public abstract void agregarMateria();

    public abstract void agregarNotaPasoUno();

    public abstract void listarAlummnos();

    public abstract void terminarPrograma();

    public abstract void importarDatos();

    public void iniciarMenu(Scanner sc){
        String menu ="""
                Bienvenido al menu principal
                1. Crear Alumno
                2. Agregar materia
                3. Agregar nota
                4. Cargar archivo
                5. Exportar archivo
                6. Listar Alumnos
                7. Salir
                """;
        int opc;
        do{
            System.out.println(menu);
            opc = Entrada_Por_Teclado.pedirEntero(sc);
            switch (opc){
                case 1 -> crearAlummno();
                case 2 -> agregarMateria();
                case 3 -> agregarNotaPasoUno();
                case 4 -> importarDatos();
                case 5 -> exportarDatos();
                case 6 -> listarAlummnos();
                case 7 -> terminarPrograma();
                default -> System.out.println("Opción no válida");
            }

        } while (opc != 7);
    }
}
