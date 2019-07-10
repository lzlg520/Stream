package com.lzlg.map;

import com.lzlg.Data;
import com.lzlg.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMapTest {
    public static void main(String[] args) {
        List<String> dishNames = Data.menu().stream().map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames.toString());

        System.out.println("==================================");

        List<Integer> dishNameLengths = Data.menu().stream()
                .map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(dishNameLengths.toString());
    }
}