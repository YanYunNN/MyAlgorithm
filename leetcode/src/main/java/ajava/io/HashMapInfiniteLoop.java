package ajava.io;

import java.util.HashMap;
import java.util.Map;

public class HashMapInfiniteLoop {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // 创建两个线程同时对 HashMap 进行 put 操作
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                map.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 10000; i < 20000; i++) {
                map.put(i, i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印 HashMap 的大小
        System.out.println("Size of map: " + map.size());
    }
}
