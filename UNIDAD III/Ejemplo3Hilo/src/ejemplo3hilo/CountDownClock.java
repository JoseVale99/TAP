
package ejemplo3hilo;

import java.util.concurrent.TimeUnit;

public class CountDownClock extends Thread {

    private String clockName;

    public CountDownClock(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 15; i >= 0; i--) {
            System.out.printf("%s -> %s: %d%n", threadName, clockName, i);
            try {
                // Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}