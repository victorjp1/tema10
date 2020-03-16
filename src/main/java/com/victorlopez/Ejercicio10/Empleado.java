package com.victorlopez.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private double sueldo;
    private ArrayList<Hijo> hijos;

    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        hijos = new ArrayList<>();
    }

    /**
     * Método para obtener el dni del empleado
     * @return String que contiene el dni del empleado
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método para modificar el sueldo del empleado
     * @param sueldo nuevo sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Método para obtener el sueldo
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener los apellidos del empleado
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para obtener el sueldo del empleado
     * @return sueldo del empleado
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Método para obtener los hijos del empleado
     * @return array list de tipo Hijo
     */
    public ArrayList<Hijo> getHijos() {
        return hijos;
    }

    /**
     * Método para añadir hijos
     * @param hijo hijo a añadir
     */
    public void addHijo(Hijo hijo){
        this.hijos.add(hijo);
    }
    /**
     * Método para calcular la edad del paciente a través de la fecha de nacimiento
     * @return devolvemos un entero, la edad del paciente
     */
    public int getEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;


    }
    @Override
    public String toString() {
        return "Empleado{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldo=" + sueldo +
                ", hijos=" + hijos.toString() +
                '}' + "\n";
    }
}

