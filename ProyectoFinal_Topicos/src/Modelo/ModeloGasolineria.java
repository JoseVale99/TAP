
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import TDA.Cliente;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModeloGasolineria {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "123456789";
    private int     puerto      = 5432;
    private String  servidor    = "";

    private String baseDatos;
    private static Connection conexion  = null;
    
    public ModeloGasolineria(String baseDatos){
        this.baseDatos = baseDatos;
        ConexionBd();
    }

   
    public void ConexionBd(){
        this.servidor="jdbc:postgresql://"+host+":"+ puerto+"/"+baseDatos;
 
        //Registrar el driver
        try {            
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER "+ e);
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
        System.out.println("Conectado a "+baseDatos);
    }
 
    //Devuelve el objeto Connection que se usará en la clase Controller
    private Connection getConexion() {
        return conexion;
    }
    
    public boolean insertCliente(Cliente c){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into gasolineria.cliente values (?,?,?,?);";
      
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getDireccion());
            
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }
    
public boolean deleteCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlDeleteCliente = "delete from biblioteca.cliente where dni = ?;";
        
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlDeleteCliente);

            //Indicar qué información se pasa al Statement
          
            
            ps.setInt(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getDireccion());
            
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            return true;
        }catch (SQLException e) {
            System.err.println("Error en el BORRADO "+ e);
            return false;
        }
    }

 

    protected boolean updateCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlUpdateCliente = "update gasolineria.cliente set nombre = ?, apellido=?,direccion = ?, = ? where dni = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdateCliente);
                
            //Indicar qué información se pasa al procedimiento
         
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getDireccion());
            //Ejecutar el procedimiento
            ps.executeUpdate();
            //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la MODIFICACION");
            return false;
        }
    }
    
    protected Cliente selectCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        
        // Objeto con el cliente encontrado
        Cliente clienteEncontrado= null;
            
        String sqlConsulta = "select dni, nombre, apellido, direecion from gasolineria.cliente where dni = ?;";
        try{
            //Preparar el statement
            ps  = getConexion().prepareStatement(sqlConsulta);
        
            //Indicar qué información se pasa al statement
            ps.setInt(1, c.getDni());
            //Ejecutar el procedimiento
            rs  = ps.executeQuery();
            //Cargar los datos devueltos en una instancia cliente
            if(rs.next()){
                clienteEncontrado = new Cliente(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));           
            }
            
        }catch (SQLException e) {
            System.err.println("Error al CARGAR UN CLIENTE "+ e);
        }
        return clienteEncontrado;
    }
    
     protected List<Cliente> listCliente(){
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos
        ResultSet rs;
        //Obtener datos de todos los clientes
        String consultaSQL = "Select dni, nombre, apellido, direecion from gasolineria.cliente;";
        // Objeto List que contendrá todos los clientes
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            //Preparar el statement con la consulta SQL
            ps  = getConexion().prepareStatement(consultaSQL);
                      
            //Ejecutarla y obtiene en rs el resultado
            rs  = ps.executeQuery();
            
            //Recorrer el resultado para crear instancias de Cliente
            while(rs.next()){
                Cliente c = new Cliente();
                //Añadir registro a registro en el vector
                c.setDni(rs.getInt("dni"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDireccion(rs.getString("direccion"));

                // agregar a la lista cada uno de los clientes
                clientes.add(c);
            }
 
        } catch (SQLException e) {
            System.err.println("Error al CARGAR DATOS " + e);
        }
        return clientes;
    }
    
    protected void closeConexion(){

    // verifica que la conexión esté activa
        if ( getConexion() != null){
            try {
                getConexion().close();
            } catch(SQLException e){
                System.err.println("Error al cerrar la bd "+ e);
            }
        }
    }  
}
