
package Vista;

import javax.swing.*;
import java.awt.*;
import Controlador.ControladorGasolineria;
import java.awt.event.ActionListener;
public class VistaPrincipal extends JFrame {
      private JPanel panel;
      private JButton btnR , btnI;
      private JLabel lblT;
   public VistaPrincipal (){
        setResizable(true);
        setBounds(200, 200, 800, 500);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("G-Fuel");
        iniComponentes();
        
        setVisible(true);
   }
   public void iniComponentes(){
      panel = new JPanel ();
      panel.setBackground(new Color(0,0,0));
      lblT = new JLabel("BIENVENIDO",new ImageIcon ("src/magenes/logo.png"),SwingConstants.CENTER);
      lblT.setForeground(new Color(255, 255, 255));
      lblT.setFont(new Font("Arial",Font.BOLD,20));
      lblT.setBounds(0, 0, 790,300 );
      lblT .setHorizontalTextPosition(SwingConstants.CENTER);
      lblT .setVerticalTextPosition(SwingConstants.TOP);
      btnR = new JButton("REGISTRAR");
      btnR.setBackground(new Color(0,0,0));
      btnR.setForeground(new Color(255,255,255));
      btnR.setFont(new Font("Arial",Font.BOLD,15));
      btnR.setBounds(100, 350, 150, 30);
      btnI = new JButton("VENTA");
      btnI.setBackground(new Color(0,0,0));
      btnI.setForeground(new Color(255,255,255));
      btnI.setFont(new Font("Arial",Font.BOLD,15));
      btnI.setBounds(500, 350, 150, 30);
      panel.setLayout(null);
      agregarpanel();
   }
   public void agregarpanel(){
       panel.add(lblT);
       panel.add(btnR);
       panel.add(btnI);
       add(panel);
   }
   public void cC (ControladorGasolineria c){
       btnI.addActionListener((ActionListener) c); 
       btnR.addActionListener((ActionListener) c);
   }

}
