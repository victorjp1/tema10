package com.victorlopez.Ejercicio11;

public class Asignatura {
    private int id;
    private String nombre;
    private Profesor profesor;

    public Asignatura(int id, String nombre, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    /**
     * Método para obtener el ID de la asignatura
     * @return ID de la asignatura
     */
    public int getId() {
        return id;
    }

    /**
     * Método para cambiar el profesor de la asignatura
     * @param profesor profesor a cambiar
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Método para obtener el profesor que imparte la asignatura
     * @return profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return "Asignatura { " +
                "id = " + id +
                ", nombre = '" + nombre + '\'' +
                ", profesor = " + profesor +
                '}';
    }
}
