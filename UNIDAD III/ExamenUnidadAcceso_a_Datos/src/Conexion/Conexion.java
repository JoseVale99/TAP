
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    public Conexion() {
    }

    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/supermercado", "root", "123456789");
            System.out.println("Se concecto Correctamente ");

        } catch (Exception e) {
            System.err.println("Hubo un error en la instalacion " + e);
        }
        return conexion;
    }
}
