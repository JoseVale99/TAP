
package ControladorCoversor;

import ModeloCoversor.CoversorMonedas;
import VistaConversor.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorControlador implements ActionListener{

  private Vista vista;
  private CoversorMonedas modelo;

    public ConversorControlador(Vista v, CoversorMonedas m) {
    this.vista=v;
    this.modelo=m;
    vista.SetComboDivisar(modelo.convertir(DIvOrigen, DivDestino, 0));
    }
    
  
  
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
    }
 
    
    
    
}
