package test;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestsA extends AbstractQueuedSynchronizer {

    private static final Lock lock = new ReentrantLock();

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
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
}
