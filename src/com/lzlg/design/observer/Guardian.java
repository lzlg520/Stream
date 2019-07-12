package com.lzlg.design.observer;

/**
 * Guardian报纸
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (null != tweet && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
