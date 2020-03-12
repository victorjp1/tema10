package com.victorlopez.Ejercicio10;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;
    public Empresa() {
        empleados = new ArrayList<>();
    }
    public Empleado buscarDni(String dniS){
        int dni = calcularDni(dniS);
        int dniAux;
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = calcularDni(empleados.get(i).getDni());
            if (dniAux == dni){
                return empleados.get(i);
            }
        }
        return null;
    }
    private int calcularDni(String n){
        String aux = "";
        for (int i = 0; i < n.length() -1 ; i++) {
            aux += n.charAt(i);
        }
        return Integer.parseInt(aux);
    }
    public void addEmpleado(Empleado e){
        empleados.add(e);
    }

    public boolean borrarEmpleado(String dniString){
        int dniAux;
        int dni = calcularDni(dniString);
        for (int i = 0; i < empleados.size(); i++) {
            dniAux = calcularDni(empleados.get(i).getDni());
            if (dniAux == dni){
                empleados.remove(i);
                return true;
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
