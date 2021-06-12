
package ejemplo3hilo;

public class Descargar extends Thread{
    private Pistola arma;
    private int cartucho;
    
    public Descargar(Pistola arma, int cartucho){
        this.arma = arma;
        this.cartucho = cartucho;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            arma.disparar(i);
            System.out.println("Descargara # " + this.cartucho + " bala: " + i);
        }
    }
}