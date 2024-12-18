package com.bufigol.vistas;

import com.bufigol.modelo.Alumno;
import com.bufigol.modelo.Materia;
import com.bufigol.modelo.MateriaEnum;
import com.bufigol.servicios.AlumnoServicio;
import com.bufigol.servicios.ArchivoServicio;
import com.bufigol.utils.Entrada_Por_Teclado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu extends MenuTemplate {

    private AlumnoServicio alumnoServicio;
    private ArchivoServicio archivoServicio;
    private final String rutaExportacion ="src/main/resources/DatosExportados.txt";
    private final String rutaImportacion ="src/main/resources/DatosImportados.txt";

    public Menu() {
        this.alumnoServicio = new AlumnoServicio();
        this.archivoServicio = new ArchivoServicio();
    }

    /**
     *
     */
    @Override
    public void exportarDatos() {
        Map<String, Alumno> alumnosExport =  alumnoServicio.listarAlumnos();
        archivoServicio.exportarDatos(alumnosExport, rutaExportacion);
    }

    /**
     *
     */
    @Override
    public void crearAlummno() {
        //Alumno(String rut, String nombre, String apellido, String direccion)
        String rut = Entrada_Por_Teclado.pedirCadena("Ingresa el rut del Alumno: ");
        String nombre = Entrada_Por_Teclado.pedirCadena("Ingresa el nombre del Alumno: ");
        String apellido = Entrada_Por_Teclado.pedirCadena("Ingresa el apellido del Alumno: ");
        String direccion = Entrada_Por_Teclado.pedirCadena("Ingresa la direccion del Alumno: ");
        Alumno nuevoAlumno = new Alumno( rut,  nombre,  apellido,  direccion);
        Alumno alumnoCreado = this.alumnoServicio.crearAlummno(nuevoAlumno);
        if(alumnoCreado != null && alumnoCreado.equals(nuevoAlumno)){
            System.out.println("-------------------------");
            System.out.println(" Alumno creado con exito ");
            System.out.println("-------------------------");
        } else{
            System.out.println("-------------------------");
            System.out.println(" Alumno creado con problemas ");
            System.out.println("-------------------------");
        }
    }

    /**
     *
     */
    @Override
    public void agregarMateria() {
        //agregarMateria(String rutAlumno, Materia currentMate){
        String rut = Entrada_Por_Teclado.pedirCadena("Ingresa el rut del Alumno: ");
        MateriaEnum[] materiasDisponibles = MateriaEnum.values();
        System.out.println("Materias disponibles: ");
        for(int i = 0; i < materiasDisponibles.length; i++){
            System.out.println( ( i + 1 ) + materiasDisponibles[i].toString());
        }
        int seleccion;
        do{
            seleccion = Entrada_Por_Teclado.pedirEntero("Ingresa el numero de la materia: ");
        }while( (seleccion <=0) || seleccion > materiasDisponibles.length);
        Materia materia = new Materia( MateriaEnum.valueOf(String.valueOf(materiasDisponibles[seleccion-1])) );
        this.alumnoServicio.agregarMateria(rut, materia);
    }

    /**
     *
     */
    @Override
    public void agregarNotaPasoUno() {
        String rut = Entrada_Por_Teclado.pedirCadena("Ingresa el rut del Alumno: ");
        List<Materia> materias = this.alumnoServicio.materiasPorAlumnos(rut);
        if(materias.isEmpty() || materias == null){
            System.out.println("El alumno con rut " + rut + " no tiene materias");
        }else{
            for(int i = 0; i < materias.size(); i++){
                System.out.println( ( i + 1 ) + "- "+ materias.get(i).toString());
            }
            int opcSel = Entrada_Por_Teclado.pedirEntero("Ingresa el numero de la materia: ");
            while(opcSel <= 0 || opcSel > materias.size()){
                System.out.println("Opcion no valida");
                opcSel = Entrada_Por_Teclado.pedirEntero("Ingresa el numero de la materia: ");
            }
            opcSel = opcSel -1;
            Materia materiaSeleccionada = materias.get(opcSel);
            ArrayList<Materia> materiasAlumno = this.alumnoServicio.listarAlumnos().get(rut).getMaterias();
            for(int i = 0; i < materiasAlumno.size(); i++){
                if(materiasAlumno.get(i).equals(materiaSeleccionada)){
                    ArrayList<Double> notas = (ArrayList<Double>) materiasAlumno.get(i).getNotas();
                    notas.add(Entrada_Por_Teclado.pedirDouble("Ingresa la nota: "));
                    materiasAlumno.get(i).setNotas(notas);
                }
            }
            this.alumnoServicio.listarAlumnos().get(rut).setMaterias(materiasAlumno);
            System.out.println("Nota agregada con exito");
        }

    }

    /**
     *
     */
    @Override
    public void listarAlummnos() {
        Map<String, Alumno> alumnosAMostrar = this.alumnoServicio.listarAlumnos();
        String[] rutAlumnos =  alumnosAMostrar.keySet().toArray(new String[0]);
        System.out.println("------------------------");
        for(int i = 0; i < rutAlumnos.length; i++){
            Alumno currentAlumno = alumnosAMostrar.get(rutAlumnos[i]);
            System.out.println(currentAlumno.toString());
        }
        System.out.println("------------------------");

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
