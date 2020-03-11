package com.victorlopez.Ejercicio10;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados;
    public Empresa() {
        empleados = new ArrayList<>();
    }
    public Empleado buscarDni(int dni){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni() == dni){
                return empleados.get(i);
            }
        }
        return null;
    }
    public void addEmpleado(Empleado e){
        empleados.add(e);
    }
    public boolean borrarEmpleado(int dni){
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni() == dni){
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
