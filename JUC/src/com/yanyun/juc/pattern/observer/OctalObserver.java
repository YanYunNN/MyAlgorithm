package com.yanyun.juc.pattern.observer;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:56
 * @Description:
 * @Version: 1.0
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
