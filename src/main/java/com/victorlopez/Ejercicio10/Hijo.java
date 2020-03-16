package com.victorlopez.Ejercicio10;

public class Hijo {
    private String nombre;
    private int edad;

    /**
     * Constructor de la clase hijo
     * @param nombre nombre del hijo
     * @param edad edad del hijo
     */
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

    /**
     * Para obtener el nombre del hijo
     * @return String que contiene el nombre del hijo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve la edad del hijo
     * @return edad del hijo (entero)
     */
    public int getEdad() {
        return edad;
    }
}
