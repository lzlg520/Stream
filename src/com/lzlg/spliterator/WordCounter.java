package com.lzlg.spliterator;

/**
 * 单词计数器
 *
 * @author lzlg
 */
public class WordCounter {

    private int counter;

    private boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    /**
     * 遍历字符串中的每个字符
     *
     * @param c
     * @return
     */
    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else { // 上一个字符是空格，而当前遍历的字符不是空格时，单词计数器加一
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    /**
     * 单词计数器合并
     *
     * @param wordCounter
     * @return
     */
    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}