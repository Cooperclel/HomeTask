package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class LockExample {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();
        final int[] count = {0};
        executorService.submit(() -> {
            long stamp = lock.readLock();
            try {
                if(count[0] == 0){
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if(stamp == 0L){
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    count[0] = 23;
                }
                System.out.println(count[0]);
            }finally {
                lock.unlock(stamp);
            }
        });
        executorService.shutdown();
    }
}
