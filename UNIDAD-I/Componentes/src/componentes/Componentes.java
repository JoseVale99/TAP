package componentes;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;

public class Componentes extends JFrame {

    private Container panel;

    private String[] array = {"Python", "C#", "c++", "Java"};
    private JLabel etiqueta = new JLabel("Etiqueta");
    private JTextField texto = new JTextField();
    private JButton boton = new JButton("Aceptar");
    private JScrollBar scrollbar = new JScrollBar();
    private JComboBox combobox = new JComboBox(array);
    private JColorChooser colores = new JColorChooser();
    private JFileChooser file = new JFileChooser("archivo");
    private JPasswordField pasword = new JPasswordField("#SomosTecNM");
    private JProgressBar barra = new JProgressBar();
    private JSlider slider = new JSlider();

    private JTable tablas = new JTable(3, 3);

    public Componentes() {
        // Asignar nombre a la ventana
        super("Agregar componentes");
        panel = getContentPane();
        panel.setLayout(null);

        // Etiqueta
        panel.add(this.etiqueta);
        etiqueta.setBounds(40, 10, 80, 25);

        // Caja de texto
        panel.add(this.texto);
        texto.setBounds(100, 10, 150, 25);

        // Boton
        panel.add(this.boton);
        boton.setBounds(280, 10, 100, 25);

        // ScrollBar
        this.panel.add(this.scrollbar);
        this.scrollbar.setBounds(450, 10, 15, 400);

        // JcomboBox
        this.panel.add(this.combobox);
        this.combobox.setBounds(100, 60, 100, 25);

        // Jcolor choiser
        this.panel.add(this.colores);
        this.colores.setBounds(100, 150, 330, 300);

        // JFileChooser:
        this.panel.add(this.file);
        this.file.setBounds(500, 160, 300, 300);

        // JPasswordField
        this.panel.add(this.pasword);
        this.pasword.setBounds(260, 60, 100, 25);

        // JProgressBar
        this.panel.add(this.barra);
        this.barra.setValue(0);
        this.barra.setStringPainted(true);
        this.barra.setBounds(500, 60, 300, 25);
        // JSlider

        this.panel.add(this.slider);
        this.slider.setBounds(200, 460, 300, 20);
        // JTable
        this.panel.add(this.tablas);
        this.tablas.setBounds(100, 500, 300, 200);

        // Dimensiones de la ventana
        setSize(900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        fill(this.barra);
    }

    public static void main(String[] args) {
        Componentes c = new Componentes();

    }

    public void fill(JProgressBar barra) {
        int i = 0;
        try {
            while (i <= 100) {
                // llenar la barra de menú
                barra.setValue(i + 10);

                // Retrasar el Hilo
                Thread.sleep(1000);
                i += 10;
                if (i == 100) {
                    i = 0;

                }
            }
        } catch (Exception e) {
        }
    }
}
