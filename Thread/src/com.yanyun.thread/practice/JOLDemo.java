package com.yanyun.thread.practice;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/19/14:31
 * @description 打印一个对象
 */
public class JOLDemo {
    public static void main(String[] args) {
        Object o = new Object();
        String printable = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(printable);

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
