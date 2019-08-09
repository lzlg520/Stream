package com.lzlg.interview.first;

public class A {
    static {
        System.out.println("static A");
    }

    {
        System.out.println("class A");
    }

    public A() {
        System.out.println("I'm class A.");
    }
}
