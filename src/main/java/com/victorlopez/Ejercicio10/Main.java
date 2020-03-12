package com.victorlopez.Ejercicio10;

import com.victorlopez.Lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner lector;
    static boolean validado;
    static Empresa empresa;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        int opcion;
        empresa = new Empresa();
        boolean salir = false;
        do {
            opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    nuevoEmpleado();
                    break;
                case 2:
                    nuevoHijo();
                    break;
                case 3:
                    modificarSueldo();
                    break;
                case 4:
                    borrarEmpleado();
                    break;
                case 5:
                    //borrarHijo();
                    break;
                case 6:
                    //consultas();
                    break;
                case 7:
                    System.out.println(empresa.toString());
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }while (!salir);
    }
    public static void borrarEmpleado(){
        String dni = pedirDni();
        if (empresa.borrarEmpleado(dni)){
            System.out.println("El empleado se ha borrado correctamente");
        }else{
            System.out.println("El empleado no se encuentra en la base de datos!");
        }
    }
    public static void modificarSueldo(){
        String dni = pedirDni();
        double sueldo;
        Empleado e = empresa.buscarDni(dni);
        if (e == null){
            System.out.println("El empleado no existe en la base de datos");
        }else{
            sueldo = pedirSueldo();
            e.setSueldo(sueldo);
            System.out.println("El sueldo se ha modificado correctamente");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }
    public static void nuevoHijo(){
        String dni = pedirDni();
        Empleado e = empresa.buscarDni(dni);
        if (e == null){
            System.out.println("Ese empleado no está registrado en la base de datos");
        }else{
            System.out.println("Ahora empezamos con los datos del hijo: ");
            String nombre = pedirNombre();
            int edad = pedirEdad();
            Hijo h = new Hijo(nombre,edad);
            e.addHijo(h);
        }
    }
    public static void nuevoEmpleado(){
        String dni = pedirDni();
        if (empresa.buscarDni(dni) != null){
            System.out.println("Ya existe un empleado con ese dni!!");
        }else{
            String nombre = pedirNombre();
            String apellidos = pedirApellidos();
            LocalDate fechaNacimiento = pedirFechaNacimiento();
            double sueldo = pedirSueldo();
            Empleado e = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo);
            addHijos(e);
            empresa.addEmpleado(e);
        }
    }
    public static void addHijos(Empleado e){
        int hijos;
        do {
            try{
                System.out.println("Cuantos hijos tiene el empleado?");
                hijos = Integer.parseInt(lector.nextLine());
                if (hijos >= 0){
                    validado = true;
                    crearHijos(hijos, e);
                }else{
                    validado = false;
                    System.out.println("No puede ser un número negativo");
                }
            }catch (NumberFormatException nfe){
                validado = false;
            }
        }while (!validado);
    }
    public static void crearHijos(int n, Empleado e){
        String nombre;
        int edad;
        for (int i = 0; i < n; i++) {
            nombre = pedirNombre();
            edad = pedirEdad();
            Hijo h = new Hijo(nombre,edad);
            e.addHijo(h);
        }
    }
    public static int pedirEdad(){
        int edad = -1;
        do {
            try{
                System.out.println("Introduce la edad:");
                edad = Integer.parseInt(lector.nextLine());
                if (edad > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("La edad debe ser mínimo 1 año");
                }
            }catch (NumberFormatException nfe){
                validado = false;
            }
        }while (!validado);
        return edad;
    }
    public static double pedirSueldo(){
        double sueldo = -1;
        do {
            try{
                System.out.println("Introduce el sueldo del empleado: ");
                sueldo = Double.parseDouble(lector.nextLine());
                if (sueldo > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("El sueldo no puede ser negativo!!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("No pueden ser letras!!!");
            }
        }while (!validado);
        return sueldo;
    }
    /**
     * Método para pedir la fecha de nacimiento del paciente
     * @return devuelve la fecha ya validada
     */
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
    public static String pedirApellidos(){
        String apellidos;
        do {
            System.out.println("Introduce los apellidos:");
            apellidos = lector.nextLine().trim().toUpperCase();
            if (apellidos.length() > 2){
                validado = true;
            }else{
                validado = false;
                System.out.println("Debe tener almenos 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return apellidos;
    }
    /**
     * Método para pedir el nombre del paciente
     * @return devuelve el nombre ya validado
     */
    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre:");
            nombre = lector.nextLine().trim().toUpperCase();
            if (nombre.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("El nombre debe tener mínimo 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return nombre;
    }

    public static String pedirDni(){
        String dni;
        do {

                System.out.println("Introduce el número de DNI del empleado: ");
                dni = lector.nextLine();
                if (compruebaNIF(dni)){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Introduce el número de DNI:");
                    System.out.println("Ejemplo: 54375561");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }

                Lib.pausa();
                Lib.limpiarPantalla();
        }while (!validado);
        return dni;
    }
    public static boolean compruebaNIF(String nif) {
        String dniString = "";
        // Cogemos como letra el último caracter del NIF
        char letra = nif.charAt(nif.length()-1);
        char c;
        for(int i = 0; i < nif.length(); i++) {
            // Si es un dígito lo añadimos a dniString
            c = nif.charAt(i);
            if(Character.isDigit(c)) {
                dniString = dniString + c;
            }
        }
        return letra == obtenerLetraDNI(Integer.parseInt(dniString));
    }

    public static char obtenerLetraDNI(int dni) {
        String tabla = new String("TRWAGMYFPDXBNJZSQVHLCKE");
        return tabla.charAt(dni % 23);
    }

    public static int mostrarMenu(){
        int opcion = -1;
        do {
            try {
                System.out.println("*********************");
                System.out.println("* GESTIÓN EMPLEADOS *");
                System.out.println("*********************");
                System.out.println("1. Nuevo empleado");
                System.out.println("2. Nuevo hijo");
                System.out.println("3. Modificar sueldo");
                System.out.println("4. Borrar empleado");
                System.out.println("5. Borrar hijo");
                System.out.println("6. Consultas");
                System.out.println("7. Mostrar Empleados");
                System.out.println("-----------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine()) ;
                if (opcion >= 0 && opcion <= 7){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Solo números");
            }
        }while(!validado);
        return opcion;
    }
}
