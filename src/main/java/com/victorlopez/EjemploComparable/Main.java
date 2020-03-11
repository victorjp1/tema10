package com.victorlopez.EjemploComparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Libro> libros;
    public static void main(String[] args) {
        libros = new ArrayList<>();
        casosPrueba();//Rellenamos casos de prueba
        System.out.println("Libros sin ordenar: ");
        System.out.println(libros.toString());//Imprimimos libros sin ordenar
        Collections.sort(libros);//Ordenamos libros por titulo
        System.out.println("Libros ordenados por título");
        System.out.println(libros.toString());//Imprimimos ordenado por título
        libros.sort(new Libro.ComparatorIsbn());//Ordenamos por ISBN
        System.out.println("Libros ordenados por ISBN");
        System.out.println(libros.toString());//Imprimimos ordenado por ISBN
        libros.sort(new Libro.ComparatorNumPaginas()); //Ordenamos por número de páginas
        System.out.println("Libros ordenador por número de páginas");
        System.out.println(libros.toString());//Imprimos ordenado por número de páginas
    }
    public static void casosPrueba(){
        Libro l1 = new Libro(320752,"Lo que la isla se llevó",500);
        Libro l2 = new Libro(12433,"Olei xe",600);
        Libro l3 = new Libro(3214,"Mel",700);
        Libro l4 = new Libro(1234123413,"De categoria",800);
        Libro l5 = new Libro(3214321,"Un cafenet sempre ve be",900);
        Libro l6 = new Libro(320732,"Libro de autoestima de raul quesada",1000);
        Libro l7 = new Libro(564333,"Merda al puto ull",1100);
        Libro l8 = new Libro(589856,"Quesda brut",1200);
        Libro l9 = new Libro(59469854,"Hola que tal",1300);
        Libro l10 = new Libro(456546,"Ola k tal",1400);
        Libro l11 = new Libro(5465464,"OLei xe siempre aktibo",1500);
        Libro l12 = new Libro(2345346,"Lo que el viente se llevó",1600);
        Libro l13 = new Libro(90753,"Tu eres un shit",1700);
        Libro l14 = new Libro(598473,"Som una shit",1800);
        Libro l15 = new Libro(1234567890,"La noche del terror",1900);
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l4);
        libros.add(l5);
        libros.add(l6);
        libros.add(l7);
        libros.add(l8);
        libros.add(l9);
        libros.add(l10);
        libros.add(l11);
        libros.add(l12);
        libros.add(l13);
        libros.add(l14);
        libros.add(l15);
    }
}
