package com.lzlg.design.observer;

/**
 * NY时报
 */
public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (null != tweet && tweet.contains("money")) {
            System.out.println("Breaking news in NY ! " + tweet);
        }
    }
}
