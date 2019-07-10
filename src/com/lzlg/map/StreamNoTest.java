package com.lzlg.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNoTest {
    public static void main(String[] args) {
        // Test 1 : 将数字转换成平方
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = numbers.stream().map(n -> n * n).collect(Collectors.toList());

        System.out.println(collect.toString());

        System.out.println("======================>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        // Test 2 : 返回两个数字列表的所有数对
        List<Integer> numbersOne = Arrays.asList(1, 2, 3);

        List<Integer> numbersTwo = Arrays.asList(3, 4);

        List<int[]> pairs = numbersOne.stream().flatMap(
                i -> numbersTwo.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        System.out.println("======================>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // Test 3 : 返回总和能被3整除的数对

        List<int[]> list = numbersOne.stream().flatMap(i -> numbersTwo.stream()
                .filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
    }
}