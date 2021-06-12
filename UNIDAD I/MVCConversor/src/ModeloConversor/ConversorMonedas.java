/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConversor;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author josed
 */
public class ConversorMonedas {

    private Hashtable<String, Double> tablaConversion = new Hashtable<>();

    public ConversorMonedas() {
        insertarMoneda("PSM", 1.0);//Peso
        insertarMoneda("USD", 0.052);//USD
        insertarMoneda("JPY", 5.99);//Yen
        insertarMoneda("BIT", 10.4);//BitCoins
        insertarMoneda("EWR", 0.046);//BitCoins

    }

    public void insertarMoneda(String codigo, Double tipoCambio) {
        tablaConversion.put(codigo, tipoCambio);
    }

    private Double obtenerTipoDeCambio(String codigoMoneda) {
        return tablaConversion.get(codigoMoneda);

    }

    public Double convertir(String codDivOrigen, String codDivDestino, Double importe) {
       
        Double pesos = 0.0;
    
       pesos = importe /obtenerTipoDeCambio(codDivOrigen);
       
       
       
        return pesos*obtenerTipoDeCambio(codDivDestino);

    }

    public Enumeration<String> obtenerCodigoDivisa() {
    
        return tablaConversion.keys();
    }

}
