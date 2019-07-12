package com.lzlg.defaultfunction;

public class C implements B, A {

    public void hello() {
        B.super.hello(); // 解决默认方法冲突1：显示的调用某个接口中的默认方法
    }

    public static void main(String[] args) {
        new C().hello();
    }
}
