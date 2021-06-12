
package practica_05;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import polinomio.Polinomio;

public class App extends javax.swing.JFrame {
private int MAX_NUM_COEF = 6;
    private Polinomio polinomio;
    private double[] coef;
    private boolean calculo;
    private JFreeChart grafico;
   
    
    public App() {
        //super(parent, modal);
        initComponents();
        coef = new double[MAX_NUM_COEF];
        calculo = true;
        a0.setText("0.0");
        a1.setText("0.0");
        a2.setText("0.0");
        a3.setText("0.0");
        a4.setText("0.0");
        a5.setText("0.0");
        vInicial.setText("0.0");
        vFinal.setText("0.0");
        vInc.setText("0.0");
        
    }

 

      private void closeDialog(java.awt.event.WindowEvent evt) {                             
        setVisible(false);
        dispose();
    } 
    
       public double valor(Number numero) {
        double val = (double) numero;
        return val;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        label4 = new java.awt.Label();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        a0 = new javax.swing.JTextField();
        a1 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        a4 = new javax.swing.JTextField();
        a5 = new javax.swing.JTextField();
        BtnCalcular = new javax.swing.JButton();
        raices = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        vInicial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        vFinal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        vInc = new javax.swing.JTextField();
        BtnCrearGrafico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        label5.setText("Calculo y Graficación de Polinomios");
        label5.setVisible(false);
        jPanel1.add(label5);
        label5.setBounds(68, 0, 0, 0);

        label4.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        label4.setText("Cálculo y Graficación de Polinomios");
        jPanel1.add(label4);
        label4.setBounds(30, 40, 587, 55);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("a");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(80, 138, 13, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("a");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 172, 13, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("a");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(80, 212, 13, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("a");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 249, 13, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setText("a");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 290, 13, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("a");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 330, 13, 30);

        jLabel14.setText("0");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(99, 148, 20, 16);

        jLabel13.setText("1");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(99, 183, 20, 16);

        jLabel12.setText("2");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(100, 230, 20, 16);

        jLabel11.setText("3");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 270, 20, 16);

        jLabel10.setText("4");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(100, 310, 20, 16);

        jLabel9.setText("5");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 350, 20, 16);

        a0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a0ActionPerformed(evt);
            }
        });
        a0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a0KeyReleased(evt);
            }
        });
        jPanel1.add(a0);
        a0.setBounds(131, 144, 160, 24);

        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        a1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a1KeyReleased(evt);
            }
        });
        jPanel1.add(a1);
        a1.setBounds(131, 179, 160, 24);

        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        a2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a2KeyReleased(evt);
            }
        });
        jPanel1.add(a2);
        a2.setBounds(131, 219, 160, 24);

        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        a3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a3KeyReleased(evt);
            }
        });
        jPanel1.add(a3);
        a3.setBounds(131, 256, 160, 24);

        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });
        a4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a4KeyReleased(evt);
            }
        });
        jPanel1.add(a4);
        a4.setBounds(131, 298, 160, 24);

        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });
        a5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                a5KeyReleased(evt);
            }
        });
        jPanel1.add(a5);
        a5.setBounds(130, 340, 160, 24);

        BtnCalcular.setText("Calcular");
        BtnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCalcularActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCalcular);
        BtnCalcular.setBounds(20, 390, 100, 32);

        raices.setText("0");
        raices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raicesActionPerformed(evt);
            }
        });
        jPanel1.add(raices);
        raices.setBounds(140, 390, 480, 30);

        jLabel1.setText("Incremento:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 440, 70, 30);
        jPanel1.add(vInicial);
        vInicial.setBounds(220, 440, 70, 24);

        jLabel15.setText("Valor Inicial");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(140, 440, 80, 30);

        vFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vFinalActionPerformed(evt);
            }
        });
        jPanel1.add(vFinal);
        vFinal.setBounds(380, 440, 80, 24);

        jLabel16.setText("Valor Final:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(310, 440, 70, 30);
        jPanel1.add(vInc);
        vInc.setBounds(560, 440, 60, 24);

        BtnCrearGrafico.setText("Crear Grafico");
        BtnCrearGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearGraficoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCrearGrafico);
        BtnCrearGrafico.setBounds(250, 490, 130, 32);

        jLabel2.setText("Graficar");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 436, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCalcularActionPerformed
       
        String tRaices = ""; //  texto a mostrar de las raices
        double vRaices[] = null; // valores de las raices
        double coefs[] = null; // valores de los coeficientes
        int nRaices = 0; // número de raices obtenidas
        int nCoef = 0; // número de coeficientes
        polinomio = new Polinomio();
        // valida que sean los coeficientes minimos para una ecuación lineal
       calculo =true; //verificaValores();
        if (calculo) {
            nCoef =2;
          
           vRaices = new double[1];
            if (coef[2] != 0) {
               vRaices = new double[4];
                nCoef++;
               
            }
            if (coef[3] != 0) {
                
               vRaices = new double[3];
                nCoef++;
            }
            if (coef[4] != 0) {
                vRaices = new double[4];
                nCoef++;
            }
            if (coef[5] != 0) {
               vRaices = new double[5];
                nCoef++;
            }
            coefs = new double[nCoef];
            for (int c = 0; c < nCoef; c++) {
                coefs[c] = coef[c];
            
            }
            // se fijan los valores de los coeficientes
            polinomio.setCoeficiente(coefs);
            System.err.println(polinomio.getCoeficiente().toString());
            System.err.println(polinomio.getPolinomio());
           
            try {
                vRaices = polinomio.getRaices();
               // System.out.print(vRaices);
                nRaices = polinomio.getRaices().length;
               // System.out.print(nRaices);
            } catch (Exception ex) {
             //  Logger.getLogger(App.class.getName()).long(Level.SEVERE, null, ex);
            }
        
            if (polinomio.getGrado() == 1) {
               
                tRaices = String.format(" X= %6.4f", vRaices[0]);
            } else if (polinomio.getGrado() == 2) {
                if (nRaices == 2) {
                    tRaices = String.format(" X0= %6.4f, X1= %6.4f", vRaices[0], vRaices[1]);
                    System.err.println("entra acccacaca");
                } else {
                    tRaices = String.format(" X0= %6.4f + i %6.4f\t      X1= %6.4f - i %6.4f\t", vRaices[0], vRaices[1], vRaices[0], vRaices[1]);
                }
            } else if (polinomio.getGrado() > 2) {
                for (int r = 0; r < nRaices; r++) {
                    tRaices += String.format("  X[%5d]= %6.4f", r, vRaices[r]);
                }
            }
       }
        if (tRaices != "") {
            raices.setText(tRaices);
            vInicial.setEditable(true);
         //   vFinal.setEditable(true);
            vInc.setEditable(true);
        }
    }//GEN-LAST:event_BtnCalcularActionPerformed

    private void raicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raicesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raicesActionPerformed

    private void vFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vFinalActionPerformed

    private void a0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a0ActionPerformed
           // TODO add your handling code here:
