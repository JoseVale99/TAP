/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorConversor;

import ModeloConversor.ConversorMonedas;
import VistaConversor.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class ConversorControlador implements ActionListener{
    private Ventana v;
    private ConversorMonedas modelo;
    
    public ConversorControlador(Ventana v, ConversorMonedas modelo){
    this.v=v;
    this.modelo=modelo;
    
   v.setComboDivisas(modelo.obtenerCodigoDivisa());
    
    }
    public void actionPerformed(ActionEvent e){
    //Se obtiene los valores para operar
    double importe =v.obtenerImporte();//---.-------------------------
        
    String codDivisaOrigen = v.obtenerDivisaOrigen();
        
    String codDivisaDestino =v.obtenerDivisaDestino();
   //.............................Bien
    
    //Se realiza la conversion
    double resultado = modelo.convertir(codDivisaOrigen, codDivisaDestino, importe);
        System.out.println("resultado:::  "+resultado);
    
    //Se muestra el resultado en la etiqueta resultado
    DecimalFormat df= new DecimalFormat("#,###.##");
    v.actualizarResultado(df.format(resultado).toString());
    }
    
    
}
