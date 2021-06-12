
package PruebaVotacion;

import ModeloControlador.Controlador;
import ModeloVista.Vista;
import ModeloVotacion.Modelo;



public class Pruebas {
    


    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista  vista = new Vista();
        Controlador  controlador = new Controlador(vista,modelo);
        
        vista.conectarControlador(controlador);
        vista.arrancar();   
    }


}
