package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 调用 wait() 使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其它线程会调用 notify() 或者
 * notifyAll() 来唤醒挂起的线程。 它们都属于 Object 的一部分，而不属于 Thread。
 * 只能用在同步方法或者同步控制块中使用，否则会在运行时抛出 IllegalMonitorStateException。 使用 wait()
 * 挂起期间，线程会释放锁。这是因为，如果没有释放锁，那么其它线程就无法进入对象的同步方法或者同步控制块中，那么就无法执行 notify() 或者
 * notifyAll() 来唤醒挂起的线程，造成死锁。
 * 
 */
public class TestWaitNotify {
    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("after");
    }

    // wait() 和 sleep() 的区别:
    // wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
    // wait() 会释放锁，sleep() 不会。
    public static void main(String[] args) {
        TestWaitNotify waitNotify = new TestWaitNotify();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> waitNotify.after());
        executorService.execute(() -> waitNotify.before());
    }

}
