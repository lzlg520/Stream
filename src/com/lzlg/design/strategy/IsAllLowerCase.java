package com.lzlg.design.strategy;

/**
 * 实现策略接口的类
 */
public class IsAllLowerCase implements ValidationStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
