
package hilos;


public class HelloRunnable implements Runnable{//extends Thread{

public void run(){
    System.err.println("hello from a troad!");
}   
//    public static void main(String[] args) {
//      (new HelloRunnable()).start();
//    }

public static void main(String[] args) {
    (new Thread(new HelloRunnable())).start();
    }
    
}
