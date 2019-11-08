import java.util.concurrent.*;

public class SheduledExecutorServiceExemple {
    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException{
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        };
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();


    }
}
