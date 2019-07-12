package com.lzlg.defaultfunction;

public interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}
