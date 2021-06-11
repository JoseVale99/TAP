
package TDA;


public class Cliente {
  private String nombre;
  private String apellido;
  private String direccion;
  private int dni;

  
  
    public Cliente( int dni, String nombre, String apellido, String direccion) {
  this.dni=dni;
  this.nombre=nombre;
  this.apellido=apellido;
  this.direccion=direccion;
  
    }
  public Cliente() {
    }

  

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
  
  
  
}
