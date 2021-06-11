
package Vista;
import Controlador.ControladorGasolineria;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author josed
 */
public class VistaGas extends JFrame{
    JLabel titulo;
    JLabel [] tEstacion;//Titulo de la estacion;
    JLabel [] Imagenes1;//Imagenes de la estacion 1
    JLabel [] Imagenes2;//Imagenes de la estacion 2
    JLabel [] Imagenes3;//Imagenes de la estacion 1
    JPanel [] estacion;// Panel de cada estacion
    JProgressBar [] porcentaje;
    ButtonGroup G;
    ButtonGroup G2;
    ButtonGroup G3;
    JRadioButton [] gasolina1;//Diesel, Magma, Premium estacion 1
    JRadioButton [] gasolina2;//Diesel, Magma, Premium estacion 2
    JRadioButton [] gasolina3;//Diesel, Magma, Premium estacion 3
    String [] gasolinas= {"Diesel","Magna","Premium"};
    String [] montoLitros= {"Monto", "Litros"};
    String [] proveedores= {"G-500","Pemex","Efecticard" };
    JComboBox proveedor;
    JTextField [] IdEmpleado;
    JTextField [] monto1;//Monto Y litros estacion 1
    JTextField [] monto2;//Monto Y litros estacion 2
    JTextField [] monto3;//Monto Y litros estacion 3
    JTextField abastecer;//JtextField para abastecer
    JButton [] confirmar;//Bototn confirmar en cada estación
    JButton facturar;
    JButton salir;
    
