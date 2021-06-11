
package version_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PruebaconSincroniaExecuteService {

    public static void main(String[] args) throws InterruptedException {
        Pila pila = new Pila(10);
        Productor p1 = new Productor(pila);
         p1.setnumProd(1);
        Productor p2 = new Productor(pila);
         p2.setnumProd(2);
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);

        Thread prodT1 = new Thread(p1);
        prodT1.setName(" Hilo_1-productor");
        prodT1.start();
        Thread prodT2 = new Thread(p2);
        prodT2.setName(" Hilo_2-productor");
        prodT2.start();
        Thread prodT3 = new Thread(c1);
        prodT3.setName(" Hilo_1-consumidor");
        prodT3.start();
        Thread prodT4 = new Thread(c2);
        prodT4.setName(" Hilo_2-consumidor");
        prodT4.start();
        Thread prodT5 = new Thread(c3);
        prodT5.setName(" Hilo_3-consumidor");
        prodT5.start();
       
        ExecutorService ejecutor = Executors.newCachedThreadPool();
        ejecutor.execute(p1);
        ejecutor.execute(p2);
        ejecutor.execute(c2);
        ejecutor.execute(c3);
        ejecutor.execute(c1);
        ejecutor.shutdown();
        try {
            boolean tareasTerminaron = ejecutor.awaitTermination(1, TimeUnit.MINUTES);
        if (tareasTerminaron)
            System.out.println("Todas las tareas terminaron");
        else {
            System.out.println("Se agoto el tiempo esperando a que las tareas termianran.");
            System.exit(1);
        }
        }
        catch (InterruptedException ex){
        System.out.println("Hubo una interrupcion minetras esperaba a que terminaran las tareas");}
    }
    
}
