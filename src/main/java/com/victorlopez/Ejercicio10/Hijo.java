package com.victorlopez.Ejercicio10;

public class Hijo {
    private String nombre;
    private int edad;

    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
