package com.lzlg.interview.first;

public class B extends A {
    static {
        System.out.println("static B");
    }

    {
        System.out.println("class B");
    }

    public B() {
        System.out.println("I'm class B.");
    }
}
