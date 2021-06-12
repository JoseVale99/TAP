package practica_06;

public class PruebaProductorConsumidorP {
    public static void main(String[] args) {
        Pila pila = new Pila (10);
        
        ProductorP p1 = new ProductorP(pila);
        Thread prodT1 = new Thread (p1);
        prodT1.start();
        
        ProductorP p2 = new ProductorP(pila);
        Thread prodT2 = new Thread (p2);
        prodT2.start();
        
        ConsumidorP c1 = new ConsumidorP(pila);
        Thread consT1 = new Thread (c1);
        consT1.start();
        
        ConsumidorP c2 = new ConsumidorP(pila);
        Thread consT2 = new Thread (c2);
        consT2.start();  
        
        ConsumidorP c3 = new ConsumidorP(pila);
        Thread consT3 = new Thread (c3);
        consT3.start();
    }
}
