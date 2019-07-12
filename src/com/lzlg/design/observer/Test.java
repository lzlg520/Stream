package com.lzlg.design.observer;

public class Test {
    public static void main(String[] args) {
        // 不使用Lambda表达式
//        Feed f = new Feed();
//        f.registerObserver(new NYTimes());
//        f.registerObserver(new Guardian());
//        f.registerObserver(new LeMonde());
//
//        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

        // 使用Lambda不再显示的实例化三个观察者对象(观察者不复杂，也不重用，可使用Lambda)
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if (null != tweet && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        f.registerObserver((String tweet) -> {
            if (null != tweet && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
