/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaConversor;

import ControladorConversor.ConversorControlador;
import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author USUARIO
 */
public class Ventana extends JFrame {

    private JPanel panel;
    private JTextField txtImports;
    private JButton btn;
    private JComboBox<String> comboDivD;
    private JComboBox<String> comboDivO;
    private JLabel lblResultado;
    private JLabel importe;
    private JLabel convertir;

    public Ventana() {
        setTitle(" Conversor de monedas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        initComponents();
    }

    public void initComponents() {
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(new FlowLayout());

        importe = new JLabel("Introduce el importe");
        importe.setFont(new Font("Calibri", Font.BOLD, 12));
        panel.add(importe);

        txtImports = new JTextField();
        panel.add(txtImports);
        txtImports.setColumns(10);

        comboDivO = new JComboBox<String>();
        panel.add(comboDivO);

        convertir = new JLabel("Convertir a: ");
        convertir.setFont(new Font("Calibri", Font.BOLD, 12));
        panel.add(convertir);

        comboDivD = new JComboBox<String>();
        panel.add(comboDivD);

        btn = new JButton("Convertir");
        btn.setFont(new Font("Calibri", Font.BOLD, 12));
        panel.add(btn);

        JSeparator separator = new JSeparator();
        panel.add(separator);

        lblResultado = new JLabel("Convertir a: ");
        lblResultado.setFont(new Font("Calibri", Font.BOLD, 12));
        panel.add(lblResultado);

    }

    public void arrancar() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pack();
                    setVisible(true);
                    setLocationRelativeTo(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    public Double obtenerImporte() {
        try {

            return Double.valueOf(String.valueOf(txtImports.getText()));

        } catch (Exception e) {

            return 0.0D;
        }

    }

    public String obtenerDivisaOrigen() {
        return comboDivO.getSelectedItem().toString();
    }

    public String obtenerDivisaDestino() {
        return comboDivD.getSelectedItem().toString();
    }

    public void actualizarResultado(String importe) {
        //System.out.println("resultado final !" + importe);
        lblResultado.setText(String.valueOf(obtenerImporte() + " " + obtenerDivisaOrigen() + " "
                + " = " + importe + " " + obtenerDivisaDestino()));
    }

    public void setComboDivisas(Enumeration<String> codigoMonedas) {
        String elemento;
        while (codigoMonedas.hasMoreElements()) {
            elemento = codigoMonedas.nextElement();
            comboDivO.addItem(elemento);
            comboDivD.addItem(elemento);
            System.out.println("elemento: " + elemento);

        }
    }

    public void conectarControlador(ConversorControlador controlador) {
        btn.addActionListener(controlador);
    }

}
