package com.victorlopez.Ejercicio10;

import com.victorlopez.Lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner lector;
    static boolean validado;
    static Empresa empresa;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        casosPrueba();
        int opcion;
        empresa = new Empresa();
        boolean salir = false;
        do {
            opcion = mostrarMenu();//Opcion del menu validada
            switch (opcion){//Menu principal de la app
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
                    borrarHijo();
                    break;
                case 6:
                    consultas();
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

    /**
     * Casos de prueba para la app
     */
    public static void casosPrueba(){

    }

    /**
     * Método que valora la opcion del menu consultas
     */
    public static void consultas(){
        boolean consultas = true;
        do {
            int opcion = mostrarMenuConsultas();
            switch (opcion){
                case 1:
                    buscarNif();
                    break;
                case 2:
                    buscarNombre();
                    break;
                case 3:
                    buscarRangoEdad();
                    break;
                case 4:
                    buscarRangoSueldo();
                    break;
                case 5:
                    buscarHijosMenores();
                    break;
                case 0:
                    consultas = false;
                    break;
            }
        }while (consultas);
    }

    /**
     * Método que busca trabajadores con hijos menores de edad
     */
    public static void buscarHijosMenores(){
        ArrayList<Empleado> encontrados = empresa.buscarPorHijosMenores();
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    /**
     * Método para buscar empleados por rango de sueldo
     */
    public static void buscarRangoSueldo(){
        double min;
        double max;
        System.out.println("Introduce el sueldo mínimo");
        min = pedirSueldo();
        System.out.println("Introduce el sueldo máximo");
        max = pedirSueldo();
        ArrayList<Empleado> encontrados = empresa.buscarPorSueldo(min, max);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados entre ese rango de sueldos");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    /**
     * Método para buscar empleados por un rango de edad
     */
    public static void buscarRangoEdad(){
        int[] rango = pedirRango();
        ArrayList<Empleado> encontrados = empresa.buscarPorEdad(rango[0], rango[1]);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    /**
     * Método para pedir el rango de edad
     * @return array de enteros de 2 posiciones, la primera con el mínimo de edad y la segunda con el máximo de edad
     */
    public static int[] pedirRango(){
        int[] rango = new int[2];//La primera posición es el mínimo y la segunda el máximo
        do {
            try{
                System.out.println("Introduce el mínimo de edad que debe tener el empleado");
                rango[0] = Integer.parseInt(lector.nextLine());
                if (rango[0] > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("No puedes introducir números negativos");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Deben ser dígitos");
            }
        }while (!validado);
        do {
            try{
                System.out.println("Introduce el máximo de edad que debe tener el empleado");
                rango[1] = Integer.parseInt(lector.nextLine());
                if (rango[1] > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("No puedes introducir números negativos");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Deben ser dígitos");
            }
        }while (!validado);
        return rango;
    }

    /**
     * Método para buscar empleados por una secuencia de caracteres
     */
    public static void buscarNombre(){
        String nombre = pedirNombre();
        ArrayList<Empleado> encontrados = empresa.buscarNombre(nombre);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    /**
     * Método para buscar empleados por NIF
     */
    public static void buscarNif(){
        String dni = pedirDni();
        Empleado e = empresa.buscarDni(dni);
        if (e == null){
            System.out.println("El empleado no existe");
        }else{
            System.out.println(e.toString());
        }
    }

    /**
     * Método para mostrar el menú consultas
     * @return devuelve la opcion elegida ya validada
     */
    public static int mostrarMenuConsultas(){
        int opcion = 0;
        do {
            try{
                System.out.println("***********************");
                System.out.println("* CONSULTAS EMPLEADOS *");
                System.out.println("***********************");
                System.out.println("1. Buscar por NIF");
                System.out.println("2. Buscar por número");
                System.out.println("3. Buscar por rango de edad");
                System.out.println("4. Buscar por rango de sueldo");
                System.out.println("5. Buscar por hijos menores de edad");
                System.out.println("---------------------------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 5){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Opción no válida");
            }
        }while(!validado);
        return opcion;
    }

    /**
     * Método para eliminar un hijo de un empleado
     */
    public static void borrarHijo(){
        String dni = pedirDni();
        String nombre;
        if (empresa.existEmpleado(dni)){
            nombre = pedirNombre();
            if (empresa.borrarHijo(dni, nombre)){
                System.out.println("Hijo eliminado de la base de datos correctamente!");
            }else{
                System.out.println("No se ha encontrado el hijo");
            }
        }else{
            System.out.println("No existe un empleado con ese nombre!");
        }
    }

    /**
     * Método para eliminar un empleado
     */
    public static void borrarEmpleado(){
        String dni = pedirDni();
        if (empresa.borrarEmpleado(dni)){
            System.out.println("El empleado se ha borrado correctamente");
        }else{
            System.out.println("El empleado no se encuentra en la base de datos!");
        }
    }

    /**
     * Método para modificar el sueldo de un empleado
     */
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

    /**
     * Método para añadir un nuevo hijo al empleado
     */
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

    /**
     * Método para añadir un nuevo empleado
     */
    public static void nuevoEmpleado(){
        String dni = pedirDni();
        if (empresa.existEmpleado(dni)){
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

    /**
     * Método para añadir hijos a un empleado
     * @param e empleado a añadir
     */
    public static void addHijos(Empleado e){
        int numHijos;
        do {
            try{
                System.out.println("Cuantos hijos tiene el empleado?");
                numHijos = Integer.parseInt(lector.nextLine());
                if (numHijos >= 0){
                    validado = true;
                    crearHijos(numHijos, e);
                }else{
                    validado = false;
                    System.out.println("No puede ser un número negativo");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Error");
            }
        }while (!validado);
    }

    /**
     * Método para crear hijos.
     * @param n número de hijos a crear
     * @param e empleado a añadir
     */
    public static void crearHijos(int n, Empleado e){
        String nombre;
        int edad;
        for (int i = 0; i < n; i++) {
            nombre = pedirNombre();
            edad = pedirEdad();
            e.addHijo(new Hijo(nombre,edad));
        }
    }

    /**
     * Método para pedir la edad
     * @return devuelve la edad ya validada
     */
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
    /**
     * Método para pedir el sueldo
     * @return sueldo ya validado
     */
    public static double pedirSueldo(){
        double sueldo = -1;
        do {
            try{
                System.out.println("Introduce el sueldo: ");
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
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!validado);
        return fechaNacimiento;
    }

    /**
     * Método para pedir los apellidos
     * @return apellidos ya validados y en minúsculas
     */
    public static String pedirApellidos(){
        String apellidos;
        do {
            System.out.println("Introduce los apellidos:");
            apellidos = lector.nextLine().trim().toLowerCase();
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
     * @return devuelve el nombre ya validado y en minúsculas
     */
    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre:");
            nombre = lector.nextLine().trim().toLowerCase();
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

    /**
     * Método para pedir el DNI
     * @return dni validado
     */
    public static String pedirDni(){
        String dni;
        do {
                System.out.println("Introduce el número de DNI del empleado: ");
                dni = lector.nextLine().toUpperCase().trim();
                try{
                    if (compruebaNIF(dni)){
                        validado = true;
                    }else{
                        validado = false;
                        System.out.println("Letra incorrecta");
                        Lib.pausa();
                        Lib.limpiarPantalla();
                    }
                }catch (NumberFormatException nfe){
                    validado = false;
                    System.out.println("Introduce un número de DNI correcto:");
                    System.out.println("Ejemplo: 54375561L");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }

        }while (!validado);
        return dni;
    }

    /**
     * Método que comprueba si el NIF es correcto
     * @param nif nif a comprobar
     * @return boolean que dice si es correcto o no
     */
    public static boolean compruebaNIF(String nif) {
        StringBuilder dniString = new StringBuilder();
        // Cogemos como letra el último caracter del NIF
        char letra = nif.charAt(nif.length()-1);
        char c;
        for(int i = 0; i < nif.length(); i++) {
            // Si es un dígito lo añadimos a dniString
            c = nif.charAt(i);
            if(Character.isDigit(c)) {
                dniString.append(c);
            }
        }
            return letra == obtenerLetraDNI(Integer.parseInt(dniString.toString()));
    }

    /**
     * Obtener la letra correspondiente del dni
     * @param dni dni a valorar
     * @return letra correcta de deni
     */
    public static char obtenerLetraDNI(int dni) {
        String tabla = "TRWAGMYFPDXBNJZSQVHLCKE";
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
