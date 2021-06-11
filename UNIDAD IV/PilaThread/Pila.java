/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilaThread;

/**
 *
 * @author Bayer
 */
public class Pila {

    private int tope;
    private char[] datos;

    public Pila(int nd) {
        datos = new char[nd];
        tope = -1;
    }

    public boolean estaLlena() {
        return tope == datos.length - 1;
    }

    public boolean estaVacia() {
        return tope < 0;
    }

    public void poner(char c) {
        if (estaLlena()) {
            System.out.println("Pila llena, intento colocar " + Thread.currentThread().getName());
        }
        while (estaLlena()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
            tope++;
            c = datos[tope];
            this.notify();
        }
    }

    public synchronized char quitar() {
        char d = ' ';
        if (estaVacia()) {
            System.out.println("Pila Vacia en espera " + Thread.currentThread().getName());
        }
        while (estaVacia()) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
            d = datos[tope];
            tope--;
            this.notify();
        }
        return d;
    }

    public char ver() {
        if (!estaVacia()) {
            return datos[tope];
        }
        return ' ';
    }

}
