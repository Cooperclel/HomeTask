import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class ExecutorExample {
    public static void main(String[] args) throws Exception, ExecutionException, InterruptedException{
        Runnable task = () -> System.out.println("Новое исполнение");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task);
        executor.execute(task);
        //execute() - вызывает поток и выводит результат
    }

}
