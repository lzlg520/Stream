package com.lzlg.design.strategy;

/**
 * 测试
 */
public class Test {
    public static void main(String[] args) {
        // 以前的方式
//        Validator numericValidator = new Validator(new IsNumeric());
//        boolean isNumeric = numericValidator.validate("aaaa");
//
//        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
//        boolean isLowerCase = lowerCaseValidator.validate("bbbb");
//
//        System.out.println(isNumeric);
//
//        System.out.println(isLowerCase);

        // 使用lambda表达式
        // 无需再创建策略接口的实现类
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean isNumeric = numericValidator.validate("aaaa");

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean isLowerCase = lowerCaseValidator.validate("bbbb");

        System.out.println(isNumeric);
        System.out.println(isLowerCase);
    }
}
