package ajava.thread;

public class ContextSwitchExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                // 模拟一些计算任务
                double value = Math.pow(Math.random(), Math.random());
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        long startTime = System.nanoTime();
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
    }
}
