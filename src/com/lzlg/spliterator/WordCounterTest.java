package com.lzlg.spliterator;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 测试类
 *
 * @author lzlg
 */
public class WordCounterTest {
    public static void main(String[] args) {
//        Stream<Character> stream = IntStream.range(0, SimpleCount.SENTENCE.length())
//                .mapToObj(SimpleCount.SENTENCE::charAt);
        // 不使用并行流
//        System.out.println("Found " + countWords(stream) + " words.");

        // 使用并行流，发现结果并不正确
        // 原因：原始的String在任意位置拆分，有时一个单词会被分为两个词，拆分流会影响结果。
//        System.out.println("Found " + countWords(stream.parallel()) + " words.");

        // 使用自定义的拆分器来运行并行流
        Spliterator<Character> spliterator = new WordCounterSpliterator(SimpleCount.SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(stream) + " words.");
    }

    /**
     * 使用归约计算累计单词数量
     *
     * @param stream
     * @return
     */
    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate, WordCounter::combine);
        return wordCounter.getCounter();
    }
}
