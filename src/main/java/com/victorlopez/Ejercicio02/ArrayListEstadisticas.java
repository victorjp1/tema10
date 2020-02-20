package com.victorlopez.Ejercicio02;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas{
    /**
     * Método que obtiene el mínimo de un array List de numeros reales
     * @return devuelve el mínimo del array list
     */
    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < size(); i++) {
            if (get(i) < min){
                min = get(i);
            }
        }
        return min;
    }

    /**
     * Método que obtiene el máximo de un array llist de numeros reales
     * @return devuelve el máximo
     */
    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < size(); i++) {
            if (get(i) > max){
                max = get(i);
            }
        }
        return max;
    }

    /**
     * Método que hace el sumatorio de todos los elementos del array list
     * @return
     */
    @Override
    public double sumatorio() {
        double acumulador = 0;
        for (int i = 0; i < size(); i++) {
            acumulador += get(i);
        }
        return acumulador;
    }

    /**
     * Método que calcula la media de todos los elementos del array list
     * @return devuelve la media
     */
    @Override
    public double media() {
        return sumatorio() / size();

    }
    /**
     * Método que devuelve el valor que más se repite en el array list con HashMap
     * @return devuelve el valor que más se ha repetido
     */
    public double modaHashMap(){
        double num = 0;
        int repeticiones;
        int maxRep = 0;
        HashMap<Double, Integer> numeros = new HashMap();
        for (int i = 0; i < size(); i++) {
            if (numeros.containsKey(get(i))){
                repeticiones = numeros.get(get(i)) + 1;
                numeros.replace(get(i),repeticiones);
                if (repeticiones > maxRep){
                    maxRep = repeticiones;
                    num = get(i);
                }
            }else{
                numeros.put(get(i), 1);
            }
        }
        return num;
    }
    /**
     * Método que devuelve el valor que más se repite en el array list manualmente
     * @return devuelve el valor que más se ha repetido
     */
    @Override
    public double moda() {
        int contador = 0;
        int contadorAux;
        double num = 0;
        double elemento;
        for (int i = 0; i < size() ; i++) {
            contadorAux = 0;
            elemento = get(i);
            for (int j = 0; j < size() ; j++) {
                if (elemento == get(j)){
                    contadorAux++;
                }
            }
            if (contador < contadorAux){
                num = elemento;
                contador = contadorAux;
            }
        }
        return num;
    }
}
