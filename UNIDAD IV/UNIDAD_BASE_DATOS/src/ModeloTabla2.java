/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bayer
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author
 */
public class ModeloTabla2 extends AbstractTableModel {

    private Connection conexion;

    String encabezados[] = new String[]{
        "Id Medida", "Fecha", "Peso", "Cintura", "Cadera","Id TipoAct","Id Persona"
    };
    Class tipos[] = new Class[]{
        Integer.class, Date.class, Double.class, Integer.class, Integer.class,Integer.class,Integer.class
    };
    Object datos[][];

    public ModeloTabla2(String Usuario, String Contraseña) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/mediciones_personas", Usuario, Contraseña);
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
            ResultSet rs = stmt.executeQuery("SELECT*FROM MEDICIONES");
            while (rs.next()) {
                contador += 1;
            }
        } catch (Exception e) {

        }
        return contador;
    }

    //
    // metodo que llena a los datos
    public void actualizaEstatus() {

        datos = new Object[getTotal()][encabezados.length];

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT*FROM MEDICIONES");
            int contador = 0;
            while (rs.next()) {
                datos[contador][0] = rs.getInt(1);
                datos[contador][1] = rs.getDate(2);
                datos[contador][2] = rs.getDouble(3);
                datos[contador][3] = rs.getInt(4);
                datos[contador][4] = rs.getInt(5);
                datos[contador][5] = rs.getInt(6);
                datos[contador][6] = rs.getInt(7);

                contador += 1;
            }
        } catch (Exception e) {

        }

        //********************
//  usa el modelo de tabla creada por el usuario
        fireTableDataChanged();
    }

}
