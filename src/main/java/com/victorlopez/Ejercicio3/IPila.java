package com.victorlopez.Ejercicio3;

public interface IPila<T> {
    T push(T t);
    T pop();
    int size();
    T top();
    boolean empty();
    String toString();
}
