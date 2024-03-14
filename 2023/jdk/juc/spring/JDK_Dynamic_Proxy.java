package com.yanyun.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/02/05/14:25
 * @description JDK 动态代理是通过与委托类实现同样的接口，然后在实现的接口方法里进行增强来实现的，这就意味着如果要用 JDK 代理，委托类必须实现接口，
 * 这样的实现方式看起来有点蠢，更好的方式是什么呢，直接继承自委托类不就行了，这样委托类的逻辑不需要做任何改动，CGlib 就是这么做的
 */
class JDK_Dynamic_Proxy {
    public interface HelloInterface {
        void sayHello();
    }

    public static class Hello implements HelloInterface {
        @Override
        public void sayHello() {
            System.out.println("Hello dynamic");
        }
    }

    /**
     * 不同于静态代理，不需要对Hello类进行代理
     * 利用反射自动代理
     */
    public static class MyProxy implements InvocationHandler {
        private Object target;

        public MyProxy(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Before:" + method.getName());
            Object res = method.invoke(target, args);
            System.out.println("After:" + method.getName());
            return res;
        }

        // 方法2：为目标对象生成代理对象
        public Object getProxyInstance() {
            return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Before:" + method.getName());
                    Object res = method.invoke(target, args);
                    System.out.println("After:" + method.getName());
                    return res;
                }
            });
        }
    }

    public static void main(String[] args) {
        //法一
        Hello hello = new Hello();
        InvocationHandler handler = new MyProxy(hello);
        Object instance = Proxy.newProxyInstance(handler.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        if (instance instanceof HelloInterface) {
            HelloInterface proxyInstance = (HelloInterface) instance;
            proxyInstance.sayHello();
        }

        System.out.println("---------------------------------------");
        //法二
        Hello realObject = new Hello();
        HelloInterface proxyInstance = (HelloInterface) new MyProxy(realObject).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.sayHello();
    }
}
