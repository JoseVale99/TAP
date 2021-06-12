
package version_2;

public class Consumidor implements Runnable{
private Pila pila;
private static int numCons=0;

    public Consumidor(Pila p) {
    pila = p;
    numCons++;
    
    }

    @Override
    public void run() {
     char c;
        for (int i = 0; i < 20; i++) {
            c = pila.quitar();
         
                System.out.println("Hilo: " + Thread.currentThread().getName() + " Consumidor " + numCons + " :" + c);
   
            try {
                Thread.sleep((int) (Math.random() * 777));
            } catch (InterruptedException e) {
            }
        } //for
    }
}


