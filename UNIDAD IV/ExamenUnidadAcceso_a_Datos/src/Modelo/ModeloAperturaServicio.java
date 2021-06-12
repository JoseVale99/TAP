
package Modelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

public class ModeloAperturaServicio  extends AbstractTableModel {
      private Connection conexion;
      
       String encabezados[] = new String[]{
        "No Empleado", " No caja", "apertura", "cierre"
    };
    Class tipos[] = new Class[]{
        Integer.class, Integer.class, Date.class, Date.class
    };
    Object datos[][];
    
        public ModeloAperturaServicio(String Usuario, String Contraseña) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/supermercado", Usuario, Contraseña);
            System.out.println("Se concecto Correctamente ");

        } catch (Exception e) {
            System.err.println("Hubo un error en la instalacion " + e);
        }
        actualizaEstatus();
    }
    
    
    
    
      // solo los metodos getRowCount( ), getColumnCount( ),y  getValueAt( ) son requeridos
    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public String getColumnName(int c) {
        return encabezados[c];
    }

    @Override
    public Class getColumnClass(int c) {
        return tipos[c];
    }

    @Override
    public Object getValueAt(int r, int c) {
        return datos[r][c];
    }
    public int getTotal() {
        int contador = 0;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT*FROM EMPLEADO");
            while (rs.next()) {
                contador += 1;
            }
        } catch (Exception e) {

        }
        return contador;
    }

        public void actualizaEstatus() {

        datos = new Object[getTotal()][encabezados.length];

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *FROM APERTURASERVICIO");
            int contador = 0;
            while (rs.next()) {
                datos[contador][0] = rs.getInt(1);
                datos[contador][1] = rs.getInt(2);
                datos[contador][2] = rs.getDate(3);
                datos[contador][3] = rs.getDate(4);
              //  datos[contador][4] = rs.getDouble(5);

                contador += 1;
            }
        } catch (Exception e) {

        }

        //********************
//  usa el modelo de tabla creada por el usuario
        fireTableDataChanged();
    }
}
