/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcconversor;

import ControladorConversor.ConversorControlador;
import ModeloConversor.ConversorMonedas;
import VistaConversor.Ventana;


public class MVCConversor {

    public static void main(String[] args) {
        // TODO code application logic here
        ConversorMonedas modelo= new ConversorMonedas();
        Ventana vista= new Ventana();
        ConversorControlador controlador= new ConversorControlador(vista,modelo);
        
        vista.conectarControlador(controlador);
        vista.arrancar();
    }
    
}
