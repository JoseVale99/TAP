
package gasolineria;


import Controlador.ControladorGasolineria;
import Modelo.ModeloGasolineria;
import Modelo.ModeloLogin;
import Vista.VistaCliente;
import Vista.VistaGas;
import Vista.VistaLogin;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;


public class Gasolineria {    
    public static void main(String[] args)   {
        VistaPrincipal vistap  = new VistaPrincipal();
        VistaLogin vistal = new VistaLogin();
        VistaRegistro vistar= new VistaRegistro();
        VistaGas vistag = new VistaGas();
        
        VistaCliente vistacliente = new VistaCliente();
       
        Modelo.ModeloGasolineria modelo = new ModeloGasolineria("gasolineria");
       ModeloLogin modelog = new ModeloLogin("gasolineria");
        
       ControladorGasolineria controlador = new ControladorGasolineria(vistap, 
               vistal, vistag, vistar, vistacliente, modelo,modelog);
        vistap.cC(controlador);
        vistal.cC(controlador);
        vistal.Ingresar(controlador);
        vistar.cC(controlador);
        vistag.cC(controlador);
        vistacliente.cC(controlador);
        
       
       
    }
}
       