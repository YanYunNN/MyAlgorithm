package com.yanyun.sword.juc.pattern.observer;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:56
 * @Description:
 * @Version: 1.0
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
