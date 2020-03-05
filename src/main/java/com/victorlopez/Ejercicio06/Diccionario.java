package com.victorlopez.Ejercicio06;

import java.util.HashMap;

public class Diccionario {
    HashMap<String, String> diccionario;

    /**
     * Constructor de la clase diccionario
     */
    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    /**
     * Método para traducir una palabra de inglés a español
     * @param p
     * @return
     */
    public String traducir (String p){
       return diccionario.get(p);
    }
    public void introducirParejas(String key, String value){
        diccionario.put(key, value);
    }
    public String eliminarPalabra(String p){
        return diccionario.remove(p);

    }
}
