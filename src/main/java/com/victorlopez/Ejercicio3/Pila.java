package com.victorlopez.Ejercicio3;

import java.util.ArrayList;

public class Pila implements IPila<String>  {
    private ArrayList<String> pila;

    public Pila() {
        this.pila = new ArrayList();
    }
    public Pila(int n) {
        this.pila = new ArrayList(n);
    }

    @Override
    public String push(String e) {
        pila.add(e);
        return e;
    }

    @Override
    public String pop() {
        if (!empty()){
            String aux = top();
            pila.remove(pila.get(size() - 1));
            return aux;
        }
        return "No hay elementos en la pila";
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
    public String top() {
        if(!empty()){
            return pila.get(size() -1);
        }
        return "No hay elementos en la pila";
    }

    @Override
    public boolean empty() {
        return pila.isEmpty();
    }
}
