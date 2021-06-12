package ModeloControlador;

import ModeloVista.Vista;
import ModeloVotacion.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
public class Controlador implements ActionListener, KeyListener {

    int inc = 0;
    int i1 = 0, i2 = 0, i3 = 0;
    private final Vista v;
    private final Modelo modelo;

    public Controlador(Vista v, Modelo modelo) {
        this.v = v;
        this.modelo = modelo;
    }

    public void actionPerformed(ActionEvent ae) {


        if (v.getVotar1().equals(ae.getSource())) {
            inc++;
            i1++;
            v.Persona1(i1, i2, i3);
            v.Persona2(inc);
        } else if (v.getVotar2() == ae.getSource()) {
            inc++;
            i2++;
            v.Persona1(i1, i2, i3);
            v.Persona2(inc);
        } else if (v.getVotar3() == ae.getSource()) {
            inc++;
            i3++;
            v.Persona1(i1, i2, i3);
            v.Persona2(inc);
        }
        Double r1 = modelo.Operacion1(inc, i1);
        Double r2 = modelo.Operacion2(inc, i2);
        Double r3 = modelo.Operacion3(inc, i3);
        v.Persona3(inc, r1, r2, r3);
        if (v.getReiniciar()== ae.getSource()) {
            inc = 0;
            i1 = 0;
            i2 = 0;
            i3 = 0;
            r1 = 0.0;
            r2 = 0.0;
            r3 = 0.0;
            v.Reiniciar(i1, i2, i3, inc, r1, r2, r3);
        }

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent ke) {

        float suma = 0;
        if (v.getPressupuesto1() == ke.getSource()|| v.getPressupuesto2() == ke.getSource() || v.getPressupuesto3() == ke.getSource()) {
            try {
                float n1 = Float.valueOf( v.getPressupuesto1().getText());
                float n2 = Float.valueOf( v.getPressupuesto2().getText());
                float n3 = Float.valueOf( v.getPressupuesto3().getText());

                suma = modelo.CalcularPresuouesto(n1, n2, n3);
                
                v.Presupuestos(suma);

            } catch (Exception e) {
            
            }
        }
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent ke) {


    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent ke) {

    }
}
