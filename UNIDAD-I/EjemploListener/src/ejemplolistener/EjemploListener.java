package ejemplolistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EjemploListener extends JFrame {

    private JPanel panel;
    private JTextField txtnumero;
    private JButton btnincrementar;

    public EjemploListener() {

        initComponents();

    }

    private void initComponents() {

        setSize(400, 200);
        txtnumero = new JTextField("0", 10);
        txtnumero.setEditable(false);
        btnincrementar = new JButton("Incrementar");

        btnincrementar.addMouseListener(new MyClickListener());
        panel = new JPanel();
        panel.add(this.txtnumero);
        panel.add(this.btnincrementar);

        setContentPane(this.panel);

    }

    private class MyClickListener extends MouseAdapter {

        private int numClicks;

        @Override
        public void mouseClicked(MouseEvent event) {
            numClicks++;
            txtnumero.setText(String.valueOf(this.numClicks));
        }

    }

    public static void main(String[] args) {
        EjemploListener e = new EjemploListener();

        e.setDefaultCloseOperation(EXIT_ON_CLOSE);
        e.setVisible(true);
    }

}
