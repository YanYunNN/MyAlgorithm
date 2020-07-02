package com.yanyun.juc.Thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: YanYun
 * @Date: 2020/07/02/16:16
 * @Description: 自旋锁测试
 * @Url： https://blog.csdn.net/qq_41154882/article/details/102584096
 */
public class SpinLockTest {
    private AtomicBoolean available = new AtomicBoolean();

    public void lock() {
        // 循环检测尝试获取锁
        while (!tryLock()) {
            System.out.println("循环检测");
        }
    }

    public boolean tryLock() {
        return available.compareAndSet(false, true);
    }

    private void unLock() {
        if (!available.compareAndSet(true, false)) {
            throw new RuntimeException("释放锁失败！");
        }
    }


    /**
     * 票据排队方案
     */
    public class TicketLock {
        // 队列票据(当前排队号码)
        private AtomicInteger queueNum = new AtomicInteger();
        // 出队票据(当前需等待号码)
        private AtomicInteger dueueNum = new AtomicInteger();

        //因为获得自己的号码之后，是可以对号码进行更改的，这就造成系统紊乱，锁不能及时释放。
        // 这时候就需要有一个能确保每个人按会着自己号码排队办业务的角色
        private ThreadLocal<Integer> ticketLocal = new ThreadLocal<>();
//        private ThreadLocal<Integer> ticketLocal = ThreadLocal.withInitial(() -> 1);

        // 获取锁：如果获取成功，返回当前线程的排队号
        public int lock() {
            int currentTicketNum = dueueNum.incrementAndGet();
            // 获取锁的时候，将当前线程的排队号保存起来
            ticketLocal.set(currentTicketNum);
            while (currentTicketNum != queueNum.get()) {
                // 未叫号等待...
            }
            return currentTicketNum;
        }

        // 释放锁：传入当前排队的号码
        public void unLock(int ticketNum) {
            ticketLocal.get();
            queueNum.compareAndSet(ticketNum, ticketNum + 1);
        }

    }
}
