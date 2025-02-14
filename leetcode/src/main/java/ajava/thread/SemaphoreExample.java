package ajava.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        // 创建一个 Semaphore 对象，初始许可数为 3
        Semaphore semaphore = new Semaphore(3);

        // 创建并启动多个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(semaphore, i)).start();
        }
    }
}

class Worker implements Runnable {
    private Semaphore semaphore;
    private int id;

    public Worker(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            // 获取一个许可
            semaphore.acquire();

            // 执行任务
            System.out.println("Thread " + id + " is running.");
            Thread.sleep(2000); // 模拟任务执行时间

            // 任务执行完毕
            System.out.println("Thread " + id + " has finished.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 释放许可
            semaphore.release();
        }
    }
}
