package practica_09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableColumnModel;

public class ManipulaDatos extends JFrame implements ActionListener {

    // Elementos para leer datos
    private JTextField nombre;
    private SpinnerDateModel modelo;
    private JSpinner fechaNac;
    private JLabel edad;
    private JSpinner estatura;
    private JRadioButton hombre;
    private JRadioButton mujer;
    private String name;
    private JLabel nombrePersona;
    private JTextField peso;
    private JTextField cintura;
    private JTextField cadera;
    private JComboBox actividad;
    private JScrollPane scrollpersona;
    private JScrollPane scrollMediciones;

    // atributos para el control de acciones
    private JButton agregarRgtro;
    private JButton iniciarValores;
    private JButton eliminarRgtro;
    private JButton agregarMedidas;

    // atribtutos para acceder a la BDD
    private ModeloTablaPersonas ModeloTablaPersona = new ModeloTablaPersonas("root", "123456789");
    private JTable tablaPersona = new JTable(ModeloTablaPersona);
    private ModeloTablaMediciones modeloTablaMedidas = new ModeloTablaMediciones("root", "123456789");
    private JTable tablaMedidas = new JTable(modeloTablaMedidas);
    private PreparedStatement psd, psd2;
    private int id;
// controlar la eleccion y validacion de algunos datos
    private final String DA_NOMBRE = "Da tu nombre"; // titulo predeagregaMeddo en el campo nombre
// instancia de la clase Modelo
    Modelo m = new Modelo();

