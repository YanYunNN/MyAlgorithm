package com.yanyun.juc.concurrency;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 练习callable
 * <p>
 * Created by sunyiwei on 2016/11/22.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "FutureTask";
            }
        });

        executorService.submit(future);

        String content = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            content = scanner.nextLine();
            if ("CANCEL".equalsIgnoreCase(content)) {
                future.cancel(true);
            }

            //done but not caused by cancel
            if (future.isDone()) {
                if (future.isCancelled()) {
                    System.out.println("Future is cancel.");
                } else {
                    System.out.println(future.get());
                }

                break;
            }
        }

        executorService.shutdownNow();
    }
}
