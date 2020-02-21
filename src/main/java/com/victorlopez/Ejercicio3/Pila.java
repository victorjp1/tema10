package com.victorlopez.Ejercicio3;

import java.util.ArrayList;

public class Pila<T> implements IPila<T>  {
    private ArrayList<T> pila;

    public Pila() {
        this.pila = new ArrayList();
    }
    public Pila(int n) {
        this.pila = new ArrayList(n);
    }

    @Override
    public T push(T e) {
        pila.add(e);
        return e;
    }

    @Override
    public T pop() {
        if (!empty()){
            T aux = top();
            pila.remove(pila.get(size() - 1));
            return aux;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pila{" +
                "pila=" + pila.toString() +
                '}';
    }

    @Override
    public int size() {
        return pila.size();
    }

    @Override
    public T top() {
        if(!empty()){
            return pila.get(size() -1);
        }
        return null;
    }

    @Override
    public boolean empty() {
        return pila.isEmpty();
    }
}