    public ManipulaDatos() {

        Container base = getContentPane();
        base.setLayout(new BorderLayout());
        JTabbedPane paneiPrincipal = new JTabbedPane();
        JPanel panelPersona = new JPanel();
        JPanel panelMedidas = new JPanel();
        base.add(paneiPrincipal);
        paneiPrincipal.add(panelPersona);
        paneiPrincipal.add(panelMedidas);
        paneiPrincipal.setTitleAt(0, "Personas");
        paneiPrincipal.setTitleAt(1, "Medidas");

        JPanel datosN = new JPanel();
        JPanel datosC = new JPanel();
        JLabel titulo = new JLabel("Manipulación de datos de personas");
        JLabel titulo2 = new JLabel("Manipulación de datos de Mediciones para: ", SwingConstants.CENTER);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 18));
        titulo2.setFont(new Font("Serif", Font.BOLD, 20));

        datosN.add(titulo);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        datosC.add(formarCampospersona(), BorderLayout.WEST);
        panelPersona.add(titulo, BorderLayout.NORTH);
        panelPersona.add(datosC, BorderLayout.CENTER);

        datosN.add(panelMediciones(), BorderLayout.WEST);
        panelMedidas.add(titulo2, BorderLayout.NORTH);
        panelMedidas.add(datosN, BorderLayout.CENTER);
    }

    public JPanel formarCampospersona() {
        Border br = new TitledBorder(new EtchedBorder(), "Proporciona los datos");

        JPanel panelPersona = new JPanel();
        panelPersona.setLayout(new BorderLayout());

        JPanel panelGral = new JPanel();
        panelGral.setLayout(new BorderLayout());

        JPanel paneltablas = new JPanel();
        paneltablas.setLayout(new FlowLayout());

        JPanel paneltabla = new JPanel();
        paneltabla.setLayout(new FlowLayout());

        JPanel campospersona = new JPanel();
        campospersona.setLayout(new GridLayout(4, 3, 10, 8));

        JLabel esp = new JLabel();
        JLabel nomb = new JLabel("Nombre");
        nombre = new JTextField(DA_NOMBRE, 12);
        nombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nombre.setSelectionStart(0);
                nombre.setSelectionEnd(nombre.getText().length());
            }

            @Override
            public void focusLost(FocusEvent fe) {

            }
        });
        edad = new JLabel();
        modelo = new SpinnerDateModel();
        JLabel fechanac = new JLabel("Fecha nacimiento");
        fechaNac = new JSpinner(modelo);
        fechaNac.setEditor(new JSpinner.DateEditor(fechaNac, "yyyy-MM-dd"));

        fechaNac.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                int edades = m.Calcular_Edad(m.Year(String.valueOf(fechaNac.getValue())),
                        m.Mes(String.valueOf(fechaNac.getValue())),
                        m.Dia(String.valueOf(fechaNac.getValue())));
                if (edades < 0) {
                    edad.setText("0 Años");
                } else {
                    edad.setText("" + edades + " Años");
                }
            }
        });
        JLabel sex = new JLabel("Sexo");
        hombre = new JRadioButton("Hombre");
        mujer = new JRadioButton("Mujer");
        ButtonGroup option = new ButtonGroup();
        option.add(hombre);
        option.add(mujer);
        // Botones
        agregarRgtro = new JButton("Agregar Registro");
        iniciarValores = new JButton("Inicializar los valores");
        eliminarRgtro = new JButton("Eliminar Reg.Seleccionado");
        agregarMedidas = new JButton("Agregar Medidas");

        // Agregar la tabla 
        tablaPersona.getTableHeader().setReorderingAllowed(false);
        tablaPersona.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = tablaPersona.getColumnModel();

        colum.getColumn(1).setPreferredWidth(150);
        tablaPersona.setRowSelectionAllowed(true);
        scrollpersona = new JScrollPane(tablaPersona);

        /// funciones boton:
        agregarRgtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conexion conex = new Conexion();
                    Connection cn;
                    cn = conex.getConexion();
                    psd = cn.prepareStatement("INSERT INTO PERSONA (NOMBRE,FECHANAC,SEXO) VALUES(?,?,?)");
                    psd.setString(1, nombre.getText());
                    String date = String.valueOf(fechaNac.getValue());
                    int day = m.Dia((String.valueOf(fechaNac.getValue())));
                    int mes = m.Mes((String.valueOf(fechaNac.getValue())));
                    int año = m.Year((String.valueOf(fechaNac.getValue())));
                    String dates = año + "-" + mes + "-" + day;
                    psd.setDate(2, Date.valueOf(dates));
                    String sexo;
                    if (hombre.isSelected()) {
                        sexo = "M";
                    } else {
                        sexo = "F";
                    }
                    psd.setString(3, sexo);
                    int res = psd.executeUpdate();
                    if (res < 0) {
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                    }
                    cn.close();
                } catch (SQLException ex) {
                    System.err.println("Error en: " + ex);
                }
                ModeloTablaPersona.actualizaEstatus();
            }
        });
        // inicializar valores:
        iniciarValores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                nombre.setText("Introduce tu Nombre");
                fechaNac.setModel(new SpinnerDateModel());
                fechaNac.setEditor(new JSpinner.DateEditor(fechaNac, "yyyy-MM-dd"));
                edad.setText("");
                option.clearSelection();
            }
        });

        // eliminar ;
        eliminarRgtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = tablaPersona.getSelectedRowCount();
                if (fila < 1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro");
                } else {
                    if (deleteDatos(Integer.parseInt(tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 0).toString())) > 0) {
                        ModeloTablaPersona.actualizaEstatus();
              
                    }else{
                    JOptionPane.showMessageDialog(null, "Existen datos de esta persona en la sig tabla ¡Verifique!");
                    }
                }
            }
        });
        // Agregar Medidas
        agregarMedidas.addActionListener(this);
        //se agregan todos los componentes de persona 
        campospersona.setBorder(br);
        campospersona.add(nomb);
        campospersona.add(nombre);
        campospersona.add(esp);
        campospersona.add(fechanac);
        campospersona.add(fechaNac);
        campospersona.add(edad);
        campospersona.add(sex);
        campospersona.add(hombre);
        campospersona.add(mujer);
        // Agregar componentes al panel
        paneltablas.add(agregarRgtro);
        paneltablas.add(iniciarValores);
        paneltablas.add(eliminarRgtro);
        paneltablas.add(agregarMedidas);
        paneltabla.add(scrollpersona);

        panelGral.add(paneltablas, BorderLayout.NORTH);
        panelGral.add(paneltabla, BorderLayout.CENTER);

