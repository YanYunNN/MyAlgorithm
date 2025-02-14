package ajava;

import ajava.base.UserDao;
import ajava.base.UserDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    public static void main(String[] args) {
        // 被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        JdkInvocationHandlerImpl jdkInvocationHandlerImpl = new JdkInvocationHandlerImpl(userDaoImpl);
        //类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();
        // 主要装载器、一组接口及调用处理动态代理实例
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, jdkInvocationHandlerImpl);
        newProxyInstance.save();

        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.getInstance(new UserDaoImpl());
        userDao.save();
    }

    public static class JdkInvocationHandlerImpl implements InvocationHandler {
        // 这其实业务实现类对象，用来调用具体的业务方法
        private Object target;

        // 通过构造函数传入目标对象
        public JdkInvocationHandlerImpl(Object target) {
            this.target = target;
        }

        //动态代理实际运行的代理方法
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("调用开始处理");
            //下面invoke()方法是以反射的方式来创建对象，第一个参数是要创建的对象，第二个是构成方法的参数，由第二个参数来决定创建对象使用哪个构造方法
            Object result = method.invoke(target, args);
            System.out.println("调用结束处理");
            return result;
        }
    }

    public static class CglibProxy implements MethodInterceptor {
        private Object targetObject;

        // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
        public Object getInstance(Object target) {

            // 设置需要创建子类的类
            this.targetObject = target;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }

        //代理实际方法
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("开启事物");
            Object result = proxy.invoke(targetObject, args);
            System.out.println("关闭事物");
            // 返回代理对象
            return result;
        }
    }
}
