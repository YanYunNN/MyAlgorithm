package com.yanyun.juc.pattern.singleton;

/**
 * 单例双重校验锁
 */
public class DCLSingleton {
    /**
     * @NAME 指令重排： JVM 在保证最终结果正确的情况下，可以不按照程序编码的顺序执行语句，尽可能提高程序的性能
     * 在 JVM 中会经过三步：
     * （1）为 singleton 分配内存空间
     * （2）初始化 singleton 对象
     * （3）将 singleton 指向分配好的内存空间
     * 第 2、3 步有可能会发生指令重排现象，singleton 已经不为空，获取到未初始化的singleton 对象，就会报 NPE 异常
     * <p>
     * 一、使用 volatile 关键字修饰的变量，可以保证其指令执行的顺序与程序指明的顺序一致，不会发生顺序变换
     * 在多线程环境下就不会发生 NPE 异常了
     * 二、使用 volatile 关键字修饰的变量，可以保证其内存可见性
     */
    private volatile static DCLSingleton uniqueInstance;

    private DCLSingleton() {
    }

    /**
     * 双重检查：如果多个线程同时了通过了第一次检查，并且其中一个线程首先通过了第二次检查并实例化了对象，
     * 那么剩余通过了第一次检查的线程就不会再去实例化对象。
     */
    public synchronized static DCLSingleton getInstance() {
        //检查变量是否被初始化
        // 线程A和线程B同时看到singleton = null，如果不为null，则直接返回singleton
        if (uniqueInstance == null) {
            // 线程A或线程B获得该锁进行初始化，加锁
            /**
             * 加类锁作用：解决了频繁加锁性能低效：
             * 问题：每次去获取对象都需要先获取锁，并发性能非常地差，极端情况下，可能会出现卡顿现象
             * 结果：如果没有实例化对象则加锁创建，如果已经实例化了，则不需要加锁，直接获取实例
             */
            synchronized (DCLSingleton.class) {
                //再次检查变量是否已经被初始化，如果还没被初始化就初始化一个对象
                // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                if (uniqueInstance == null) {
                    uniqueInstance = new DCLSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}
