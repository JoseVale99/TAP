package practica_06;

public class PruebaProductorConsumidor {
    public static void main(String[] args) {
        Pilas pila = new Pilas (10);
        Productor p1 = new Productor(pila);
        Thread prodT1 = new Thread (p1);
        prodT1.start();
        Productor p2 = new Productor(pila);
        Thread prodT2 = new Thread (p2);
        prodT2.start();
        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        Thread consT1 = new Thread (c1);
        Thread consT2 = new Thread (c2);
        Thread consT3 = new Thread (c3);
        consT1.start();
        consT2.start();
        consT3.start();
    }
}
