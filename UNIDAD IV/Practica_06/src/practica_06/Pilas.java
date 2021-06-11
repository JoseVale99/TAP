package practica_06;

public class Pilas {
    private int tope;
    private char [] datos;
    public Pilas (int nd){
    datos = new char [nd];
    tope =-1;
    }
    public boolean llena (){
    return tope== datos.length-1;
    }
    public boolean vacia (){
    return tope<0;
    }
    public void poner  (char c){
    if (llena()){
    System.out.println("Pila llena, intento colocar "+Thread.currentThread().getName());
     }
    else{
    tope++;
    datos [tope]=c;
     } 
    }
    public char quitar (){
    char d=' ';
    if (vacia()){
    System.out.println("Pila vacia, intento retirar "+Thread.currentThread().getName());
    } 
    else {
    d = datos[tope];
    tope--;
    }
    return d;
    }
    public char ver (){
    if (!vacia())
    return datos[tope];
    return ' ';
    }   
}
