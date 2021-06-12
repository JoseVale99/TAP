
package consumer;

import java.util.Random;

public class Produccer implements Runnable{
    
    private Drop drop;
    
    public Produccer(Drop drop){
        this.drop = drop;
    }
    
    @Override
    public void run() {
        String importantInfo[] = {
            "Mares eat oats","Does eat oats","Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();
        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (Exception e) {
            }
        }
        drop.put("HECHO");
    }
    
    
    
}