//          
//        coef[0] = valor((Number)Double.parseDouble(a0.getText()));
//        if (coef[0] == 0.0) {
//            a0.requestFocus();
//            JOptionPane.showMessageDialog(this, "El valor del coeficiente a0 debe ser != 0");
//        } else {
//            a1.requestFocus();
//        }
    }//GEN-LAST:event_a0ActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
//       coef[1] = valor((Number) Double.parseDouble(a1.getText()));
//        if (coef[1] == 0.0) {
//            a1.requestFocus();
//            JOptionPane.showMessageDialog(this, "El valor del coeficiente a1 debe ser != 0");
//        } else {
//            a2.requestFocus();
//        }
    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
//       coef[2] = valor((Number) Double.parseDouble(a2.getText()));
//        if (coef[2] == 0.0) {
//            a2.requestFocus();
//            JOptionPane.showMessageDialog(this, "El valor del coeficiente a2 debe ser != 0");
//        } else {
//            a3.requestFocus();
//        }
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
     coef[3] = valor((Number) Double.parseDouble(a3.getText()));
        if (coef[3] == 0.0) {
            a2.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor del coeficiente a3 debe ser != 0");
        } else {
            a3.requestFocus();
        }
    }//GEN-LAST:event_a3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
      coef[4] = valor((Number) Double.parseDouble(a4.getText()));
        if (coef[4] == 0.0) {
            a2.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor del coeficiente a4 debe ser != 0");
        } else {
            a3.requestFocus();
        }
    }//GEN-LAST:event_a4ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5ActionPerformed
      coef[5] = valor((Number) Double.parseDouble(a5.getText()));
        if (coef[5] == 0.0) {
            a2.requestFocus();
            JOptionPane.showMessageDialog(this, "El valor del coeficiente a5 debe ser != 0");
        } else {
            a3.requestFocus();
        }
    }//GEN-LAST:event_a5ActionPerformed

    private void BtnCrearGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearGraficoActionPerformed
        if (valor((Number) Double.parseDouble(vInicial.getText())) != 0 && valor((Number)
                Double.parseDouble(vFinal.getText())) != 0 && valor((Number)
                        Double.parseDouble(vInc.getText())) != 0) {
            XYSeries serieXY = new XYSeries("y=f(x)");
            double vf = valor((Number) Double.parseDouble(vFinal.getText()));
            double vi = valor((Number)  Double.parseDouble(vInicial.getText()));
            double inc = valor((Number) Double.parseDouble(vInc.getText()));
            while (vi < vf) {
                serieXY.add(vi, polinomio.getY(vi));
                vi += inc;
            }
            XYDataset datosXY = new XYSeriesCollection(serieXY);
            grafico = ChartFactory.createXYLineChart("y=" + polinomio.getPolinomio(), "X", "Y", 
                    datosXY, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame fgrafico = new ChartFrame("", grafico);
            fgrafico.setVisible(true);
            fgrafico.setSize(800, 500);
        }
    }//GEN-LAST:event_BtnCrearGraficoActionPerformed

    private void a0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a0KeyReleased
     try{
        coef[0] = valor((Number)Double.parseDouble(a0.getText()));
     }catch(Exception e){}
    }//GEN-LAST:event_a0KeyReleased

    private void a1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a1KeyReleased
        try {
             coef[1] = valor((Number) Double.parseDouble(a1.getText()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_a1KeyReleased

    private void a2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a2KeyReleased
        try {
            coef[2] = valor((Number) Double.parseDouble(a2.getText()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_a2KeyReleased

    private void a3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a3KeyReleased
        try {
             coef[3] = valor((Number) Double.parseDouble(a3.getText()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_a3KeyReleased

    private void a4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a4KeyReleased
        try {
             coef[4] = valor((Number) Double.parseDouble(a4.getText()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_a4KeyReleased

    private void a5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_a5KeyReleased
        try {
             coef[5] = valor((Number) Double.parseDouble(a5.getText()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_a5KeyReleased

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new App().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCalcular;
    private javax.swing.JButton BtnCrearGrafico;
    private javax.swing.JTextField a0;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JTextField a4;
    private javax.swing.JTextField a5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private javax.swing.JTextField raices;
    private javax.swing.JTextField vFinal;
    private javax.swing.JTextField vInc;
    private javax.swing.JTextField vInicial;
    // End of variables declaration//GEN-END:variables
}
