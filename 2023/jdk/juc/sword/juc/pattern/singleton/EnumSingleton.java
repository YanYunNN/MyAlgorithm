package com.yanyun.sword.juc.pattern.singleton;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/07/21/20:19
 * @description JDK 1.5 后，使用 Java 语言实现单例模式的方式又多了一种：枚举
 * <p>
 * 优势 1 ：一目了然的代码 :写的代码越少，越不容易出错
 * 优势 2：天然的线程安全与单一实例 :在程序启动时，会调用 Singleton 的空参构造器，实例化好一个Singleton 对象赋给 INSTANCE，之后再也不会实例化
 * 优势 3：枚举保护单例模式不被破坏: 使用枚举可以防止调用者使用反射、序列化与反序列化机制强制生成多个单例对象，破坏单例模式。
 * <p>防反射：枚举类默认继承了 Enum 类，在利用反射调用 newInstance() 时，会判断该类是否是一个枚举类，如果是，则抛出异常。
 * <p>防反序列化：在序列化和反序列化的过程中，只是写出和读入了枚举类型和名字，没有任何关于对象的操作
 * <p>防反序列化：在序列化和反序列化的过程中，只是写出和读入了枚举类型和名字，没有任何关于对象的操作
 */
public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        System.out.println("枚举创建对象了");
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        EnumSingleton t1 = EnumSingleton.INSTANCE;
        EnumSingleton t2 = EnumSingleton.INSTANCE;
        System.out.print("t1和t2的地址是否相同：" + (t1 == t2));
    }
}
