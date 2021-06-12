package indicadoresSalud;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;
import javax.swing.*;

public class IndicadoresSalud extends JFrame {

    private JButton ciMC;
    private JButton cICC;
    private JButton borrar;
    private JLabel resultadoIMC;
    private JLabel resultadoICC;
    private JTextField edad;
    private JTextField estatura;
    private JTextField peso;
    private JTextField cadera;
    private JTextField cintura;
    private JRadioButton hombre;
    private JRadioButton mujer;
    private Container panel;

    public IndicadoresSalud() {
        super("IMC-ICC");
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        String patch = "/imagenes/IMC2.png";
        URL url = this.getClass().getResource(patch);
        ImageIcon icon = new ImageIcon(url);

        JLabel presentacion = new JLabel("INDICADORES BASICOS DE RIESGOS A LA SALUD", 
        icon, SwingConstants.CENTER);
        this.ciMC = new JButton("Calcular IMC");
        this.cICC = new JButton("Calcular ICC");
        this.edad = new JTextField(4);
        this.estatura = new JTextField(4);
        this.peso = new JTextField(4);
        this.resultadoIMC = new JLabel("_____________________ ");
        this.cintura = new JTextField(4);
        this.cadera = new JTextField(4);
        this.hombre = new JRadioButton("Hombre");
        this.mujer = new JRadioButton("Mujer");
        this.resultadoICC = new JLabel("_____________________ ");
        this.borrar = new JButton("Borrar Datos");
        JLabel tEdad = new JLabel(" Proporciona tu edad (>19):");
        JLabel tIMC = new JLabel("CÁLCULO DEL ÍNDICE DE MASA CORPORAL (IMC)");
        JLabel testatura = new JLabel("Estura (cms) : ");
        JLabel tpeso = new JLabel(" Peso(kgs.) : ");
        JLabel tiCC = new JLabel("CÁLCULO DEL INDICE DE CINTURA-CADERA (I-C-C)");
        JLabel tcintura = new JLabel(" Cintura (cms) : ");
        JLabel tcadera = new JLabel(" Cadera (cms) : ");
        JLabel sexo = new JLabel("       Sexo : ");

        presentacion.setHorizontalTextPosition(SwingConstants.CENTER);
        presentacion.setVerticalTextPosition(SwingConstants.TOP);
        panel.add(presentacion);
        panel.add(tEdad);
        panel.add(edad);
        panel.add(tIMC);
        panel.add(testatura);
        panel.add(estatura);
        panel.add(tpeso);
        panel.add(peso);
        panel.add(ciMC);
        panel.add(resultadoIMC);
        panel.add(tiCC);
        panel.add(tcintura);
        panel.add(cintura);
        panel.add(tcadera);
        panel.add(cadera);
        panel.add(sexo);
        panel.add(hombre);
        panel.add(mujer);
        panel.add(cICC);
        panel.add(resultadoICC);
        panel.add(borrar);
        ButtonGroup option = new ButtonGroup();
        option.add(hombre);
        option.add(mujer);

        setSize(320, 510);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ciMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                DecimalFormat df = new DecimalFormat("#.00");
                String resultado = "";

                JButton boton = (JButton) ae.getSource();

                if (edad.getText().isEmpty() || peso.getText().isEmpty() || estatura.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "¡Los campos estan vacios!", "ERROR", JOptionPane.WARNING_MESSAGE);

                } else {

                    if (boton == ciMC) {
                        if (isNumeric(edad.getText()) && isNumeric(peso.getText()) && isNumeric(estatura.getText())) {
                            Double mtsCms = Double.parseDouble(estatura.getText()) / 100.0;
                            Double pesoKgs = Double.parseDouble(peso.getText());
                            if (mtsCms < 1.40 || mtsCms > 2 || pesoKgs < 40 || pesoKgs > 160) {
                                JOptionPane.showMessageDialog(null, "Se requiere valores dentro del rango");
                            } else {
                                Double uIMC = pesoKgs / Math.pow(mtsCms, 2);
                                resultado = String.valueOf(df.format(uIMC));
                                resultadoIMC.setText(resultado);

                                if (Double.parseDouble(resultado) < 18.5) {
                                    resultadoIMC.setText(resultado + " => bajo de Peso");
                                } else if (Double.parseDouble(resultado) >= 18.5 && Double.parseDouble(resultado) <= 24.9) {
                                    resultadoIMC.setText(resultado + " => Peso normal ");
                                } else if (Double.parseDouble(resultado) >= 25 && Double.parseDouble(resultado) <= 29.9) {
                                    resultadoIMC.setText(resultado + " => Sobre Peso ");
                                } else {
                                    resultadoIMC.setText(resultado + " => Obesidad");

                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Se requiere valores numericos");
                        }
                    }

                }

            }

        });

        cICC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                DecimalFormat df = new DecimalFormat("#.00");
                JButton boton2 = (JButton) ae.getSource();
                String resICC = "";
                if (cintura.getText().toString().isEmpty() || cadera.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(boton2, "¡Los campos estan vacios!", "ERROR", 
                    JOptionPane.WARNING_MESSAGE);
                } else {
                    if (boton2 == cICC) {
                        if (isNumeric(cintura.getText()) && isNumeric(cadera.getText())) {
                            Double ICC = Double.parseDouble(cintura.getText()) / Double.parseDouble(cadera.getText());
                            resICC = String.valueOf(df.format(ICC));

                            if (hombre.isSelected()) {
                                if (Double.parseDouble(resICC) < 0.95) {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular BAJO");

                                } else if (Double.parseDouble(resICC) >= 0.95 && Double.parseDouble(resICC) <= 1.0) {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular MEDIO");
                                } else {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular ALTO");
                                }

                            } else {
                                if (Double.parseDouble(resICC) < 0.80) {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular BAJO");

                                } else if (Double.parseDouble(resICC) >= 0.80 && Double.parseDouble(resICC) <= 0.85) {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular MEDIO");
                                } else {

                                    resultadoICC.setText(resICC + " => Riesgo Cardiovascular ALTO");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Se requiere valores numericos");

                        }
                    }
                }
            }

        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton btnDelete = (JButton) ae.getSource();
               if (btnDelete == borrar) {
                edad.setText(null);
                peso.setText(null);
                estatura.setText(null);
                resultadoIMC.setText("_____________________ ");
                cintura.setText(null);
                cadera.setText(null);
                hombre.setSelected(false);
                mujer.setSelected(false);
                resultadoICC.setText("_____________________ ");
            }
            }
        });
        
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
