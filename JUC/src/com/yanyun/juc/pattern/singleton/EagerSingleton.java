package com.yanyun.juc.pattern.singleton;

/**
 * 饿汉式单例模式
 * 优点： 在多线程模式下是安全的
 * 缺点： 没有调用方法前就被加载，会占用内存
 */
public class EagerSingleton {
    /**
     * 饿汉式在类加载时已经创建好该对象，在程序调用时直接返回该单例对象即可
     * 即我们在编码时就已经指明了要马上创建这个对象，不需要等到被调用时再去创建。
     * <p>
     * 类在加载时会在堆内存中创建一个Singleton对象，当类被卸载时，Singleton对象也随之消亡了。
     */
    private static final EagerSingleton uniqueInstance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return uniqueInstance;
    }
}
