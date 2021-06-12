
package ejemplo7;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
public class Ejemplo7 extends JFrame implements ItemListener{
    private BorderLayout border;
    private String [] array ={"jjsjs ","Halla","haya","hay"}; 
    
    private JComboBox<String> comboBox;
    private String [] cometiqueta={"dhhdd","jxjjd","kkss","skksks"};
    private JLabel etiqueta = new JLabel();
    
    
    
    public Ejemplo7(){
    super("Dmostraci+on de item LISTENER");
        setSize(350, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        comboBox = new JComboBox<String>(array);
        comboBox.addItemListener(this);
        
        add(comboBox,BorderLayout.NORTH);
        add(etiqueta, BorderLayout.SOUTH);
        setVisible(true);
        
        
    }

    
    
    
    
    public static void main(String[] args) {
        new Ejemplo7();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
      int eleccion = comboBox.getSelectedIndex();
    etiqueta.setText(cometiqueta[eleccion]);
    }
    
}
