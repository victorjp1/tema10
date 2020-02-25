package com.victorlopez.Ejercicio05;

import java.time.LocalDate;
import java.time.Period;

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

    /**
     * Método para saber la altura del paciente en metros
     * @return devuelve la altura en metros del paciente
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Método que devuelve el sexo del paciente
     * @return devolvemos el sexo del paciente como un enumerado
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Método que devuelve el id del paciente
     * @return devuelve un entero que es el id del paciente
     */
    public int getId() {
        return id;
    }

    /**
     * Método para valorar el peso del paciente
     * @param p paciente a valorar
     * @return devolvemos un double, que es el IMC del paciente
     */
    public static double valorarPeso(Paciente p){
        double altura = p.getAltura();
        double peso = p.getPeso();
        double IMC = peso / (altura * altura);
        return IMC;
    }

    /**
     * Devuelve el peso del paciente
     * @return devolvemos un double que es el peso del paciente
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Método to String del paciente
     * @return devolvemos el String formado
     */
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

    /**
     * Método que devuelve la edad del paciente
     * @return entero con la edad del paciente
     */
    public int getEdad(){
        return calcularEdad();
    }

    /**
     * Método para calcular la edad del paciente a través de la fecha de nacimiento
     * @return devolvemos un entero, la edad del paciente
     */
    private int calcularEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;


    }
}
