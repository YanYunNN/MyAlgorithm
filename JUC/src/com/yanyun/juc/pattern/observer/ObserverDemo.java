package com.yanyun.juc.pattern.observer;

import com.yanyun.juc.concurrency.NotifyWaitTester;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:51
 * @Description: https://blog.csdn.net/ThinkWon/article/details/105870730
 * @Version: 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexObserver(subject);
        new OctalObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        subject.notifyAllObservers();

        System.out.println("----------------------");
        System.out.println("Second state change: 10");
        subject.setState(10);
        subject.notifyAllObservers();
    }

}
