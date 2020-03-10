package com.victorlopez.Ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empleado {
    private int dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private double sueldo;
    private ArrayList<Hijo> hijos;

    public Empleado(int dni, String nombre, String apellidos, LocalDate fechaNacimiento, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public ArrayList<Hijo> getHijos() {
        return hijos;
    }
    public void addHijos(Hijo hijo){
        hijos.add(hijo);
    }
}
