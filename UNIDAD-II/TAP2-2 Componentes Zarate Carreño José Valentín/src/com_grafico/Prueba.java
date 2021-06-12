
package com_grafico;
import javax.swing.JFrame;

public class Prueba {
     public static void main(String[] args) {
     
        JFrame f = new JFrame();
        String title = "MUESTRA DE VALORES";
        String Leyenda[] = {"C#", "Kotlin", "C++", "Python","Java"};
        Grafico graf = new Grafico(title, Leyenda);
        int altura[]={10, 20, 30, 50,70};
                graf.setValores(altura);
        f.setVisible(true);
        f.add(graf);
        
    
        
        f.setSize(640, 530);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
}
