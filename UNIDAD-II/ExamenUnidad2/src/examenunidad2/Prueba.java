package examenunidad2;
// TAP2EvaluacionOrdinaria- Zarate Carreño José Valentín
import barraHerramientas.BarraHerramientas;  // se importa la libreria BarraHerramientas 
import barraHerramientas.MiBoton;  // tambien es importante importar la libreria MiBoton
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prueba extends JFrame implements ActionListener {

    BarraHerramientas b; 
    MiBoton[] arreglo;  // se declara un array de MiBoton
    // se crean los botones
    MiBoton b1 = new MiBoton();
    MiBoton b2 = new MiBoton();
    MiBoton b3 = new MiBoton();
    MiBoton b4 = new MiBoton();

    public Prueba() {
        b = new BarraHerramientas(); // se crea nuestro objeto BarraHrremientas
       
        // se agregan los botones a nuestra barra
        b.agregarBoton(b1);
        b.agregarBoton(b2);
        b.agregarBoton(b3);
        b.agregarBoton(b4);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        b1.setImagenTexto("Guardar", new ImageIcon("src/salvar.png"), 20, 20);
        b1.setBackground(new Color(93, 193, 185)); // Se agrega color a nuestro boton
        b1.agregarEvento(this); // se agrega el Evento al Boton 1
        b1.setEnabled(true); // cambia el estado del boton a habilitado

        b2.setIcono(new ImageIcon("src/1.png"), 20, 20);
        b2.setEnabled(true);
        b2.setBackground(new Color(23, 17, 105));

        b3.setColorLetter(Color.BLACK);
        b3.setBackground(new Color(140, 126, 62)); // cambiar el color del boton
        b3.setText("Enviar"); // Agregar texto al boton
        b3.setEnabled(false); // cambia el estado del boton a inhabilitado

        b4.setBackground(new Color(43, 152, 62)); // cambiar el color del boton
        
        b4.setEnabled(false); // cambia el estado del boton a inhabilitado

        // se cambia la posicion de nuestra barra de herramientas
        b.setOrientationO(b.HORIZONTAL); // en posición Horizontal
        //b.setOrientationO(b.VERTICAL); // en posición vertical 
        
        add(b);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("HOLA");
        JOptionPane.showMessageDialog(null, "HOLA MUNDO");
    }

    public static void main(String[] args) {
        new Prueba();
    }
}
