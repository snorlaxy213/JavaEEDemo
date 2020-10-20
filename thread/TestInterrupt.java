package thread;

public class TestInterrupt {
    
    private static class TestThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();
        thread.start();
        thread.interrupt();
        System.out.println("test InterruptedException");
    }
}
