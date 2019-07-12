package com.lzlg.design.chain;

/**
 * 头条处理类
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }
}
