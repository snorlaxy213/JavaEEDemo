package thread;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 250;
    }
    
}
