package com.victorlopez.Ejercicio08;

import java.util.HashMap;
import java.util.Iterator;

public class Diccionario {
    private HashMap<String, String> diccionario;

    /**
     * Constructor de la clase diccionario
     */
    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    /**
     * Método que determina si existe la palabra en el diccionario
     * @param p palabra a buscar
     * @return boolean que determina si existe o no
     */
    public boolean existePalabra(String p){
        return diccionario.containsKey(p);
    }

    /**
     * Método para añadir palabras en el diccionario
     * @param p palabra a añadir
     * @param definicion definicion a añadir
     * @return devuelve true si se ha podido añadir y false si ya existe
     */
    public boolean añadirPalabra(String p, String definicion){
        if (diccionario.containsKey(p)){
            return false;
        }else{
            diccionario.put(p, definicion);
            return true;
        }
    }

    /**
     * Método para modificar el significado de una palabra
     * @param p palabra a modificar
     * @param definicion definicion nueva de la palabra
     * @return devuelve true si se ha modificado y false si no se encuentra en el diccionario
     */
    public boolean modificarPalabra(String p, String definicion){
        if (diccionario.containsKey(p)){
            diccionario.replace(p, definicion);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Método para eliminar una palabra
     * @param p palabra a eliminar
     * @return devuelve true si se ha eliminado y false si no existia
     */
    public boolean eliminarPalabra(String p){
        if (diccionario.containsKey(p)){
            diccionario.remove(p);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Método para consultar palabras
     * @param p palabra a consultar
     * @return definicion de la palabra o null si no existe
     */
    public String consultarPalabra(String p){
        if (diccionario.containsKey(p)){
            return diccionario.get(p);
        }else{
            return null;
        }
    }

    /**
     * Devuelve el diccionario entero
     * @return cadena creada con los elementos del diccionario
     */
    public String toString(){
        String cadena = "";
        String aux;
        Iterator<String> iter = diccionario.keySet().iterator();
        while (iter.hasNext()){
            aux = iter.next();
            cadena += aux + ": " + diccionario.get(aux) + "\n";
        }
       return cadena;
    }
}
