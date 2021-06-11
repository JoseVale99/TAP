package practica_06;

public class Productor implements Runnable {
 private Pilas pila;
 private  int numProd = 0;
  private static int numPro = 0;
 public Productor (Pilas p){
 pila = p;
 numPro++;
 numProd = numPro; 
 }
    @Override
    public void run() {
        char c;
        for (int i=0;i<20;i++){
        c = (char)(Math.random()*26+65);
        pila.poner (c);
        System.out.println("Productor "+numProd+" agrego a "+c+" en hilo "+Thread.currentThread().getName());
        try {
        Thread.sleep((int)(Math.random()*777));
        }
        catch (InterruptedException e){}
        }
    }   
}
