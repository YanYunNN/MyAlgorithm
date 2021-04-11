package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestsA extends AbstractQueuedSynchronizer {

    private static final Lock lock = new ReentrantLock();

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
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

    public static void main(String[] args) {
        Integer[] integer = new Integer[] { 1, 2, 3, 4 };
        List integetList = Arrays.asList(integer);
        integetList.set(1,9);
        StringBuilder builder=new StringBuilder();
    }
}
