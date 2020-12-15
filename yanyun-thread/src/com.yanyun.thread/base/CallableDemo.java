package com.yanyun.thread.base;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/13/16:35
 * @description
 */
public class CallableDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 2;
        }

        @SneakyThrows
        public static void main(String[] args) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<Integer> result = executor.submit(new Task());
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println(result.get());
        }

        @SneakyThrows
        public static void main1(String[] args) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            FutureTask<Integer> futureTask = new FutureTask<>(new Task());
            executor.submit(futureTask);
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println(futureTask.get());
        }
    }
}
