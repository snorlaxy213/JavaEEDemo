package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestSynchronized {

    // 同步一个代码块, 作用于同一个对象。
    public void func1(){
        synchronized(this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    // 同步一个方法, 作用于同一个对象。
    public synchronized void func2(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

    // 同步一个类, 两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
    public void func3(){
        synchronized(TestSynchronized.class){
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
 
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 一个对象
        // TestSynchronized sync = new TestSynchronized();
        // executorService.execute(() -> sync.func1());
        // executorService.execute(() -> sync.func1());

        // 两个对象
        TestSynchronized sync1 = new TestSynchronized();
        TestSynchronized sync2 = new TestSynchronized();
        executorService.execute(() -> sync1.func3());
        executorService.execute(() -> sync2.func3());
    }
}