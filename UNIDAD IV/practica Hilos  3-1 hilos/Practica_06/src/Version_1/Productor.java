package Version_1;
public class Productor implements Runnable {
private Pilas pila;
private int numProd;

public Productor(Pilas p){
    pila=p;
    }
public void setnumProd(int nu){
numProd = nu;
}
public int getnumProd(){
return numProd;
}

    @Override
    public void run() {
        char c;
        for(int i=0;i<20;i++){
            c=(char)(Math.random()*26+65);
            pila.poner(c);
            System.out.println("  Productor "+getnumProd()+" agrego a "+c+" en el hilo "+Thread.currentThread().getName());
            try{
                Thread.sleep((int)(Math.random()*777));
            }catch(InterruptedException e){
                
            }
        }
     }
    
}
