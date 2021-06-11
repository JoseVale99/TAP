/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.ControladorGasolineria;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author josed
 */
public class VistaCliente extends JFrame {

    private JLabel Factura;
    private JLabel DatosCliente;
    private JLabel nombre;
    private JLabel ApellidoP;
    private JLabel ApellidoM;
    private JLabel Direccion;
    private JLabel DNI;

    public JTextField Jnombre;
    public JTextField JApellidoP;
    public JTextField JApellidoM;
    public JTextField JDireccion;
    public JTextField JDNI;

    public JButton LimpiarCampos;
    public JButton Registro;
    public JButton Regresar;

    public VistaCliente() {
        super("G Fuell");
        setResizable(true);
        setSize(1080, 720);
        setLayout(new BorderLayout());
        JPanel norte = new JPanel();
        norte.setBackground(Color.BLACK);

        JPanel centro = new JPanel();
        centro.setBackground(Color.black);
        centro.setLayout(new GridLayout(1,2));

        JPanel centro1 = new JPanel();
        centro1.setBackground(Color.black);
        centro1.setLayout(new BorderLayout());

        JPanel centro11 = new JPanel();
        centro11.setBackground(Color.black);
        //centro11.setLayout(new GridLayout(5, 3, 10, 5));


        Factura = new JLabel("Factura", SwingConstants.CENTER);
        Factura.setFont(new Font("Arial", Font.BOLD, 30));
        Factura.setForeground(Color.white);
        Factura.setAlignmentY(SwingConstants.CENTER);

        DatosCliente = new JLabel("Datos del cliente",SwingConstants.CENTER);
        DatosCliente.setFont(new Font("Arial", Font.BOLD, 30));
        DatosCliente.setForeground(Color.white);

        nombre = new JLabel("Nombre");
        nombre.setFont(new Font("Arial", Font.BOLD, 20));
        nombre.setForeground(Color.white);
        nombre.setPreferredSize(new Dimension(160,80));

        
        ApellidoP = new JLabel("Apellido "+"\n"
                + "Paterno");
        ApellidoP.setFont(new Font("Arial", Font.BOLD, 20));
        ApellidoP.setForeground(Color.white);
        ApellidoP.setPreferredSize(new Dimension(160,80));

        ApellidoM = new JLabel("Apellido Materno");
        ApellidoM.setFont(new Font("Arial", Font.BOLD, 20));
        ApellidoM.setForeground(Color.white);
        ApellidoM.setPreferredSize(new Dimension(160,80));

        Direccion = new JLabel("Direccion");
        Direccion.setFont(new Font("Arial", Font.BOLD, 20));
        Direccion.setForeground(Color.white);
        Direccion.setPreferredSize(new Dimension(160,80));

        DNI = new JLabel("DNI");
        DNI.setFont(new Font("Arial", Font.BOLD, 20));
        DNI.setForeground(Color.white);
        DNI.setPreferredSize(new Dimension(160,80));

        Jnombre = new JTextField();
        Jnombre.setPreferredSize(new Dimension(250,28));
        JApellidoP = new JTextField();
        JApellidoP.setPreferredSize(new Dimension(250,28));
        JApellidoM = new JTextField();
        JApellidoM.setPreferredSize(new Dimension(250,28));
        JDireccion = new JTextField();
        JDireccion.setPreferredSize(new Dimension(250,28));
        JDNI = new JTextField();
        JDNI.setPreferredSize(new Dimension(250,28));

        LimpiarCampos = new JButton("Limpar Campos");
        LimpiarCampos.setFont(new Font("Arial", Font.BOLD, 18));
        LimpiarCampos.setBackground(new Color(0, 0, 0));
        LimpiarCampos.setForeground(Color.white);
        LimpiarCampos.setPreferredSize(new Dimension(250,38));

        Registro = new JButton("Registrar");
        Registro.setFont(new Font("Arial", Font.BOLD, 18));
        Registro.setBackground(new Color(0, 0, 0));
        Registro.setForeground(Color.white);
        Registro.setPreferredSize(new Dimension(250,38));
        

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Arial", Font.BOLD, 18));
        Regresar.setBackground(new Color(0, 0, 0));
        Regresar.setForeground(Color.white);
        Regresar.setPreferredSize(new Dimension(250,38));

        centro11.add(nombre);
        centro11.add(Jnombre);
        centro11.add(ApellidoP);
        centro11.add(JApellidoP);
        centro11.add(ApellidoM);
        centro11.add(JApellidoM);
        centro11.add(Direccion);
        centro11.add(JDireccion);
        centro11.add(DNI);
        centro11.add(JDNI);
        

        centro1.add(DatosCliente, BorderLayout.NORTH);
        centro1.add(centro11);
        
        /******************************************************/
        JPanel centro2 = new JPanel();
        centro2.setBackground(Color.black);
        JLabel logo = new JLabel();
        logo.setForeground(Color.red);                
        logo.setIcon(new ImageIcon ("src/Imagenes/logo.png"));
        logo.setPreferredSize(new Dimension(470,400));
        centro2.add(logo);
        
        centro2.add(LimpiarCampos);
        centro2.add(Registro);
        centro2.add(Regresar);
        
        
        centro.add(centro1);
        centro.add(centro2);

        norte.add(Factura);
        add(norte, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
      //  setVisible(true);

    }
    public void RegistarControlador(ControladorGasolineria c){
    Registro.setActionCommand("Registrar");
    Registro.addActionListener(c);
    }
       public void cC (ControladorGasolineria c){
       Regresar.addActionListener((ActionListener) c); 
       Registro.addActionListener((ActionListener) c);
   }
}
