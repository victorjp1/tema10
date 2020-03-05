package com.victorlopez.Ejercicio05;

import com.victorlopez.Lib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static Scanner lector;
    private static boolean validado;
    private static Centro c1;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
        LocalDate fechaNac2 = LocalDate.parse("15/08/1996", fmt);
        IMCMensaje m;
        LocalDate fechaNac3 = LocalDate.parse("15/08/2000", fmt);
        c1 = new Centro();
        c1.añadirPaciente("Victor",fechaNac, Sexo.M, 1.7, 60.5);
        c1.añadirPaciente("Lucia",fechaNac2, Sexo.F, 1.5, 50.5);
        c1.añadirPaciente("Raul",fechaNac3, Sexo.M, 2, 80);
        int id;
        boolean salir = false;
        int opcion;
        do {
           opcion = mostrarMenu();
           switch (opcion){
               case 1:
                   añadirPaciente();
                   break;
               case 2:
                   eliminarPaciente();
                   break;
               case 3:
                   imprimirPorSexo(c1.pacientesPorSexo(c1.getPacientes()));
                   break;
               case 4:
                   int[] mayorMenor = c1.mayorMenor();
                   imprimirMayorMenor(mayorMenor);
                   break;
               case 5:
                   m = IMC();
                   imprimirIMC(m);
                   break;
               case 6:
                   System.out.println(c1.toString());
                   Lib.pausa();
                   Lib.limpiarPantalla();
                   break;
               case 7:
                   buscarPorId();
                   break;
               case 0:
                   salir = true;
                   break;
           }

        }while(!salir);
    }
    public static void imprimirPorSexo(int[] a){
        System.out.println("Existen " + a[0] + " pacientes de sexo masculino");
        System.out.println("Existen " + a[1] + " pacientes de sexo femenino");
        Lib.pausa();
        Lib.limpiarPantalla();
    }
    /**
     * Método para imprimir la posición del paciente mayor y menor
     * @param a array con resultados.
     */
    public static void imprimirMayorMenor(int[] a){
        System.out.println("El paciente de mayor edad se encuentra en la posición: " + a[1]);
        System.out.println("El paciente de menor edad se encuentra en la posición: " + a[0]);
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para imprimir el resultado de IMC
     * @param m Enumerado de IMC
     */
    public static void imprimirIMC(IMCMensaje m){
        switch (m){
            case NORMAL:
                System.out.println("Tiene un peso normal");
                break;
            case GRADO1:
                System.out.println("Tiene sobrepeso de grado 1");
                break;
            case GRADO2:
                System.out.println("Tiene soprepeso de grado 2");
                break;
            case GRADO3:
                System.out.println("Tiene sobrepeso de grado 3");
                break;
            case ERROR:
                System.out.println("No se ha encontrado el paciente");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para calcular cual es su estado de peso a un paciente buscandolo por ID
     * @return devolvemos el enumerado con el tipo de sobrepeso
     */
    public static IMCMensaje IMC(){
        int id = pedirId();
        return c1.ICM(id);
    }

    /**
     * Método para buscar pacientes por Id
     */
    public static void buscarPorId(){
        int id = pedirId();
        Paciente p = c1.buscarPorId(id);
        imprimirResultadoBuscar(p);
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para imprimir el resultado de la búsqueda del paciente
     * @param p paciente a valorar
     */
    public static void imprimirResultadoBuscar(Paciente p){
        if (p == null){
            System.out.println("No existe el paciente");
        }else{
            System.out.println(p.toString());
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para eliminar al paciente del centro por ID
     */
    public static void eliminarPaciente(){
        int id = pedirId();
        int resultado = c1.eliminarPaciente(id);
        imprimirResultadoEliminar(resultado);
    }

    /**
     * Método para imprimir los resultados del eliminado
     * @param r resultado a valorar
     */
    public static void imprimirResultadoEliminar(int r){
        if (r == 1){
            System.out.println("El paciente se ha eliminado correctamente");
        }else{
            System.out.println("No existe un paciente con ese ID");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para pedir el ID del paciente
     * @return devuelve un ID ya validado
     */
    public static int pedirId(){
        int id = 0;
        do {
            try{
                Lib.limpiarPantalla();
                System.out.println("Introduce el ID del paciente: ");
                id = Integer.parseInt(lector.nextLine());
                if (id < 0){
                    validado = false;
                    System.out.println("No puedes introducir un ID negativo");
                    Lib.pausa();
                }else{
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                System.out.println("Introduce un ID válido por favor");
                validado = false;
                Lib.pausa();
            }
        }while(!validado);
        return id;
    }
    /**
     * Método para añadir pacientes a una clase centro médico
     * @return devuelve un entero con el ID del paciente
     */
    public static void añadirPaciente(){
        String nombre = pedirNombre();
        LocalDate fechaNacimiento = pedirFechaNacimiento();
        Sexo sexo = pedirSexo();
        double altura = pedirAltura();
        double peso = pedirPeso();
        c1.añadirPaciente(nombre,fechaNacimiento,sexo, altura, peso);
    }

    /**
     * Método para pedir el peso del paciente
     * @return devuelve el peso del paciente validado
     */
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

    /**
     * Método para pedir la altura del paciente
     * @return devuelve la altura del paciente ya validada
     */
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

    /**
     * Método para pedir el sexo del paciente
     * @return devuelve el sexo del paciente
     */
    public static Sexo pedirSexo() {
        Sexo sexo = Sexo.M;
        do {
            try{
                System.out.println("Sexo ([M-F]: ");
                char s = lector.nextLine().toLowerCase().charAt(0);
                if (s == 'm') {
                    sexo = Sexo.M;
                    validado = true;
                } else if (s == 'f') {
                    sexo = Sexo.F;
                    validado = true;
                } else if (s == ' '){
                    sexo = Sexo.M;
                    validado = true;
                }else {
                    validado = false;
                    System.out.println("Debe indicar ' ' , 'M' ó 'F'");
                }
            }catch(StringIndexOutOfBoundsException siobe){
                sexo = Sexo.M;
            }
        } while (!validado);
        return sexo;
    }

    /**
     * Método para pedir el nombre del paciente
     * @return devuelve el nombre ya validado
     */
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

    /**
     * Método para mostrar el menú principal
     * @return devuelve la opción ya validada
     */
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
                    System.out.println("6. Mostrar todos los pacientes");
                    System.out.println("7. Buscar por ID");
                    System.out.println("----------------------------------");
                    System.out.println("0. Salir");
                    opcion = Integer.parseInt(lector.nextLine());
                    validado = true;
                }catch (NumberFormatException nfe){
                    validado = false;
                    System.out.println("Introduce una de las opciones del menú");
                }
            }while(!validado);
        }while(opcion <= 0 && opcion >= 7);
        return opcion;
    }
}

