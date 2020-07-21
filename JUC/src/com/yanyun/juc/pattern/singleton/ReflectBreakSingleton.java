package com.yanyun.juc.pattern.singleton;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/07/21/20:11
 * @description 无论是懒汉式还是饿汉式/双检锁，终究敌不过反射和序列化，它们俩都可以把单例对象破坏掉（产生多个对象）。
 * @see DCLSingleton
 * @see LazySingleton
 * @see EagerSingleton
 */
public class ReflectBreakSingleton {

    /**
     * 利用反射，强制访问类的私有构造器，去创建另一个对象
     */
    @SneakyThrows
    public static void main(String[] args) {
        // 获取类的显式构造器
        Constructor<DCLSingleton> construct = DCLSingleton.class.getDeclaredConstructor();
        // 可访问私有构造器
        construct.setAccessible(true);
        // 利用反射构造新对象
        DCLSingleton obj1 = construct.newInstance();
        // 通过正常方式获取单例对象
        DCLSingleton obj2 = DCLSingleton.getInstance();
        // false
        System.out.println(obj1 == obj2);
    }
}
