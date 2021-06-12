/*
 * 
COSAS QUE FALTAN Y EXAMEN 
PANEL 1:
    No permitir datos duplicados
    BOTON AGREGAR MEDIDAS
PANEL 2
    QUE MUESTRE SOLO LOS DATOS MAS NO LOS INDICADORES COMO IMC Y ICC
PANEL 3 
    AGREGAR OTRA PESTAÑA INDICADORES QUE MUESTRE LOS RESULTADOS DE LOS INDICADORES 
    QUE REFERENCIA LOS REGISTROS SELECCIONADOS DE UNA PERSONA 
    
 */


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author Administrador
 */
public class AplicacionBaseDeDatos extends JFrame implements ActionListener {

    JButton agregarRegistro;
    JButton iniciarValores;
    JButton eliminarRegistro;
    JButton agregarMedidas;
    PreparedStatement psd,psd2;
    ResultSet rs,rs2;
    String name;
    int id;
    ModeloTabla1 mt = new ModeloTabla1("root", "123456789");
    JTable jt = new JTable(mt);

    /**
     * ********************************************
     */
    JPanel presentacion;
    JLabel titulo;
    JLabel eNombre;
    JTextField dNombre;
    SpinnerDateModel modelo;
    JSpinner fecha;
    JLabel fechaNac;
    JLabel edad;
    String fechacompleta;
    JLabel sexo;
    JRadioButton masculino;
    JRadioButton femenino;
    ButtonGroup sexos;
    JLabel eEstatura;
    JSpinner dEstatura;
    JScrollPane jsp;
    JLabel nombrePersona;
    /**
     * ***********************************
     */

    /**
     * *****************LAMINA 2*********************
     */
    JButton MedagregarReg;
    JButton MediniciaValores;
    JButton MedeliminarRegis;
    JLabel proporcionaDat;
    JLabel ePeso;
    JTextField dPeso;
    JLabel eCintura;
    JSpinner dCintura;
    JLabel eCadera;
    JSpinner dCadera;
    JLabel seleccionaAct;
    String actividades[] = {"Sendatario", "Moderado", "Activo", "Muy Activo"};
    JComboBox listaActividades;

    ModeloTabla1 mt2 = new ModeloTabla1("root", "123456789");
    JTable jt2;
    JScrollPane p2;

    /**
     * *************************************
     */

    public AplicacionBaseDeDatos() {
        Container panel = getContentPane();

        JTabbedPane panelPrincipal = new JTabbedPane();
        panelPrincipal.addTab("Personas ", panel1());
        panelPrincipal.addTab("Mediciones", panelMediciones());
        add(panelPrincipal);
        setVisible(true);
        setSize(800, 500);
        // iniciarValores.addActionListener(this);
//String name;
        //add(Titulo,BorderLayout.WEST);
    }

