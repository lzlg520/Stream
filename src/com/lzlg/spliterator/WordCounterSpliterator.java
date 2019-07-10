package com.lzlg.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 单词拆分器，
 * 用来保证拆分时候不是从单词中间拆分的，只能从两个单词之间（有空格）拆分
 *
 * @author lzlg
 */
public class WordCounterSpliterator implements Spliterator<Character> {
    /**
     * 要拆分的字符串
     */
    private String string;
    /**
     * 当前字符所在位置
     */
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 处理当前字符
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length(); // 判断是否还有字符要处理
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) { // 拆分条件
            return null; // 返回null，表示要解析的String已经足够小，可以顺序处理。
        }
        // 从字符串中间进行遍历，找到拆分点
        for (int splitPos = currentSize / 2 + currentChar;
             splitPos < string.length(); splitPos++) {
            // 如果当前位置是空白字符，证明可以拆分
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));

                // 将当前位置设置为拆分位置
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    /**
     * estimateSize估计剩下多少元素需要遍历；这里是准确值，不是估算值
     *
     * @return
     */
    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    /**
     * spliterator的特性
     * 1.ORDERED 元素有既定的顺序，因此Spliterator在遍历和划分时也遵循这一顺序
     * 2.DISTINCT 对于任意一对遍历过的元素x和y ， x.equals(y) 返回false
     * 3.SORTED 遍历的元素按照一个预定义的顺序排序
     * 4.SIZED 该Spliterator由一个已知大小的源建立，因此estimateSize返回的是准确值
     * 5.NONNULL 保证遍历的元素不会为Null
     * 6.IMMUTABLE Spliterator的数据源不能修改。这意味着在遍历时不能添加，删除或修改元素
     * 7.CONCURRENT 该Spliterator的数据源可以被其他线程同时修改且无需同步
     * 8.SUBSIZED 该Spliterator和所有从它拆分出来的Spliterator都是SIZED
     *
     * @return
     */
    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
