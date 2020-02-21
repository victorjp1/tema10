package com.victorlopez.Ejercicio4;


public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola= new Cola();
        System.out.println(cola.peek());
        cola.add(1);
        cola.add(2);
        System.out.println(cola.remove());
        System.out.println(cola.toString());
        cola.add(3);
        cola.add(4);
        System.out.println(cola.peek());
        System.out.println(cola.toString());
    }
}
