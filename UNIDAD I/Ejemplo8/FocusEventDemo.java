import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FocusEventDemo extends JFrame implements FocusListener {
    final static String newline = "\n";
    final int numItems = 15;
    JTextArea mostrar;
   
    //Constructor que configura el titulo cuando lo llamen.
    public FocusEventDemo(String nombreTitulo) {
        super(nombreTitulo);
    }
     
    public void agregarComponentesPanel(final Container pane) {
        GridBagLayout grilla = new GridBagLayout();
        pane.setLayout(grilla);
         
        GridBagConstraints c = new GridBagConstraints();
         
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;  //Hace la columna lo más ancho posible.
        JTextField campoTexto = new JTextField("Un Campo de Texto");
        campoTexto.setMargin(new Insets(0,2,0,2));
        campoTexto.addFocusListener(this);
        grilla.setConstraints(campoTexto, c);
        add(campoTexto);
       
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.1;  //Ensancha un poco cualquier otra columna.
        JLabel etiqueta = new JLabel("Una Etiqueta:");
        etiqueta.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        etiqueta.addFocusListener(this);
        grilla.setConstraints(etiqueta, c);
        add(etiqueta);
         
        String prefijoCombo = "Item de ComboBox #";
        Vector<String> vector = new Vector<String>(numItems);
        for (int i = 0; i < numItems; i++)
            vector.addElement(prefijoCombo + i);
        JComboBox<String> comboBox = new JComboBox<String>(vector);
        comboBox.addFocusListener(this);
        grilla.setConstraints(comboBox, c);
        add(comboBox);
         
        c.gridwidth = GridBagConstraints.REMAINDER;
        JButton boton = new JButton("Un Botón");
        boton.addFocusListener(this);
        grilla.setConstraints(boton, c);
        add(boton);
         
        c.weightx = 0.0;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.BOTH;
        String prefijoLista = "Item de la Lista #";
        Vector<String> listaVector = new Vector<String>(numItems);
        for (int i = 0; i < numItems; i++) {
            listaVector.addElement(prefijoLista + i);
        }
        JList<String> lista = new JList<String>(listaVector);
        lista.setSelectedIndex(1); //Es más fácil ver el cambio de enfoque, si se selecciona un elemento.
        lista.addFocusListener(this);
        JScrollPane scrollPaneLista = new JScrollPane(lista);
         
        grilla.setConstraints(scrollPaneLista, c);
        add(scrollPaneLista);
         
        c.weighty = 1.0; //Hace esta fila tan alto como sea posible.
        c.gridheight = GridBagConstraints.REMAINDER;
        mostrar = new JTextArea();
        mostrar.setEditable(false);
        //El método setRequestFocusEnabled impide que un componente de ser seleccionable
        //pero todavía puede obtener el enfoque a través del teclado, probar con "tab"
        mostrar.setRequestFocusEnabled(false);
        mostrar.addFocusListener(this);
        JScrollPane scrollPaneArea = new JScrollPane(mostrar);
         
        grilla.setConstraints(scrollPaneArea, c);
        add(scrollPaneArea);
        setPreferredSize(new Dimension(450, 450));
        ((JPanel)pane).setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    //Métodos de la interface FocusListener
    public void focusGained(FocusEvent e) {
        mostrarMensaje("Foco ganado", e);
    }
     
    public void focusLost(FocusEvent e) {
        mostrarMensaje("Foco perdido", e);
    }
   
   
    void mostrarMensaje(String prefijo, FocusEvent e) {
        mostrar.append(prefijo + (e.isTemporary() ? " (temporary):" : ":") );
        mostrar.append(e.getComponent().getClass().getName() );
        mostrar.append("; Componente Anterior: " + (e.getOppositeComponent() != null ? e.getOppositeComponent().getClass().getName() : "ninguno") );
        mostrar.append( newline);
        mostrar.setCaretPosition(mostrar.getDocument().getLength());
    }
     
    // Crear la GUI y la muestra. Para la seguridad del hilo, este método debe ser invocado desde el
    // el hilo de distribución de eventos.
    private static void crearYMostrarGUI() {
        //Crear y da la configuracion básica de la ventana.
        FocusEventDemo marco = new FocusEventDemo("Demostración de FocusListener");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Configura el contenido del panel con el método "agregarComponentesPanel(final Container pane).
        marco.agregarComponentesPanel(marco.getContentPane());
         
        //Enpaquetamos y hacemos visible la ventana.
        marco.pack();
        marco.setVisible(true);
    }
     
    public static void main (String[] args) {
        /* Podemos elegir alguno de los Look and Feel comentando el otro. */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       
        //Programa una tarea para el hilo de distribución de eventos:
        //La interfaz Runnable y el método run que llama a nuestro método.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }
}