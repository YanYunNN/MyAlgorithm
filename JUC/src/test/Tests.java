package test;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tests {

    private static final Lock lock = new ReentrantLock();

    @Test
    public void testUnFair() {
        new Thread(() -> func(), "线程1").start();
        new Thread(() -> func(), "线程2").start();
    }

    public static void func() {
        try {
            lock.tryLock();
            System.out.println(Thread.currentThread().getName() + "加锁");
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "解锁");
        }
    }

    private static final Lock fairLock = new ReentrantLock(true);

    @Test
    public void testFair() {
        new Thread(() -> fairFunc(), "线程A").start();
        new Thread(() -> fairFunc(), "线程B").start();
        new Thread(() -> fairFunc(), "线程C").start();
        new Thread(() -> fairFunc(), "线程D").start();
        new Thread(() -> fairFunc(), "线程E").start();
    }

    public static void fairFunc() {
        for (int i = 0; i < 2; i++) {
            try {
//                fairLock.lock();
                if (!fairLock.tryLock()) {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "加锁超时");
                }
                System.out.println(Thread.currentThread().getName() + "加锁");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();
                System.out.println(Thread.currentThread().getName() + "解锁");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> fairFunc(), "线程A").start();
        new Thread(() -> fairFunc(), "线程B").start();
        /*new Thread(() -> fairFunc(), "线程C").start();
        new Thread(() -> fairFunc(), "线程D").start();
        new Thread(() -> fairFunc(), "线程E").start();*/
    }
}
