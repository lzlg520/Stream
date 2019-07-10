package com.lzlg.spliterator;

/**
 * 传统的单词计数 类
 *
 * @author lzlg
 */
public class SimpleCount {

    public static final String SENTENCE = "Nel mezzo del  cammin di  nostra vita " +
            "mi ritrovai in   una   selva oscura " + "che la   dritta via era   smarrita ";

    private SimpleCount() {
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countWordsIteratively(SENTENCE));
    }
}
