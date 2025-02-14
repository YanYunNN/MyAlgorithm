package ajava;

import java.util.*;
import java.util.concurrent.locks.StampedLock;

public class Test {
    private class Inner {
        public void print() {
            System.out.println("Inner class");
        }
    }

    public static void main(String[] args) {
        Object[] objects = new Object[10];
        Inner[] inners = new Inner[10];
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) {
                    break ok;
                }
            }
        }

        List<Object> objects1 = Collections.synchronizedList(new ArrayList<>());
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        objectObjectMap.put("1", "1");

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).run();
        ;
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).run();
        ;
        System.out.println(3);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        ;
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        ;
        System.out.println(3);


        String s1 = "1" + "1";
        String s2 = "11";
        String s3 = new String("11");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        Collections.unmodifiableList(new ArrayList<>());

        StampedLock stampedLock = new StampedLock();
        long l = stampedLock.tryReadLock();
    }


}
