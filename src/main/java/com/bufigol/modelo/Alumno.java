package com.bufigol.modelo;

import java.util.List;
import java.util.Objects;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List materias;

    public Alumno(String rut, String nombre, String apellido, String direccion, List materias) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.materias = materias;
    }

    public Alumno() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List getMaterias() {
        return materias;
    }

    public void setMaterias(List materias) {
        this.materias = materias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(getRut(), alumno.getRut());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRut(), getNombre(), getApellido(), getDireccion(), getMaterias());
    }
}
