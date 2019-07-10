package com.lzlg.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamWordsTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths.toString());
    }
}
