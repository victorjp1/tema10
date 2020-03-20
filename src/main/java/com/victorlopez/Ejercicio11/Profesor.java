package com.victorlopez.Ejercicio11;

public class Profesor {
    private String dni;
    private String nombre;
    private double sueldo;

    public Profesor(String dni, String nombre, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    /**
     * Método para cambiar el sueldo del profesor
     * @param sueldo new sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método para obtener el dni del profesor
     * @return dni del profesor
     */
    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Profesor { " +
                "dni = '" + dni + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", sueldo = " + sueldo +
                '}';
    }
}
