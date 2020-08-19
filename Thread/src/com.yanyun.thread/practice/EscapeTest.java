package com.yanyun.thread.practice;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/19/10:13
 * @description
 */

import java.io.IOException;
import java.util.Random;

/**
 * 除了锁消除，JVM还会对无逃逸(NoEscape)对象进行对象分配消除优化。对象分配消除是指将本该在「堆」中分配的对象，转化为由「栈」中分配。
 * 乍听一下，很不可思议，但是我们可以通过一个案例来验证一下。
 * 比如以下代码，在一个 1 千万次的循环中，分别创建 EscapeTest 对象 t1 和 t2。
 */
public class EscapeTest {
    private final int a;
    private final int b;

    public EscapeTest(final int a, final int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(final String[] args) throws IOException {
        final Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            final EscapeTest t1 = new EscapeTest(random.nextInt(), random.nextInt());
            final EscapeTest t2 = new EscapeTest(random.nextInt(), random.nextInt());
            if (t1.equals(t2)) {
                System.out.println("Prevent anything from being optimized out.");
            }
        }
        System.in.read();
    }
}
