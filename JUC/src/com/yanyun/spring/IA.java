package com.yanyun.spring;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/02/18/13:40
 * @description
 */
public interface IA {
    String a = "a";
    int b = 1;

    default double a() {
        short s1 = 1;
//        s1 = s1 + 1;
        s1 += s1;
        try {
            int i = 1 / 0;
        } finally {
//            Collections.synchronizedMap();
//            ConcurrentHashMap
            System.out.println(1);
        }
        return a.hashCode() + b;
    }
}

class A implements IA {
    public static void main(String[] args) {
        new A().a();
    }
}
