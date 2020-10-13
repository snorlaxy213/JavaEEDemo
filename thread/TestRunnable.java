package thread;

public class TestRunnable implements Runnable {

    int count;

    public TestRunnable(int count){
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("TestRunnable: " + count);
            count+=2;
        }
    }

}