package com.yanyun.juc.pattern.singleton;

/**
 * 懒汉式单例模式
 * 优点：只有调用方法才创建对象，不会占用内存
 * 缺点：在多线程模式下不安全
 */
public class LazySingleton {
    /**
     * 懒加载
     */
    private static LazySingleton uniqueInstance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        //检查变量是否被初始化
        if (uniqueInstance == null) {
            uniqueInstance = new LazySingleton();
        }
        return uniqueInstance;
    }
}
