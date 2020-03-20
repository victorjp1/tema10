package com.victorlopez.Ejercicio11;

import java.util.ArrayList;

public class Alumno {
    private static int nAlumnos = 0;
    private int id;
    private String nombre;
    private Grupo grupo;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo, ArrayList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
        this.id = ++nAlumnos;
    }

    /**
     * Método para obtener el ID del alumno
     * @return id del alumno
     */
    public int getId() {
        return id;
    }

    /**
     * Método para obtener el grupo del alumno
     * @return grupo del alumno
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Método para obtener las asignaturas de alumno
     * @return ArrayList de asignaturas
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id = " + id +
                ", nombre = '" + nombre + '\'' +
                ", grupo = " + grupo +
                ", asignaturas = " + asignaturas.toString() +
                '}';
    }
}
