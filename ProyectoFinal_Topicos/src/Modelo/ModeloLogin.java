package Modelo;

import TDA.Cliente;
import TDA.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModeloLogin {

    private String host = "localhost";
    private String usuario = "postgres";
    private String clave = "123456789";
    private int puerto = 5432;
    private String servidor = "";
    private String user_name, contrasenia;
    private String baseDatos;
    private static Connection conexion = null;

    public ModeloLogin(String baseDatos) {
        this.baseDatos = baseDatos;
        ConexionBd();
    }

    public void ConexionBd() {
        this.servidor = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;

        //Registrar el driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER " + e);
            System.exit(0); //parar la ejecución
        }

        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                    this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a " + baseDatos);
    }

    //Devuelve el objeto Connection que se usará en la clase Controller
    private Connection getConexion() {
        return conexion;
    }

    public boolean Iniciar_Sesion(Usuario l) {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;

        String user = l.getUsername();
        String sqlConsulta = "select *from gasolineria.usuario where usuario ='" + user + "'";
        try {
            //Preparar el statement
            ps = getConexion().prepareStatement(sqlConsulta);

            rs = ps.executeQuery();
            if (rs.next()) {
                user_name = rs.getString("USUARIO");
                contrasenia = rs.getString("PASWORD");
                if (user_name.equals(l.getUsername()) && contrasenia.equals(l.getPassword())) {
                    return true;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error " + e);
        }
        return false;
    }

    public Cliente selectCliente(Cliente c) {
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;

        // Objeto con el cliente encontrado
        Cliente clienteEncontrado = null;

        String sqlConsulta = "select dni, nombre, apellido, direccion from gasolineria.cliente where dni = ?;";
        try {
            //Preparar el statement
            ps = getConexion().prepareStatement(sqlConsulta);

            //Indicar qué información se pasa al statement
            ps.setInt(1, c.getDni());
            //Ejecutar el procedimiento
            rs = ps.executeQuery();
            //Cargar los datos devueltos en una instancia cliente
            if (rs.next()) {
                clienteEncontrado = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (SQLException e) {
            System.err.println("Error al CARGAR UN CLIENTE " + e);
        }
        return clienteEncontrado;
    }

    protected void closeConexion() {

        // verifica que la conexión esté activa
        if (getConexion() != null) {
            try {
                getConexion().close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la bd " + e);
            }
        }
    }
}
