package Version_1;
public class PruebaproductorConsumidor {

    public static void main(String[] args) {
        Pilas pila = new Pilas(10);

        Productor p1 = new Productor(pila);
        p1.setnumProd(1);
        Thread prodT1 = new Thread(p1);
        prodT1.start();
        
        Productor p2 = new Productor(pila);
        p2.setnumProd(2);
        Thread prodT2 = new Thread(p2);
        prodT2.start();

        Consumidor c1 = new Consumidor(pila);
        Consumidor c2 = new Consumidor(pila);
        Consumidor c3 = new Consumidor(pila);
        Thread c_1 = new Thread(c1);
        Thread c_2 = new Thread(c2);
        Thread c_3 = new Thread(c3);
        
        c_1.start();
        c_2.start();
        c_3.start();

    }
}
