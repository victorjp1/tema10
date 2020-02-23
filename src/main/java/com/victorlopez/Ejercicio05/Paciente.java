package com.victorlopez.Ejercicio05;

import com.victorlopez.Sexo;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.GregorianCalendar;

public class Paciente {
    private int id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    private double altura;
    private double peso;

    public Paciente(int id, String nombre, LocalDate fechaNacimiento, Sexo sexo, double altura, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    @Override
    public String toString() {
        int edad = calcularEdad();
        return "Paciente{" +
                "id =" + id +
                ", nombre ='" + nombre + '\'' +
                ", fechaNacimiento =" + fechaNacimiento.toString() +
                ", sexo =" + sexo +
                ", edad =" + edad +
                ", altura =" + altura +
                ", peso =" + peso +
                '}';
    }
    public int calcularEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;


    }
}
