package com.lzlg.design.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
//        ProcessingObject<String> headerTextProcessing = new HeaderTextProcessing();
//        ProcessingObject<String> spellCheckerProcessing = new SpellCheckerProcessing();
//
//        headerTextProcessing.setSuccessor(spellCheckerProcessing);
//
//        String result = headerTextProcessing.handle("Aren't labdas really sexy?!!");
//        System.out.println(result);

        // 直接使用新的API
        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;

        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
