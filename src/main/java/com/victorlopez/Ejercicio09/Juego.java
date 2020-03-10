package com.victorlopez.Ejercicio09;

import com.victorlopez.Lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Juego {
    private Diccionario diccionario;
    static Scanner lector = new Scanner(System.in);
    private ArrayList<Jugador> ganadores;
    private final int MAX_JUGADORES = 5;

    /**
     * Constructor de la clase juego
     * @param diccionario diccionario con el que jugar
     */
    public Juego(Diccionario diccionario) {
        this.diccionario = diccionario;
        ganadores = new ArrayList<>(MAX_JUGADORES);
        llenarJugadores();//Datos aleatorios
        Collections.sort(ganadores);//Ordenamos los datos
    }

    /**
     * Mostramos las 5 mejoras puntuaciones
     * @return devolvemos el String formado
     */
    public String mejoresPuntuaciones(){
        String aux = "";
        for (int i = 0; i < MAX_JUGADORES ; i++) {
            aux += ganadores.get(i).toString() + "\n";
        }
        return aux;
    }

    /**
     * Método para llenar el marcador
     */
    public void llenarJugadores(){

        String[] aleatorio = {"Caroline", "Adios" , "Alberto" , "Monica Gaduro" , "Victor"};
        for (int i = 0; i < aleatorio.length ; i++) {
            Jugador j = new Jugador(aleatorio[i], i);
            ganadores.add(i, j);
        }
    }

    /**
     * Método para jugar
     */
    public void jugar(){
        boolean acierto = true;
        int contador = 0;
        String palabra;
        String eleccion;
        do{
            palabra = conseguirPalabra();
            System.out.println("La definicion es: " + diccionario.consultarPalabra(palabra));
            eleccion = lector.nextLine().toLowerCase().trim();
            if (eleccion.equals(palabra)){
                contador++;
                System.out.println("Correcto!!");
            }else{
                System.out.println("Incorrecto, la palabra es: " + palabra);
                acierto = false;
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while(acierto);
        System.out.println("Tu puntuación es de: " + contador);
        valorarPuntuacion(contador);

    }

    /**
     * Método para valorar la puntuación obtenida
     * @param p puntos a valorar
     */
    private void valorarPuntuacion(int p){
        boolean ganador = false;
        int i = 0;

        do{
            if(p > ganadores.get(i).getPuntuacion() && !ganador){
                ganador = true;
                nuevoGanador(p,i);
            }
            i++;
        }while (i < ganadores.size() && !ganador);
    }

    /**
     * Método para introducir un nuevo ganador a los mejores tiempos
     * @param p puntos obtenidos
     * @param pos posicion en el array list donde debe ir el jugador en el marcador
     */
    private void nuevoGanador(int p, int pos){
        Boolean validado;
        String nickname;
        do {
            System.out.println("Introduce tu nickname: ");
            nickname = lector.nextLine();
            if (nickname.length() <= 2){
                validado = false;
            }else{
                validado = true;
            }
        }while(!validado);
        ganadores.add(pos, new Jugador(nickname, p));
        ganadores.remove(ganadores.size() - 1);
    }

    /**
     * Método para conseguir una palabra del diccionario
     * @return devolvemos una palabra aleatoria
     */
    private String conseguirPalabra(){
        int numElemento;
        int numElementos = diccionario.getDiccionario().size();
        numElemento = Lib.aleatorio(0,numElementos);
        String key = "";
        Iterator<String> iter = diccionario.getDiccionario().keySet().iterator();
        for (int i = 0; i < numElemento; i++) {
            if (i != numElemento)
                key = iter.next();
        }
        return key;
    }
}
