package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jose Valentín Zarate Carreño
 */
public class Vista extends JFrame {

    private JPanel panel;
    private JLabel nombreLabel;
    private JLabel primer_apellidoLabel;
    private JLabel segundo_apellidoLabel;
    private JTextField nombre;
    private JTextField primer_apellidoText;
    private JTextField segundo_apellidoText;
    private JScrollPane scrollEmpleado;

    private Modelo.ModeloEmpleados ModeloTablaEmpleado = new Modelo.ModeloEmpleados("root", "123456789");
    private JTable tablaEmpleado = new JTable(ModeloTablaEmpleado);
    
     private Modelo.ModeloAperturaServicio ModeloTablaAperrtura = new Modelo.ModeloAperturaServicio("root", "123456789");
    private JTable tablaApertura = new JTable( ModeloTablaAperrtura);

    public Vista() {
        setTitle(" Conversor de monedas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ManipulaDatos();
    }

    public void ManipulaDatos() {

        Container base = getContentPane();
        base.setLayout(new BorderLayout());
        JTabbedPane paneiPrincipal = new JTabbedPane();
        JPanel panelPersona = new JPanel();
        JPanel panelMedidas = new JPanel();
        base.add(paneiPrincipal);
        paneiPrincipal.add(panelPersona);
        paneiPrincipal.add(panelMedidas);
        paneiPrincipal.setTitleAt(0, "Empleado");
        paneiPrincipal.setTitleAt(1, "Apertura Servicio");

        JPanel datosN = new JPanel();
        JPanel datosC = new JPanel();
        JLabel titulo = new JLabel("Manipulación de datos Empleado ");
        JLabel titulo2 = new JLabel("Datos generales", SwingConstants.CENTER);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 18));
        titulo2.setFont(new Font("Serif", Font.BOLD, 20));

        datosN.add(titulo);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        datosC.add(Empleado(), BorderLayout.WEST);
        panelPersona.add(titulo, BorderLayout.NORTH);
        panelPersona.add(datosC, BorderLayout.CENTER);

       // datosN.add(panelApertura(), BorderLayout.WEST);
        panelMedidas.add(titulo2, BorderLayout.NORTH);
        panelMedidas.add(datosN, BorderLayout.CENTER);
    }

    public JPanel Empleado() {
        Border br = new TitledBorder(new EtchedBorder(), "Datos Empleados");
        JPanel panelEmpleado = new JPanel();
        panelEmpleado.setLayout(new BorderLayout());

        JPanel panelGral = new JPanel();
        panelGral.setLayout(new BorderLayout());

        JPanel paneltablas = new JPanel();
        paneltablas.setLayout(new FlowLayout());

        JPanel paneltabla = new JPanel();
        paneltabla.setLayout(new FlowLayout());

        JPanel campoEmpleado = new JPanel();
        campoEmpleado.setLayout(new GridLayout(3, 2, 16, 20));

        nombreLabel = new JLabel("Nombre");
        nombre = new JTextField(12);

        primer_apellidoLabel = new JLabel("Primer Apellido");
        primer_apellidoText = new JTextField(12);

        segundo_apellidoLabel = new JLabel("Segundo Appellido");
        segundo_apellidoText = new JTextField(12);

        JButton abrir = new JButton("Abrir");
        
        
        campoEmpleado.setBorder(br);
        campoEmpleado.add(nombreLabel);
        campoEmpleado.add(nombre);
        campoEmpleado.add(primer_apellidoLabel);
        campoEmpleado.add(primer_apellidoText);
        campoEmpleado.add(segundo_apellidoLabel);
        campoEmpleado.add(segundo_apellidoText);

        // Agregar la tabla 
        tablaEmpleado.getTableHeader().setReorderingAllowed(false);
        tablaEmpleado.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = tablaEmpleado.getColumnModel();

        colum.getColumn(1).setPreferredWidth(150);
        tablaEmpleado.setRowSelectionAllowed(true);
        scrollEmpleado = new JScrollPane(tablaEmpleado);

        campoEmpleado.setBorder(br);
        campoEmpleado.add(nombreLabel);
        campoEmpleado.add(nombre);
        campoEmpleado.add(primer_apellidoLabel);
        campoEmpleado.add(primer_apellidoText);
        campoEmpleado.add(segundo_apellidoLabel);
        campoEmpleado.add(segundo_apellidoText);
        paneltabla.add(scrollEmpleado);
        
        panelGral.add(paneltabla, BorderLayout.CENTER);

        panelEmpleado.add(campoEmpleado, BorderLayout.CENTER);
        panelEmpleado.add(panelGral, BorderLayout.SOUTH);

        return panelEmpleado;
    }

  public JPanel panelApertura(){
Border br = new TitledBorder(new EtchedBorder(), "Datos");
        

JPanel panelEmpleado = new JPanel();
        panelEmpleado.setLayout(new BorderLayout());

        JPanel panelGral = new JPanel();
        panelGral.setLayout(new BorderLayout());

        JPanel paneltablas = new JPanel();
        paneltablas.setLayout(new FlowLayout());

        JPanel paneltabla = new JPanel();
        paneltabla.setLayout(new FlowLayout());

        JPanel campoEmpleado = new JPanel();
        campoEmpleado.setLayout(new GridLayout(3, 2, 16, 20));

        nombreLabel = new JLabel("Nombre");
        nombre = new JTextField(12);

        primer_apellidoLabel = new JLabel("Primer Apellido");
        primer_apellidoText = new JTextField(12);

        segundo_apellidoLabel = new JLabel("Segundo Appellido");
        segundo_apellidoText = new JTextField(12);

        campoEmpleado.setBorder(br);
        campoEmpleado.add(nombreLabel);
        campoEmpleado.add(nombre);
        campoEmpleado.add(primer_apellidoLabel);
        campoEmpleado.add(primer_apellidoText);
        campoEmpleado.add(segundo_apellidoLabel);
        campoEmpleado.add(segundo_apellidoText);

        // Agregar la tabla 
        tablaEmpleado.getTableHeader().setReorderingAllowed(false);
        tablaEmpleado.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = tablaEmpleado.getColumnModel();

        colum.getColumn(1).setPreferredWidth(150);
        tablaEmpleado.setRowSelectionAllowed(true);
        scrollEmpleado = new JScrollPane(tablaEmpleado);

        campoEmpleado.setBorder(br);
        campoEmpleado.add(nombreLabel);
        campoEmpleado.add(nombre);
        campoEmpleado.add(primer_apellidoLabel);
        campoEmpleado.add(primer_apellidoText);
        campoEmpleado.add(segundo_apellidoLabel);
        campoEmpleado.add(segundo_apellidoText);
        paneltabla.add(scrollEmpleado);
        
        panelGral.add(paneltabla, BorderLayout.CENTER);

        panelEmpleado.add(campoEmpleado, BorderLayout.CENTER);
        panelEmpleado.add(panelGral, BorderLayout.SOUTH);

        return panelEmpleado;
}
}
