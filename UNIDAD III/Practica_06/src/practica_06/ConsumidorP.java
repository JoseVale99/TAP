
package practica_06;

public class ConsumidorP implements Runnable {
 private final Pila pila;
 private  int numCons=0;
  private static int numCon=0;
 public ConsumidorP (Pila p){
 pila=p;
 numCon++;
 numCons=numCon;
 }
     @Override
    public void run() {
      char c;
      for (int i=0;i<20;i++){
        c = pila.quitar();
        System.out.println("Hilo: "+Thread.currentThread().getName()+"-consumidor Consumidor: "+numCons+" :"+c);
      try {
        Thread.sleep((int)(Math.random()*1000));}
       catch (InterruptedException e){}
        }
        
    }
    
    
}