package ajava;

/**
 * @author xcai
 * @date 2024/06/21
 * @see <a href=''>Conf<a/>
 * | 单例实现方式                                         | 优点                                                               | 缺点                            |
 * |---------------------------------------------------|--------------------------------------------------------------------|--------------------------------|
 * | **饿汉式（Eager Initialization）**                  | - 简单实现<br>- 类加载时即创建实例，避免线程同步问题     | - 类加载时即创建实例，可能造成资源浪费                  |
 * | **懒汉式（Lazy Initialization）**                   | - 实现简单<br>- 仅在需要时创建实例，节省资源            | - 每次调用都需同步，性能开销较大                      |
 * | **双重检查锁定（Double-Checked Locking）**           | - 延迟加载<br>- 线程安全<br>- 性能较好                | - 实现复杂<br>- 需要使用volatile关键字确保变量的可见性 |
 * | **静态内部类（Bill Pugh Singleton）**                | - 延迟加载<br>- 线程安全<br>- 实现简单，推荐使用        | - 需要理解Java类加载机制                          |
 * | **枚举（Enum Singleton）**                          | - 实现最简单<br>- 线程安全<br>- 防止反序列化破坏单例     | - 无法延迟加载实例                               |
 * | **静态块初始化（Static Block Initialization）**      | - 线程安全<br>- 可以处理异常                          | - 类加载时即创建实例，可能造成资源浪费              |
 * | **ThreadLocal 单例**                               | - 提供线程局部单例，适用于多线程环境下的单例实现           | - 每个线程都有自己的实例，无法实现全局单例          |
 */
public class SingletonDemo {

    // 1. 饿汉式（Eager Initialization）
    public static class EagerSingleton {
        private static final EagerSingleton INSTANCE = new EagerSingleton();

        private EagerSingleton() {
        }

        public static EagerSingleton getInstance() {
            return INSTANCE;
        }
    }

    // 2. 懒汉式（Lazy Initialization）
    public static class LazySingleton {
        private static LazySingleton instance;

        private LazySingleton() {
        }

        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }

    // 3. 双重检查锁定（Double-Checked Locking）
    public static class DoubleCheckedLockingSingleton {
        private static volatile DoubleCheckedLockingSingleton instance;

        private DoubleCheckedLockingSingleton() {
        }

        public static DoubleCheckedLockingSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckedLockingSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedLockingSingleton();
                    }
                }
            }
            return instance;
        }
    }

    // 4. 静态内部类（Bill Pugh Singleton）
    public static class StaticInnerClassSingleton {
        private StaticInnerClassSingleton() {
        }

        private static class SingletonHelper {
            private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
        }

        public static StaticInnerClassSingleton getInstance() {
            return SingletonHelper.INSTANCE;
        }
    }

    // 5. 枚举（Enum Singleton）
    public enum EnumSingleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("Enum Singleton instance");
        }
    }

    // 6. 基于静态块的初始化
    public static class StaticBlockSingleton {
        private static final StaticBlockSingleton INSTANCE;

        static {
            try {
                INSTANCE = new StaticBlockSingleton();
            } catch (Exception e) {
                throw new RuntimeException("An error occurred while creating singleton instance", e);
            }
        }

        private StaticBlockSingleton() {
        }

        public static StaticBlockSingleton getInstance() {
            return INSTANCE;
        }
    }

    // 7. 使用 ThreadLocal 实现单例
    public static class ThreadLocalSingleton {
        private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
                ThreadLocal.withInitial(ThreadLocalSingleton::new);

        private ThreadLocalSingleton() {
        }

        public static ThreadLocalSingleton getInstance() {
            return threadLocalInstance.get();
        }
    }

    public static void main(String[] args) {
        // 测试 EagerSingleton
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        System.out.println("EagerSingleton: " + eagerSingleton);

        // 测试 LazySingleton
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println("LazySingleton: " + lazySingleton);

        // 测试 DoubleCheckedLockingSingleton
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("DoubleCheckedLockingSingleton: " + doubleCheckedLockingSingleton);

        // 测试 StaticInnerClassSingleton
        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
        System.out.println("StaticInnerClassSingleton: " + staticInnerClassSingleton);

        // 测试 EnumSingleton
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething();

        // 测试 StaticBlockSingleton
        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();
        System.out.println("StaticBlockSingleton: " + staticBlockSingleton);

        // 测试 ThreadLocalSingleton
        ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();
        System.out.println("ThreadLocalSingleton: " + threadLocalSingleton);
    }
}
