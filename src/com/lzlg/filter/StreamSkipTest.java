package com.lzlg.filter;

import com.lzlg.Data;
import com.lzlg.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSkipTest {
    public static void main(String[] args) {
        List<Dish> dishes = Data.menu().stream().filter(d -> d.getCalories() > 300)
                .skip(2).collect(Collectors.toList());
        System.out.println(dishes.toString());
    }
}
