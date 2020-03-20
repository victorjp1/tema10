package com.victorlopez.Ejercicio11;

public class Aula {
    private int id;
    private double m2;

    public Aula(int id, double m2) {
        this.id = id;
        this.m2 = m2;
    }

    /**
     * Método para obtener el id del aula
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Método para obtener los metros cuadrados del aula
     * @return
     */
    public double getM2() {
        return m2;
    }

    @Override
    public String toString() {
        return "Aula { " +
                "id = " + id +
                ", m2 = " + m2 +
                '}';
    }
}
