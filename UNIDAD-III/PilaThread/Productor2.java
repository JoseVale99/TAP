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
public class Productor2 implements Runnable {
private Pila pila;
private static int numProd=1;

public Productor2(Pila p){
    pila=p;
    numProd++;
}
    @Override
    public void run() {
        char c;
        for(int i=0;i<20;i++){
            c=(char)(Math.random()*26+65);
            pila.poner(c);
            System.out.println("Productor "+numProd+" agrego a "+c+" en el "+Thread.currentThread().getName());
            try{
                Thread.sleep((int)(Math.random()*77));
            }catch(InterruptedException e){
                
            }
        }
     }
    
}
