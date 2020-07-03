package com.yanyun.juc.pattern.observer;

import lombok.Data;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:53
 * @Description:
 * @Version: 1.0
 */
@Data
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
