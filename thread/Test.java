package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) {

        // --------------- Runnable ---------------------
        TestRunnable runnableOne = new TestRunnable(1);
        TestRunnable runnableTwo = new TestRunnable(2);
        Thread threadOne = new Thread(runnableOne);
        Thread threadTwo = new Thread(runnableTwo);
        threadOne.start();
        threadTwo.start();

        // --------------- Callable ---------------------
        TestCallable testCallable = new TestCallable();
        FutureTask<Integer> testTask = new FutureTask<>(testCallable);
        Thread testThread = new Thread(testTask);
        testThread.start();
        try {
            System.out.println(testTask.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        TestThread testThread2 = new TestThread();
        testThread2.start();
    }
}
