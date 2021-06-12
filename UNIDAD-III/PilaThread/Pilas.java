
package PilaThread;

/**
 *
 * @author Bayer
 */
public class Pilas {

    private int tope;
    private char[] datos;

    public Pilas(int nd) {
        datos = new char[nd];
        tope = -1;
    }

    public boolean estaLlena() {
        return tope == datos.length - 1;
    }

    public boolean estaVacia() {
        return tope < 0;
    }

    public void poner(char c) {
        if (estaLlena()) {
            System.out.println("Pila llena, intento colocar " + Thread.currentThread().getName());
        } else {
            tope++;
            datos[tope] = c;
        }
    }

    public char quitar() {
        char d = ' ';
        if (estaVacia()) {
            System.out.println("Pila Vacia Intento retirar " + Thread.currentThread().getName());
        } else {
            d = datos[tope];
            tope--;
        }
        return d;
    }

    public char ver() {
        if (!estaVacia()) {
            return datos[tope];
        }
        return ' ';
    }
}
