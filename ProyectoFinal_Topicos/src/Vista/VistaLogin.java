package Vista;

import Controlador.ControladorGasolineria;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import botonr.ComponenteBotonRedondo;
import java.awt.event.FocusListener;

public class VistaLogin extends JFrame{

    private JPanel login;
    private JLabel etiqueta_usuario;
    private JLabel etiqueta_contrasenia;
    public JTextField ingresar_user;
    public JPasswordField contrasenia;
    private JButton ingresar;
    private JButton recuperar;

    public VistaLogin() {

        login = new JPanel();
        login.setLayout(null);
        login.setSize(400, 350);
        login.setBackground(new Color(0, 0, 0)); // color de fondo
        login.setBounds(260, 150, 366, 480);
        setResizable(false);
        //setLocationRelativeTo(null);

        // Etiquetas 
        etiqueta_usuario = new JLabel("Ingresa tu nombre de usuario:");
        etiqueta_usuario.setForeground(Color.white);
        etiqueta_usuario.setFont(new Font("Open Sans Ligth", Font.BOLD, 20));
        etiqueta_usuario.setBounds(45, 50, 600, 50);

        etiqueta_contrasenia = new JLabel("Ingresa tu contraseña:");
        etiqueta_contrasenia.setForeground(Color.white);
        etiqueta_contrasenia.setFont(new Font("Open Sans Ligth", Font.BOLD, 20));
        etiqueta_contrasenia.setBounds(70, 180, 300, 50);

        //TextField (entradas de texto)
        ingresar_user = new JTextField("   Ingresa tu usuario");
        ingresar_user.setFont(new Font("Open Sans Ligth", Font.BOLD, 15));
        ingresar_user.setForeground(Color.white);
        ingresar_user.setBounds(35, 100, 300, 50);
        ingresar_user.setBackground(new Color(0, 0, 0));

        contrasenia = new JPasswordField("     Ingresa tu contraseña");
        contrasenia.setFont(new Font("Open Sans Ligth", Font.BOLD, 15));
        contrasenia.setForeground(Color.white);
        contrasenia.setBounds(35, 230, 300, 50);
        contrasenia.setBackground(new Color(0, 0, 0));

        ////botones
        ingresar = new JButton("Ingresar");
        ingresar.setBackground(new Color(0, 0, 0));
        ingresar.setBounds(110, 350, 150, 50);
        ingresar.setBorder(new ComponenteBotonRedondo(40));
        ingresar.setForeground(Color.WHITE);
        login.add(ingresar);

        JButton Recuperar = new JButton("¿Perdiste tu contraseña? Recuperala aqui");
        Recuperar.setBackground(new Color(0, 0, 0));
        Recuperar.setBounds(35, 420, 296, 50);
        Recuperar.setBorder(null);
        Recuperar.setForeground(Color.WHITE);
        login.add(Recuperar);

        login.add(etiqueta_contrasenia);
        login.add(ingresar_user);
        login.add(etiqueta_usuario);
        login.add(contrasenia);

        add(login);
        /// Atributos básicos de la ventana 
        setBounds(200, 200, 370, 520);
        setLocationRelativeTo(null);
        setTitle("G_FUELL");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
public void Ingresar(ControladorGasolineria c){
    ingresar.setActionCommand("Ingresar");
    ingresar.addActionListener(c);
    
    }
    
    public void cC(ControladorGasolineria c) {
      ingresar_user.addFocusListener((FocusListener) c);
    contrasenia.addFocusListener((FocusListener) c);
    }
public void limpiar(){
 ingresar_user.setText("Ingresa tu nombre de usuario:");
contrasenia.setText("     Ingresa tu contraseña");
}
 
}
