package com.yanyun.thread.practice.easy;

import sun.reflect.ConstructorAccessor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/28/10:31
 * @description
 */
public enum MyEnum {
    D;

    public static void main(String[] args) throws Exception {
        Constructor c = MyEnum.D.getClass().getDeclaredConstructors()[0];
        Method acquireConstructorAccessor = Constructor.class.getDeclaredMethod("acquireConstructorAccessor");
        acquireConstructorAccessor.setAccessible(true);
        acquireConstructorAccessor.invoke(c);
        Field field = Constructor.class.getDeclaredField("constructorAccessor");
        field.setAccessible(true);
        ConstructorAccessor constructorAccessor = (ConstructorAccessor) field.get(c);
        MyEnum a = (MyEnum) constructorAccessor.newInstance(new Object[]{"CCCC", 2});
        System.out.println(a);

        //获得构造器
        Constructor con = MyEnum.D.getClass().getDeclaredConstructor();
//设置为可访问
        con.setAccessible(true);
//构造两个不同的对象
        MyEnum singleton1 = (MyEnum) con.newInstance();
        MyEnum singleton2 = (MyEnum) con.newInstance();
//验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));
    }
}
