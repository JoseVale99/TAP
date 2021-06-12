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
public class PruebaSinSincronia {

    public static void main(String[] args) throws InterruptedException {
        Pilas pila = new Pilas(10);
        Productor p = new Productor(pila);
        Productor p2 = new Productor(pila);
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);

        Thread prodT1 = new Thread(p);
        prodT1.setName("HILO 1 PRODUCTOR");
        prodT1.start();
        Thread prodT2 = new Thread(p2);
        prodT2.setName("HILO 2 PRODUCTOR");
        prodT2.start();
        Thread prodT3 = new Thread(c1);
        prodT3.setName("HILO 1 CONSUMIDOR");
        prodT3.start();
        Thread prodT4 = new Thread(c2);
        prodT4.setName("HILO 2 CONSUMIDOR");
        prodT4.start();
        Thread prodT5 = new Thread(c3);
        prodT5.setName("HILO 3 CONSUMIDOR");
        prodT5.start();

    }

}
