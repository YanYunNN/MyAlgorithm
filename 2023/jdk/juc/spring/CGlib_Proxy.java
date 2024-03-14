package com.yanyun.spring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/02/05/14:25
 * @description
 */
class CGlib_Proxy {
    public interface HelloInterface {
        void sayHello();
    }

    public static class HelloImpl implements HelloInterface {
        @Override
        public void sayHello() {
            System.out.println("Hello cglib");
        }
    }


    public static class MyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before---" + method.getName());
            Object object = methodProxy.invokeSuper(o, objects);
            System.out.println("after----" + method.getName());
            return object;
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //继承被代理类
        enhancer.setSuperclass(HelloImpl.class);
        //设置回调
        enhancer.setCallback(new MyMethodInterceptor());
        //生成代理类对象
        HelloImpl helloImpl = (HelloImpl) enhancer.create();
        //在调用代理类中方法时，会被实现的方法拦截器拦截
        helloImpl.sayHello();
    }
}
