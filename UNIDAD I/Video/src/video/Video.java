package video;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class Video extends JFrame{
    private JPanel p0,p1,p2,p3,p4;
    private JPanel p11,p12,p13,p14;
    private JPanel p41;
    private JPanel p31,p32;
    private JPanel p21,p22;
    private JButton b1,b2,b3,b4;
    private JLabel lb11,lb12,lb13,lb14,lb15;
    private JLabel P3_lb1,P3_lb2,P3_lb3;
    private JLabel lb21,lb22,lb23,lb24;
    private JTextField t11,t12;
    private JTextField t21,t22,t23,t24;
    private JComboBox box1,box2;
    private JCheckBox cb1,cb2;
    private JDateChooser fecha1 ;
    private final  Border border = new TitledBorder(new EtchedBorder(Color.BLACK, Color.black),"Dirección");
    private final  Border border2 = new TitledBorder(new EtchedBorder(Color.BLACK, Color.black),"Abscripción");
    private final String [] array={"Dpto de sistemas","Dpto ing industrial"};

    
    
    public Video(){
        setResizable(false);
        iniciarComponentes();// Metodo que inicia los componentes
        //se establecen las caracteristicas de la ventana
       
        setTitle("Registro de personal");//titulo 
        
       

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//cierra la ejecucion del programa
    
    }
    
    public void iniciarComponentes(){
        p0= new JPanel();
        p0.setLayout(new GridLayout(4,1));

        p1= Panel1();
        p1.setBackground(Color.BLACK);
        


        p2= Panel2();
        p2.setBackground(Color.WHITE);
        p3= Panel3();
        p3.setBorder(border2);
        p3.setBackground(Color.white);
        p4= Panel4();
        

        p0.add(p1); p0.add(p2); p0.add(p3); p0.add(p4);
        add(p0);
    
    }
    
    public JPanel Panel1(){
        p1  = new JPanel();
        p1.setLayout(null);
        p13= new JPanel();
        p13.setLayout(null);
        p13.setBounds(300, 0, 400, 175);
        p13.setBackground(Color.white);
        p14= new JPanel();
        

        p14.setBackground(Color.white);
        p14.setBounds(700, 0, 200, 200);

        p11 = new JPanel();    
        p11.setSize(200, 200);
        p11.setBackground(Color.white);


        p12 = new JPanel();
        p12.setLayout( new GridLayout(3,1));
        p12.setBounds(200, 0, 100, 175);
        p12.setBackground(Color.white); 

        lb11= new JLabel();
        lb11.setForeground(Color.BLACK);
        lb11.setIcon(new ImageIcon ("src/apoyo.png"));
        lb11.setBounds(100, 100, 50, 50);
        lb11.setPreferredSize(new Dimension(80,80));
        lb12= new JLabel("Apellidos: ",SwingConstants.CENTER);
        lb13= new JLabel("Nombre: ",SwingConstants.CENTER);
        lb14= new JLabel("Sexo: ",SwingConstants.CENTER);
        lb15= new JLabel ();
        lb15.setIcon(new ImageIcon ("img/cerrar.png"));
        lb15.setBounds(100, 100, 50, 50);
        lb15.setPreferredSize(new Dimension(80,80));
        t11=new JTextField(20);
        t11.setBounds(0, 20, 300, 20);
        t12=new JTextField(20);
        t12.setBounds(0, 78, 300, 20);
        cb1= new JCheckBox("Mujer");
        cb2= new JCheckBox("Hombre");
        cb1.setBounds(0, 120, 100, 50);
        cb2.setBounds(120, 120, 100, 50);
        cb1.setBackground(Color.white);
        cb2.setBackground(Color.white);


        p11.add(lb11);
        p12.add(lb12);p12.add(lb13);p12.add(lb14);    
        p13.add(t11);p13.add(t12);p13.add(cb1);p13.add(cb2);
        p14.add(lb15);
       

        p1.add(p11);p1.add(p12);p1.add(p13);p1.add(p14);
        return p1;    
    }
    
    public JPanel Panel2(){
        p2 = new JPanel();
        p21= new JPanel();
        p21.setBackground(Color.WHITE);
        p22= new JPanel();
        p22.setBackground(Color.WHITE);
        

        lb21= new JLabel("Calle ",SwingConstants.CENTER);
        lb21.setPreferredSize(new Dimension(150,50));
        lb22= new JLabel("Número ",SwingConstants.CENTER);
        lb22.setPreferredSize(new Dimension(150,50));
        lb23= new JLabel("Colonia ",SwingConstants.CENTER);
        lb23.setPreferredSize(new Dimension(150,50));
        lb24= new JLabel("Ciudad ",SwingConstants.CENTER);
        lb24.setPreferredSize(new Dimension(150,50));
        t21 = new JTextField(25);
        t22 = new JTextField(25);
        t23 = new JTextField(25);
        t24 = new JTextField(25);

        p2.add(p21);p2.add(p22);
        p2.setLayout(new GridLayout(1,2));
        p2.setBorder(border);

        
        p21.add(lb21);p21.add(t21);p22.add(lb22);p22.add(t22);
        p21.add(lb23);p21.add(t23);p22.add(lb24);p22.add(t24);
       
        return p2;
    }
    
    public JPanel Panel3(){
     
        p3= new JPanel();
        p3.setLayout(new GridLayout(1,2));

        p31= new JPanel();
        p31.setLayout(null);
        p31.setBackground(Color.white);
        //p31.setBorder(border);
        
        
        P3_lb1= new JLabel("Departamento",SwingConstants.CENTER);
        P3_lb2= new JLabel("Puesto",SwingConstants.CENTER);
        P3_lb3= new JLabel("Fecha de ingreso",SwingConstants.CENTER);
        P3_lb3.setPreferredSize(new Dimension(150,50));
        P3_lb1.setBounds(50, 20, 100, 20);
        P3_lb2.setBounds(31, 70, 100, 20);
        fecha1= new JDateChooser();

        box1= new JComboBox(array);
        box1.setPreferredSize(new Dimension(500,500));
        box1.setBounds(200, 20, 150, 20);
        box2= new JComboBox(new String[]{"ComboBox"});
        box2.setBounds(200, 70, 150, 20);
        p31.add(P3_lb1);p31.add(box1);p31.add(P3_lb2);p31.add(box2);
        

        p32= new JPanel();
        p32.setBackground(Color.WHITE);

        p32.add(P3_lb3);p32.add(fecha1);
        p3.add(p31);p3.add(p32);

        return p3;
    }
    
    public JPanel Panel4(){
        p4= new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.RIGHT));


        p41= new JPanel();
        p41.setPreferredSize(new Dimension(350,80));
        p41.setLayout(new GridLayout(1,4));
        p4.setBackground(Color.WHITE);

        b1= new JButton();
        b1.setPreferredSize(new Dimension(20,20));

        b2= new JButton();
        b2.setPreferredSize(new Dimension(20,20));

        b3= new JButton();
        b3.setPreferredSize(new Dimension(20,20));

        b4= new JButton();
        b4.setPreferredSize(new Dimension(20,20));
        b1.setIcon(new ImageIcon ("img/agregar.png"));
        b1.setBackground(new Color(133,190,255));
        b2.setIcon(new ImageIcon ("img/editar.png"));
        b2.setBackground(Color.WHITE);
        b3.setIcon(new ImageIcon ("img/buscar.png"));
        b3.setBackground(Color.WHITE);
        b4.setIcon(new ImageIcon ("img/compartimiento.png"));
        b4.setBackground(Color.WHITE);
        p41.add(b1);p41.add(b2);p41.add(b3);p41.add(b4);
        p4.add(p41);
        return p4;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
      Video a = new Video();
    a.setSize(900,700);//tamaño de la ventana
       a.setLocationRelativeTo(null);//alinea la ventana en medio de la pantalla
        a.setVisible(true);//muestra la pantalla
    }
    
}
