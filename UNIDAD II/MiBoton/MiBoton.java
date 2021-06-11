import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import javafx.scene.text.Font;

public class MiBoton extends JButton{


public MiBoton (String txt,ImageIcon iconoOriginal, int ancho,int alto){
super(txt, new ImageIcon(
    iconoOriginal.getImage().getScaledInstance(ancho, alto,java.awt.image)));

    apariencia();

}

public void apariencia(){
this.setBorder(null);
this.setContentAreaFilled(true);
this.setOpaque(true);
this.setFont(new Font("Arial",Font.BOLD,15));
this.setBackground(Color.white);
this.setForeground(Color.BLUE);
this.setPreferredSize(new DimensionUIResource(200,40));
this.setHorizontalTextPosition(SwingConstants.CENTER);
this.setVerticalTextPosition(SwingConstants.BOTTOM);



}



}