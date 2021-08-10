package Lock.SingleMode;

import java.util.concurrent.locks.ReentrantLock;

public class SingleMode{

    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }
        
    }


}