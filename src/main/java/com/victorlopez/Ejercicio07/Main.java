package com.victorlopez.Ejercicio07;

import com.victorlopez.Lib;

import java.util.Scanner;

public class Main {
    static boolean validado;
    static Scanner lector;
    static boolean salir;
    public static void main(String[] args) {
        lector = new Scanner (System.in);
        int opcionMenu;
        double euros = 0;
        double conversion = 0;
        boolean cambio = true;
        salir = false;
        Convertidor convertidor = new Convertidor();
        do {
            opcionMenu = menuEuros();
            switch (opcionMenu){
                case 1:
                    euros = pedirEuros();
                    do {
                        int opcion = mostrarMenu();
                        switch (opcion){
                            case 1:
                                cambio = true;
                                conversion = convertidor.convertir(euros, Moneda.USD);
                                break;
                            case 2:
                                cambio = true;
                                conversion = convertidor.convertir(euros, Moneda.GBP);
                                break;
                            case 3:
                                conversion = convertidor.convertir(euros, Moneda.INR);
                                cambio = true;
                                break;
                            case 4:
                                conversion = convertidor.convertir(euros, Moneda.AUD);
                                cambio = true;
                                break;
                            case 5:
                                conversion = convertidor.convertir(euros, Moneda.CAD);
                                cambio = true;
                                break;
                            case 6:
                                conversion = convertidor.convertir(euros, Moneda.ARS);
                                cambio = true;
                                break;
                            case 7:
                                conversion = convertidor.convertir(euros, Moneda.BOB);
                                cambio = true;
                                break;
                            case 8:
                                conversion = convertidor.convertir(euros, Moneda.CLP);
                                cambio = true;
                                break;
                            case 9:
                                conversion = convertidor.convertir(euros, Moneda.VEZ);
                                cambio = true;
                                break;
                            case 10:
                                conversion = convertidor.convertir(euros, Moneda.CRC);
                                cambio = true;
                                break;
                            case 11:
                                conversion = convertidor.convertir(euros, Moneda.CUP);
                                cambio = true;
                                break;
                            case 12:
                                conversion = convertidor.convertir(euros, Moneda.DOP);
                                cambio = true;
                                break;
                            case 13:
                                conversion = convertidor.convertir(euros, Moneda.MXN);
                                cambio = true;
                                break;
                            case 0:
                                cambio = false;
                        }
                        if (opcion != 0){
                            System.out.printf("El resultado de la conversión es: %.2f %n", conversion);
                            Lib.pausa();
                        }
                        Lib.limpiarPantalla();
                    }while(cambio);
                    break;
                case 2:
                    salir = true;
                    System.out.println("Has salido del programa");
            }
        }while(!salir);
    }
    public static int menuEuros(){
        int opcion = 0;
        do {
            try{
                System.out.println("CONVERTIDOR DE MONEDAS");
                System.out.println("1. Elegir cantidad");
                System.out.println("2. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion == 1 || opcion == 2){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Introduce una opcion del menú");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Opción no válida");
            }
        }while(!validado);
        return opcion;
    }
    public static double pedirEuros(){
        double euros = 0;
        do {
            try{
                System.out.println("Introduce la cantidad en euros a convertir:");
                euros = Double.parseDouble(lector.nextLine());
                if (euros > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Solo cifras positivas");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Valor incorrecto");
            }
        }while (!validado);
        return euros;
    }
    public static int mostrarMenu(){
        int opcion = -1;
        do {
            try{
                System.out.println("CAMBIO DE MONEDA");
                System.out.println("1. USD (Dólar EEUU)");
                System.out.println("2. GBP (Libra esterlina)");
                System.out.println("3. INR (Rupia India)");
                System.out.println("4. AUD (Dólar Australiano)");
                System.out.println("5. CAD (Dólar Canadiense)");
                System.out.println("6. ARS (Peso Argentino)");
                System.out.println("7. BOB (Boliviano Boliviano)");
                System.out.println("8. CLP (Peso Chileno)");
                System.out.println("9. VEZ (Peso Colombiano)");
                System.out.println("10. CRC (Colón Costarricense)");
                System.out.println("11. CUP (Peso Cubano)");
                System.out.println("12. DOP (Peso Dominicano)");
                System.out.println("13. MXN (Peso Mexicano)");
                System.out.println("------------------------------------");
                System.out.println("0. Salir del menú de monedas");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 13){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Introduce una opcion del menú");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Introduce las opciones del menú");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while(!validado);
        return opcion;
    }
}
