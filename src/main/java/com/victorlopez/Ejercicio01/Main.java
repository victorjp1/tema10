package com.victorlopez.Ejercicio01;

import com.victorlopez.Lib;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Lib.llenarArrayAleatorio(nums);
        ArrayList<Integer> ordenados = paresImpares(nums);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Array list: " + ordenados.toString());
    }

    /**
     * Método para ordenar en 2 secciones, pares e impares
     * @param n array de enteros a ordenar
     * @return array list ordenada
     */
    public static ArrayList<Integer> paresImpares(int[] n){
        ArrayList<Integer> aux = new ArrayList(n.length);
        int indicePares= 0;
        int indiceImpares;
        for (int i = 0; i < n.length ; i++) {
            if (n[i] % 2 == 0){
                aux.add(indicePares, n[i]);
            }else{
                indiceImpares = aux.size();
                aux.add(indiceImpares, n[i]);
            }
        }
        return aux;
    }
}
