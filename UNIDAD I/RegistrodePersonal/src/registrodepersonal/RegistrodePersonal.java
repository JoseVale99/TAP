package registrodepersonal;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class RegistrodePersonal extends JFrame {

    private JLabel imagen,apellidos,nombre,sexo;
    private JTextField cuadroDeTexto;
    private JButton botonAceptar, botonCancelar;
    private Container panel;
    private JPanel imgpanel, datos;

    public RegistrodePersonal() {
        super("Registro de Personal");
        setLayout(new GridLayout(2, 1));

        imgpanel = new JPanel();
        datos = new JPanel();

        this.imagen = new JLabel();
        this.imagen.setIcon(new ImageIcon("img/usuario.png"));
        this.apellidos= new JLabel("Apellidos");
        this.nombre= new JLabel("Nombre");
        this.imgpanel.setLayout(new GridLayout(1,2));
        this.datos.setLayout(new FlowLayout(FlowLayout.TRAILING));
        
            this.imgpanel.add(imagen);
            this.imgpanel.add(apellidos);
           this.imgpanel.add(nombre);
            add(imgpanel);
            // add(datos);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
         
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        RegistrodePersonal registro = new RegistrodePersonal();

    }

}