// agregar al panel a retornar 
        panelPersona.add(campospersona, BorderLayout.CENTER);
        panelPersona.add(panelGral, BorderLayout.SOUTH);

        return panelPersona;
    }

    public int deleteDatos(int id) {
        Conexion conex = new Conexion();
        Connection cn;
        cn = conex.getConexion();
        String sql = "DELETE FROM PERSONA WHERE IDPERSONA =" + id;

        int res = 0;
        try {
            psd = cn.prepareStatement(sql);
            res = psd.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en: " + e);
        }

        return res;
    }

    public ImageIcon imagenActividad(int a) {
        String ruta = "/imagenes/";
        String nombrelmagen[] = {"1.png", "2.png", "3.png", "4.png"};
        URL url = getClass().getResource(ruta + nombrelmagen[a]);
        ImageIcon icon = new ImageIcon(url);
        return icon;
    }

    public void cargaDatosMedidas() {
        String Consultamedidas = "SELECT * FROM MEDICIONES where IDPERSONA=" + id;
        modeloTablaMedidas.actualizaEstatusMedidas(Consultamedidas);

    }

    public JPanel panelMediciones() {
        Border borde1 = new TitledBorder(new EtchedBorder(), "Proporciona los datos");
        Border borde2 = new TitledBorder(new EtchedBorder(), "Seleccionar la actividad");
        Border borde3 = new TitledBorder(new EtchedBorder(), "");

        JPanel panelGral = new JPanel();
        panelGral.setLayout(new BorderLayout());

        JPanel nomb = new JPanel();
        JPanel Imagen = new JPanel();
        Imagen.setBorder(borde3);

        JPanel paneltablas = new JPanel();

        JPanel paneltabla = new JPanel();

        JPanel panelmediciones = new JPanel();
        panelmediciones.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 28));

        JPanel panelcentroOeste = new JPanel();
        panelcentroOeste.setLayout(new GridLayout(2, 0, 70, 20));

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BorderLayout());

        JPanel panelEste = new JPanel();
        panelEste.setLayout(new GridLayout(4, 4, 70, 20));

        JPanel panelOesteSup = new JPanel();

        nombrePersona = new JLabel("-------- ---------", SwingConstants.CENTER);
        nombrePersona.setFont(new Font("Arial", Font.BOLD, 16));

        // componentes para el panelEste
        JLabel dEstatura = new JLabel("Estatura:(mts) ");
        String FORMAT = "0.00";
        estatura = new JSpinner(new SpinnerNumberModel(1.10, 1.10, 6.60, 0.01));
        estatura.setEditor(new JSpinner.NumberEditor(estatura, FORMAT));

        JLabel dPeso = new JLabel("Peso (Kgs)");
        peso = new JTextField(4);

        JLabel dCintura = new JLabel("Cintura (Cms)");
        cintura = new JTextField(4);

        JLabel dCadera = new JLabel("Cadera (Cms)");
        cadera = new JTextField(4);

        panelEste.setBorder(borde1);
        panelEste.add(dEstatura);
        panelEste.add(estatura);
        panelEste.add(dPeso);
        panelEste.add(peso);
        panelEste.add(dCintura);
        panelEste.add(cintura);
        panelEste.add(dCadera);
        panelEste.add(cadera);

        //agregar comp paneloestesup
        String actividades[] = {"Sedentario", "Moderado", "Activo", "Muy Activo"};
        actividad = new JComboBox(actividades);

        JLabel image = new JLabel();
        actividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String actvidad = actividad.getSelectedItem().toString();
                if (actvidad.equals("Sedentario")) {
                    image.setText("No hace ejercico");
                    image.setIcon(imagenActividad(0));

                } else if (actvidad.equals("Moderado")) {
                    image.setText("Realizan ejercicios suaves de 1 a 3 veces por semana");
                    image.setIcon(imagenActividad(1));

                } else if (actvidad.equals("Activo")) {
                    image.setText("Practican deporte de 3 a 5 veces por semana");
                    image.setIcon(imagenActividad(2));

                } else if (actvidad.equals(("Muy Activo"))) {
                    image.setText("Practican deporte de 6 a 7 días por semana");
                    image.setIcon(imagenActividad(3));
                }
                image.setHorizontalTextPosition(SwingConstants.CENTER);
                image.setVerticalTextPosition(SwingConstants.TOP);
                Imagen.add(image);
            }
        });

        panelOesteSup.add(actividad);
        panel.setBorder(borde2);
        panel.add(panelOesteSup);

        //botones  
        agregarRgtro = new JButton("Agregar Registro");
        iniciarValores = new JButton("Inicializar los valores");
        eliminarRgtro = new JButton("Eliminar Reg.Seleccionado");

        //Agregar la tablas Mediciones
        tablaMedidas.getTableHeader().setReorderingAllowed(false);
        tablaMedidas.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = tablaMedidas.getColumnModel();
        for (int i = 1; i < 6; i++) {
            colum.getColumn(i).setPreferredWidth(70);
        }
        colum.getColumn(0).setPreferredWidth(26);
        colum.getColumn(2).setPreferredWidth(80);

        tablaMedidas.setRowSelectionAllowed(true);
        scrollMediciones = new JScrollPane(tablaMedidas);

