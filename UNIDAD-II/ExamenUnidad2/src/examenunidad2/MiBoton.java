
package examenunidad2;
// TAP2EvaluacionOrdinaria- Zarate Carreño José Valentín
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MiBoton extends JButton{
    private String txt;
 
    public MiBoton(){
        super();
        txt="Etiqueta";
        super.setText(txt);
        apariencia();
    }
    public MiBoton(String txt){
        super(txt);
        apariencia();
    
    }
    public MiBoton(String txt,ImageIcon iconoOriginal,int ancho, int alto){
        super(txt, new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
      
        apariencia();
    }
    
    public MiBoton(ImageIcon iconoOriginal, int ancho,int alto){
        super(new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
    }
    public void setIcono(ImageIcon icon,int ancho,int alto){
        setText("");
        setIcon(new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
    }
    public void setImagenTexto(String texto,ImageIcon icon,int ancho,int alto){
        setText(texto);
        setIcon(new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT)));
    }
    public void setTexto(String texto){
        setText(texto);
    }
    public void setColorLetter(Color color) {
        setForeground(color);
    }
    
     public void setTipoLetra(Font f) {
        setFont(f);
    }
    public void agregarEvento(Object e){
       this.addActionListener((ActionListener) (e));
    }
  
    
    public void apariencia(){
        this.setBorder(null);
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setFont(new Font("Arial",Font.BOLD,15));
        this.setBackground(Color.white);
        this.setForeground(Color.blue);
        this.setPreferredSize(new Dimension(150,150));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setSize(100, 20);
    }


}