import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException {
//        Runnable task = () -> System.out.println("Новое исполнение");
//        Executor executor = (runnable) -> {
//            new Thread(runnable).start();
//        };
//        executor.execute(task);
//        executor.execute(task);
//
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.SECONDS, new SynchronousQueue());
//        Callable<String> task = () -> Thread.currentThread().getName();
//        threadPoolExecutor.setRejectedExecutionHandler((runnable, executor) -> System.out.println("Rejected"));
//        for (int i = 0; i < 5; i++) {
//            threadPoolExecutor.submit(task);
//        }
//        threadPoolExecutor.shutdown();


//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
//        Callable<String> task = () -> {
//            System.out.println(Thread.currentThread().getName());
//            return Thread.currentThread().getName();
//        };
//        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        });
//        try {
//            System.out.println("attempt to shutdown executor");
//            executor.shutdown();
//            executor.awaitTermination(5, TimeUnit.SECONDS);
//        }
//        catch (InterruptedException e) {
//            System.err.println("tasks interrupted");
//        }
//        finally {
//            if (!executor.isTerminated()) {
//                System.err.println("cancel non-finished tasks");
//            }
//            executor.shutdownNow();
//            System.out.println("shutdown finished");
//        }

//        Callable task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                return 123;
//            }
//            catch (InterruptedException e) {
//                throw new IllegalStateException("task interrupted", e);
//            }
//        };
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executor.submit(task);
//
//        System.out.println("future done? " + future.isDone());
//
//        Integer result = future.get();
//
//        System.out.println("future done? " + future.isDone());
//        System.out.print("result: " + result);

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//
//        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
//        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
//
//        TimeUnit.MILLISECONDS.sleep(1337);
//
//        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
//        System.out.printf("Remaining Delay: %sms", remainingDelay);



//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//
//        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
//
//        int initialDelay = 0;
//        int period = 1;
//        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);



//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//
//        Runnable task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println("Scheduling: " + System.nanoTime());
//            }
//            catch (InterruptedException e) {
//                System.err.println("task interrupted");
//            }
//        };
//
//        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);

    }
}
