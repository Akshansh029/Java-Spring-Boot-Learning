package executorService;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
            service.scheduleAtFixedRate(new ProbeTask(), 2, 3, TimeUnit.SECONDS);

            try{
                if(!service.awaitTermination(10, TimeUnit.SECONDS)){
                    System.out.println("Shutting down the scheduled service...");
                    service.shutdownNow();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}

class ProbeTask implements Runnable{

    @Override
    public void run(){
        System.out.println("Probe task being executed by Thread " + Thread.currentThread().getName() +
                " at " + LocalDateTime.now());
    }
}
