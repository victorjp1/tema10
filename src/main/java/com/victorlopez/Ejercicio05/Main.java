package com.victorlopez.Ejercicio05;

import com.victorlopez.Lib;
import com.victorlopez.Sexo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    private static Scanner lector;
    private static boolean validado;
    private static Centro c1;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        c1 = new Centro();
        int id;
        boolean salir = false;
        int opcion;
        do {
           opcion = mostrarMenu();
           switch (opcion){
               case 1:
                   id = añadirPaciente();
                   break;
               case 2:
                   //eliminarPaciente();
                   break;
               case 3:
                   //pacientesPorSexo();
                   break;
               case 4:
                   //mayorMenor();
                   break;
               case 5:
                   //IMC();
                   break;
               case 6:
                   break;
               case 0:
                   salir = true;
                   break;
           }

        }while(!salir);
        ArrayList<Paciente> nada= c1.getPacientes();
        for (int i = 0; i <  nada.size(); i++) {
            System.out.println(nada.get(i).toString());
        }
    }
    public static int añadirPaciente(){
        int id = Lib.aleatorio(0,10000);
        String nombre = pedirNombre();
        LocalDate fechaNacimiento = pedirFechaNacimiento();
        Sexo sexo = pedirSexo();
        double altura = pedirAltura();
        double peso = pedirPeso();
        c1.añadirPaciente(id,nombre,fechaNacimiento,sexo, altura, peso);
        return id;
    }
    public static double pedirPeso(){
        double peso = -1;
        do {
            try{
                System.out.println("Introduce el peso del paciente: [KG] ");
                peso = Double.parseDouble(lector.nextLine());
                if (peso > 0 && peso < 350){
                    validado = true;
                }else{
                    System.out.println("Peso no posible");
                    validado = false;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("El peso no está en formato correcto");
            }
        }while(!validado);
        return peso;
    }
    public static double pedirAltura(){
        double altura = -1;
        do {
            try{
                System.out.println("Introduce la altura del paciente: [m]");
                altura = Double.parseDouble(lector.nextLine());
                if (altura > 0 && altura < 3){
                    validado = true;
                }else{
                    System.out.println("Altura no posible");
                    validado = false;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("La altura no pueden ser letras");
            }
        }while(!validado);
        return altura;
    }
    public static LocalDate pedirFechaNacimiento(){
        LocalDate fechaNacimiento = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            Lib.limpiarPantalla();
            System.out.println("Fecha de nacimiento (dd-mm-yyyy): ");
            String fechaNacimientoString = lector.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoString,fmt);
                validado = true;
            } catch (Exception pe) {
                validado = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!validado);
        return fechaNacimiento;
    }
    public static Sexo pedirSexo() {
        Sexo sexo = Sexo.M;
        do {
            System.out.println("Sexo ([M-F]: ");
            char s = lector.nextLine().toLowerCase().charAt(0);
            if (s == 'm') {
                sexo = Sexo.M;
                validado = true;
            } else if (s == 'f') {
                sexo = Sexo.F;
                validado = true;
            } else {
                validado = false;
                System.out.println("Debe indicar 'M' ó 'F'");
            }
        } while (!validado);
        return sexo;
    }
    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre del paciente:");
            nombre = lector.nextLine();
            if (nombre.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("El nombre debe tener mínimo 3 caracteres");
            }
        }while (!validado);
        return nombre;
    }
    public static int mostrarMenu(){
        int opcion = -1;
        do{
            do {
                try{
                    System.out.println("**CENTRO MÉDICO**");
                    System.out.println("1. Añadir Paciente");
                    System.out.println("2. Eliminar paciente");
                    System.out.println("3. Pacientes por sexo");
                    System.out.println("4. Mayor a menor");
                    System.out.println("5. Indice de masa corporal");
                    System.out.println("6. Edad en años de un paciente");
                    System.out.println("----------------------------------");
                    System.out.println("0. Salir");
                    opcion = Integer.parseInt(lector.nextLine());
                    validado = true;
                }catch (NumberFormatException nfe){
                    validado = false;
                    System.out.println("Introduce una de las opciones del menú");
                }
            }while(!validado);
        }while(opcion <= 0 && opcion >= 6);
        return opcion;
    }
}

