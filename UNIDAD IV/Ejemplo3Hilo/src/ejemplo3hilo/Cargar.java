/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3hilo;

public class Cargar extends Thread{
    private Pistola arma;
    private int cartucho;
    
    public Cargar(Pistola arma, int cartucho){
        this.arma = arma;
        this.cartucho = cartucho;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            arma.apuntar();
            System.out.println("Apuntar #" + this.cartucho + "bala: " + i);
        }
    }
}