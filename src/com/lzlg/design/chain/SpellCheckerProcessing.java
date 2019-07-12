package com.lzlg.design.chain;

/**
 * 拼写检查类
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
