package com.victorlopez.Ejercicio11;

import java.util.ArrayList;

public class Centro {
    private static int nCentros = 0;
    private int id;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Grupo> grupos;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Aula> aulas;
    private ArrayList<Profesor> profesores;

    public Centro() {
        alumnos = new ArrayList<>();
        grupos = new ArrayList<>();
        asignaturas = new ArrayList<>();
        aulas = new ArrayList<>();
        profesores = new ArrayList<>();
        id = ++nCentros;
    }

    /**
     * Método para añadir un aula al centro
     * @param id id del aula
     * @param m2 m2 del aula
     * @return true si se ha creado correctamente y false si ya existia
     */
    public boolean addAula(int id, double m2){
        if (buscarAula(id) == null){
            aulas.add(new Aula(id, m2));
            return true;
        }else{
            return false;
        }
    }

    /**
     * Método para buscar alumnos por grupo
     * @param g grupo a valorar
     * @return devuelve un ArrayList de alumnos
     */
    public ArrayList<Alumno> alumnosPorGrupo(Grupo g){
        ArrayList<Alumno> resultado = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getGrupo() == g){
                resultado.add(alumnos.get(i));
            }
        }
        return resultado;
    }
    /**
     * Método para buscar alumnos por asignatura
     * @param a asignatura a valorar
     * @return devuelve un ArrayList de alumnos
     */
    public ArrayList<Alumno> alumnosPorAsignatura(Asignatura a){
        ArrayList<Alumno> resultado = new ArrayList<>();
        boolean encontrado;
        for (int i = 0; i < alumnos.size(); i++) {
            encontrado = false;
            for (int j = 0; j < alumnos.get(i).getAsignaturas().size(); j++) {
                if (alumnos.get(i).getAsignaturas().get(j) == a && !encontrado){
                    resultado.add(alumnos.get(i));
                    encontrado = true;
                }
            }
        }
        return resultado;
    }
    /**
     * Método para buscar alumnos por profesor
     * @param p profesor a valorar
     * @return devuelve un ArrayList de alumnos
     */
    public ArrayList<Alumno> alumnosPorProfesor(Profesor p){
        ArrayList<Alumno> resultado = new ArrayList<>();
        boolean encontrado;
        Profesor aux;
        for (int i = 0; i < alumnos.size(); i++) {
            encontrado = false;
            for (int j = 0; j < alumnos.get(i).getAsignaturas().size(); j++) {
               aux = alumnos.get(i).getAsignaturas().get(j).getProfesor();
               if (aux == p && !encontrado){
                   resultado.add(alumnos.get(i));
                   encontrado = true;
               }
            }
        }
        return resultado;
    }

    /**
     * Método para borrar un aula
     * @param id id del aula
     * @return true si se ha eliminado, false si no
     */
    public boolean removeAula(int id){
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getId() == id){
                aulas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para borrar un grupo
     * @param id id del grupo
     * @return true si se ha eliminado, false si no
     */
    public boolean removeGrupo(int id){
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == id){
                grupos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para añadir un grupo
     * @param id id del grupo
     * @param nombre nombre del grupo
     * @param aula aula de referencia del grupo
     */
    public void addGrupo(int id, String nombre, Aula aula){
        grupos.add(new Grupo(id, nombre, aula));
    }
    public Aula buscarAula(int id){
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getId() == id){
                return aulas.get(i);
            }
        }
        return null;
    }

    /**
     * Método para añadir alumnos
     * @param nombre nombre del alumno
     * @param grupo grupo al que pertenece
     * @param asignaturas asignaturas en las que esta matriculado
     */
    public void addAlumno(String nombre, Grupo grupo, ArrayList<Asignatura> asignaturas){
        alumnos.add(new Alumno(nombre, grupo, asignaturas));
    }

    /**
     * Método para buscar un profesor
     * @param dni dni del profesor
     * @return si encuentra un profesor lo devuelve, en caso contrario, devuelve null
     */
    public Profesor buscarProfesor(String dni){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                return profesores.get(i);
            }
        }
        return null;
    }

    /**
     * Método para añadir un profesor
     * @param dni dni del profe
     * @param nombre nombre del profe
     * @param sueldo sueldo del profe
     */
    public void addProfesor(String dni, String nombre, double sueldo){
        profesores.add(new Profesor(dni, nombre, sueldo));
    }

    /**
     * Método para añadir una asignatura
     * @param id id de la asignatura
     * @param nombre nombre de la asignatura
     * @param p profesor que la imparte
     */
    public void addAsignatura(int id, String nombre, Profesor p){
        asignaturas.add(new Asignatura(id, nombre, p));
    }
    /**
     * Método para borrar una asignatura
     * @param id id de la asignatura
     * @return true si se ha eliminado, false si no
     */
    public boolean removeAsignatura(int id){
        for (int i = 0; i < asignaturas.size(); i++) {
            if (asignaturas.get(i).getId() == id){
                asignaturas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para conseguir todas las asignaturas
     * @return String que contiene todas las asignaturas
     */
    public String asignaturasToString(){
        String aux = "";
        for (int i = 0; i < asignaturas.size(); i++) {
            aux += asignaturas.get(i).toString() + "\n";
        }
        return aux;
    }

    /**
     * Método para conseguir todas las aulas
     * @return String con todas las aulas
     */
    public String aulasToString(){
        String aux = "";
        for (int i = 0; i < aulas.size(); i++) {
            aux += aulas.get(i).toString() + "\n";
        }
        return aux;
    }
    /**
     * Método para conseguir todas los profes
     * @return String con todos los profes
     */
    public String profesorestoString(){
        String aux = "";
        for (int i = 0; i < profesores.size(); i++) {
            aux += profesores.get(i).toString() + "\n";
        }
        return aux;
    }
    /**
     * Método para conseguir todas los grupos
     * @return String con todas los grupos
     */
    public String gruposToString(){
        String aux = "";
        for (int i = 0; i < grupos.size(); i++) {
            aux += grupos.get(i).toString() + "\n";
        }
        return aux;
    }
    /**
     * Método para conseguir todas los alumnos
     * @return String con todas los alumnos
     */
    public String alumnosToString(){
        String aux = "";
        for (int i = 0; i < alumnos.size(); i++) {
            aux += alumnos.get(i).toString() + "\n";
        }
        return aux;
    }

    /**
     * Método para borrar profesores
     * @param dni dni del profesor
     * @return true si se ha podido borrar, en caso contrario false
     */
    public boolean removeProfesor(String dni){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                profesores.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para buscar asignaturas
     * @param id id de la asignatura
     * @return asignatura encontrada o null
     */
    public Asignatura buscarAsignatura(int id){
        for (int i = 0; i < asignaturas.size() ; i++) {
            if (asignaturas.get(i).getId() == id){
                return asignaturas.get(i);
            }
        }
        return null;
    }

    /**
     * Método para buscar un grupo
     * @param id id del grupo
     * @return grupo encontrado o null
     */
    public Grupo buscarGrupo(int id){
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == id){
                return grupos.get(i);
            }
        }
        return null;
    }

    /**
     * Método para eliminar alumnos
     * @param id id del alumno
     * @return true si se ha eliminado y false si no
     */
    public boolean eliminarAlumno(int id){
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getId() == id){
                alumnos.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Centro{" +
                "id =" + id +
                ", alumnos = " + alumnos.toString() +
                ", grupos = " + grupos.toString() +
                ", asignaturas = " + asignaturas.toString() +
                '}';
    }
}
