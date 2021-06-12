
package biblioteca;

public class prueba {
 
    
    public static void main(String[] args) {
        // TODO code application logic here
        ModeloBiblioteca modelo = new ModeloBiblioteca("dbbiblioteca");

VistaBiblioteca vista  = new VistaBiblioteca();

ControladorBiblioteca controlador  = new ControladorBiblioteca(vista, modelo);
vista.conectaControlador(controlador);
 
    } // cerrar main
}
