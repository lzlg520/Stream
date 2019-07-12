package com.lzlg.design.strategy;

/**
 * 验证器
 */
public class Validator {
    private ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}