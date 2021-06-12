
package com_BarraHerramientas;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class BarraHerramientas extends JPanel implements  ActionListener{
    private MiBoton [] botones;
  
    public BarraHerramientas(){
        
        setDimensionPanel(1,0,8,0);
        botones= new MiBoton[0];
        for(int i=0;i<botones.length;i++){
            botones[i]= new MiBoton();
            add(botones[i]);
            
        }
        
    }
  
    public BarraHerramientas(MiBoton [] botones){
        setBotones(botones);
        setDimensionPanel(1,0,8,0);
        for(int i=0;i<botones.length;i++){
            add(botones[i]);
            
        }
    }
    public void setDimensionPanel(int f, int c, int x, int y){
        setLayout(new GridLayout(f, c, x, y));
    }
    public void setBotones(MiBoton [] botones){
        this.botones= botones;
        
    }
    public void agregarBoton(MiBoton boton){
        MiBoton [] aux=this.botones;
        botones= new MiBoton[aux.length+1];
        for(int i=0;i<aux.length;i++){
            botones[i]=aux[i];
            
        }
        botones[aux.length]=(boton);
        add(boton);
    }
    public MiBoton[] getBotones(){
        return botones;
    }
       public void setOrientationO(String h){
           System.out.println(""+h);  
  // setLayout(new GridLayout(0,getBotones().length));
        
    }
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
