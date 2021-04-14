package StaticMultipleThread;

public class StaticMultipleThread2 implements Runnable {

    private int num; 

    @Override
    public void run() {
        num = 2;
        System.out.println("当前线程值是：" + Thread.currentThread().getName() + ",num值是：" + num);
        num = 6;
        System.out.println("当前线程值是：" + Thread.currentThread().getName() + ",num值是：" + num * 3);
    }
    
    public static void main(String[] args) {
        StaticMultipleThread2 thread2 = new StaticMultipleThread2();
        for (int i = 0; i < 50; i++) {
            new Thread(thread2, "Thread-" + i).start();
        }
    }
}
