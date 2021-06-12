
package hilos;


public class Hilos4 extends Thread{
    private String palabra;
    
    public Hilos4(String s){
    
    this.palabra=s;
    }
public  void run(){

    for (int i = 0; i < 30; i++) {
        System.out.println(palabra);
    }

}
    public static void main(String[] args) {
        Thread h1 = new Hilos4("Hola");
        Thread h2 = new Hilos4("Hi");
        Thread h3= new Hilos4("Salut");
        h1.start();
        h2.start();
        h3.start();
        
    }

}
