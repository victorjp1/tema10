package com.victorlopez.Ejercicio3;

public interface IPila<String> {
    String push(String e);
    String pop();
    int size();
    String top();
    boolean empty();
}
