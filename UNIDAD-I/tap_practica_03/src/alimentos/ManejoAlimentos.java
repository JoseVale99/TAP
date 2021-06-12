package alimentos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManejoAlimentos extends JFrame implements 
            ActionListener, ChangeListener, ItemListener {

    private final Color COLORES[] = {Color.GREEN, Color.yellow, Color.ORANGE, Color.CYAN, Color.magenta};
    private final String[] TIPO_ALIMENTO = {"VERDURAS", "FRUTAS", "CEREALES",
             "LEGUMINOSAS", "ALIM. DE ORIG. ANIMAL"};
    private final int[] KCAL_TIPO_ALIM = {25, 60, 70, 120, 40};
    private JSlider racTipoAlim[];
    private JLabel KcalTipoAlim[] = new JLabel[5];
    private JPanel pKalTipoAlim[];
    private JLabel Kilocalorias;
    private JButton verificar;

    // atributos para el panel Alimentos
    private final String TIEMPOSCOMIDA[] = {"Desayuno", "Comida", "Cena", "Todos"};
    private JCheckBox eleccionTiempo[];
    private DefaultListModel<Alimentos> modelosListas[];
    private JList tiempos[] = new JList[1];
    private JComboBox alimento;
    private JButton aceptar;
    private JLabel tipoAli;
    private JLabel nAlimentos;
    
    private Alimentos alimentos[] = new Alimentos[22];
    private int[] numAlimTie;
    private JLabel numAlimTiem[];
    private JLabel itemsDesayuno = new JLabel(), itemsComida = new JLabel(), itemsCena = new JLabel();

    public ManejoAlimentos() {
        super("Practica 2");
        Container panel = getContentPane();
        JTabbedPane panelPrincipal = new JTabbedPane();
        panelPrincipal.addTab("Conociendo los alimentos", panelConociendo());
        panelPrincipal.addTab("Elección de alimentos", panelAlimentos());

        panel.add(panelPrincipal);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void cargarDatos() {
        alimentos = new Alimentos[22];

        alimentos[0] = new Alimentos("Zanahoria", 0);
        alimentos[1] = new Alimentos("Lechuga", 0);
        alimentos[2] = new Alimentos("Espinaca", 0);
        alimentos[3] = new Alimentos("Acelgas", 0);
        alimentos[4] = new Alimentos("Tomate", 0);
        alimentos[5] = new Alimentos("Platano", 1);
        alimentos[6] = new Alimentos("Naranja", 1);
        alimentos[7] = new Alimentos("Sandia", 1);
        alimentos[8] = new Alimentos("Pera", 1);
        alimentos[9] = new Alimentos("Pepino", 1);
        alimentos[10] = new Alimentos("Melón", 1);
        alimentos[11] = new Alimentos("Arroz", 2);
        alimentos[12] = new Alimentos("Tortilla", 2);
        alimentos[13] = new Alimentos("Jamón", 4);
        alimentos[14] = new Alimentos("Pan Blanco", 2);
        alimentos[15] = new Alimentos("Frijol", 2);
        alimentos[16] = new Alimentos("Muslo de Pollo", 4);
        alimentos[17] = new Alimentos("Sardina", 4);
        alimentos[18] = new Alimentos("Garbanzos", 2);
        alimentos[19] = new Alimentos("Habas", 2);
        alimentos[20] = new Alimentos("Lentejas", 0);
        alimentos[21] = new Alimentos("Pasta", 2);

    }

    private JPanel panelConociendo() {

        JPanel conocer = new JPanel();
        conocer.setLayout(new BorderLayout());
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        JPanel panelCentro = new JPanel();

        JPanel panelSur = new JPanel();
        JPanel panelTitulo = new JPanel();
        JPanel panelEncabezados = new JPanel();

        panelTitulo.setLayout(new GridLayout(3, 2));
        JLabel enc1 = new JLabel("CONOCIMIENTO DE LAS KILOCALORÍAS APORTADAS POR RACIONES POR TIPO DE ALIMENTO ");
        JLabel enc2 = new JLabel("Elige el número de las raciones de cada tipo de alimento que consideres debes de consumir");

        panelTitulo.add(enc1);
        panelTitulo.add(enc2);
        panelEncabezados.add(panelTitulo);

        panelSuperior.add(panelEncabezados, BorderLayout.CENTER);

        pKalTipoAlim = new JPanel[TIPO_ALIMENTO.length];
        JPanel pGpoTipoAlim = new JPanel();
        pGpoTipoAlim.setLayout(new GridLayout(0, 5));
        racTipoAlim = new JSlider[TIPO_ALIMENTO.length];
        verificar = new JButton("Verificar Proporción");
        Kilocalorias = new JLabel("Total de kilocalorias ", 0);
        panelSur.add(Kilocalorias);
        panelSur.add(verificar);
        

        for (int i = 0; i < TIPO_ALIMENTO.length; i++) {
            JPanel pdatos = new JPanel();
            pdatos.setLayout(new BorderLayout());
            JLabel tit = new JLabel(TIPO_ALIMENTO[i]);
            tit.setHorizontalAlignment(SwingConstants.CENTER);
            pKalTipoAlim[i] = new JPanel();
            racTipoAlim[i] = new JSlider();
            racTipoAlim[i].setOrientation(SwingConstants.VERTICAL);//
            racTipoAlim[i].setPaintLabels(true);
            racTipoAlim[i].setPaintTicks(true);
            racTipoAlim[i].setMinimum(0);
            racTipoAlim[i].setMaximum(10);
            racTipoAlim[i].setValue(0);
            racTipoAlim[i].setMajorTickSpacing(2);
            racTipoAlim[i].setMinorTickSpacing(0);
            racTipoAlim[i].addChangeListener(this);

            KcalTipoAlim[i] = new JLabel(KCAL_TIPO_ALIM[i] + "");
            KcalTipoAlim[i].setBackground(COLORES[i]);
            KcalTipoAlim[i].setOpaque(true);
            KcalTipoAlim[i].setVerticalAlignment(SwingConstants.TOP);
            KcalTipoAlim[i].setHorizontalAlignment(SwingConstants.RIGHT);
            pKalTipoAlim[i].setLayout(null);
            pKalTipoAlim[i].setPreferredSize(new Dimension(80, 80));
            pKalTipoAlim[i].add(KcalTipoAlim[i]);

            pdatos.add(tit, BorderLayout.NORTH);
            pdatos.add(racTipoAlim[i], BorderLayout.WEST);
            pdatos.add(pKalTipoAlim[i], BorderLayout.EAST);
            pGpoTipoAlim.add(pdatos);
        }
        verificar.addActionListener(this);
        panelCentro.add(pGpoTipoAlim);//bien
        conocer.add(panelSuperior, BorderLayout.NORTH);//bien
        conocer.add(panelCentro, BorderLayout.CENTER);//bien
        conocer.add(panelSur, BorderLayout.SOUTH);//bien
        return conocer;
    }

    public JPanel panelAlimentos() {
        JPanel pAlimentos = new JPanel();
        pAlimentos.setLayout(new BorderLayout());
        JPanel panelCentro = new JPanel();//Para la seleccion de alimentos y cuadros de verifcacion 
        JPanel panelCheck = new JPanel();//Para cuadros de verificacion de tiempos de comidas 
        panelCheck.setLayout(new GridLayout(1, 0));
        panelCentro.setLayout(new BorderLayout());
        JPanel panelSeleccion = new JPanel();//Para la selccion de los alimentos 
        JLabel titulo = new JLabel("ELECCION DE ALIMENTOS Y ASIGNACION A UN TIEMPO PARA SU CONSUMO ");
        titulo.setHorizontalAlignment(JLabel.CENTER);
        JLabel tAlimento = new JLabel("Elige alimento");
        aceptar = new JButton("Aceptar");
        tipoAli = new JLabel("");
        cargarDatos();
        alimento = new JComboBox(alimentos);
        tipoAli.setText(TIPO_ALIMENTO[0]);// se rnuestra el primer° 
        alimento.addItemListener(this);
        JPanel panelTiempos = new JPanel();
        panelTiempos.add(new JPanel());
        panelSeleccion.add(tAlimento);
        panelSeleccion.add(alimento);
        panelSeleccion.add(tipoAli);
        panelCentro.add(panelSeleccion, BorderLayout.NORTH);
        panelCentro.add(creaPanelTiempos(), BorderLayout.CENTER);
        pAlimentos.add(titulo, BorderLayout.NORTH);
        pAlimentos.add(panelCentro, BorderLayout.CENTER);
        panelCentro.add(creaListas(), BorderLayout.SOUTH);
        return pAlimentos;
    }

    public JPanel creaPanelTiempos() {
        JPanel tiemposAlimento = new JPanel();
        tiemposAlimento.setLayout(new BorderLayout());
        JLabel indicacion = new JLabel("Selecciona el tiempo cuando deseas consumirlo");
        indicacion.setHorizontalAlignment(JLabel.CENTER);
        tiemposAlimento.add(indicacion, BorderLayout.NORTH);
        JPanel eleccion = new JPanel();
        aceptar = new JButton("Agregar");
        eleccionTiempo = new JCheckBox[TIEMPOSCOMIDA.length];
        numAlimTie = new int[10];
        eleccion.setLayout(new FlowLayout());

        for (int i = 0; i < eleccionTiempo.length; i++) {
            eleccionTiempo[i] = new JCheckBox(TIEMPOSCOMIDA[i]);
            eleccion.add(eleccionTiempo[i]);
            eleccionTiempo[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    for (int i = 0; i < eleccionTiempo.length; i++) {
                        if (e.getSource() == eleccionTiempo[3]) {
                            if (eleccionTiempo[3].isSelected()) {
                                eleccionTiempo[i].setSelected(true);
                            } else {
                                eleccionTiempo[i].setSelected(false);
                            }
                        }

                    }
                }
            });
        }
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JButton evento = (JButton) event.getSource();
                if (evento == aceptar) {

                    if (eleccionTiempo[0].isSelected()) {
                        if (!modelosListas[0].contains(((Alimentos) alimento.getSelectedItem()))) {
                            modelosListas[0].addElement(((Alimentos) alimento.getSelectedItem()));

                            numAlimTiem[0].setText("Num. Alim :" + modelosListas[0].getSize());
                        }
                    }
                    if (eleccionTiempo[1].isSelected()) {
                        if (!modelosListas[1].contains(((Alimentos) alimento.getSelectedItem()))) {
                            modelosListas[1].addElement(((Alimentos) alimento.getSelectedItem()));

                            numAlimTiem[1].setText("Num. Alim : " + modelosListas[1].getSize());

                        }
                    }
                    if (eleccionTiempo[2].isSelected()) {
                        if (!modelosListas[2].contains(((Alimentos) alimento.getSelectedItem()))) {
                            modelosListas[2].addElement(((Alimentos) alimento.getSelectedItem()));

                            numAlimTiem[2].setText("Num. Alim : " + modelosListas[2].getSize());
                        }
                    }
                }
            }
        });
        eleccion.add(aceptar);

        tiemposAlimento.add(indicacion, BorderLayout.NORTH);
        tiemposAlimento.add(eleccion, BorderLayout.CENTER);

        return tiemposAlimento;
    }

    private JPanel creaListas() {
        JPanel psur = new JPanel();
        psur.setLayout(new GridLayout(1, 3));
        JPanel pListas = new JPanel();
        JPanel listas = new JPanel();
        JPanel numAlim = new JPanel();
        tiempos = new JList[TIEMPOSCOMIDA.length - 1];
        numAlimTiem = new JLabel[TIEMPOSCOMIDA.length - 1];
        modelosListas = new DefaultListModel[TIEMPOSCOMIDA.length - 1];
        GridLayout dList = new GridLayout(0, TIEMPOSCOMIDA.length - 1, 5, 0);
        pListas.setLayout(new BorderLayout());
        listas.setLayout(dList);
        numAlim.setLayout(dList);
        //muestra los Jlist
        for (int t = 0; t < tiempos.length; t++) {
            modelosListas[t] = new DefaultListModel();
            tiempos[t] = new JList(modelosListas[t]);
            listas.add(new JScrollPane(tiempos[t]));
        }

        for (int i = 0; i < tiempos.length; i++) {
            numAlimTiem[i] = new JLabel();
            numAlim.add(numAlimTiem[i]);
        }

        psur.add(numAlim);

        pListas.add(listas, BorderLayout.NORTH);
        pListas.add(psur, BorderLayout.SOUTH);

        return pListas;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton comprobar = (JButton) ae.getSource();
        if (verificar == comprobar) {
            if ((racTipoAlim[0].getValue() < 6 || racTipoAlim[1].getValue() < 6) 
                && racTipoAlim[2].getValue() < 4 && racTipoAlim[3].getValue() < 5 && racTipoAlim[4].getValue() < 5) {
    JOptionPane.showMessageDialog(null, "Necesitas comer mas:\n Frutas\n Verduras\n Leguminosas\n cereales\nAlimentos de Origen Animal  "
                );
            } else if ((racTipoAlim[0].getValue() == 5) || (racTipoAlim[1].getValue() == 5) 
                && (racTipoAlim[2].getValue() == 3) && (racTipoAlim[3].getValue() == 4) && (racTipoAlim[4].getValue() == 4)) {
                JOptionPane.showMessageDialog(null, "Estas comiendo Bien "
                );
            } else if (racTipoAlim[0].getValue() > 6 || racTipoAlim[1].getValue() > 6 
                    && racTipoAlim[2].getValue() > 4 && racTipoAlim[3].getValue() > 5 && racTipoAlim[4].getValue() > 5) {
    JOptionPane.showMessageDialog(null, "Estas comiendo de mas:\nLeguminosas\n cereales\nAlimentos de Origen Animal  \nVerduras y Frutas BIEN"
                );
            }

        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        int totalKc = 0;

        for (int ta = 0; ta < COLORES.length; ta++) {
             int base = (racTipoAlim[ta].getHeight() - racTipoAlim[ta].getValue() * 
                     KCAL_TIPO_ALIM[ta] * racTipoAlim[ta].getHeight() / racTipoAlim[ta].getHeight());
            int y = 195;
            KcalTipoAlim[ta].setBounds(0, y - (racTipoAlim[ta].getValue() * 19), 60, racTipoAlim[ta].getValue() * 20);

            KcalTipoAlim[ta].setText(" " + racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta] + " -kC");
            totalKc += racTipoAlim[ta].getValue() * KCAL_TIPO_ALIM[ta];
        }
        Kilocalorias.setText("Total KC: " + totalKc + " ");
        this.repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        JComboBox aliSel = (JComboBox) ie.getSource();
        int t = ((Alimentos) aliSel.getSelectedItem()).GetTipo();

        tipoAli.setText(TIPO_ALIMENTO[t]);

    }

}
