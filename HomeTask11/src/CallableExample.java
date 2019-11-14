import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException{

//        Runnable task = () -> System.out.println("Исполнение");
        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //newFixedThreadPool(1) - получение фиксированного пула потоков.
        //В нашем случае пул сосотоящий из одного потока
//        Thread thread = new Thread(task);
//        thread.start();
        Future<Integer> future = executor.submit(task);
        // submit() используется, чтобы завершить задачу после , при этом исполнитель не может вернуть результат задачи напрямую.
        //для результата необходимо сначала проверить, завершено ли выполнение задачи при помощи метода isDone()
        //get() -  блокирует поток и ждет завершения задачи, а затем возвращает результат ее выполнения.

        System.out.println("future done? " + future.isDone());

        Integer result = future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

        }
}