    public JPanel panel1() {

        presentacion = new JPanel();
        titulo = new JLabel("Proporciona tus Datos");
        eNombre = new JLabel("Nombre: ");
        dNombre = new JTextField("Introduce tu Nombre", 20);
        dNombre.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dNombre.setSelectionStart(0);
                dNombre.setSelectionEnd(dNombre.getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        modelo = new SpinnerDateModel();
        fecha = new JSpinner(modelo);
        fecha.setEditor(new JSpinner.DateEditor(fecha, "yyyy-MM-dd"));
        fechaNac = new JLabel("Fecha de Nacimiento: ");
        edad = new JLabel();
        fechacompleta = String.valueOf(fecha.getValue());

        fecha.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int edades = Calcular_Edad(Year(String.valueOf(fecha.getValue())), Mes(String.valueOf(fecha.getValue())), Dia(String.valueOf(fecha.getValue())));
                //System.out.println(fecha.getValue());
                if (edades < 0) {
                    edad.setText("0 Años");
                } else {
                    edad.setText("" + edades + " Años");
                }

            }
        });
        sexo = new JLabel("Sexo: ");
        masculino = new JRadioButton("Masculino");
        femenino = new JRadioButton("Femenino");
        sexos = new ButtonGroup();
        sexos.add(masculino);
        sexos.add(femenino);

        JPanel panel = new JPanel();
        titulo.setBounds(400, 0, 200, 30);
        eNombre.setBounds(400, 40, 150, 30);
        dNombre.setBounds(540, 40, 200, 20);
        fechaNac.setBounds(400, 80, 150, 20);
        fecha.setBounds(540, 80, 120, 20);
        edad.setBounds(680, 80, 50, 20);
        sexo.setBounds(400, 110, 50, 20);
        masculino.setBounds(460, 110, 100, 20);
        femenino.setBounds(570, 110, 100, 20);

        panel.setLayout(null);

        panel.add(titulo);
        panel.add(eNombre);
        panel.add(dNombre);
        panel.add(fechaNac);
        panel.add(fecha);
        panel.add(sexo);
        panel.add(masculino);
        panel.add(femenino);
        panel.add(edad);
        panel.setSize(600, 700);
        // panel.setBorder(BorderFactory.createCompoundBorder());
        panel.setVisible(true);

        agregarRegistro = new JButton("Agregar Registro");
        iniciarValores = new JButton("Inicializar los valores");
        eliminarRegistro = new JButton("Eliminar Reg.Seleccionado");
        agregarMedidas = new JButton("Agregar Medidas");
        agregarRegistro.setBounds(100, 180, 140, 30);
        iniciarValores.setBounds(245, 180, 160, 30);
        eliminarRegistro.setBounds(410, 180, 200, 30);
        agregarMedidas.setBounds(615, 180, 150, 30);
        // SpinnerNumberModel modelo2=new SpinnerNumberModel();
        eEstatura = new JLabel("Estatura: ");
        dEstatura = new JSpinner(new SpinnerNumberModel(40, 40, 199, 1));
        eEstatura.setBounds(400, 140, 100, 20);
        dEstatura.setBounds(490, 140, 100, 20);
        panel.add(agregarRegistro);
        panel.add(iniciarValores);
        panel.add(eliminarRegistro);
        panel.add(agregarMedidas);
        panel.add(eEstatura);
        panel.add(dEstatura);

        //jt.getTableHeader().setFont(font);
        jt.getTableHeader().setReorderingAllowed(false);
        jt.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = jt.getColumnModel();
        for (int i = 0; i < 5; i++) {
            colum.getColumn(i).setPreferredWidth(150);
        }
        jt.setRowSelectionAllowed(true);
        jsp = new JScrollPane(jt);
        jsp.setPreferredSize(new Dimension(753, 200));
        jsp.setBounds(100, 230, 600, 200);
        panel.add(jsp);
        agregarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection cn;
                    cn = getConexion();
                    psd = cn.prepareStatement("INSERT INTO PERSONA (NOMBRE,FECHANAC,SEXO,ESTATURA) VALUES(?,?,?,?)");
                    psd.setString(1, dNombre.getText());
                    String date = String.valueOf(fecha.getValue());
                    int day = Dia((String.valueOf(fecha.getValue())));
                    int mes = Mes((String.valueOf(fecha.getValue())));
                    int año = Year((String.valueOf(fecha.getValue())));
                    String dates = año + "-" + mes + "-" + day;
                    psd.setDate(2, Date.valueOf(dates));
                    String sexo;
                    if (masculino.isSelected()) {
                        sexo = "M";
                    } else {
                        sexo = "F";
                    }
                    psd.setString(3, sexo);
                    psd.setString(4, String.valueOf(dEstatura.getValue()));

                    int res = psd.executeUpdate();
                    if (res < 0) {
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                    }
                    cn.close();

                } catch (SQLException ex) {
                    System.err.println("Error en: " + ex);
                }
                mt.actualizaEstatus();
            }
        });
        iniciarValores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dNombre.setText("Introduce tu Nombre");
                fecha.setModel(new SpinnerDateModel());
                fecha.setEditor(new JSpinner.DateEditor(fecha, "yyyy-MM-dd"));
                edad.setText("");
                masculino.setSelected(false);
                femenino.setSelected(false);
                dEstatura.setModel(new SpinnerNumberModel(40, 40, 199, 1));
            }
        });

        eliminarRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = jt.getSelectedRowCount();
            if (fila < 1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                if (deleteDatos(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString())) > 0) {
                    mt.actualizaEstatus();
                }
            }
            }
        });

        agregarMedidas.addActionListener(/*new ActionListener() {
            String nombre_p;

            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = jt.getSelectedRowCount();
                if (fila < 1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro");
                } else {
                    nombre_p = jt.getValueAt(jt.getSelectedRow(), 1).toString();
                    id = Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString());
                    System.out.println(name + " " + id);

                }
            }

            public String getName() {
                return nombre_p;
            }
        }*/this);
        return panel;
    }

    public int deleteDatos(int id) {
        Connection cn = getConexion();
        String sql = "DELETE FROM PERSONA WHERE IDPERSONA =" + id;

        int res = 0;
        try {
            psd = cn.prepareStatement(sql);
            // psd.setInt(1, id);
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

     public int deleteAct(int id) {
        Connection cn = getConexion();
        String sql = "DELETE FROM MEDICIONES WHERE IDPERSONA =" + id;

        int res = 0;
        try {
            psd = cn.prepareStatement(sql);
            // psd.setInt(1, id);
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
    public int Calcular_Edad(int Anios, int meses, int dias) {
        int Edad = 0;

        Calendar Calendario = Calendar.getInstance();
        int Anio = Calendario.get(Calendar.YEAR);
        int MesI = (Calendario.get(Calendar.MONTH)) + 1;
        int Diass = Calendario.get(Calendar.DAY_OF_MONTH);

        Edad = Anio - Anios;

        if ((meses - MesI) > 0) {
            Edad--;
        } else if ((meses - MesI) == 0) {
            if ((dias - Diass) > 0) {
                Edad--;
            }
        }

        return Edad;
    }

    public int Year(String Fecha) {
        return Integer.parseInt(Fecha.substring(24, 28));

    }

    public int Mes(String Fecha) {
        String meses = Fecha.substring(4, 7);
        int Numero = 0;

        if (meses.equals("Jan")) {
            Numero = 1;
        } else if (meses.equals("Feb")) {
            Numero = 2;
        } else if (meses.equals("Mar")) {
            Numero = 3;
        } else if (meses.equals("Apr")) {
            Numero = 4;
        } else if (meses.equals("May")) {
            Numero = 5;
        } else if (meses.equals("Jun")) {
            Numero = 6;
        } else if (meses.equals("Jul")) {
            Numero = 7;
        } else if (meses.equals("Aug")) {
            Numero = 8;
        } else if (meses.equals("Sep")) {
            Numero = 9;
        } else if (meses.equals("Oct")) {
            Numero = 10;
        } else if (meses.equals("Nov")) {
            Numero = 11;
        } else if (meses.equals("Dec")) {
            Numero = 12;
        }

        return Numero;
    }

    public int Dia(String Fecha) {
        return Integer.parseInt(Fecha.substring(8, 10));
    }

    public static void main(String[] args) {
        AplicacionBaseDeDatos ma = new AplicacionBaseDeDatos();
        ma.setVisible(true);
        ma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/mediciones_personas", "root", "123456789");
            System.out.println("Se concecto Correctamente ");

        } catch (Exception e) {
            System.err.println("Hubo un error en la instalacion " + e);
        }
        return conexion;

        //********************
//  usa el modelo de tabla creada por el usuario
        //fireTableDataChanged();
    }

    /*_________________________________________________________________________________________________________*/
    public JPanel panelMediciones() {
        JPanel panelmediciones = new JPanel();
        panelmediciones.setLayout(null);
        JLabel encabezado = new JLabel("MANIPULACION DE DATOS DE MEDICIONES PARA: ");

        nombrePersona = new JLabel();
        //  nombrePersona.setText("---"+name+"---");
        proporcionaDat = new JLabel("Proporciona los Datos");
        ePeso = new JLabel("Peso (Kgs)");
        dPeso = new JTextField(10);
        eCintura = new JLabel("Cintura (Cms)");
        dCintura = new JSpinner(new SpinnerNumberModel(50, 50, 200, 1));
        eCadera = new JLabel("Cadera (Cms)");
        dCadera = new JSpinner(new SpinnerNumberModel(50, 50, 200, 1));
        seleccionaAct = new JLabel("Selecciona la Actividad");
         String actividades[] = {"Sendatario", "Moderado", "Activo", "Muy Activa"};
        listaActividades = new JComboBox(actividades);
        agregarRegistro = new JButton("Agregar Registro");
        iniciarValores = new JButton("Iniciar Valores");
        eliminarRegistro = new JButton("Eliminar Reg.Selec.");
        ModeloTabla2 mt2 = new ModeloTabla2("root", "123456789");
        JTable jt2 = new JTable(mt2);
        jt2.getTableHeader().setReorderingAllowed(false);
        jt2.getTableHeader().setResizingAllowed(false);
        TableColumnModel colum = jt2.getColumnModel();
        for (int i = 0; i < 6; i++) {
            colum.getColumn(i).setPreferredWidth(200);
        }
        jt2.setRowSelectionAllowed(true);
       JScrollPane jsp2 = new JScrollPane(jt2);
        jsp2.setPreferredSize(new Dimension(753, 300));

        encabezado.setBounds(250, 0, 300, 50);
        nombrePersona.setBounds(400, 30, 100, 30);
        proporcionaDat.setBounds(50, 50, 200, 50);
        ePeso.setBounds(50, 110, 70, 30);
        dPeso.setBounds(140, 120, 60, 20);
        eCadera.setBounds(50, 145, 100, 30);
        dCadera.setBounds(140, 150, 60, 20);
        eCintura.setBounds(50, 180, 100, 30);
        dCintura.setBounds(140, 185, 60, 20);
        seleccionaAct.setBounds(400, 50, 150, 30);
        listaActividades.setBounds(400, 90, 150, 25);
        jsp2.setBounds(50, 250, 700, 200);
        MedagregarReg = new JButton("Agregar Registro");
        MediniciaValores = new JButton("Inicializar los valores");
        MedeliminarRegis = new JButton("Eliminar Registro");
        MedagregarReg.setBounds(120, 210, 150, 30);
        MediniciaValores.setBounds(280, 210, 180, 30);
        MedeliminarRegis.setBounds(470, 210, 150, 30);
        MedagregarReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dPeso.getText().isEmpty()||listaActividades.getSelectedItem().toString()==null){
                    JOptionPane.showMessageDialog(null, "Algun campo esta vacio, rellenelo");
                }else{
                try {
                Connection cn;
                cn = getConexion();
                psd = cn.prepareStatement("INSERT INTO MEDICIONES (FECHA,PESO,CINTURA,CADERA,IDTIPOACT,IDPERSONA) VALUES(?,?,?,?,?,?)");
                //psd.setString(1, dNombre.getText());
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String dates = año + "-" + mes + "-" + dia;
                psd.setDate(1, Date.valueOf(dates));
                Double peso=Double.parseDouble(dPeso.getText().toString());
                psd.setDouble(2, peso);
                int cintura=Integer.parseInt(dCintura.getValue().toString());
                int cadera=Integer.parseInt(dCadera.getValue().toString());
                psd.setInt(3, cintura);
                psd.setInt(4, cadera);
                int id_Act=1;
                String actvidad =listaActividades.getSelectedItem().toString();
                if(actvidad.equals("Sedentario")){
                    id_Act=1;
                    psd.setInt(5,id_Act);
                } else if(actvidad.equals("Moderado")){
                    id_Act=2;
                    psd.setInt(5,id_Act);
                }else if(actvidad.equals("Activo")){
                    id_Act=3;
                    psd.setInt(5,id_Act);
                }else if(actvidad.equals(("Muy Activo"))){
                    id_Act=4;
                    psd.setInt(5,id_Act);
                }
                    System.out.println(id);
                psd.setInt(6,id);

                int res = psd.executeUpdate();
                if (res < 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                }
                cn.close();

            } catch (SQLException ex) {
                System.err.println("Error en: " + ex);
            }
            mt2.actualizaEstatus();
        }
            }
            
        });
        MediniciaValores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dPeso.setText("");
                dCadera.setModel(new SpinnerNumberModel(50, 50, 200, 1));
                dCintura.setModel(new SpinnerNumberModel(50, 50, 200, 1));
                 name =" ";
                nombrePersona.setText("---" + name + "---");
                
           //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        MedeliminarRegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   int fila = jt2.getSelectedRowCount();
            if (fila < 1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                if (deleteAct(Integer.parseInt(jt2.getValueAt(jt2.getSelectedRow(), 6).toString())) > 0) {
                   
                }
            } mt2.actualizaEstatus();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                
       
        panelmediciones.add(encabezado);
        panelmediciones.add(nombrePersona);
        panelmediciones.add(proporcionaDat);
        panelmediciones.add(ePeso);
        panelmediciones.add(dPeso);
        panelmediciones.add(eCadera);
        panelmediciones.add(dCadera);
        panelmediciones.add(eCintura);
        panelmediciones.add(dCintura);
        panelmediciones.add(seleccionaAct);
        panelmediciones.add(listaActividades);
        panelmediciones.add(jsp2);
        panelmediciones.add(MedagregarReg);
        panelmediciones.add(MediniciaValores);
        panelmediciones.add(MedeliminarRegis);
        return panelmediciones;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton evento = (JButton) e.getSource();
        if (evento == agregarRegistro) {
            try {
                    Connection cn;
                    cn = getConexion();
                    psd = cn.prepareStatement("INSERT INTO PERSONA (NOMBRE,FECHANAC,SEXO,ESTATURA) VALUES(?,?,?,?)");
                    psd.setString(1, dNombre.getText());
                    String date = String.valueOf(fecha.getValue());
                    int day = Dia((String.valueOf(fecha.getValue())));
                    int mes = Mes((String.valueOf(fecha.getValue())));
                    int año = Year((String.valueOf(fecha.getValue())));
                    String dates = año + "-" + mes + "-" + day;
                    psd.setDate(2, Date.valueOf(dates));
                    String sexo;
                    if (masculino.isSelected()) {
                        sexo = "M";
                    } else {
                        sexo = "F";
                    }
                    psd.setString(3, sexo);
                    psd.setString(4, String.valueOf(dEstatura.getValue()));

                    int res = psd.executeUpdate();
                    if (res < 0) {
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                    }
                    cn.close();

                } catch (SQLException ex) {
                    System.err.println("Error en: " + ex);
                }
                mt.actualizaEstatus();
            }

        if (evento == iniciarValores) {
                dNombre.setText("Introduce tu Nombre");
                fecha.setModel(new SpinnerDateModel());
                fecha.setEditor(new JSpinner.DateEditor(fecha, "yyyy-MM-dd"));
                edad.setText("");
                masculino.setSelected(false);
                femenino.setSelected(false);
                dEstatura.setModel(new SpinnerNumberModel(40, 40, 199, 1));
        }
        if (evento == eliminarRegistro) {
            int fila = jt.getSelectedRowCount();
            if (fila < 1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                if (deleteDatos(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString())) > 0) {
                    mt.actualizaEstatus();
                }
            }
        }
        if (evento == agregarMedidas) {
            int fila = jt.getSelectedRowCount();
            System.out.println(fila);
            if (fila < 1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                name = jt.getValueAt(jt.getSelectedRow(), 1).toString();
                nombrePersona.setText("---" + name + "---");
                id = Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString());
                System.out.println(name + " " + id);

            }
        }

        /**
         * *********************SEGUNDA LAMINA*****************************************
         */
       
        /*if (evento == MedagregarReg) {

            //   DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Connection cn;
                cn = getConexion();
                psd = cn.prepareStatement("INSERT INTO MEDICIONES (FECHA,PESO,CINTURA,CADERA,IDTIPOACT,IDPERSONA) VALUES(?,?,?,?,?,?)");
                psd.setString(1, dNombre.getText());
                Calendar fecha = Calendar.getInstance();
                int año = fecha.get(Calendar.YEAR);
                int mes = fecha.get(Calendar.MONTH) + 1;
                int dia = fecha.get(Calendar.DAY_OF_MONTH);
                String dates = año + "-" + mes + "-" + dia;
                psd.setDate(1, Date.valueOf(dates));
                Double peso=Double.parseDouble(dPeso.getText().toString());
                psd.setDouble(2, peso);
                int cintura=Integer.parseInt(dCintura.getValue().toString());
                int cadera=Integer.parseInt(dCadera.getValue().toString());
                psd.setInt(3, cintura);
                psd.setInt(4, cadera);
                int id_Act=0;
                String actvidad =listaActividades.getSelectedItem().toString();
                if(actvidad.equals("Sedentario")){
                    id_Act=1;
                } else if(actvidad.equals("Moderado")){
                    id_Act=2;
                }else if(actvidad.equals("Activo")){
                    id_Act=3;
                }else if(actvidad.equals(("Muy Activo"))){
                    id_Act=4;
                }
                psd.setInt(5,id_Act);

                int res = psd.executeUpdate();
                if (res < 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo añadir el registro");
                }
                cn.close();

            } catch (SQLException ex) {
                System.err.println("Error en: " + ex);
            }
            mt.actualizaEstatus();
        }*/

    }
}
