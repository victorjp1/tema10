package com.victorlopez.Ejercicio09;

public class Jugador implements Comparable<Jugador>{
    private String nickname;
    private int puntuacion;

    /**
     * Constructor de la clase jugador
     * @param nickname nombre de usuario del jugador
     * @param puntuacion puntuacion que ha obtenido el jugador
     */
    public Jugador(String nickname, int puntuacion) {
        this.nickname = nickname;
        this.puntuacion = puntuacion;
    }

    /**
     * Constructor de la clase Jugador, los puntos se inicializan a 0
     * @param nickname nombre de usuario del jugador
     */
    public Jugador(String nickname) {
        this(nickname, 0);
    }

    /**
     * Saca todos los datos del jugador formateados
     * @return devolvemos el string creado
     */
    @Override
    public String toString() {
        String aux = "";
        aux += String.format("%-15s %4d %n", nickname + ": ", puntuacion);
        return aux;
    }

    /**
     * Método par obtener el nickname del jugador
     * @return nombre de usuario del jugador
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Método para obtener la puntuación del jugador
     * @return puntuación del jugador
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Método para ordenar por puntuación
     * @param j jugador a comparar
     * @return entero con el resultado
     */
    @Override
    public int compareTo(Jugador j) {
        return j.getPuntuacion() - getPuntuacion();
    }
}
