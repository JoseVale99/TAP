
package version_2;

public class PruebaconSincronia {
    
    public static void main(String[] args) throws InterruptedException {
        Pila pila = new Pila(10);
        Productor p1 = new Productor(pila);
        Productor p2 = new Productor(pila);
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
      
    }
}
