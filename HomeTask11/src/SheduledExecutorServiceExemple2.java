import java.util.concurrent.*;

public class SheduledExecutorServiceExemple2 {
    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException{
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);


    }
}
