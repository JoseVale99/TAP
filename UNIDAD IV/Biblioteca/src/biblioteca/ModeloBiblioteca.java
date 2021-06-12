package biblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;


public class ModeloBiblioteca {
    private String  host     = "localhost";
    private String  usuario     = "postgres";
    private String  clave       = "123456789";
    private int     puerto      = 5432;
    private String  servidor    = "";

    private String baseDatos;
    private static Connection conexion  = null;
    
    public ModeloBiblioteca(String baseDatos){
        this.baseDatos = baseDatos;
        ConexionBd();
    }

   
    protected void ConexionBd(){
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
    
    protected boolean insertCliente(Cliente c){
        //Objeto para ejecutar las instrucciones en la base de datos
        PreparedStatement ps;
        String sqlInsertCliente = "insert into scbiblioteca.cliente values (?,?,?);";
        try{
            //Preparar la instrucción
            ps  = getConexion().prepareStatement(sqlInsertCliente);
            //Indicar qué información se pasa al Statement
            ps.setString(1, c.getNif());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            
            //Ejecutar el comando insert
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            System.err.println("Error en la INSERCIÓN " + e );
            return false;
        }
    }
    
protected boolean deleteCliente(Cliente c){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        PreparedStatement ps;
        String sqlDeleteCliente = "delete from scbiblioteca.cliente where nif = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlDeleteCliente);

            //Indicar qué información se pasa al Statement
            ps.setString(1, c.getNif());
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
        String sqlUpdateCliente = "update scbiblioteca.cliente set nombre = ?, apellidos = ? where nif = ?;";
        try{
            //Preparar la llamada
            ps  = getConexion().prepareStatement(sqlUpdateCliente);
                
            //Indicar qué información se pasa al procedimiento
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getNif());
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
            
        String sqlConsulta = "select nif, nombre, apellidos from scbiblioteca.cliente where nif = ?;";
        try{
            //Preparar el statement
            ps  = getConexion().prepareStatement(sqlConsulta);
                       
            //Indicar qué información se pasa al statement
            ps.setString(1, c.getNif());
            //Ejecutar el procedimiento
            rs  = ps.executeQuery();
            //Cargar los datos devueltos en una instancia cliente
            if(rs.next()){
                clienteEncontrado = new Cliente(rs.getString(1), rs.getString(2),rs.getString(3));           
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
        String consultaSQL = "Select nif, nombre, apellidos from scbiblioteca.cliente;";
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
                c.setNif(rs.getString("nif"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellidos"));

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
