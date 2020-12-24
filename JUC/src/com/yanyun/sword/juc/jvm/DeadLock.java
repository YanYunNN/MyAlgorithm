package com.yanyun.sword.juc.jvm;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/07/28/15:11
 * @description 测试死锁/检测死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        User u1 = new User("u1");
        User u2 = new User("u2");
        Thread thread1 = new Thread(new SynAddRunalbe(u1, u2, 1, 2, true));
        thread1.setName("thread1");
        thread1.start();
        Thread thread2 = new Thread(new SynAddRunalbe(u1, u2, 2, 1, false));
        thread2.setName("thread2");
        thread2.start();
    }

    /**
     * 线程死锁等待演示
     */
    public static class SynAddRunalbe implements Runnable {
        User u1, u2;
        int a, b;
        boolean flag;

        public SynAddRunalbe(User u1, User u2, int a, int b, boolean flag) {
            this.u1 = u1;
            this.u2 = u2;
            this.a = a;
            this.b = b;
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                if (flag) {
                    synchronized (u1) {
                        Thread.sleep(100);
                        synchronized (u2) {
                            System.out.println(a + b);
                        }
                    }
                } else {
                    synchronized (u2) {
                        Thread.sleep(100);
                        synchronized (u1) {
                            System.out.println(a + b);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
