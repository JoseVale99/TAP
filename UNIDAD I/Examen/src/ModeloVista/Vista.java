package ModeloVista;

import ModeloControlador.Controlador;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JFrame {

    private TitledBorder border1, border2, border3, border4;// = new TitledBorder(new EtchedBorder(Color.BLACK, Color.black),"Indique la fuente de información");
    private JCheckBox caja1, caja2, caja3;
    private Container principal;
    private JPanel panelSup, panelVotar, panel2Votar, panel3Votar, panel4Votar;
    private JLabel image1, image2, image3;
    private JLabel voto1, voto2, voto3;
    private JLabel porcentaje1, porcentaje2, porcentaje3;
    private JTextField presupuesto1, presupuesto2, presupuesto3;
    private JLabel lblvoto, lblpresupuesto; //panel sur 2
    private JButton BtnVotar1, BtnVotar2, BtnVotar3, BtnReiniciar;
    private JProgressBar barra1, barra2, barra3;

    public Vista() {
        setTitle("Elecciones");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        initComponents();

    }

    public void initComponents() {
        principal = getContentPane();
        principal.setLayout(null);//new GridLayout(4, 1,40,30));
        String patch1 = "/imagenes/persona2.png";
        URL url1 = this.getClass().getResource(patch1);
        ImageIcon icon1 = new ImageIcon(url1);

        String patch2 = "/imagenes/persona3.png";
        URL url2 = this.getClass().getResource(patch2);
        ImageIcon icon2 = new ImageIcon(url2);

        String patch = "/imagenes/persona1.png";
        URL url = this.getClass().getResource(patch);
        ImageIcon icon = new ImageIcon(url);
        image1 = new JLabel(icon, SwingConstants.CENTER);
        image1.setBounds(65, 20, 50, 60);

        image2 = new JLabel(icon1, SwingConstants.CENTER);
        image2.setBounds(65, 20, 50, 60);

        image3 = new JLabel(icon2, SwingConstants.CENTER);
        image3.setBounds(65, 20, 50, 60);

        //Botones
        BtnVotar1 = new JButton("votar");
        BtnVotar1.setBounds(30, 90, 120, 25);

        BtnVotar2 = new JButton("votar");
        BtnVotar2.setBounds(30, 90, 120, 25);

        BtnVotar3 = new JButton("votar");
        BtnVotar3.setBounds(30, 90, 120, 25);

        border2 = new TitledBorder(new EtchedBorder());
        border3 = new TitledBorder(new EtchedBorder(), "Presupuestos");
        border4 = new TitledBorder(new EtchedBorder(), "Totales");
        //labels
        voto1 = new JLabel("0", SwingConstants.CENTER);
        voto1.setBorder(border2);
        voto1.setBounds(30, 120, 120, 25);

        voto2 = new JLabel("0", SwingConstants.CENTER);
        voto2.setBorder(border2);
        voto2.setBounds(30, 120, 120, 25);

        voto3 = new JLabel("0", SwingConstants.CENTER);
        voto3.setBorder(border2);
        voto3.setBounds(30, 120, 120, 25);

        //porcentajes 
        porcentaje1 = new JLabel("0%", SwingConstants.CENTER);
        porcentaje1.setBorder(border2);
        porcentaje1.setBounds(30, 150, 120, 25);

        porcentaje2 = new JLabel("0%", SwingConstants.CENTER);
        porcentaje2.setBorder(border2);
        porcentaje2.setBounds(30, 150, 120, 25);

        porcentaje3 = new JLabel("0%", SwingConstants.CENTER);
        porcentaje3.setBorder(border2);
        porcentaje3.setBounds(30, 150, 120, 25);

        //barras DE PROFRESO
        barra1 = new JProgressBar();
        barra1.setValue(0);
        barra1.setBounds(30, 180, 120, 25);

        barra2 = new JProgressBar();
        barra2.setValue(0);
        barra2.setBounds(30, 180, 120, 25);

        barra3 = new JProgressBar();
        barra3.setValue(0);
        barra3.setBounds(30, 180, 120, 25);

        panelSup = new JPanel();
        panelSup.setLayout(new GridLayout(1, 3));
        panelSup.setBounds(10, 10, 615, 100);

        ///::::::::::::::::::::::::::::::::::::::::::::::::presupuestos
        presupuesto1 = new JTextField("0", SwingConstants.CENTER);
        presupuesto1.setBorder(border2);

        presupuesto2 = new JTextField("0", SwingConstants.CENTER);
        presupuesto2.setBorder(border2);

        presupuesto3 = new JTextField("0", SwingConstants.CENTER);
        presupuesto3.setBorder(border2);

        //panel sur :::::::::::::
        JPanel panelsur1 = new JPanel();
        panelsur1.setLayout(new GridLayout(1, 3, 40, 0));
        panelsur1.setBorder(border3);
        panelsur1.setBounds(10, 380, 615, 50);

        //panel sur 2
        JPanel panelsur2 = new JPanel();
        panelsur2.setLayout(new GridLayout(2, 3, 10, 20));
        panelsur2.setBorder(border4);
        panelsur2.setBounds(10, 450, 615, 100);

        //componentes panel sur2;
        JLabel lb1 = new JLabel("Votos", SwingConstants.CENTER);
        JLabel lb2 = new JLabel("Presupuesto", SwingConstants.CENTER);
        lblvoto = new JLabel("", SwingConstants.CENTER);
        lblvoto.setBorder(border2);

        lblpresupuesto = new JLabel("", SwingConstants.CENTER);
        lblpresupuesto.setBorder(border2);

        BtnReiniciar = new JButton("Reiniciar");

        //panel contenedor de 3 paneles
        panelVotar = new JPanel();
        panelVotar.setLayout(new GridLayout(1, 2, 40, 2));
        panelVotar.setBounds(10, 120, 615, 250);

        panel2Votar = new JPanel();
        panel2Votar.setLayout(null);

        panel3Votar = new JPanel();
        panel3Votar.setLayout(null);

        panel4Votar = new JPanel();
        panel4Votar.setLayout(null);

        //titulo de caja1
        border1 = new TitledBorder(new EtchedBorder(), "Indique la fuente de información");

        //CHECk BOX
        caja1 = new JCheckBox("Publicidad por Radio");
        caja2 = new JCheckBox("Publicidad por Prensa");
        caja3 = new JCheckBox("Publicidad por Television");

        // panel checkbox
        panelSup.add(caja1);
        panelSup.add(caja2);
        panelSup.add(caja3);
        panelSup.setBorder(border1);

        //agregar componetes panel verde
        panel2Votar.add(image1);
        panel2Votar.add(BtnVotar1);
        panel2Votar.add(voto1);
        panel2Votar.add(porcentaje1);
        panel2Votar.add(barra1);
        panel2Votar.setBorder(border2);

        panel3Votar.add(image2);
        panel3Votar.add(BtnVotar2);
        panel3Votar.add(voto2);
        panel3Votar.add(porcentaje2);
        panel3Votar.add(barra2);
        panel3Votar.setBorder(border2);

        panel4Votar.add(image3);
        panel4Votar.add(BtnVotar3);
        panel4Votar.add(voto3);
        panel4Votar.add(porcentaje3);
        panel4Votar.add(barra3);
        panel4Votar.setBorder(border2);

        //Agregar a panel 3 paneles
        panelVotar.add(panel2Votar);
        panelVotar.add(panel3Votar);
        panelVotar.add(panel4Votar);
//:::::::::::::::::::::::
        panelsur1.add(presupuesto1);
        panelsur1.add(presupuesto2);
        panelsur1.add(presupuesto3);

        panelsur2.add(lb1);
        panelsur2.add(lblvoto);
        panelsur2.add(BtnReiniciar);
        panelsur2.add(lb2);

        panelsur2.add(lblpresupuesto);

        //agregar al contenedor
        principal.add(panelSup);
        principal.add(panelVotar);
        principal.add(panelsur1);
        principal.add(panelsur2);

    }

    public void arrancar() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pack();
                    setSize(645, 600);
                    setResizable(false);
                    setVisible(true);
                    setLocationRelativeTo(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    public JButton getVotar1() {
        return BtnVotar1;
    }

    public JButton getVotar2() {
        return BtnVotar2;
    }

    public JButton getVotar3() {
        return BtnVotar3;
    }

    public JButton getReiniciar() {
        return BtnReiniciar;
    }
    
    public JTextField getPressupuesto1(){
    
    return presupuesto1;
    }
    
     public JTextField getPressupuesto2(){
    
    return presupuesto2;
    }
      public JTextField getPressupuesto3(){
    
    return presupuesto3;
    }

    public void Persona1(int txti1, int txti2, int txti3) {
        voto1.setText(String.valueOf(" " + txti1));
        voto2.setText(String.valueOf(" " + txti2));
        voto3.setText(String.valueOf(" " + txti3));
    }
   

    public void Persona2(int inc) {
        lblvoto.setText(" " + inc);
    }
    DecimalFormat df = new DecimalFormat("##.#");

    public void Persona3(int inc, double pm1, double pm2, double pm3) {
        porcentaje1.setText("" + df.format(pm1) + "%");
        barra1.setValue((int) pm1);
        porcentaje2.setText("" + df.format(pm2) + "%");
        barra2.setValue((int) pm2);
        porcentaje3.setText("" + df.format(pm3) + "%");
        barra3.setValue((int) pm3);
    }
    
    public void Presupuestos(float total){
    
    lblpresupuesto.setText(String.valueOf(total));
    
    
    }

    public void Reiniciar(int txti1, int txti2, int txti3, int inc, double r1, double r2, double r3) {
        voto1.setText(String.valueOf(" " + txti1));
        voto2.setText(String.valueOf(" " + txti2));
        voto3.setText(String.valueOf(" " + txti3));
        lblvoto.setText(" " + inc);
        porcentaje1.setText("" + df.format(r1) + "%");
        barra1.setValue((int) r1);
        porcentaje2.setText("" + df.format(r2) + "%");
        barra2.setValue((int) r2);
        porcentaje3.setText("" + df.format(r3) + "%");
        barra3.setValue((int) r3);
        lblvoto.setText(null);
        presupuesto1.setText(null);
        presupuesto2.setText(null);
        presupuesto3.setText(null);
        lblpresupuesto.setText(null);
        
    }

    public void conectarControlador(Controlador controlador) {
        BtnVotar1.addActionListener(controlador);
        BtnVotar2.addActionListener(controlador);
        BtnVotar3.addActionListener(controlador);
        BtnReiniciar.addActionListener(controlador);
        presupuesto1.addKeyListener(controlador);
         presupuesto2.addKeyListener(controlador);
          presupuesto3.addKeyListener(controlador);
        

    }

}
