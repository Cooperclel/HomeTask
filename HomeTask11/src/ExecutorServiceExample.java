import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            //currentThread() - возвращает ссылку на текущий поток
            //getName() - выводит его имя
            System.out.println("Hello " + threadName);
        });
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            //shutdown() - ждет завершения запущенных задач,
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
                //isShutdown возвращает true, когда ExecuteService перестает принимать новые задачи(Достигается путем)
                //isTerminated() возвращает true, когда isShutdown тоже true и все задачи закончены
            }
            executor.shutdownNow();
            //shutdownNow() - останавливает исполнитель немедленно.
            System.out.println("shutdown finished");
        }
    }
}
