package com.yanyun.sword.juc.concurrency.lock;

/**
 * LOCK操作接口
 * <p>
 * Created by sunyiwei on 2016/12/6.
 */
public interface Operator {
    void lock();

    void unlock();
}
