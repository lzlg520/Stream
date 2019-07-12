package com.lzlg.design.strategy;

/**
 * 策略模式实现类
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
