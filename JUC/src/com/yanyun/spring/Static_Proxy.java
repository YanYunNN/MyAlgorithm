package com.yanyun.spring;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/02/05/14:25
 * @description
 */
class Static_Proxy {
    public interface HelloInterface {
        void sayHello();
    }

    public static class Hello implements HelloInterface {
        @Override
        public void sayHello() {
            System.out.println("Hello Tommy");
        }
    }

    public static class HelloProxy implements HelloInterface {
        HelloInterface proxy = new Hello();

        @Override
        public void sayHello() {
            System.out.println("before---");
            proxy.sayHello();
            System.out.println("after----");
        }
    }

    public static void main(String[] args) {
        HelloInterface instance=new HelloProxy();
        instance.sayHello();
    }
}
