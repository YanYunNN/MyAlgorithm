package ajava.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierExample {

    private static final int THREAD_COUNT = 3;
    private static CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT, () -> {
        // 当所有线程到达屏障点后执行的任务
        System.out.println("All threads have reached the barrier point.");
    });

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Task(i)).start();
        }
    }

    static class Task implements Runnable {
        private int threadId;

        public Task(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + threadId + " is performing some work.");
                Thread.sleep((long) (Math.random() * 1000)); // 模拟任务执行时间
                System.out.println("Thread " + threadId + " is waiting at the barrier.");
                barrier.await(); // 等待其他线程到达屏障点
                System.out.println("Thread " + threadId + " has passed the barrier.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
