package practica_06;

public class Pila {
 private int tope;
 private char [] datos;
 public Pila (int nd){
 datos = new char [nd];
 tope=-1;
 }
 public boolean llena (){
 return tope == datos.length-1;
 }
 public boolean vacia (){
 return tope<0;
 }
 public synchronized void poner  (char c){
 if (llena())
      System.out.println("Pila llena, intento colocar "+Thread.currentThread().getName()+"-productor");
 while (llena ()) 
     try{
     this.wait();}
     catch (InterruptedException e){}
     tope++;
     datos [tope]=c;
     this .notify();
    
 }
 public synchronized char quitar (){
 char d=' ';
 if (vacia ())
     System.out.println("Pila vacia , en espera el hilo "+Thread.currentThread().getName()+"-consumidor");
 while  (vacia ())
     try{
     this.wait();}
     catch (InterruptedException e){}
     d = datos [tope];
     tope--;
     this.notify();
     return d;
 }
 public char ver (){
 if (!vacia())
     return datos[tope];
     return ' ';
 }
}
