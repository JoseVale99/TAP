
package practica_09;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Prueba {
   public static void main(String[] args) {
    
       
       for (int i = 0; i < 6; i++) {
           for (int j = 0; j < i; j++) {
               System.out.print("*");
           }
           System.out.print("\n");
       }
       
    }
}
