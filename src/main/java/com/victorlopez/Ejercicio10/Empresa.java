package com.victorlopez.Ejercicio10;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;
    public Empresa() {
        empleados = new ArrayList<>();
    }

    /**
     * Método para buscar empleados en un rango de edad
     * @param min mínima edad a tener en cuenta
     * @param max máxima edad a tener en cuenta
     * @return ArrayList de tipo Empleado con todos los empleados que coinciden con los requerimientos
     */
    public ArrayList<Empleado> buscarPorEdad(int min, int max){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        Empleado e;
        for (int i = 0; i < empleados.size() ; i++) {
            e = empleados.get(i);
            if (e.getEdad() >= min && e.getEdad() <= max){
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    /**
     * Método para obtener todos los empleados con hijos menores de edad
     * @return ArrayList de tipo empleado con todos los empleados correspondientes
     */
    public ArrayList<Empleado> buscarPorHijosMenores(){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        int edadHijo;
        boolean encontrado;
        Empleado e;
        for (int i = 0; i < empleados.size(); i++) {
            e = empleados.get(i);
            encontrado = false;
            for (int j = 0; j < e.getHijos().size(); j++) {
                edadHijo = e.getHijos().get(j).getEdad();
                if (edadHijo < 18 && !encontrado){
                    encontrados.add(e);
                    encontrado = true;
                }
            }
        }
        return encontrados;
    }

    /**
     * Método para buscar empleados por un rango de sueldo
     * @param min mínimo a valorar
     * @param max máximo a valorar
     * @return ArrayList de tipo empleado
     */
    public ArrayList<Empleado> buscarPorSueldo(double min, double max){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        Empleado e;
        for (int i = 0; i < empleados.size() ; i++) {
            e = empleados.get(i);
            if (e.getSueldo() >= min && e.getSueldo() <= max){
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    /**
     * Método para buscar empleados por cadena de caraacteres
     * @param nombre nombre o parte del nombre a buscar
     * @return ArrayList de tipo empleado con todas las coincidencias
     */
    public ArrayList<Empleado> buscarNombre(String nombre){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        String nombreAux;
        for (int i = 0; i < empleados.size(); i++) {
            nombreAux = empleados.get(i).getNombre();
            if (nombreAux.contains(nombre)){
                encontrados.add(empleados.get(i));
            }
        }
        return encontrados;
    }

    /**
     * Método para buscar por DNI
     * @param dni dni a buscar
     * @return devuelve el empleado encontrado y si no lo encuentra null
     */
    public Empleado buscarDni(String dni){
        String dniAux;
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = empleados.get(i).getDni();
            if (dniAux.equals(dni)){
                return empleados.get(i);
            }
        }
        return null;
    }

    /**
     * Método para añadir empleados
     * @param e empleado a añadir
     */
    public void addEmpleado(Empleado e){
        empleados.add(e);
    }

    /**
     * Método para borrar empleados
     * @param dni dni de empleado a borrar
     * @return true si se ha eliminado y false si no
     */
    public boolean borrarEmpleado(String dni){
        String dniAux;
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = empleados.get(i).getDni();
            if (dniAux.equals(dni)){
                empleados.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para saber si existe el empleado
     * @param dni dni a valorar
     * @return true si existe, false si no
     */
    public boolean existEmpleado(String dni){
        String dniAux;
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = empleados.get(i).getDni();
            if (dni.equals(dniAux)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para borrar hijos de empleados
     * @param dni dni a valorar
     * @param nombre nombre del hijo a valorar
     * @return devuelve true si se ha borrado y false si no
     */
    public boolean borrarHijo(String dni, String nombre){
        String dniAux;
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = empleados.get(i).getDni();
            if (dni.equals(dniAux)){
                ArrayList<Hijo> hijos = empleados.get(i).getHijos();
                for (int j = 0; j < hijos.size(); j++) {
                    if (hijos.get(j).getNombre().equals(nombre)){
                        hijos.remove(j);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < empleados.size() ; i++) {
            aux += empleados.get(i).toString() + "\n";
        }
        return aux;
    }
}
