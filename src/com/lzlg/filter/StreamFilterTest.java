package com.lzlg.filter;

import com.lzlg.Data;
import com.lzlg.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterTest {

    public static void main(String[] args) {
        List<Dish> vegetarianMenu = Data.menu().stream()
                .filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianMenu.toString());
    }

}
