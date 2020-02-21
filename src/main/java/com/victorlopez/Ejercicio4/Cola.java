package com.victorlopez.Ejercicio4;

import java.util.ArrayList;

public class Cola<T> implements ICola<T> {
    private ArrayList<T> cola;
    private final int INICIO = 0;

    /**
     * Constructor de la classe cola
     */
    public Cola() {
        this.cola = new ArrayList<T>();
    }
    /**
     * Constructor de la classe cola con capacidad inicial
     */
    public Cola(int n) {
        this.cola = new ArrayList<T>(n);
    }

    /**
     * Método que convierte a String el Array List de la pila
     * @return devuelve un String
     */
    @Override
    public String toString() {
        return
                "Cola=" + cola.toString() + '}';
    }

    /**
     * Método para añadir un número a la cola
     * @param e elemento a añadir
     */
    @Override
    public void add(T e) {
        cola.add(e);
    }

    /**
     * Método que elimina el primer elemento de la cola
     * @return devuelve el valor eliminado
     */
    @Override
    public T remove() {
        if (!isEmpty()){
            T aux = cola.get(0);
            cola.remove(INICIO);
            return aux;
        }
        return null;
    }

    /*
     * Método para saber el número de elementos de la cola
     * @return devuelve el numero de elementos de la cola
     */
    @Override
    public int size() {
        return cola.size();
    }

    /**
     * Método que devuelve al primer elemento de la cola
     * @return primer elemento de la cola
     */
    @Override
    public T peek() {
        if (!isEmpty()){
            return cola.get(INICIO);
        }
        return null;
    }

    /**
     * Método para saber si la cola esta vacia o no
     * @return devuelve true si está vacia y false si contiene elementos
     */
    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }
}
