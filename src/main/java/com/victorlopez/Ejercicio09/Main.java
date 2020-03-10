package com.victorlopez.Ejercicio09;

import java.util.Scanner;

public class Main {
    static Scanner lector;
    static boolean validado;
    static Diccionario diccionario;
    static Juego juego;
    public static void main(String[] args) {
        int opcion;
        diccionario = new Diccionario();
        juego = new Juego(diccionario);
        diccionario.añadirPalabra("hola", "adios");
        diccionario.añadirPalabra("victor", "mamma mia");
        diccionario.añadirPalabra("todo", "nada");
        diccionario.añadirPalabra("ahi", "ole");
        lector = new Scanner(System.in);
        String definicion;
        boolean salir = false;
        String palabra;
        do {
            opcion = mostrarMenu();
            switch (opcion){
                case 1://Añadir palabra
                    palabra = pedirPalabra();//Pedimos la palabra a añadir
                    definicion = pedirDefinicion();//Pedimos la definicion
                    añadirPalabra(palabra, definicion);//Añadimos palabra
                    break;
                case 2://Modificar palabra
                    palabra = pedirPalabra();//Pedimos palabra
                    modificarPalabra(palabra);//Modificamos si es posible
                    break;
                case 3://Eliminar palabra
                    palabra = pedirPalabra();//Pedir palabra
                    eliminarPalabra(palabra);//Eliminamos palabra si es posible
                    break;
                case 4://Consultar palabra
                    palabra = pedirPalabra();//Pedimos palabra
                    consultarPalabra(palabra);//Consultamos palabra si es posible
                    break;
                case 5:
                    System.out.println(diccionario.toString());//Imprimimos el diccionario
                    break;
                case 6://Opcion para jugar a adinivar el programa
                    juego.jugar();
                    break;
                case 7://Mostrar nuevas puntuaciones
                    System.out.println(juego.mejoresPuntuaciones());
                    break;
                case 0://Salimos de la app
                    salir = true;
                    System.out.println("Esperamos tu regreso");
            }
        }while(!salir);
    }

    /**
     * Método para consultar la definicion de una palabra
     * @param p palabra a consultar
     */
    public static void consultarPalabra(String p){
        String def = diccionario.consultarPalabra(p);
        if (def == null){
            System.out.println("Esa palabra no existe!!");
        }else{
            System.out.println(def);
        }
    }

    /**
     * Método para eliminar un palabra del diccionario
     * @param p palabra a eliminar
     */
    public static void eliminarPalabra(String p){
        validado = diccionario.eliminarPalabra(p);
        if (validado){
            System.out.println("Palabra eliminada correctamente!!");
        }else{
            System.out.println("Esa palabra no existe!!");
        }
    }

    /**
     * Método para modificar la definicion de un palabra
     * @param p palabra a modificar
     */
    public static void modificarPalabra(String p){
        String definicion;
        if (diccionario.existePalabra(p)){
            definicion = pedirDefinicion();
            diccionario.modificarPalabra(p,definicion);
            System.out.println("Palabra modificada correctamente!");
        }else{
            System.out.println("Esa palabra no existe!!");
        }
    }

    /**
     * Método para pedir la definicion de una palabra
     * @return devuelve la definicion de la palabra
     */
    public static String pedirDefinicion(){
        System.out.println("Introduce la definicion de la palabra: ");
        return lector.nextLine().toLowerCase().trim();
    }

    /**
     * Método para añadir una palabra al diccionario
     * @param p palabra a añadir
     * @param def definicion a añadir
     */
    public static void añadirPalabra(String p, String def){
        validado = diccionario.añadirPalabra(p,def);
        if (validado){
            System.out.println("Palabra añadida correctamente!!");
        }else{
            System.out.println("La palabra ya existe!!");
        }
    }

    /**
     * Método para pedir una palabra
     * @return palabra sin espacios en blanco y en minúsculas
     */
    public static String pedirPalabra(){
        System.out.println("Introduce la palabra:");
        return lector.nextLine().toLowerCase().trim();
    }

    /**
     * Método para mostrar el menú principal de la app
     * @return devuelve la opcion ya validada
     */
    public static int mostrarMenu(){
        int opcion = -1;
        do {
            try{
                System.out.println("***********************");
                System.out.println("* GESTIÓN DICCIONARIO *");
                System.out.println("***********************");
                System.out.println("1. Añadir palabra");
                System.out.println("2. Modificar palabra");
                System.out.println("3. Eliminar palabra");
                System.out.println("4. Consultar palabra");
                System.out.println("5. Mostrar diccionario");
                System.out.println("6. Jugar");
                System.out.println("7. Mejores puntuaciones");
                System.out.println("-------------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 7){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opcion incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Opción no válida!");
            }
        }while (!validado);
        return opcion;
    }
}
