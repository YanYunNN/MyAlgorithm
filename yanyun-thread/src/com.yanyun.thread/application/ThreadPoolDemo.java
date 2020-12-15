package com.yanyun.thread.application;

import java.util.concurrent.*;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/26/11:13
 * @description
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1000,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100),
                r -> new Thread(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        executor.execute(() -> new Task());
        System.out.println(executor.getTaskCount());
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 2;
        }
    }
}
