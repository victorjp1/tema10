package com.victorlopez.Ejercicio05;

import java.time.LocalDate;
import java.util.ArrayList;

public class Centro {
    private ArrayList<Paciente> pacientes;
    private int id;

    public Centro() {
        this.pacientes = new ArrayList();
        id = 1;
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Método para saber la posicion en el array de los pacientes más pequeños y mayores
     * @return devolvemos un array de 2  posiciones, la primera con la posicion del paciente menor y la segunda con el paciente mayor
     */
    public int[] mayorMenor(){
        int mayor = 0;
        int menor = Integer.MAX_VALUE;
        int[] mayorMenor = new int[2];
        for (int i = 0; i < pacientes.size() ; i++) {
            if (mayor < pacientes.get(i).getEdad()){
                mayor = pacientes.get(i).getEdad();
                mayorMenor[1] = i;
            }
            if (menor > pacientes.get(i).getEdad()){
                menor = pacientes.get(i).getEdad();
                mayorMenor[0] = i;
            }
        }
        return mayorMenor;
    }

    /**
     * Método para buscar un paciente por id
     * @param id id a buscar
     * @return devolvemos el paciente encontrado, sino devolverá null.
     */
    public Paciente buscarPorId(int id){
        for (int i = 0; i < pacientes.size() ; i++) {
            Paciente p = pacientes.get(i);
            if (p.getId() == id){
                return pacientes.get(i);
            }
        }
        return null;
    }

    /**
     * Método para eliminar pacientes de la lista
     * @param id id de paciente a eliminar
     * @return devolvemos un entero, 1 si ha ido bien la operación y -1 si no se ha encontrado el alumno
     */
    public int eliminarPaciente(int id){
        for (int i = 0; i < pacientes.size() ; i++) {
            Paciente p = pacientes.get(i);
            if (p.getId() == id){
                pacientes.remove(i);
                return 1;
            }
        }
        return -1;
    }
    /**
     * Método para mostrar todos los pacientes
     * @return devolvemos un String con todos los pacientes
     */
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < pacientes.size() ; i++) {
            aux += pacientes.get(i).toString();
        }
        return aux;
    }

    /**
     * Método para calcular el número de hombres y el número de mujeres entre todos los pacientes
     * @param pacientes array lyst a valorar
     * @return devolvemos un arrray, la primera posición contiene el número de hombres y la segunda de mujeres
     */
    public static int[] pacientesPorSexo(ArrayList<Paciente> pacientes){
        int[] sexos = new int[2];
        for (int i = 0; i < pacientes.size() ; i++) {
            if (pacientes.get(i).getSexo() == Sexo.F){
                sexos[1]++;
            }else{
                sexos[0]++;
            }
        }
        return sexos;
    }

    /**
     * Método para añadir un paciente
     * @param nombre nombre del paciente
     * @param fNacimiento fecha de nacimiento en formato dd/mm/aaaa
     * @param sexo sexo del paciente
     * @param altura altura del paciente en metros
     * @param peso peso en kg del paciente
     */
    public void añadirPaciente(String nombre, LocalDate fNacimiento, Sexo sexo, double altura, double peso){
        Paciente p = new Paciente(id, nombre, fNacimiento, sexo, altura, peso);
        pacientes.add(p);
        id++;
    }

    /**
     * Método para calcular cual es el mensaje de ICM
     * @param id id de paciente a valorar
     * @return devolvemos un enumerado con los tipos de sobrepeso
     */
    public IMCMensaje ICM(int id){
        for (int i = 0; i < pacientes.size() ; i++) {
            if (pacientes.get(i).getId() == id){
                double IMC = Paciente.valorarPeso(pacientes.get(i));
                if (IMC < 18.5){
                    return IMCMensaje.INSUFICIENTE;
                }else if(IMC < 25){
                    return IMCMensaje.NORMAL.NORMAL;
                }else if (IMC < 27){
                    return IMCMensaje.GRADO1;
                }else if (IMC < 27){
                    return IMCMensaje.NORMAL.GRADO2;
                }else{
                    return IMCMensaje.GRADO3;
                }
            }
        }
        return IMCMensaje.ERROR;
    }
}
