package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 250;
    }

    public static void main(String[] args) {
        // --------------- Callable ---------------------
        TestCallable testCallable = new TestCallable();
        FutureTask<Integer> testTask = new FutureTask<>(testCallable);
        Thread testThread = new Thread(testTask);
        testThread.start();
        try {
            System.out.println(testTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
}
