package com.yanyun.sword.juc.pattern.observer;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:52
 * @Description:
 * @Version: 1.0
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
