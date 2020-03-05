package com.victorlopez.Ejercicio06;

import com.victorlopez.Lib;

import java.util.Scanner;

public class Main {
    static Scanner lector ;
    static boolean validado;
    static Diccionario diccionario = new Diccionario();
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        String palabra;
        String resultado;
        String traduccion;
        boolean salir = false;
        int numParejas;
        do {
            int opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    numParejas = pedirNumParejas();
                    introducirParejas(numParejas);
                    Lib.limpiarPantalla();
                    break;
                case 2:
                    palabra = pedirPalabra();
                    traduccion = diccionario.traducir(palabra);
                    imprimirResultadoTraduc(traduccion);
                    break;
                case 3:
                    resultado = diccionario.eliminarPalabra(pedirPalabra());
                    imprimirResultadoEliminar(resultado);
                    break;
                case 0:
                    salir = true;
                    Lib.limpiarPantalla();
                    System.out.println("Has salido del programa!");
            }
        }while(!salir);
    }

    /**
     * Método para imprimir el resultado del intento de eliminar la palabra
     * @param r resultado
     */
    public static void imprimirResultadoEliminar(String r){
        if (r == null){
            System.out.println("No se ha encontrado la palabra");
        }else{
            System.out.println("La palabra se ha eliminado correctamente");
        }
    }
    /**
     * Método para imprimir los resultados de la traducción
     * @param p palabra a traducir
     */
    public static void imprimirResultadoTraduc(String p){
        if (p == null){
            System.out.println("La palabra no existe");
        }else{
            System.out.println("La traducción es: " + p);
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para pedir la palabra
     * @return devuelve la palabra
     */
    public static String pedirPalabra(){
        String palabra;
        System.out.println("Introduce la palabra: ");
        palabra = lector.nextLine().trim().toLowerCase();
        return palabra;
    }

    /**
     * Método para introducir las parejas de palabras dentro del diccionario
     * @param n número de palabras a introducir
     */
    public static void introducirParejas(int n){
        String palabraCaste = "";
        String palabraIngles = "";
        for (int i = 0; i < n ; i++) {
            System.out.println("Introduce la palabra en Castellano");
            palabraCaste = lector.nextLine().toLowerCase().trim();
            System.out.println("Introduce la palabra en Inglés");
            palabraIngles = lector.nextLine().toLowerCase().trim();
            diccionario.introducirParejas(palabraIngles, palabraCaste);
        }
    }

    /**
     * Método para pedir el número de parejas a introducir
     * @return devuelve el número de parejas a introducir
     */
    public static int pedirNumParejas(){
        int numParejas = 0;
        do {
            try{
                System.out.println("Cuantas parejas de palabras deseas introducir?");
                numParejas = Integer.parseInt(lector.nextLine());
                if (numParejas < 1){
                    validado = false;
                    System.out.println("Debe ser un número positivo");
                }else{
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Introduce números por favor");
            }
        }while (!validado);
        return numParejas;
    }

    /**
     * Método para mostrar el menú principal
     * @return devuelve la opcion ya validada
     */
    public static int mostrarMenu(){
        int opcion = 0;
        do {
            try{
                System.out.println("MENÚ PRINCIPAL");
                System.out.println("--------------");
                System.out.println("1. Introducir parejas de palabras");
                System.out.println("2. Traducir palabras");
                System.out.println("0. Salir de la aplicación");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion < 0 && opcion > 2){
                    validado = false;
                    System.out.println("Opción fuera de rango");
                }else{
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("");
            }
        }while(!validado);
        return opcion;
    }
}
