package StaticMultipleThread;

public class StaticMultipleThread implements Runnable {

    private static int num;

    @Override
    public void run() {
        num = 3;
        System.out.println("当前线程值是：" + Thread.currentThread().getName() + ",num值是：" + num);
        num = 5;
        System.out.println("当前线程值是：" + Thread.currentThread().getName() + ",num值是：" + num * 2);
    }
    
    public static void main(String[] args) {
        StaticMultipleThread thread = new StaticMultipleThread();
        for (int i = 0; i < 50; i++) {
            new Thread(thread, "Thread-" + i).start();
        }
    }
}
