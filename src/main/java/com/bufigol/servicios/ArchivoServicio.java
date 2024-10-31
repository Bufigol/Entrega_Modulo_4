package com.bufigol.servicios;

import com.bufigol.modelo.Alumno;
import com.bufigol.modelo.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArchivoServicio {
    private List alumnosACargar;
    private PromedioServicioImp promediosServicioImp;

    public void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
        promediosServicioImp = new PromedioServicioImp();
        cargarAlumnosAArchivoServicio(alumnos);
        escribirEnArchivo(ruta,"Listado de Alumnos con sus notas\n");
        escribirEnArchivo(ruta,"---------------------------------\n");
        escribirEnArchivo(ruta,"");
        ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) this.alumnosACargar;
        for (int i = 0; i < this.alumnosACargar.size(); i++) {
            Alumno currentAlumno = listaAlumnos.get(i);
            escribirEnArchivo(ruta,"Nombre del Alumno: " + currentAlumno.getNombre() + " " + currentAlumno.getApellido() +"\n");
            escribirEnArchivo(ruta,"Rut del Alumno: " + currentAlumno.getRut() + "\n");
            escribirEnArchivo(ruta,"Direccion: " + currentAlumno.getDireccion() + "\n");
            ArrayList<Materia> materiasDelAlumno = (ArrayList<Materia>) currentAlumno.getMaterias();
            if(materiasDelAlumno != null && !materiasDelAlumno.isEmpty()){
                escribirEnArchivo(ruta,"Notas:\n");
                for(int j = 0; j < materiasDelAlumno.size(); j++){
                    Materia currentMateria = materiasDelAlumno.get(j);
                    escribirEnArchivo(ruta,(j+1) + "- " + currentMateria.getNombre() + "\n");
                    Double promedio = promediosServicioImp.calcularPromedio(currentMateria.getNotas());
                    escribirEnArchivo(ruta,"Promedio: " + promedio + "\n");
                }
            }else{
                System.out.println("El Alumno no tiene materias");
            }
            escribirEnArchivo(ruta,"---------------------------------\n");
        }
    }

    private void cargarAlumnosAArchivoServicio(Map<String, Alumno> alumnos){
        this.alumnosACargar = new ArrayList<Alumno>();
        String[] rutAlumnos =  alumnos.keySet().toArray(new String[0]);
        for(int i = 0; i < rutAlumnos.length; i++){
            Alumno alumno = alumnos.get(rutAlumnos[i]);
            this.alumnosACargar.add(alumno);
        }
    }

    private void escribirEnArchivo(String ruta, String contenido) {
        BufferedWriter escritor = null;
        try {
            // Crear un FileWriter en modo append (true) si deseas añadir contenido
            escritor = new BufferedWriter(new FileWriter(ruta, true));
            escritor.write(contenido);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            // Asegurarse de cerrar el BufferedWriter
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
