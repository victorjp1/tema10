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

}
