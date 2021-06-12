
package hilos;


public class Hilo5 extends Thread{
    
private String palabra;
    
    public Hilo5(String nombre,String s){
   super(nombre);
    this.palabra=s;
    }
public  void run(){
synchronized(getClass()){
    for (int i = 0; i < 30; i++) {
        System.out.println(palabra+i);
    
    try{
    Thread.sleep(3000);
    }catch(java.lang.InterruptedException e){
    }
    
    }
}
}
    public static void main(String[] args) {
        Thread h1 = new Hilo5("h1","Hola");
        Thread h2 = new Hilo5("h2","Hi");
        Thread h3= new Hilo5("h3","Salut");
        h3.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        h2.start();
        h3.start();
        
    }
}
