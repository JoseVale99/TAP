
package biblioteca;

class Cliente {
    private String nif;
  private String nombre;
  private String apellidos;
  
    public Cliente(String nif, String nombre, String apellidos){
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public Cliente(){
        
    }
    
    public void setNif (String nif){
        this.nif = nif;
    }
    
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getNif(){
        return nif;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
}
