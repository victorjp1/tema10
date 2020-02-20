package com.victorlopez.Ejercicio02;

import com.victorlopez.Lib;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas();//Creamos el nuevo objeto array list
        Lib.llenarArrayListAleatorio(estadisticas, 10);//Lo llenamos de forma aleatoria con 10 elementos
        System.out.println("El Array List es: " + estadisticas.toString());
        System.out.printf("La media del Array es: %2.2f %n", estadisticas.media());
        System.out.printf("El mínimo es: %2.2f %n", estadisticas.minimo());
        System.out.printf("El máximo es: %2.2f %n", estadisticas.maximo());
        System.out.printf("El sumatorio es: %2.2f %n", estadisticas.sumatorio());
        System.out.printf("El valor más repetido es: %2.2f %n", estadisticas.moda());
        System.out.printf("El valor más repetido es: %2.2f %n", estadisticas.modaHashMap());
    }
}
