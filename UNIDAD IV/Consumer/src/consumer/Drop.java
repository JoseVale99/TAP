
package consumer;

public class Drop {
    
    // Mensaje enviado del productor al consumidor
    private String message;
    // True si el consumidor debe esperar para que el productor envie el mensaje
    // false si el productor deberia esperar para que el consumidor reciba el mensaje
    private boolean empty = true;
    
    public synchronized String take() {
        // Espera hasta que el mensaje esté disponible
        while (empty) {
            System.err.println("entra?");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        // cambia el estado
        empty = true;
        // Notifica el productor que el estatus ha cambiado
        notifyAll();
        return message;
    }
    public synchronized void put(String message){
     
        System.err.println("boolean  "+empty);
      while (!empty) {            
      System.err.println("entra 2");
          try {
               
                wait();
            } catch (Exception e) {
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}