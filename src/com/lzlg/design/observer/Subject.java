package com.lzlg.design.observer;

/**
 * 主题接口
 */
public interface Subject {
    /**
     * 注册观察者
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 通知观察者
     *
     * @param tweet
     */
    void notifyObservers(String tweet);
}
