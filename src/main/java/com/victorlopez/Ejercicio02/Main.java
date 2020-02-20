package com.victorlopez.Ejercicio02;

import com.victorlopez.Lib;

public class Main {
    public static void main(String[] args) {
        ArrayListEstadisticas estadisticas = new ArrayListEstadisticas();//Creamos el nuevo objeto array list
        Lib.llenarArrayListAleatorio(estadisticas, 10);//Lo llenamos de forma aleatoria con 10 elementos
        imprimirResumen(estadisticas);

    }
    public static void imprimirResumen(ArrayListEstadisticas a){
        System.out.println("El Array List es: " + a.toString());
        System.out.printf("La media del Array es: %2.2f %n", a.media());
        System.out.printf("El mínimo es: %2.2f %n", a.minimo());
        System.out.printf("El máximo es: %2.2f %n", a.maximo());
        System.out.printf("El sumatorio es: %2.2f %n", a.sumatorio());
        System.out.printf("El valor más repetido es: %2.2f %n", a.moda());
        System.out.printf("El valor más repetido encontrado con HashMap es: %2.2f %n", a.modaHashMap());
    }
}
