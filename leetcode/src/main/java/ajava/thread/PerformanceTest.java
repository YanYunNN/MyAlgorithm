package ajava.thread;

import java.lang.reflect.Method;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class PerformanceTest {
    public static void targetMethod(String message) {

    }

    public static void main(String[] args) throws Throwable {
        // 使用反射
        Method method = PerformanceTest.class.getMethod("targetMethod", String.class);

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            method.invoke(null, "Hello");
        }
        long endTime = System.nanoTime();
        System.out.println("Reflection time: " + (endTime - startTime));

        // 使用MethodHandle
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle methodHandle = lookup.findStatic(PerformanceTest.class, "targetMethod", methodType);

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            methodHandle.invokeExact("Hello");
        }
        endTime = System.nanoTime();
        System.out.println("MethodHandle time: " + (endTime - startTime));
    }
}
