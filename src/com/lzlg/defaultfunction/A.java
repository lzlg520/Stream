package com.lzlg.defaultfunction;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
