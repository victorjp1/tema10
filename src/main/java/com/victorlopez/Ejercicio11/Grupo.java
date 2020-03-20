package com.victorlopez.Ejercicio11;

public class Grupo {
    private int id;
    private String nombre;
    private Aula aula;

    public Grupo(int id, String nombre, Aula aula) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
    }

    /**
     * Método para obtener el id del grupo
     * @return devuelve el ID del grupo
     */
    public int getId() {
        return id;
    }

    /**
     * Método para cambiar el aula del grupo
     * @param aula aula a cambiar
     */
    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Grupo {" +
                "id = " + id +
                ", nombre = '" + nombre + '\'' +
                ", aula = " + aula +
                '}';
    }
}
