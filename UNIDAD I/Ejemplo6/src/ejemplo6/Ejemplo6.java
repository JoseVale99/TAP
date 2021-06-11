package ejemplo6;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class Ejemplo6 extends JFrame implements ActionListener {

    private List<JButton> botones;
    private int indice;
    private JButton btnagregar;
    private JScrollPane scroll;
    private JPanel panel;

    public Ejemplo6() {

        iniciarcomponentes();
        botones = new ArrayList<>();
        indice = 0;

    }

    public void iniciarcomponentes() {
        btnagregar = new JButton("Agregar");
        panel = new JPanel();
        Container contenedor = getContentPane();
        panel.setLayout(new GridLayout(3, 0));
        scroll = new JScrollPane(panel);
        btnagregar.addActionListener(this);
        contenedor.add(btnagregar, BorderLayout.NORTH);
        contenedor.add(scroll, BorderLayout.CENTER);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton boton = new JButton("Boton " + indice);
        botones.add(boton);
        panel.add(boton);
        indice += 1;
        panel.updateUI();

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "presionaste el boton" + boton.getText());
            }
        });

    }

    public static void main(String[] args) {
        new Ejemplo6();
    }

}
