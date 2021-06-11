
package ModeloCoversor;

import java.util.Hashtable;


public class CoversorMonedas  {
    
    
    
    private Hashtable <String, Double>tablaconversion
            =new Hashtable<>() ;

    public CoversorMonedas() {
        insertarMoneda("pash",1.0);
        insertarMoneda("USD",0.052);
        insertarMoneda("JPY", 5.99);
        insertarMoneda("Bit", 0.00000);
    }

    private void insertarMoneda(String codigo, double Tipocambio) {
     tablaconversion.put(codigo, Tipocambio);
    }

    private double ObtenerTipoCambio(String codigoMoneda){
    
    return tablaconversion.get(codigoMoneda);
    }

    public double convertir(String DIvOrigen,String DivDestino, double importe){
       
    double pesos =importe/ObtenerTipoCambio(DIvOrigen);
    return ObtenerTipoCambio(DivDestino);
    }

   // public enumeraration<String>
    


}



