
package consumer;


public class Example {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Produccer(drop))).start();
        (new Thread(new Consumer(drop))).start();
        
    }
}
