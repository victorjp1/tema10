package com.victorlopez.Ejercicio3;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Pila<String> pila= new Pila(5);
        System.out.println(pila.top());
        System.out.println(pila.pop());
        pila.push("hola");
        pila.push("Que tal");
        pila.push("Como estas");
        pila.push("xD");
        System.out.println(pila.top());
        System.out.println(pila.toString());
        System.out.println(pila.size());
        System.out.println(pila.pop());
        System.out.println(pila.size());
        System.out.println(pila.toString());
    }
}
