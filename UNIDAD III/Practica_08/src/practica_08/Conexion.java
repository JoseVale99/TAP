package practica_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection coneccion; //contenida en el paquete sql
    private static Conexion conexion;// instacia a utilizar
    private static int numConexiones;//controla el numero de veces que se accedió

    private Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        try {
//Clase usada para una conexion con Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");
// para MySql : “com.mysql.jdbc.Driver”
//investiga cual es para postgreSql
            try {
                coneccion = (Connection) DriverManager.getConnection(url, usuario, password);
            } catch (SQLException ex) {

                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getConexion(String url, String usuario, String password) 
            throws ClassNotFoundException {
        numConexiones++;
        if (conexion == null) {
            conexion = new Conexion(url, usuario, password);
        }
        return conexion;
    }
    public static  Connection getConeccion(){
    return  coneccion;
    }
    
    public  boolean cerrarConexion(){
        try {
            if (coneccion != null){
            if(numConexiones==1){
            coneccion.close();
            return true;
            }
            else
            numConexiones--;
            return  false;
            
            }
        } catch (SQLException ex) {
            System.out.println("Error a tratar de cerrar la conexion "+ex);
        }
    return false;
    }
}
