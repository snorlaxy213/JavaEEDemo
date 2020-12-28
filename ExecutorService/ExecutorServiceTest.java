package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        testCachedThreadPool();
        // testFixedThreadPool();
        // testScheduledThreadPool1();
        // testScheduledThreadPool2();
        // testSingleThreadExecutor();
    }

    /**
     * 1. 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。 2.
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     * 
     */
    private static void testCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            // 去掉sleep，同时10个线程在工作，有slepp，会复用之前没有注销的线程
            // try {
            //     Thread.sleep(index * 1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);

                    long threadId = Thread.currentThread().getId();
                    System.out.println("Thread # " + threadId + " is doing this task");
                }
            });
        }
    }

    /**
     * 1. 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * 
     */
    private static void testFixedThreadPool() {
        // 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        long threadId = Thread.currentThread().getId();
                        System.out.println("Thread # " + threadId + " is doing this task");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。
     */
    private static void testScheduledThreadPool1() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        // 延迟3秒执行
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
                long threadId = Thread.currentThread().getId();
                System.out.println("Thread # " + threadId + " is doing this task");
            }
        }, 3, TimeUnit.SECONDS);
    }

    public static void testScheduledThreadPool2() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        // 延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
                long threadId = Thread.currentThread().getId();
                System.out.println(System.currentTimeMillis() + " Thread # " + threadId + " is doing this task");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }

    /**
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    public static void testSingleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}