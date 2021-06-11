
package ejemplo3hilo;

public class Pistola {
    private int cartucho;
    private boolean enPosicion = true;
    
    public synchronized void disparar(int cartucho){
        while(!enPosicion){
            try {
                // esperar a apuntar
                wait();
            } catch (InterruptedException e) {
            }
        }
        enPosicion = false;
        notifyAll();
    }
    
    public synchronized void apuntar(){
        while (enPosicion) {            
            try {
                // esperar a disparar
                wait();
            } catch (InterruptedException e) {
            }
        }
        enPosicion = true;
        notifyAll();
    }
}