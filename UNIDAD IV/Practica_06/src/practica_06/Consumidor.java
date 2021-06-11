package practica_06;

public class Consumidor implements Runnable {
 private final Pilas pila;
 private  int numCons=0;
 private static int numCon=0;
 public Consumidor (Pilas p){
 pila=p;
 numCon++;
 numCons=numCon;
 }
    @Override
    public void run() {
      char c;
      for (int i=0;i<20;i++){
        c = pila.quitar();
        if (Character.isAlphabetic(c))
        System.out.println("Hilo: "+Thread.currentThread().getName()+" Consumidor: "+numCons+" :"+c);
      try {
        Thread.sleep((int)(Math.random()*777));}
       catch (InterruptedException e){}
        }
        
    }
    
    
}