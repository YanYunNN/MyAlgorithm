package com.yanyun.juc.Async;

import java.util.concurrent.*;

/**
 * 异步
 */
public class AsyncCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableThread callableThread = new CallableThread();
        Future<Object> submit = executorService.submit(callableThread);
        //shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。
        //而shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
        executorService.shutdown();
        executorService.shutdownNow();
        try {
            String str = (String) submit.get();
            boolean done = submit.isDone();
            System.out.println(str + ":" + done);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static class CallableThread implements Callable<Object> {
        @Override
        public String call() throws Exception {
            return "123";
        }
    }
}