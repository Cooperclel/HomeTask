import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample implements ThreadFactory {
    private int counter = 0;
    private String prefix = "";

    public ThreadFactoryExample(String prefix){
        this.prefix = prefix;
    }
    public Thread newThread(Runnable r){
        return new Thread(r, prefix + "-" + counter++);
    }
}
