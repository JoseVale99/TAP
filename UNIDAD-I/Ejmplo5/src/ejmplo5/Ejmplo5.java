package ejmplo5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Ejmplo5 extends JFrame {

    private JPanel panel;
    private JTextField txt;
    private JButton btnhola;
    private JButton btnadios;

    public Ejmplo5() {
        initComponents();

    }

    private void initComponents() {

        setSize(400, 200);
        txt = new JTextField(10);
        btnhola = new JButton("Hola");
        btnadios = new JButton("Adios");

        btnhola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt.setText("Hello!");
            }
        });

        btnadios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txt.setText("Bye!");
            }
        });
        panel = new JPanel();
        panel.add(this.txt);
        panel.add(this.btnhola);
        panel.add(this.btnadios);

        setContentPane(this.panel);

    }

    public static void main(String[] args) {

        Ejmplo5 e = new Ejmplo5();
        e.setDefaultCloseOperation(EXIT_ON_CLOSE);
        e.setVisible(true);

    }

}
