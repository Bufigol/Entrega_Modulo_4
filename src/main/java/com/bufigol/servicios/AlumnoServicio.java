package com.bufigol.servicios;

import com.bufigol.modelo.Alumno;
import com.bufigol.modelo.Materia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos;

    public AlumnoServicio(Map<String, Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public AlumnoServicio() {
        this.listaAlumnos = new HashMap<String, Alumno>();
    }

    public Alumno crearAlummno(Alumno alumno) {
        if(this.listaAlumnos == null){
            this.listaAlumnos = new HashMap<String, Alumno>();
        }
        if(!this.listaAlumnos.isEmpty()){
            if(this.listaAlumnos.containsKey(alumno.getRut())){
                System.out.println("El alumno ya existe");
                return null;
            }else{
                this.listaAlumnos.put(alumno.getRut(),alumno);
                return alumno;
            }

        }else{
            this.listaAlumnos.put(alumno.getRut(),alumno);
            return alumno;
        }
    }

    public void agregarMateria(String rutAlumno, Materia currentMate){
        if(this.listaAlumnos == null || this.listaAlumnos.isEmpty()) {
            System.out.println("Lista de Alumnos nula, por favor registrar alumno primero");
        }else{
            if(this.listaAlumnos.get(rutAlumno).getMaterias() == null) {
                this.listaAlumnos.get(rutAlumno).setMaterias(new ArrayList<Materia>());
            }
            if(currentMate != null){
                ArrayList<Materia> materias = (ArrayList<Materia>) this.listaAlumnos.get(rutAlumno).getMaterias();
                boolean existe = false;
                for(Materia mate : materias){
                    if(mate.equals(currentMate)){
                        existe = true;
                        break;
                    }
                }
                if(!existe){
                    materias.add(currentMate);
                    this.listaAlumnos.get(rutAlumno).setMaterias(materias);
                }else{
                    System.out.println("La materia ya existe para ese alumno");
                }
            }else {
                System.out.println("La materia es nula");
            }
        }
    }



    public List materiasPorAlumnos(String rutAlumno){
        if(this.listaAlumnos == null || this.listaAlumnos.isEmpty()) {
            System.out.println("Lista de Alumnos nula, por favor registrar alumno primero");
            return null;
        }
        if(this.listaAlumnos.containsKey(rutAlumno)){
            if(this.listaAlumnos.get(rutAlumno).getMaterias() != null){
                return this.listaAlumnos.get(rutAlumno).getMaterias();
            }else{
                System.out.println("El alumno no tiene materias");
                return null;
            }
        }else{
            System.out.println("El alumno no existe");
            return null;
        }
    }

    public Map<String, Alumno> listarAlumnos(){
        return this.listaAlumnos;
    }
}
