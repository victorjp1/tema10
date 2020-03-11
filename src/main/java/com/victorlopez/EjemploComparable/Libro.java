package com.victorlopez.EjemploComparable;

import java.util.Comparator;

public class Libro implements Comparable<Libro>{
    private int isbn;
    private String titulo;
    private int nPaginas;

    /**
     * Constructor de la clase libro
     * @param isbn isbn del libro
     * @param titulo titulo del libro
     * @param nPaginas número de páginas del libro
     */
    public Libro(int isbn, String titulo, int nPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.nPaginas = nPaginas;
    }

    /**
     * Método toString para libro
     * @return String generado de libro
     */
    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", nPaginas=" + nPaginas +
                '}' + "\n";
    }

    /**
     * Método que devuelve el ISBN
     * @return devuelve SIBN
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Método para obtener el título del libro
     * @return titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    /**
     * Método para comparar sobre el título del ibro
     * @param l1 libro a comparar
     * @return libro que ha ganado
     */
    @Override
    public int compareTo(Libro l1) {
        return this.getTitulo().compareTo(l1.getTitulo());
    }

    /**
     * Clase comparator para comparar libros por isbn
     */
    public static class ComparatorIsbn implements Comparator<Libro> {
        /**
         * Método compare de libro
         * @param l1 libro 1 a comparar
         * @param l2 libro 2 a comparar
         * @return libro con isbn menor
         */
        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getIsbn() - l2.getIsbn();
        }
    }

    /**
     * Clase para comparar números por número de páginas
     */
    public static class ComparatorNumPaginas implements Comparator<Libro> {
        /**
         * Método para comparar libros por número de páginax
         * @param l1 libro 1 a comparar
         * @param l2 libro 2 para comparar
         * @return devuelve que libro tiene menos páginas
         */
        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getnPaginas() - l2.getnPaginas();
        }
    }

}
