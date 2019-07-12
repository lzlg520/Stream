package com.lzlg.design.template;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(133, (Customer c) -> System.out.println(c.getName()));
    }
}