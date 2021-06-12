package practica_08;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ManejoDatos {

    private Connection conexion;//acceso a conexion
    private Conexion crearConexion;//Crea conexion
    private final int CAMPOS_PERSONA = 4;
    private final int CAMPOS_ACTIUIDAD = 3;

    public ManejoDatos() throws ClassNotFoundException {
        crearConexion = 
    crearConexion.getConexion("jdbc:derby://localhost:1527/mediciones_personas", "root", "123456789");
        conexion = crearConexion.getConeccion();
    }

    
    public List<Object[]> conexionConsultaPersona(String sql) { 
//Regresa los registros de las personas en una lista
        List<Object[]> datos = new ArrayList<Object[]>();
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                String dat[] = new String[CAMPOS_PERSONA];
                //Estructura del registro persona pasado como cadena
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = fecha.format((Date) rs.getDate(3));
                dat[3] = rs.getString(4);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error al conexion consultar persona" + e);

        }
        return datos;

    }

    public List<Object[]> conexionconsultaActividad(String sql) { 
//Regresa los registros de tipo de actividad
        List<Object[]> datos = new ArrayList<Object[]>();
        try {
            Statement ps = conexion.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                String dat[] = new String[CAMPOS_ACTIUIDAD];
                //Estructura del registro actividad
                dat[0] = String.valueOf((Integer) rs.getInt(1));
                dat[1] = rs.getString(2);
                dat[2] = rs.getString(3);
                datos.add(dat);
            }
        } catch (Exception e) {
            System.err.println("Error en conexion consultar actividad" + e);
        }
        return datos;

    }
}
