
package pruebabarraheraamientas;
// importar las librerias hechas de la barra :)
import com_BarraHerramientas.BarraHerramientas;
import com_BarraHerramientas.MiBoton;
// :::::::::::::::::::::::::::::::::::::::::::::::::::::::.
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PruebaBarraheraamientas extends JFrame implements ActionListener {


    BarraHerramientas b;
    MiBoton[] arreglo;

    MiBoton b1 = new MiBoton("Boton 1");
    MiBoton b2 = new MiBoton("Boton 2");
    MiBoton b3 = new MiBoton("Boton 3");
    MiBoton b4 = new MiBoton("Boton 4");
    public PruebaBarraheraamientas() {
        b = new BarraHerramientas();
//        b = new BarraHerramientas(arreglo);
        b.agregarBoton(b1);
        b.agregarBoton(b2);
        b.agregarBoton(b3);
        b.agregarBoton(b4);
        //for(int i=0;i<b.getBotones().length;i++)
        //System.out.println(b.getBotones()[i].getText());
        //setSize(500,500);
        System.out.println(b.getBotones().length);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b1.setIcono(new ImageIcon("src/salvar.png"), 20, 20);
        b1.setText("hola guapo");
        b2.setImagenTexto("Hola",new ImageIcon("src/salvar.png"), 20, 20); 
        b3.setText("HOLA");
        b1.agregarEvento(this);
        b1.setBackground(Color.yellow);
        b2.setBackground(new Color(93,193,185));
        b4.setBackground(new Color(93,193,185));
        add(b);
        pack();
    }

    
    public void actionPerformed(ActionEvent e) {
        System.out.println("HOLA");
        JOptionPane.showMessageDialog(null, "HOLA MUNDO");
    }

    public static void main(String[] args) {
        new PruebaBarraheraamientas();
    }
}
    

