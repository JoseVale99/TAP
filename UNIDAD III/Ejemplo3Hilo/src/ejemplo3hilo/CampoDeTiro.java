/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3hilo;

public class CampoDeTiro {
    
    public static void main(String[] args) {
        Pistola arma = new Pistola();
        Cargar c = new Cargar(arma, 1);
        Descargar d = new Descargar(arma, 1);
        c.start();
        d.start();
    }
}