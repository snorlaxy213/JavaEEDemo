package Thread;

public class TestThread extends Thread {
    
    @Override
    public void run(){
        int count = 10;
        for (int i = 0; i < 10; i++) {
            System.out.println("TestThread: " + count);
            count+=2;
        }
    }

    public static void main(String[] args) {
        TestThread testThread2 = new TestThread();
        testThread2.start();
    }
}
