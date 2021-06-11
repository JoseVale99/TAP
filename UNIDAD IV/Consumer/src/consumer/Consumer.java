
package consumer;

import java.util.Random;

public class Consumer implements Runnable{
    private Drop drop;
    public Consumer(Drop drop){
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String message = drop.take(); !message.equals("HECHO"); message = drop.take()){
            System.out.format("MENSAJE RECIBIDO : %s%n",message);
        }
    }
}

