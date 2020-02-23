package com.victorlopez.Ejercicio05;

import com.victorlopez.Sexo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Centro {
    private ArrayList<Paciente> pacientes;
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public Centro() {
        this.pacientes = new ArrayList();
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < pacientes.size() ; i++) {
            aux += pacientes.get(i).toString();
        }
        return aux;
    }

    public void añadirPaciente(int id, String nombre, LocalDate fNacimiento, Sexo sexo, double altura, double peso){
        Paciente p = new Paciente(id, nombre, fNacimiento, sexo, altura, peso);
        pacientes.add(p);
    }
}
