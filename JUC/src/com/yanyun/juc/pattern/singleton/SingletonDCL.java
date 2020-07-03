package com.yanyun.juc.pattern.singleton;

/**
 * 单例双重校验锁
 */
public class SingletonDCL {
    private volatile static SingletonDCL uniqueInstance;

    private SingletonDCL() {
    }

    /**
     * 双重检查：如果多个线程同时了通过了第一次检查，并且其中一个线程首先通过了第二次检查并实例化了对象，
     * 那么剩余通过了第一次检查的线程就不会再去实例化对象。
     */
    public synchronized static SingletonDCL getInstance() {
        //检查变量是否被初始化
        if (uniqueInstance == null) {
            //加锁
            synchronized (SingletonDCL.class) {
                //再次检查变量是否已经被初始化，如果还没被初始化就初始化一个对象
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonDCL();
                }
            }
        }
        return uniqueInstance;
    }
}
