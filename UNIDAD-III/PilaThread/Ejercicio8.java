/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilaThread;

/**
 *
 * @author Bayer
 */
public class Ejercicio8 extends Thread {

    private String nombre;

    public Ejercicio8(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        for (int a = 1; a <= 3; a++) {
            System.out.println(nombre + " come un " + a + "° pan con queso");
        }
        System.out.printf("%s terminó\n", nombre);
    }

    public static void main(String[] args) {
        String[] nombres = {"Papa pitufo", "pitufina", "Filósofo", "pintor", "Gruñón", "bromista",
            "dormilón", "tímido", "tontín", "bonachón", "romantico"};
        for (String nomb : nombres) {
            Ejercicio8 e = new Ejercicio8(nomb);
            Thread t = new Thread(e);
            t.start();
        }
    }
}
