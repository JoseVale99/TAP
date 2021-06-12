package VistaConversor;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import sun.applet.Main;

public class Vista extends JFrame {

    private JPanel contenedor;
    private JTextField tf1;
    private JButton btnConvertir;
    private JComboBox<String> obDivo;
    private JComboBox<String> obDivD;
    private JLabel lblresultado;
    private JLabel lblImporte;
    private JLabel lblConertir;

    public Vista() {
        setTitle("CONVERSOR DE NEDIDAS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contenedor = new JPanel();
        contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenedor);
        contenedor.setLayout(new FlowLayout());

        lblImporte = new JLabel("introduce Importe");
        lblImporte.setFont(new Font("Colibri", Font.BOLD, 12));
        contenedor.add(lblImporte);

        tf1 = new JFormattedTextField();
        contenedor.add(tf1);
        tf1.setColumns(10);

        obDivo = new JComboBox<String>();
        contenedor.add(obDivo);

        lblConertir = new JLabel("Convertir a : ");
        lblConertir.setFont(new Font("Colibri", Font.BOLD, 12));
        contenedor.add(lblConertir);

        obDivD = new JComboBox<String>();
        contenedor.add(obDivD);

        btnConvertir = new JButton("Covertir");
        btnConvertir.setFont(new Font("Colibri", Font.BOLD, 12));
        contenedor.add(btnConvertir);

        JSeparator separador = new JSeparator();
        contenedor.add(separador);

        lblresultado = new JLabel("Convertir a : ");
        lblresultado.setFont(new Font("Colibri", Font.BOLD, 12));
        contenedor.add(lblresultado);

            
    }
    public void arrancar(){
    
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
           try{
            pack();
            setVisible(true);
            setLocationRelativeTo(null);
            
        }catch(Exception e){
            e.printStackTrace();
        }
            }
        });
    }
    
    
    public Double ObtenerImporte(){
    
        try {
            return Double.valueOf(tf1.getText());
        } catch (Exception e) {
        return 0.0D;
        }
    }
    
    
    public String ObtenerDivisaOrigen(){
    
        return obDivo.getSelectedItem().toString();
    
    }
    
        public String ObtenerDivisaDestino(){
    
        return obDivD.getSelectedItem().toString();
    
    }
        public void AcualizarResultados(){
        
         lblresultado.setText(String.valueOf(ObtenerImporte())+""*ObtenerDivisorDestino());
        }
        
        public void SetComboDivisar(Enumeration<String> codigomonedas){
        String elemento;
        while(codigomonedas.hasMoreElements()){
        elemento=codigomonedas.nextElement();
        obDivD.addItem(elemento);
        obDivo.addItem(elemento);
        }
        
        }
}
