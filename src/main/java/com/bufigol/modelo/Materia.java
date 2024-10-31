package com.bufigol.modelo;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Materia {
    private MateriaEnum nombre;
    private List notas;

    public Materia(MateriaEnum nombre, List notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas= new ArrayList<Double>();
    }

    public Materia() {
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }

    public List getNotas() {
        return notas;
    }

    public void setNotas(List notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia materia)) return false;
        return getNombre() == materia.getNombre();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getNotas());
    }
}
