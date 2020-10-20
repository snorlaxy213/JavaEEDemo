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

    public static void main(String[] args) {
        // --------------- Runnable ---------------------
        TestRunnable runnableOne = new TestRunnable(1);
        TestRunnable runnableTwo = new TestRunnable(2);
        Thread threadOne = new Thread(runnableOne);
        Thread threadTwo = new Thread(runnableTwo);
        threadOne.start();
        threadTwo.start();
    }
}