//funciones para los botones
        agregarRgtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (peso.getText().isEmpty() || actividad.getSelectedItem().toString() == null) {
                    JOptionPane.showMessageDialog(null, "Algun campo esta vacio, rellenelo");
                } else {
                    try {
                        Conexion conex = new Conexion();
                        Connection cn;
                        cn = conex.getConexion();
                        psd = cn.prepareStatement("INSERT INTO MEDICIONES (FECHA,ESTATURA,PESO,CINTURA,CADERA,IDTIPOACT,IDPERSONA) VALUES(?,?,?,?,?,?,?)");
                        Calendar fecha = Calendar.getInstance();
                        int año = fecha.get(Calendar.YEAR);
                        int mes = fecha.get(Calendar.MONTH) + 1;
                        int dia = fecha.get(Calendar.DAY_OF_MONTH);
                        String dates = año + "-" + mes + "-" + dia;
                        psd.setDate(1, Date.valueOf(dates));
                        String s = String.valueOf(estatura.getValue());
                        int est = (int) (Double.parseDouble(s) * 100);
                        psd.setString(2, String.valueOf(est));
                        Double peso2 = Double.parseDouble(peso.getText().toString());
                        psd.setDouble(3, peso2);
                        int cintura2 = Integer.parseInt(cintura.getText().toString());
                        int cadera2 = Integer.parseInt(cadera.getText().toString());
                        psd.setInt(4, cintura2);
                        psd.setInt(5, cadera2);
                        int id_Act = 1;
                        String actvidad = actividad.getSelectedItem().toString();
                        System.out.println(actividad);
                        if (actvidad.equals("Sedentario")) {
                            id_Act = 1;
                            psd.setInt(6, id_Act);
                        } else if (actvidad.equals("Moderado")) {
                            id_Act = 2;
                            psd.setInt(6, id_Act);
                        } else if (actvidad.equals("Activo")) {
                            id_Act = 3;
                            psd.setInt(6, id_Act);
                        } else if (actvidad.equals(("Muy Activo"))) {
                            id_Act = 4;
                            psd.setInt(6, id_Act);
                        }
                        id = Integer.parseInt(tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 0).toString());
                        psd.setInt(7, id);
                        int res = psd.executeUpdate();
                        if (res < 0) {
                            JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                        }
                        cn.close();

                    } catch (SQLException ex) {
                        System.err.println("Error en: " + ex);
                    }
                    cargaDatosMedidas();
                }
            }
        });
        eliminarRgtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = tablaMedidas.getSelectedRowCount();
                if (fila < 1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro");
                } else {
                    if (deleteAct(Integer.parseInt(tablaMedidas.getValueAt(tablaMedidas.getSelectedRow(), 0).toString())) > 0) {
                        
                        cargaDatosMedidas();
                    }
                }
            }
        });

        iniciarValores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                estatura.setModel(new SpinnerNumberModel(40, 40, 199, 1));
                peso.setText("");
                cadera.setText("");
                cintura.setText("");
                name = " ";
                nombrePersona.setText("---------" + name + "---------");
                estatura = new JSpinner(new SpinnerNumberModel(1.10, 1.10, 6.60, 0.01));
                estatura.setEditor(new JSpinner.NumberEditor(estatura, FORMAT));
            }
        });

        //agregar botones al panel:
        paneltablas.add(agregarRgtro);
        paneltablas.add(iniciarValores);
        paneltablas.add(eliminarRgtro);
        paneltabla.add(scrollMediciones);

        panelGral.add(paneltablas, BorderLayout.NORTH);
        panelGral.add(paneltabla, BorderLayout.CENTER);
        panelcentroOeste.add(panel);
        nomb.add(nombrePersona);
        panelCentro.add(panelEste, BorderLayout.WEST);
        panelCentro.add(panelcentroOeste, BorderLayout.EAST);
        panelCentro.add(panelGral, BorderLayout.SOUTH);
        panelCentro.add(nomb, BorderLayout.NORTH);
        panelcentroOeste.add(Imagen);

        panelmediciones.add(panelCentro, BorderLayout.CENTER);
        return panelmediciones;
    }

    public int deleteAct(int id) {
        Conexion conex = new Conexion();
        Connection cn;
        cn = conex.getConexion();
        String sql = "DELETE FROM MEDICIONES WHERE IDMEDIDAS =" + id;

        int res = 0;
        try {
            psd = cn.prepareStatement(sql);
            res = psd.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en: " + e);
        }
        return res;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton evento = (JButton) e.getSource();

        if (evento == agregarMedidas) {
            int fila = tablaPersona.getSelectedRowCount();
            System.out.println(fila);
            if (fila < 1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                name = tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 1).toString();
                nombrePersona.setText("--------" + name + "--------");
                id = Integer.parseInt(tablaPersona.getValueAt(tablaPersona.getSelectedRow(), 0).toString());
                cargaDatosMedidas();

            }
        }
    }

}
