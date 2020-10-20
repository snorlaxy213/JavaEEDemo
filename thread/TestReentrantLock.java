package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    
    private Lock lock = new ReentrantLock();

    private void func(){
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        TestReentrantLock reentrantLock = new TestReentrantLock();
        executorService.execute(() -> reentrantLock.func());
        executorService.execute(() -> reentrantLock.func());
    }
}
