package com_grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Grafico extends JComponent implements Serializable {

    private int nfiguras; // numero de barras 
    private JLabel[] etis; // etiquetas para el valor a mostrar 
    private int[] vals = {10, 0, 0};//valores de cada barra, se dan valores por omision 
//Se consideran diez colores para diez valores 
    private static Color color[] = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.black,
         Color.RED, Color.YELLOW, Color.WHITE, Color.PINK, Color.MAGENTA};
    private static JLabel leyendaBarra[]; //muestra el titulo de la leyenda 
    private static JLabel colorB[]; // identificacion del color de la barras 
    private JLabel titulo; // titulo 
    private String tTitulo;// Texto del titulo 
    private String tLeyenda[];// titulos de las leyendas que idefican a cada barra 

    public Grafico() {
        //Ualores por omision 
        titulo = new JLabel("");
        etis = new JLabel[0];
        leyendaBarra = new JLabel[0];
        tLeyenda = new String[0];

    }

    public Grafico(String encabezado, String tLeyenda[]) {
        nfiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda; // texto de cada leyenda 
        leyendaBarra = new JLabel[tLeyenda.length];
        tTitulo = encabezado;
        setLeyendas(this.tLeyenda);
        iniciarElementos(); // metodo para iniciar los valores 
    }

    public void iniciarElementos() { // Creacion e inicio de los valores de cada barra 
        vals = new int[nfiguras];
        for (int nv = 0; nv < nfiguras; nv++) { //inicia los valores 
            vals[nv] = 0;
        }
        // crea y agrega la etiqueta del titulo
        titulo = new JLabel(tTitulo);
        add(titulo); // // crea e inicia los demas arreglos 
        etis = new JLabel[nfiguras]; // 
        colorB = new JLabel[nfiguras];
        for (int i = 0; i < nfiguras; i++) {
            etis[i] = new JLabel("" + 0);
            add(etis[i]);
        } //identificaion de color de cada barra colorB[]    
        for (int x = 0; x < nfiguras; x++) {
            colorB[x] = new JLabel();
            colorB[x].setBackground(color[x]);
            colorB[x].setForeground(color[x]);
            colorB[x].setOpaque(true);
            add(colorB[x]);
        }

    }

    public void setTitulo(String encabezado) {
        tTitulo = encabezado;
    }

    public void setLeyendas(String tLeyenda[]) {
        nfiguras = tLeyenda.length;
        this.tLeyenda = tLeyenda;
        leyendaBarra = new JLabel[tLeyenda.length];
        for (int e = 0; e < tLeyenda.length; e++) {
            leyendaBarra[e] = new JLabel(tLeyenda[e]);
        }
        iniciarElementos();
    }
    //metodo para asiganar la etiquetas y cambiar valores     

    public void setValores(int valores[]) {
        vals = valores;
        etis = new JLabel[vals.length];
        for (int v = 0; v < vals.length; v++) {
            etis[v] = new JLabel("" + valores[v]);
            add(etis[v]);
        }
    }

    @Override
    public void paintComponent(Graphics f) {
        int i;
        int j = 1;
        int ancho = getWidth();
        int alto = getHeight();

        titulo.setBounds((int) (getWidth() - f.getFontMetrics().stringWidth(titulo.getText())) / 2, 10,
         titulo.getText().length() * 8, 20);
        int separa = (int) (getWidth() / (nfiguras) * 0.20);
        int anchoB = (int) (getWidth() / (nfiguras) - separa);         //Ubica cada elemento en su posicion         

        //ubica cada uno de los elementos en su posicion
        for (i = 0; i < nfiguras; i++) {

            f.setColor(color[i]); //Establece el color de cada barra             
            etis[i].setBounds(separa + i * (anchoB + separa) + (anchoB / 2), 
            (alto - 20 * colorB.length) - vals[i] * 5 - etis[i].getHeight() - 2, 30, 20);
            f.fill3DRect(separa + i * (anchoB + separa), ((alto - 20 * colorB.length) - vals[i] * 5),
             anchoB, vals[i] * 5, true);

            
            colorB[i].setBounds(i * (anchoB + separa) + (anchoB / 4), 430, 30, 20);
            leyendaBarra[i].setBounds(separa + 10 + i * (anchoB + separa) + (anchoB / 2), 430, 80, 20);

            add(leyendaBarra[i]);
            j++;
        }
    }

}
