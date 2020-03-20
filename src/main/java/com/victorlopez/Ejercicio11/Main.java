package com.victorlopez.Ejercicio11;

import com.victorlopez.Lib;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner lector;
    static boolean validado;
    static Centro c1;
    static boolean gestion;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        c1 = new Centro();
        casosPrueba();
        boolean salir = false;
        do {
            int opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    gestionAlumnos();
                    break;
                case 2:
                    gestionGrupos();
                    break;
                case 3:
                    gestionAulas();
                    break;
                case 4:
                    gestionProfesores();
                    break;
                case 5:
                    gestionAsignaturas();
                    break;
                case 6:
                    consultas();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Hasta pronto!!");
            }
        }while (!salir);
    }

    /**
     * Casos de prueba del programa
     */
    public static void casosPrueba(){
        c1.addAula(1,50);
        c1.addAula(2,80);
        c1.addAula(3,100);
        c1.addAula(4,200);
        c1.addProfesor("74011022N","Marc Signes",5000);
        c1.addProfesor("28994850S", "Maria Rosa", 2000);
        c1.addProfesor("54375561L", "Víctor López", 10000);
        c1.addProfesor("54375926Q", "Francesc Mulet", 1000);
        c1.addProfesor("53944153E", "Antonio Signes", 900);
        c1.addAsignatura(1,"Seguridad informática", c1.buscarProfesor("74011022N"));
        c1.addAsignatura(2,"Base de datos", c1.buscarProfesor("28994850S"));
        c1.addAsignatura(3,"Servicios en red", c1.buscarProfesor("28994850S"));
        c1.addAsignatura(4,"Sistemas informaticos", c1.buscarProfesor("54375561L"));
        c1.addAsignatura(4,"Aplicaciones Web", c1.buscarProfesor("54375926Q"));
        c1.addAsignatura(4,"Aplicaciones Web", c1.buscarProfesor("53944153E"));
        c1.addGrupo(1,"1B", c1.buscarAula(1));
        c1.addGrupo(2,"2A", c1.buscarAula(2));
        c1.addGrupo(3,"4C", c1.buscarAula(3));
        c1.addGrupo(4,"3D", c1.buscarAula(4));
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(c1.buscarAsignatura(1));
        asignaturas.add(c1.buscarAsignatura(2));
        ArrayList<Asignatura> asignaturas1 = new ArrayList<>();
        asignaturas1.add(c1.buscarAsignatura(3));
        asignaturas1.add(c1.buscarAsignatura(4));
        ArrayList<Asignatura> asignaturas2 = new ArrayList<>();
        c1.addAlumno("Paco Reig Mulet", c1.buscarGrupo(1), asignaturas);
        c1.addAlumno("Cristian Garcia Fornes",c1.buscarGrupo(2), asignaturas1);
        c1.addAlumno("Mario Fornes Costa", c1.buscarGrupo(3), asignaturas);
        c1.addAlumno("Jairo Salva Agulles", c1.buscarGrupo(2), asignaturas1);
        c1.addAlumno("Antonio Fornes Costa", c1.buscarGrupo(1), asignaturas);
        c1.addAlumno("Vicent Ferrer Ferrer", c1.buscarGrupo(4), asignaturas2);
    }

    /**
     * Método que se encarga de la parte de consultas
     */
    public static void consultas(){
        boolean consultas = true;
        do {
            int opcion = menuConsultas();
            switch (opcion){
                case 1:
                    System.out.println(c1.alumnosToString());
                    break;
                case 2:
                    System.out.println(c1.profesorestoString());
                    break;
                case 3:
                    System.out.println(c1.asignaturasToString());
                    break;
                case 4:
                    System.out.println(c1.gruposToString());
                    break;
                case 5:
                    System.out.println(c1.aulasToString());
                    break;
                case 6:
                    alumnosPorGrupo();
                    break;
                case 7:
                    alumnosPorAsignatura();
                    break;
                case 8:
                    alumnosPorProfesor();
                    break;
                case 0:
                    consultas = false;
                    System.out.println("Has elegido volver al menú principal");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (consultas);
    }

    /**
     * Método que imprime todos los alumnos a los cuales les imparte clase un profesor en específico
     */
    public static void alumnosPorProfesor(){
        String dni = pedirDni();
        ArrayList<Alumno> alumnos;
        Profesor p = c1.buscarProfesor(dni);
        if (p == null){
            System.out.println("No existe un profesor con ese DNI");
        }else{
            alumnos = c1.alumnosPorProfesor(p);
            imprimirAlumnos(alumnos);
        }
    }
    /**
     * Método que imprime todos los alumnos los cuales cursan una asignatura en específico
     */
    public static void alumnosPorAsignatura() {
        int id = pedirId();
        ArrayList<Alumno> alumnos;
        Asignatura a = c1.buscarAsignatura(id);
        if (a == null){
            System.out.println("No existe una asignatura con ese ID");
        }else{
            alumnos = c1.alumnosPorAsignatura(a);
            imprimirAlumnos(alumnos);
        }
    }

    /**
     * Método que imprime todos los alumnos los cuales pertenecen a un grupo en específico
     */
    public static void alumnosPorGrupo(){
        int id = pedirId();
        ArrayList<Alumno> alumnos;
        Grupo g = c1.buscarGrupo(id);
        if (g == null){
            System.out.println("No existe un grupo con ese ID");
        }else{
            alumnos = c1.alumnosPorGrupo(g);
            imprimirAlumnos(alumnos);
        }
    }

    /**
     * Método que imprime un array list de alumnos con saltos de linea entre alumnos
     * @param a alumnos a imprimir
     */
    public static void imprimirAlumnos(ArrayList<Alumno> a){
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).toString());
        }
    }

    /**
     * Ménu que muestra y devuelve la opcion de consultas
     * @return opcion ya validada con las opciones del menu
     */
    public static int menuConsultas() {
        int opcion = -1;
        do {
            try{
                System.out.println("*********************");
                System.out.println("***** CONSULTAS *****");
                System.out.println("*********************");
                System.out.println("1. Todos los alumnos");
                System.out.println("2. Todos los profesores");
                System.out.println("3. Todas las asignaturas");
                System.out.println("4. Todos los grupos");
                System.out.println("5. Todas las aulas");
                System.out.println("6. Alumnos por grupo");
                System.out.println("7. Alumnos por asignatura");
                System.out.println("8. Alumnos por profesor");
                System.out.println("----------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 8){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método que se encarda de la gestion de los grupos
     */
    public static void gestionGrupos(){
        gestion = true;
        do {
            int opcion = menuGestionGrupos();
            switch (opcion){
                case 1:
                    crearGrupo();
                    break;
                case 2:
                    eliminarGrupo();
                    break;
                case 3:
                    cambiarAulaReferencia();
                    break;
                case 0:
                    gestion = false;
                    System.out.println("Has elegido volver al menú principal");
                    break;

            }
        }while (gestion);
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para cambiar el aula de referencia de un grupo
     */
    public static void cambiarAulaReferencia(){
        do {
            System.out.println("Empezamos con los datos del grupo");
            int id = pedirId();
            if (c1.existGrupo(id)){
                Grupo g = c1.buscarGrupo(id);
                System.out.println("Seguimos con los datos del aula:");
                id = pedirId();
                Aula a = c1.buscarAula(id);
                if (a == null){
                    System.out.println("No existe ningún aula con ese ID");
                    validado = false;
                }else{
                    g.setAula(a);
                    System.out.println("Aula modificada correctamente");
                    validado = true;
                }
            }else{
                System.out.println("No existe un grupo con ese ID");
                validado = false;
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!validado);
    }

    /**
     * Método para eliminar un grupo
     */
    public static void eliminarGrupo(){
        int id = pedirId();
        boolean borrado = c1.removeGrupo(id);
        if (borrado){
            System.out.println("El grupo se ha borrado correctamente");
        }else{
            System.out.println("No existe un grupo con ese ID");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para crear un grupo
     */
    public static void crearGrupo(){
        String nombre;
        Aula aula;
        int id;
        System.out.println("Empezamos con los datos del grupo");
        id = pedirId();
        if (c1.existGrupo(id)){
            validado = false;
            System.out.println("Ya existe un grupo con ese id");
        }else{
            validado = true;
            System.out.println("Introduce el nombre del grupo");
            nombre = lector.nextLine();
            System.out.println("Seguimos con los datos del aula");
            do {
                aula = pedirAula();
            }while (aula == null);
            c1.addGrupo(id, nombre, aula);
        }
    }

    /**
     * Método para pedir el aula
     * @return devuelve el aula encontrada, si no encuentra nada, devuelve null
     */
    public static Aula pedirAula(){
        int id;
        do {
            try{
                System.out.println("Introduce el ID del aula:");
                id = Integer.parseInt(lector.nextLine());
                if (id > 0){
                    Aula a = c1.buscarAula(id);
                    if (a == null){
                        System.out.println("No existe un aula con ese id");
                    }else{
                        return a;
                    }
                }else{
                    validado = false;
                    System.out.println("No puede ser negativo");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while(!validado);
        return null;
    }

    /**
     * Menú de gestión para los grupos
     * @return devuelve la opción ya validada
     */
    public static int menuGestionGrupos() {
        int opcion = -1;
        do {
            try {
                System.out.println("********************");
                System.out.println("** GESTIÓN GRUPOS **");
                System.out.println("********************");
                System.out.println("1. Crear grupo");
                System.out.println("2. Eliminar grupo");
                System.out.println("3. Cambiar aula de referencia");
                System.out.println("--------------------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    return opcion;
                }else{
                    validado = false;
                    System.out.println("Opcion correcta");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while(!validado);
        return opcion;
    }

    /**
     * Método que se encarga de la gestión de las aulas
     */
    public static void gestionAulas(){
        gestion = true;
        do {
            int opcion = menuGestionAulas();
            switch (opcion){
                case 1:
                    crearAula();
                    break;
                case 2:
                    eliminarAula();
                    break;
                case 0:
                    gestion = false;
                    break;
            }
        }while (gestion);
    }

    /**
     * Método para eliminar un aula
     */
    public static void eliminarAula(){
        boolean borrado;
        int id = pedirId();
        borrado = c1.removeAula(id);
        if (borrado){
            System.out.println("Aula borrada correctamente");
            validado = true;
        }else{
            validado = false;
            System.out.println("No existe un aula con ese ID");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para crear un aula
     */
    public static void crearAula(){
        int id;
        do {
            id = pedirId();
            if (c1.buscarAula(id) == null){
                validado = true;
            }else{
                validado = false;
                System.out.println("Ya existe un aula con ese ID");
            }
        }while (!validado);
        double m2 = pedirM2();
        c1.addAula(id, m2);
        System.out.println("Aula añadida correctamente");
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para pedir los metros cuadrados del aula
     * @return metros cuadrados validados
     */
    public static double pedirM2(){
        double m2 = -1;
        do {
            try{
                System.out.println("Introduce los metros cuadrados del aula:");
                System.out.println("La medida son metros, ej: '20'");
                m2 = Integer.parseInt(lector.nextLine());
                if (m2 > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("No puede ser negativo");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return m2;
    }

    /**
     * Método para el menú de gestion de aulas
     * @return opcion ya validada
     */
    public static int menuGestionAulas(){
        int opcion = -1;
        do {
            try{
                System.out.println("*******************");
                System.out.println("** GESTIÓN AULAS **");
                System.out.println("*******************");
                System.out.println("1. Crear aula");
                System.out.println("2. Eliminar aula");
                System.out.println("--------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 2){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opcion incorrecta");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }
            }catch (NumberFormatException nfe){
                System.out.println("Formato incorrecto");
                validado = false;
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método para controlar la gestion de profesores
     */
    public static void gestionProfesores(){
        gestion = true;
        do {
            int opcion = menuGestionProfes();
            switch (opcion){
                case 1:
                    nuevoProfesor();
                    break;
                case 2:
                    eliminarProfesor();
                    break;
                case 3:
                    modificarSueldo();
                    break;
                case 0:
                    gestion = false;
            }
        }while(gestion);
    }

    /**
     * Método para añadir un nuevo profesor
     */
    public static void nuevoProfesor() {
        String dni = pedirDni();
        String nombre = pedirNombre();
        double sueldo = pedirSueldo();
        c1.addProfesor(dni, nombre, sueldo);
    }

    /**
     * Método para añadir un profesor
     * @param dni dni del profesor
     */
    public static void nuevoProfesor(String dni) {
        String nombre = pedirNombre();
        double sueldo = pedirSueldo();
        c1.addProfesor(dni, nombre, sueldo);
    }

    /**
     * Método para eliminar un profesor
     */
    public static void eliminarProfesor(){
        String dni = pedirDni();
        boolean eliminado = c1.removeProfesor(dni);
        if (eliminado){
            System.out.println("El profesor se ha eliminado correctamente");
        }else{
            System.out.println("No existe ningún profesor con ese DNI");
        }
    }

    /**
     * Método para modificar el sueldo de un profesor
     */
    public static void modificarSueldo(){
        String dni;
        double sueldo;
            dni = pedirDni();
            Profesor p = c1.buscarProfesor(dni);
            if (p == null){
                System.out.println("No existe un profesor con ese nombre");
            }else{
                sueldo = pedirSueldo();
                p.setSueldo(sueldo);
                System.out.println("Sueldo modificado correctamente!");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
    }
    /**
     * Método para pedir el DNI
     * @return dni validado
     */
    public static String pedirDni(){
        String dni;
        do {
            System.out.println("Introduce el número de DNI del profesor: ");
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
                System.out.println("Formato incorrecto!!!");
            }
        }while (!validado);
        return sueldo;
    }

    /**
     * Método para el menú de gestión de profes
     * @return devuelvo la opcion ya validada
     */
    public static int menuGestionProfes() {
        int opcion = -1;
        do {
            try{
                System.out.println("************************");
                System.out.println("** GESTIÓN PROFESORES **");
                System.out.println("************************");
                System.out.println("1. Nuevo profesor");
                System.out.println("2. Eliminar profesor");
                System.out.println("3. Modificar sueldo");
                System.out.println("-------------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método que se encarga de la gestion de asignaturas
     */
    public static void gestionAsignaturas(){
        gestion = true;
        do {
            int opcion = menuGestionAsignaturas();
            switch (opcion){
                case 1:
                    nuevaAsignatura();
                    break;
                case 2:
                    eliminarAsignatura();
                    break;
                case 3:
                    cambiarProfesor();
                    break;
                case 0:
                    gestion = false;
            }
        }while (gestion);
    }

    /**
     * Método para eliminar una asignatura
     */
    public static void eliminarAsignatura(){
        boolean borrado;
        int id = pedirId();
        borrado = c1.removeAsignatura(id);
        if (borrado){
            System.out.println("Asignatura borrada correctamente");
            validado = true;
        }else{
            validado = false;
            System.out.println("No existe una asignatura con ese ID");
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para cambiar el profesor de una asignatura
     */
    public static void cambiarProfesor(){
        System.out.println("Datos de la asignatura:");
        int id = pedirId();
        Asignatura a = c1.buscarAsignatura(id);
        if (a == null){
            System.out.println("No existe ninguna asignatura con ese ID");
        }else{
            System.out.println("Datos del profesor: ");
            String dni = pedirDni();
            Profesor p = c1.buscarProfesor(dni);
            if (p == null){
                nuevoProfesor(dni);
                a.setProfesor(c1.buscarProfesor(dni));
            }else{
                a.setProfesor(p);
                System.out.println("Profesor modificado correctamente");
            }
        }
    }

    /**
     * Método para añadir una nueva asignatura
     */
    public static void nuevaAsignatura(){
        System.out.println("Datos de la asignatura:");
        int id = pedirId();
        String nombre;
        String dni;
        if (c1.buscarAsignatura(id) == null){
            nombre = pedirNombre();
            System.out.println("Datos del profesor: ");
            dni = pedirDni();
            Profesor p = c1.buscarProfesor(dni);
            if (p == null){
                nuevoProfesor(dni);
                c1.addAsignatura(id, nombre, c1.buscarProfesor(dni));
            }else{
                c1.addAsignatura(id,nombre,p);
            }
            System.out.println("Asignatura creada correctamente");
            Lib.pausa();
            Lib.limpiarPantalla();
        }else{
            System.out.println("Ya existe un asignatura con ese ID");
        }
    }

    /**
     * Método para el menu de gestión de asignaturas
     * @return opcion ya validada
     */
    public static int menuGestionAsignaturas() {
        int opcion = -1;
        do {
            try{
                System.out.println("*************************");
                System.out.println("** GESTIÓN ASIGNATURAS **");
                System.out.println("*************************");
                System.out.println("1. Nueva asignatura");
                System.out.println("2. Eliminar asignatura");
                System.out.println("3. Cambiar profesor");
                System.out.println("-------------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Método que controla la gestion de alumnos
     */
    public static void gestionAlumnos(){
        gestion = true;
        do {
            int opcion = mostrarMenuAlumnos();
            switch (opcion){
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    eliminarAlumno();
                    break;
                case 0:
                    gestion = false;
                    System.out.println("Has seleccionado volver al menú principal");
                    break;
            }
        }while(gestion);
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método para eliminar un alumno
     */
    public static void eliminarAlumno(){
        int id = pedirId();
        boolean eliminado = c1.eliminarAlumno(id);
        if (eliminado){
            System.out.println("El alumno se ha eliminado correctamente");
        }else{
            System.out.println("No existe ningún alumno con ese ID");
        }
    }

    /**
     * Método para pedir un ID
     * @return ID ya validado
     */
    public static int pedirId(){
        int id = -1;
        do {
            try{
                System.out.println("Introduce el ID:");
                id = Integer.parseInt(lector.nextLine());
                if (id > 0){
                    return id;
                }else{
                    validado = false;
                    System.out.println("No puede ser un número negativo");
                    Lib.pausa();
                    Lib.limpiarPantalla();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return id;
    }

    /**
     * Método para añadir un nuevo alumno.
     */
    public static void nuevoAlumno(){
        String nombre = pedirNombre();
        Grupo g = conseguirGrupo();
        ArrayList<Asignatura> asignaturas = pedirAsignaturas();
        c1.addAlumno(nombre, g, asignaturas);
        System.out.println("Alumno añadido correctamente");
        Lib.pausa();
        Lib.limpiarPantalla();
    }

    /**
     * Método que pide N asignaturas
     * @return array list de asignaturas
     */
    public static ArrayList<Asignatura> pedirAsignaturas(){
        int nAsignaturas = pedirNumAsignaturas();
        int id;
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        for (int i = 0; i < nAsignaturas; i++) {
            do {
                try{
                    System.out.println("Introduce el código de la asignatura:");
                    id = Integer.parseInt(lector.nextLine());
                    if (c1.existAsignatura(id)){
                        asignaturas.add(c1.buscarAsignatura(id));
                        System.out.println("Asignatura " + (i+1) + " encontrada");
                    }else{
                        validado = false;
                        System.out.println("No existe una asignatura con ese código");
                    }
                }catch (NumberFormatException nfe){
                    validado = false;
                    System.out.println("Formato incorrecto");
                }
                Lib.pausa();
                Lib.limpiarPantalla();
            }while (!validado);
        }
        return asignaturas;
    }

    /**
     * Método que pedimos cuantas asignaturas tiene el alumno
     * @return N asignaturas
     */
    public static int pedirNumAsignaturas(){
        int nAsignaturas = -1;
        do {
            try{
                System.out.println("¿En cuantas asignaturas está matriculado?");
                nAsignaturas = Integer.parseInt(lector.nextLine());
                if (nAsignaturas > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Debe tener mínimo 1 asignatura");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while(!validado);
        return nAsignaturas;
    }

    /**
     * Método para conseguir un Grupo
     * @return Grupo obtenido
     */
    public static Grupo conseguirGrupo(){
        int id;
        do {
            try{
                System.out.println("Introduce el ID del grupo: ");
                id = Integer.parseInt(lector.nextLine());
                if (c1.existGrupo(id)){
                    return c1.buscarGrupo(id);
                }else{
                    validado = false;
                    System.out.println("No existe ningún grupo con ese ID");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("El ID es numérico");
            }
        }while (!validado);
        return null;
    }
    /**
     * Método para pedir el nombre
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
     * Método para mostrar el menú de gestión de alumnos
     * @return opcion ya validada
     */
    public static int mostrarMenuAlumnos(){
        int opcion = -1;
        do {
            try{
                System.out.println("*********************");
                System.out.println("** GESTIÓN ALUMNOS **");
                System.out.println("*********************");
                System.out.println("1. Nuevo alumno");
                System.out.println("2. Eliminar alumno");
                System.out.println("----------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 2){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }

    /**
     * Menú principal de la app
     * @return opcion ya validada
     */
    public static int mostrarMenu(){
        int opcion = -1;
        do {
            try{
                System.out.println("************************");
                System.out.println("**** GESTIÓN CENTRO ****");
                System.out.println("************************");
                System.out.println("1. Gestionar alumnos");
                System.out.println("2. Gestionar grupos");
                System.out.println("3. Gestionar aulas");
                System.out.println("4. Gestionar profesores");
                System.out.println("5. Gestionar asignaturas");
                System.out.println("6. Consultas");
                System.out.println("----------------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 6){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Elige una opción incluida en el menú");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!");
            }
        }while (!validado);
        return opcion;
    }
}
