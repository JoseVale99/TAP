package practica_06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PruebaProductorConsumidorES {
    public static void main(String[] args) {
        Pila pila = new Pila (10);
        ProductorP p1 = new ProductorP(pila);
        ProductorP p2 = new ProductorP(pila);
        ConsumidorP c1 = new ConsumidorP(pila);
        ConsumidorP c2 = new ConsumidorP(pila);
        ConsumidorP c3 = new ConsumidorP(pila);
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
