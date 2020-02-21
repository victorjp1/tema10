package com.victorlopez.Ejercicio4;

public interface ICola <T>{
    void add(T e);
    T remove();
    int size();
    T peek();
    boolean isEmpty();
}
