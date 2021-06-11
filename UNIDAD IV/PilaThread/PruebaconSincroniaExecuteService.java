/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * VERSION CON SINCRONIA
 *
 * @author Ramirez HErnandez OScar Alexis
 */
public class PruebaconSincroniaExecuteService {

    public static void main(String[] args) throws InterruptedException {
        Pila pila = new Pila(10);
        Productor2 p = new Productor2(pila);
        Productor2 p2 = new Productor2(pila);
        Consumidor2 c1 = new Consumidor2(pila);
        Consumidor2 c2 = new Consumidor2(pila);
        Consumidor2 c3 = new Consumidor2(pila);

        Thread prodT1 = new Thread(p);
        prodT1.setName(" HILO 1 PRODUCTOR");
        prodT1.start();
        Thread prodT2 = new Thread(p2);
        prodT2.setName(" HILO 2 PRODUCTOR");
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
         prodT1.join();
        prodT2.join();
        prodT3.join();
        prodT4.join();
        prodT5.join();
         
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ejecutor.execute(p);
        ejecutor.execute(p2);
        ejecutor.execute(c1);
        ejecutor.execute(c2);
        ejecutor.execute(c3);
        ejecutor.shutdown();
        try {
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);
            if (tareasTerminaron) {
                System.out.println("Todas las tareas Terminaron");
            } else {
                System.out.println("Se agoto el tiempo esperando a que las tareas terminaran");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            System.out.println("Hubo un error mientras se esperaba a que terminaran las tareas");
        }

    }

}
