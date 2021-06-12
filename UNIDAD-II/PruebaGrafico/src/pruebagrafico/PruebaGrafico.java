package pruebagrafico;

import java.util.Random;
import com_grafico.Grafico;
import javax.swing.JFrame;

public class PruebaGrafico {

    public static void main(String[] args) {

        JFrame f = new JFrame();

        String title = "MUESTRA DE VALORES";
        String Leyenda[] = {"C#","Kotlin", "C++", "Python", "Java"};
        Grafico graf = new Grafico(title, Leyenda);
        Random rnd = new Random();

        int altura[] = new int[Leyenda.length];

        for (int i = 0; i < Leyenda.length; i++) {
            int valorDado = rnd.nextInt(70) + 1;
            altura[i] = valorDado;
            graf.setValores(altura);
            f.setVisible(true);
            f.add(graf);
        }
        f.setSize(640, 510);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
