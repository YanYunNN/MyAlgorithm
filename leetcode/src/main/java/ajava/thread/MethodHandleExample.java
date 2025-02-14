package ajava.thread;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleExample {
    public static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Throwable {
        // 获取一个Lookup对象
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        
        // 定义MethodType，表示参数和返回类型
        MethodType methodType = MethodType.methodType(void.class, String.class);
        
        // 查找静态方法hello
        MethodHandle methodHandle = lookup.findStatic(MethodHandleExample.class, "hello", methodType);
        // 调用方法
        methodHandle.invokeExact("World");
    }
}
