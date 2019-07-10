package com.lzlg.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        // flatMap方法的效果是：各个数组并不是分别映射成一个流，而是映射成流的内容
        List<String> collect = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}
