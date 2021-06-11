package Controlador;

import Modelo.ModeloGasolineria;

import TDA.Cliente;
import TDA.Usuario;
import Vista.VistaCliente;
import Vista.VistaGas;
import Vista.VistaLogin;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

public class ControladorGasolineria implements ActionListener, FocusListener {

    private VistaPrincipal view;
    private VistaLogin vl;
    private VistaGas vg;
    private VistaRegistro vr;
    private VistaCliente vc;
    private Modelo.ModeloGasolineria modelo;
    private Modelo.ModeloLogin modelog;

    public ControladorGasolineria(VistaPrincipal view, VistaLogin vl,
            VistaGas vg, VistaRegistro vr, VistaCliente vc,
            Modelo.ModeloGasolineria modelo, Modelo.ModeloLogin modelog) {
        this.view = view;
        this.vl = vl;
        this.vg = vg;
        this.vr = vr;
        this.vc = vc;
        this.modelo = modelo;
        this.modelog = modelog;

    }

    public ControladorGasolineria(VistaPrincipal vistap, VistaLogin vistal,
            VistaRegistro vistar, VistaGas vistag, VistaCliente vistacliente,
            ModeloGasolineria modelo, Modelo.ModeloLogin modelog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String comando = arg0.getActionCommand();
        switch (comando) {
            case "VENTA":
                view.setVisible(false);
                vl.setVisible(true);
                break;
            case "REGISTRAR":
                view.setVisible(false);
                vr.setVisible(true);
                break;
            case "Regresar":
                vc.setVisible(false);
                vr.setVisible(false);
                
                view.setVisible(true);
                break;
            case "Salir":
                vg.setVisible(false);
                view.setVisible(true);
                vl.limpiar();
                break;
            case "Facturar":
                vg.setVisible(false);
                vc.setVisible(true);
                view.setVisible(false);
                vl.limpiar();
                break;
            case "Registrar":
                //vc.setVisible(true);
                //view.setVisible(false);
                Cliente cliente = new Cliente(Integer.parseInt(vc.JDNI.getText()), vc.Jnombre.getText(), vc.JApellidoP.getText() + " " + vc.JApellidoM.getText(), vc.JDireccion.getText());
                modelo.insertCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente insertado");
                break;
            case "Ingresar":
               
                Usuario l = new Usuario(vl.ingresar_user.getText(), vl.contrasenia.getText());
                if (modelog.Iniciar_Sesion(l)) {
                    vl.setVisible(false);
                    vg.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error, verifique su nombre y contraseña");
                }
                break;

        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
 vl.ingresar_user.setSelectionStart(0);
        vl.ingresar_user.setSelectionEnd(vl.ingresar_user.getText().length());
        vl.contrasenia.setSelectionStart(0);
        vl.contrasenia.setSelectionEnd(vl.contrasenia.getText().length());
    }

    @Override
    public void focusLost(FocusEvent fe) {        
    }

}
