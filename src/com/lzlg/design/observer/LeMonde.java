package com.lzlg.design.observer;

/**
 * LeMonde报纸
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (null != tweet && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
