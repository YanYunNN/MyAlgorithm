package com.yanyun.javap;

import java.util.List;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/09/14:45
 * @description
 */
public class Str {
    final static List<String> a = null;

    public static void main(String[] args) {
        a.add("");
        String s = "a" + "hello";
    }

    public abstract class MyClass {
        public abstract void test();
    }

    public abstract class MyInnerClass extends MyClass {
    }

    public class OuterClass extends MyInnerClass {
        @Override
        public void test() {
//            short s1=1;
//            s1=s1+1;
        }
    }
}