    public VistaGas(){
    setSize(1380,700);
    setLayout(new BorderLayout());
    
    
    /*Titulo del panel*/
    JPanel norte= new JPanel();
    norte.setBackground(new Color(0, 0, 0));
    titulo= new JLabel("Estación de gas");
    titulo.setFont(new Font("Open Sans Extra Bold",Font.BOLD,20));
    titulo.setForeground(new Color(255,255,255));
    norte.add(titulo);
    /******************/
    /*Panel centro*/
    porcentaje= new JProgressBar[4];
    for(int i=0;i<=3;i++){
    porcentaje[i]= new JProgressBar();
    porcentaje[i].setPreferredSize(new Dimension(305,30));
    porcentaje[i].setBackground(new Color(253,249,222));
    }
    JPanel centro= new JPanel();
    centro.setPreferredSize(new Dimension(980,365));
    centro.setBackground(new Color(0, 0, 0));
    centro.add(getCentro());
    
    /**/
    /***********************************Panel Sur******************************/
    gasolina1= new JRadioButton[3];
    gasolina2= new JRadioButton[3];
    gasolina3= new JRadioButton[3];
    confirmar= new JButton[4];
    G = new ButtonGroup();
    G2= new ButtonGroup();
    G3= new ButtonGroup();
    IdEmpleado= new JTextField[3];
    for(int i=0;i<3;i++){
        gasolina1[i]=new JRadioButton(gasolinas[i]);
        gasolina1[i].setBackground(new Color(0,0,0));
        gasolina1[i].setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
        gasolina1[i].setForeground(Color.WHITE);
        gasolina2[i]=new JRadioButton(gasolinas[i]);
        gasolina2[i].setBackground(new Color(0,0,0));
        gasolina2[i].setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
        gasolina2[i].setForeground(Color.WHITE);
        gasolina3[i]=new JRadioButton(gasolinas[i]);
        gasolina3[i].setBackground(new Color(0,0,0));
        gasolina3[i].setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
        gasolina3[i].setForeground(Color.WHITE);
        G.add(gasolina1[i]);
        G2.add(gasolina2[i]);
        G3.add(gasolina3[i]);
        
        IdEmpleado[i]= new JTextField("IdEmpleado");
        IdEmpleado[i].setHorizontalAlignment(JTextField.CENTER);
        IdEmpleado[i].setPreferredSize(new Dimension(242,27));
        
        confirmar[i]= new JButton("Confirmar");
        confirmar[i].setPreferredSize(new Dimension(242,27));
        confirmar[i].setBackground(new Color(253,249,222));
        confirmar[i].setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));

    }
    /**Elementos de abastecer*/
        proveedor= new JComboBox(proveedores);
        proveedor.setPreferredSize(new Dimension(240,25));
        confirmar[3]= new JButton("Confirmar");
        confirmar[3].setPreferredSize(new Dimension(242,27));
        confirmar[3].setBackground(new Color(253,249,222));
        confirmar[3].setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
        abastecer= new JTextField("Litros", SwingConstants.CENTER);
        abastecer.setPreferredSize(new Dimension(240,25));
        abastecer.setHorizontalAlignment(JTextField.CENTER);   
    /************************/
    
    
    monto1= new JTextField[2];
    monto2= new JTextField[2];
    monto3= new JTextField[2];
    for(int x=0;x<2;x++){
        
        monto1[x]= new JTextField(montoLitros[x],SwingConstants.CENTER);
        monto1[x].setHorizontalAlignment(JTextField.CENTER);
        monto1[x].setPreferredSize(new Dimension(120,25));
        monto2[x]= new JTextField(montoLitros[x],SwingConstants.CENTER);
        monto2[x].setHorizontalAlignment(JTextField.CENTER);
        monto2[x].setPreferredSize(new Dimension(120,25));
        monto3[x]= new JTextField(montoLitros[x],SwingConstants.CENTER);
        monto3[x].setHorizontalAlignment(JTextField.CENTER);
        monto3[x].setPreferredSize(new Dimension(120,25));
    }
    facturar= new JButton("Facturar");
    facturar.setPreferredSize(new Dimension(242,27));
    facturar.setBackground(new Color(253,249,222));
    facturar.setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
    facturar.setActionCommand("Facturar");
    
    salir= new JButton("Salir");
    salir.setPreferredSize(new Dimension(242,27));
    salir.setBackground(new Color(253,249,222));
    salir.setFont(new Font("Open Sans Extra Bold",Font.BOLD,15));
    
    JPanel sur= new JPanel();
    //sur.setPreferredSize(new Dimension(980,250));
    sur.setBackground(new Color(0, 0, 0));
    sur.add(getSur());
    /**************************************************************************/
    add(norte, BorderLayout.NORTH);
    add(centro,BorderLayout.CENTER);
    add(sur,BorderLayout.SOUTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    public JPanel getCentro(){
        JPanel centro = new JPanel();
        centro.setPreferredSize(new Dimension(1350,365));
        centro.setLayout(new GridLayout(1,0,20,10));
        centro.setBackground(new Color(0, 0, 0));
        JPanel [] titulos= new JPanel[4];//Panel con los JLABEL de titulos
        JPanel [] imag = new JPanel[4];//Paneles con imagenes y barra de progreso
        
        estacion= new JPanel[4];//Estaciones de color rosa
        tEstacion= new JLabel[4];//titulos de cada JPnael Estacion 1,etc
        Imagenes1 =new JLabel[2];
        Imagenes2= new JLabel[2];
        Imagenes3= new JLabel[2];
        for(int j=0;j<2;j++){
            Imagenes1[j]= new JLabel("");
            
            Imagenes1[j].setPreferredSize(new Dimension(150,230));
            //Imagenes1[j].setBorder(BorderFactory.createLineBorder(Color.black));
            Imagenes2[j]= new JLabel("");
            Imagenes2[j].setPreferredSize(new Dimension(150,230));
            //Imagenes2[j].setBorder(BorderFactory.createLineBorder(Color.black));
            Imagenes3[j]= new JLabel("");
            
            Imagenes3[j].setPreferredSize(new Dimension(150,230));
           // Imagenes3[j].setBorder(BorderFactory.createLineBorder(Color.black));
        }
        //*******************
        JLabel imagen4= new JLabel("");//Imagen para la pipa de gas
        imagen4.setPreferredSize(new Dimension(150,230));
        //imagen4.setBorder(BorderFactory.createLineBorder(Color.black));
        imagen4.setIcon(new ImageIcon("src/imagenes/coche3.png"));
        //*******************
            for(int y=0;y<2;y++){
            if(y==0){    
            Imagenes1[y].setIcon(new ImageIcon("src/imagenes/coche0.png"));
            Imagenes2[y].setIcon(new ImageIcon("src/imagenes/coche1.png"));
            Imagenes3[y].setIcon(new ImageIcon("src/imagenes/coche2.png"));

            }else{
            Imagenes1[y].setIcon(new ImageIcon("src/imagenes/gas1.png"));
            Imagenes2[y].setIcon(new ImageIcon("src/imagenes/gas1.png"));
            Imagenes3[y].setIcon(new ImageIcon("src/imagenes/gas1.png"));
           
            
            }
            
            }
        
        for(int i=0;i<3;i++){
        tEstacion [i]= new JLabel("Estación "+ (i+1));
        tEstacion [i].setForeground(Color.BLACK);
        tEstacion [i].setFont(new Font("Open Sans Extra Bold",Font.BOLD,20));
        estacion[i]= new JPanel();
        estacion[i].setBorder(BorderFactory.createMatteBorder(1,3,3,3,Color.WHITE));
        imag[i]= new JPanel();//Paneles con imagenes y barra de progreso
        //imag[i].setBorder(BorderFactory.createLineBorder(Color.black));
        imag[i].setBackground(new Color(0,0,0));
        titulos[i]= new JPanel();
        titulos[i].setBackground(new Color(255,255,255));
        titulos[i].add(tEstacion[i]);
        
        estacion[i].setLayout(new BorderLayout());
        estacion[i].add(titulos[i],BorderLayout.NORTH);
        
        
        
        }
        //*****************************************
        tEstacion[3]= new JLabel("Abastecer");
        tEstacion[3].setForeground(Color.BLACK);
        tEstacion[3].setFont(new Font("Open Sans Extra Bold",Font.BOLD,20));
        estacion[3]= new JPanel();
        estacion[3].setBorder(BorderFactory.createMatteBorder(1,3,3,3,Color.WHITE));
        imag[3]= new JPanel();
        imag[3].setBackground(new Color(0,0,0));
        titulos[3]= new JPanel();
        titulos[3].setBackground(new Color(255,255,255));
        titulos[3].add(tEstacion[3]);
        estacion[3].setLayout(new BorderLayout());
        estacion[3].add(titulos[3],BorderLayout.NORTH);
        //*****************************************
        for(int x=0;x<2;x++){
            imag[0].add(Imagenes1[x]);
            imag[1].add(Imagenes2[x]);
            imag[2].add(Imagenes3[x]);
        }
        //************
        imag[3].add(imagen4);
        //****************
        
        for(int x=0;x<=3;x++){
            imag[x].add(porcentaje[x]);
            estacion[x].add(imag[x]);
            centro.add(estacion[x]);
        }
        return centro;
    
    }
    public JPanel getSur(){
        JPanel sur = new JPanel();// Sur contiene a datos
        sur.setPreferredSize(new Dimension(1350,200));
        sur.setLayout(new GridLayout(1,0,20,10));
        sur.setBackground(new Color(0,0,0));
        
        JPanel todoSur= new JPanel();//Panel que contiene a sur, es decir todo 
        todoSur.setLayout(new BorderLayout());
        todoSur.setBackground(new Color(0,0,0));
      
        JPanel Salir= new JPanel();//Panel pie, contiene a los botones Facturar y Salir
        Salir.setLayout(new BorderLayout());
        Salir.setBackground(new Color(0,0,0));
        
        JPanel extra= new JPanel();
        extra.setBackground(Color.BLACK);
        
        JPanel [] datos= new JPanel[4];//datos es el JPanel dividido en GridLayout(4,1) que alberga los elementos
        JPanel [] elementos1= new JPanel[4];//Cada panel se dividie en 4, los chechbox,los montos, el idEmpleado y el boton confirmar
        JPanel [] elementos2= new JPanel[4];
        JPanel [] elementos3= new JPanel[4];
        JPanel [] elementos4= new JPanel[4];

        
        
        for(int i=0;i<=3;i++){
            //Panel para cada estacion
            datos[i]= new JPanel();
            datos[i].setLayout(new GridLayout(0,1));
            datos[i].setBackground(new Color(0,0,0));
            datos[i].setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.WHITE));
            //Paneles de cada dato
            elementos1[i]= new JPanel();
            elementos1[i].setBackground(new Color(0,0,0));
            elementos2[i]= new JPanel();
            elementos2[i].setBackground(new Color(0,0,0));
            elementos3[i]= new JPanel();
            elementos3[i].setBackground(new Color(0,0,0));
            elementos4[i]= new JPanel();
            elementos4[i].setBackground(new Color(0,0,0));
        }
        //datos[3]= new JPanel();
        //datos[3].setLayout(new GridLayout(0,1));
        //datos[3].setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLACK));
        //datos[3].setBackground(new Color(255,255,255));    
        /*Nota. Revisar este for con los datos*/
        for(int x=0;x<3;x++){
            elementos1[0].add(gasolina1[x]);
            elementos2[0].add(gasolina2[x]);
            elementos3[0].add(gasolina3[x]);            
        }
            elementos4[0].add(proveedor);
        for(int x=0;x<2;x++){
        elementos1[1].add(monto1[x]);
        elementos2[1].add(monto2[x]);
        elementos3[1].add(monto3[x]);
        }
        
        
        /**Se agregan los botones confirmar y los JTextField Empleado*/
        for(int z=0;z<3;z++){
        elementos1[2].add(IdEmpleado[0]);
        elementos1[3].add(confirmar[0]);
        elementos2[2].add(IdEmpleado[1]);      
        elementos2[3].add(confirmar[1]);
        elementos3[2].add(IdEmpleado[2]);
        elementos3[3].add(confirmar[2]);
        elementos4[2].add(abastecer);
        elementos4[3].add(confirmar[3]);
        }
        //Cada panel de datos se divide en 4, por tanto alberga los 4 subpaneles nombrados como elementos
        for(int z=0;z<=3;z++){
        datos[0].add(elementos1[z]);
        datos[1].add(elementos2[z]);
        datos[2].add(elementos3[z]);
        datos[3].add(elementos4[z]);
        sur.add(datos[z]);//Se agrega todos los paneles de datos a sur
        }
        Salir.add(extra, BorderLayout.NORTH);
        Salir.add(facturar,BorderLayout.WEST);
        Salir.add(salir, BorderLayout.EAST);
        
        todoSur.add(sur,BorderLayout.CENTER);
        todoSur.add(Salir,BorderLayout.SOUTH);
        //sur.add(datos[3]);
        return todoSur;
    }
       public void cC (ControladorGasolineria c){
       salir.addActionListener((ActionListener) c); 
       facturar.addActionListener((ActionListener) c);
   }
}