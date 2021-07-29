package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAwaitSignal {
    
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void before(){
        lock.lock();
        try{
            System.out.println("before");
            condition.signalAll();    
        } finally {
            lock.unlock();
        }
    }

    private void after(){
        lock.lock();
        try{
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * java.util.concurrent 类库中提供了 Condition 类来实现线程之间的协调，可以在 Condition 上调用 await() 方法使线程等待，其它线程调用 signal() 或 signalAll() 方法唤醒等待的线程。
     * 
     * 相比于 wait() 这种等待方式，await() 可以指定等待的条件，因此更加灵活。
     * 使用 Lock 来获取一个 Condition 对象。
     */
    public static void main(String[] args) {
        TestAwaitSignal waitNotify = new TestAwaitSignal();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> waitNotify.after());
        executorService.execute(() -> waitNotify.before());
    }
}
