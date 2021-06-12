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
public class Consumidor2 implements Runnable {

    private Pila pila;
    private static int numCons = 0;

    public Consumidor2(Pila p) {
        pila = p;
        numCons++;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < 20; i++) {
            c = pila.quitar();
            if (Character.isAlphabetic(c)) {
                System.out.println("Hilo " + Thread.currentThread().getName() + " Consumidor " + numCons + " :" + c);
            }
            try {
                Thread.sleep((int) (Math.random() * 777));
            } catch (InterruptedException e) {

            }
        }

    }

}
