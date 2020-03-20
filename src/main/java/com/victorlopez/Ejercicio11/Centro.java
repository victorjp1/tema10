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

    public void addAula(int id, double m2){
        aulas.add(new Aula(id, m2));
    }
    public ArrayList<Alumno> alumnosPorGrupo(Grupo g){
        ArrayList<Alumno> resultado = new ArrayList<>();
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getGrupo() == g){
                resultado.add(alumnos.get(i));
            }
        }
        return resultado;
    }
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
    public boolean removeAula(int id){
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getId() == id){
                aulas.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean removeGrupo(int id){
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == id){
                grupos.remove(i);
                return true;
            }
        }
        return false;
    }
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
    public void addAlumno(String nombre, Grupo grupo, ArrayList<Asignatura> asignaturas){
        alumnos.add(new Alumno(nombre, grupo, asignaturas));
    }
    public Profesor buscarProfesor(String dni){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                return profesores.get(i);
            }
        }
        return null;
    }
    public void addProfesor(String dni, String nombre, double sueldo){
        profesores.add(new Profesor(dni, nombre, sueldo));
    }
    public void addAsignatura(int id, String nombre, Profesor p){
        asignaturas.add(new Asignatura(id, nombre, p));
    }
    public boolean removeAsignatura(int id){
        for (int i = 0; i < asignaturas.size(); i++) {
            if (asignaturas.get(i).getId() == id){
                asignaturas.remove(i);
                return true;
            }
        }
        return false;
    }
    public String asignaturasToString(){
        String aux = "";
        for (int i = 0; i < asignaturas.size(); i++) {
            aux += asignaturas.get(i).toString() + "\n";
        }
        return aux;
    }
    public String aulasToString(){
        String aux = "";
        for (int i = 0; i < aulas.size(); i++) {
            aux += aulas.get(i).toString() + "\n";
        }
        return aux;
    }
    public String profesorestoString(){
        String aux = "";
        for (int i = 0; i < profesores.size(); i++) {
            aux += profesores.get(i).toString() + "\n";
        }
        return aux;
    }
    public String gruposToString(){
        String aux = "";
        for (int i = 0; i < grupos.size(); i++) {
            aux += grupos.get(i).toString() + "\n";
        }
        return aux;
    }

    public String alumnosToString(){
        String aux = "";
        for (int i = 0; i < alumnos.size(); i++) {
            aux += alumnos.get(i).toString() + "\n";
        }
        return aux;
    }
    public boolean removeProfesor(String dni){
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)){
                profesores.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean existGrupo(int id){
        for (int i = 0; i < grupos.size() ; i++) {
            if (grupos.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean existAsignatura(int id){
        for (int i = 0; i < asignaturas.size() ; i++) {
            if (asignaturas.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public Asignatura buscarAsignatura(int id){
        for (int i = 0; i < asignaturas.size() ; i++) {
            if (asignaturas.get(i).getId() == id){
                return asignaturas.get(i);
            }
        }
        return null;
    }
    public Grupo buscarGrupo(int id){
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == id){
                return grupos.get(i);
            }
        }
        return null;
    }
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
