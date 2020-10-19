package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
 * 
 * 主要有三种 Executor：
 * 1. CachedThreadPool：一个任务创建一个线程；
 * 2. FixedThreadPool：所有任务只能使用固定大小的线程；
 * 3. SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
 * 
 */
public class ExecutorTest {
    
    public static void main(String[] args) {
        ExecutorService eService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            eService.execute(new TestRunnable(i));
        }
        eService.shutdown();
    }
}
