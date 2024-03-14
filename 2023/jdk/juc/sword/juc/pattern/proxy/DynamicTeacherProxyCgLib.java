package com.yanyun.sword.juc.pattern.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib的方式实现动态代理
 * 代理对象的生成过程由Enhancer类实现，大概步骤如下：
 * 生成代理类Class的二进制字节码；
 * 通过Class.forName加载二进制字节码，生成Class对象；
 * 通过反射机制获取实例构造，并初始化代理类对象。
 * <p/>
 * Created by sunyiwei on 2016/10/19.
 */
public class DynamicTeacherProxyCgLib {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        IPerson iPerson = (IPerson) createProxy(Teacher.class, teacher);

        iPerson.walk();
    }

    private static Object createProxy(Class clz, Object object) {
        Enhancer enhancer = new Enhancer();
        //targetClass
        enhancer.setSuperclass(clz);

//        enhancer.setCallbackFilter(new CallbackFilter() {
//            @Override
//            public int accept(Method method) {
//                return 0;
//            }
//        });

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("I'm a dynamic cglib proxy instance.");

                Object returnObj = proxy.invoke(object, args);

                System.out.println("Teacher stops walk.");

                return returnObj;
            }
        });

        return enhancer.create();
    }
}
