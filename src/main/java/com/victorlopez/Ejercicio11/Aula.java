package com.victorlopez.Ejercicio11;

public class Aula {
    private int id;
    private double m2;

    public Aula(int id, double m2) {
        this.id = id;
        this.m2 = m2;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Aula { " +
                "id = " + id +
                ", m2 = " + m2 +
                '}';
    }
}
