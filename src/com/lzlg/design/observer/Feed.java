package com.lzlg.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现注册的具体类
 */
public class Feed implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
