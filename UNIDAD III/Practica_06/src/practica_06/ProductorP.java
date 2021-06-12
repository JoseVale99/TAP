package practica_06;

public class ProductorP implements Runnable {
 private Pila pila;
 private  int numProd=0;
 private static int numPro = 0;
 public ProductorP (Pila p){
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
        System.out.println("Productor "+numProd+" agrego a "+c+" en hilo "+Thread.currentThread().getName()+"-productor");
        try {
        Thread.sleep((int)(Math.random()*1000));
        }
        catch (InterruptedException e){}
        }
    }   
}
