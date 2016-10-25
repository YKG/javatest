import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    static int count = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(10);

        Runnable r = new Runnable() {
            public void run() {
                count++;
                try {
                    System.out.println();
                    System.out.println(new Date() + " before");
                    Thread.sleep(5000);
                    System.out.println(new Date() + " after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.toString() + new Date() + " cnt: " + count);
            }
        };

        Runnable nosleep = new Runnable() {
            public void run() {
                count++;
                System.out.println(Thread.currentThread().getName() + new Date() + " cnt: " + count);
            }
        };
//        scheduler.scheduleAtFixedRate(r, 1, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(nosleep, 1, 1, TimeUnit.SECONDS);
    }
}
