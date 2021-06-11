
package Vista;

import Controlador.ControladorGasolineria;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import campodato.CampoDato;

public class VistaRegistro extends JFrame {

    private JPanel pnl0, pnl1, pnl2, pnl3;
    private JPanel pnl2_1;

    private JLabel registro, datosP, jlnombre, jlap, jlam, jldireccion, jldni,
                logo;
    private JLabel jlaP, jlaM;

    private CampoDato jtnombre, jtap, jtam, jtdireccion, jtdni;

    private JButton limpiarC, registrar, salir,iniSesion;

    public VistaRegistro() {
        super("G Fuell");
        iniciarCom();
        setBounds(20,0, 1080, 720);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarCom() {
        pnl0 = new JPanel();
        pnl0.setLayout(null);
        pnl0.setBackground(new Color(0, 0, 0));

        pnl1 = new JPanel();
        pnl1.setBackground(new Color(0, 0, 0));
        pnl1.setBounds(0, 0, 1080, 50);

        registro = new JLabel("Registro");
        registro.setForeground(Color.white);
        registro.setFont(new Font("Arial", Font.BOLD, 30));

        pnl2 = panelizq();

        pnl3 = panelder();

        pnl1.add(registro);

        pnl0.add(pnl1);
        pnl0.add(pnl2);
        pnl0.add(pnl3);
        add(pnl0);
    }

    public JPanel panelizq() {
        pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setBackground(new Color(0, 0, 0));
        pnl2.setBounds(50, 80, 470, 550);

        pnl2_1 = new JPanel();
        pnl2_1.setBackground(new Color(0, 0, 0));
        pnl2_1.setBounds(80, 10, 320, 50);

        datosP = new JLabel("Datos del Personal");
        datosP.setFont(new Font("Arial", Font.BOLD, 30));
        datosP.setForeground(Color.white);
        jlnombre = new JLabel("Nombre");
        jlnombre.setFont(new Font("Arial", Font.BOLD, 20));
        jlnombre.setBounds(35, 90, 75, 50);
        jlnombre.setForeground(Color.white);

        jtnombre = new CampoDato();
        jtnombre.setTipo('T');
        jtnombre.setLongitud(20);
        jtnombre.setBounds(175, 100, 250, 30);

        jlap = new JLabel("Apellido");
        jlap.setFont(new Font("Arial", Font.BOLD, 20));
        jlap.setBounds(35, 150, 100, 75);
        jlap.setForeground(Color.white);
        jlaP = new JLabel("Paterno");
        jlaP.setFont(new Font("Arial", Font.BOLD, 20));
        jlaP.setBounds(35, 175, 100, 75);
        jlaP.setForeground(Color.white);

        jtap = new CampoDato();
        jtap.setTipo('T');
        jtap.setLongitud(20);
        jtap.setBounds(175, 180, 250, 30);

        jlam = new JLabel("Apellido");
        jlam.setFont(new Font("Arial", Font.BOLD, 20));
        jlam.setBounds(35, 240, 100, 75);
        jlam.setForeground(Color.white);
        jlaM = new JLabel("Materno");
        jlaM.setFont(new Font("Arial", Font.BOLD, 20));
        jlaM.setBounds(35, 265, 100, 75);
        jlaM.setForeground(Color.white);

        jtam = new CampoDato();
        jtam.setTipo('T');
        jtam.setLongitud(20);
        jtam.setBounds(175, 270, 250, 30);

        jldireccion = new JLabel("Direccion");
        jldireccion.setFont(new Font("Arial", Font.BOLD, 20));
        jldireccion.setBounds(35, 350, 90, 50);
        jldireccion.setForeground(Color.white);

        jtdireccion = new CampoDato();
        jtdireccion.setTipo('T');
        jtdireccion.setLongitud(20);
        jtdireccion.setBounds(175, 355, 250, 30);

        jldni = new JLabel("DNI");
        jldni.setFont(new Font("Arial", Font.BOLD, 20));
        jldni.setBounds(65, 435, 50, 50);
        jldni.setForeground(Color.white);

        jtdni = new CampoDato();
        jtdni.setTipo('E');
        jtdni.setLongitud(8);
        jtdni.setBounds(175, 445, 250, 30);

        pnl2_1.add(datosP);
        pnl2.add(jlnombre); pnl2.add(jtnombre);
        pnl2.add(jlap); pnl2.add(jlaP); pnl2.add(jtap);
        pnl2.add(jlam); pnl2.add(jlaM); pnl2.add(jtam);
        pnl2.add(jldireccion); pnl2.add(jtdireccion);
        pnl2.add(jldni); pnl2.add(jtdni);
        pnl2.add(pnl2_1);
        return pnl2;
    }

    public JPanel panelder() {
        pnl3 = new JPanel();
        pnl3.setLayout(null);        
        pnl3.setOpaque(false); //Hace trasnparente el panel
        pnl3.setBounds(565, 80, 470, 550);
        
        logo = new JLabel();
        logo.setForeground(Color.red);                
        logo.setIcon(new ImageIcon ("src/Imagenes/logo.png"));
        logo.setBounds(0, 0, 470, 250);
        
        limpiarC = new JButton();
        limpiarC.setText("Limpiar Campos");
        limpiarC.setFont(new Font("Arial", Font.BOLD, 18));
        limpiarC.setBackground(new Color(0, 0, 0));
        limpiarC.setForeground(Color.white);
        limpiarC.setBounds(20, 420, 180, 35);
        
        registrar = new JButton();
        registrar.setText("Registrar");
        registrar.setFont(new Font("Arial", Font.BOLD, 18));
        registrar.setForeground(Color.white);
        registrar.setBackground(new Color(0, 0, 0));
        registrar.setBounds(275, 420, 180, 35);
        
        iniSesion = new JButton();        
        iniSesion.setText("Iniciar Sesion");
        iniSesion.setFont(new Font("Arial", Font.BOLD, 18));
        iniSesion.setBackground(new Color(0,0,0));
        iniSesion.setForeground(Color.white);
        iniSesion.setBounds(275, 485, 180, 35);
        
        salir = new JButton();
        salir.setText("Regresar");
        salir.setFont(new Font("Arial", Font.BOLD, 18));
        salir.setBackground(new Color(0,0,0));
        salir.setForeground(Color.white);
        salir.setBounds(20, 485, 180, 35);

        pnl3.add(logo);
        pnl3.add(limpiarC);
        pnl3.add(registrar);
        pnl3.add(salir);    
        pnl3.add(iniSesion);
        return pnl3;
    }

       public void cC (ControladorGasolineria c){
       salir.addActionListener((ActionListener) c); 
   }

}
