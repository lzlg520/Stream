package com.lzlg.match;

import com.lzlg.Data;
import com.lzlg.Dish;

public class StreamMatchTest {
    public static void main(String[] args) {
        // AnyMatch 至少匹配一个元素
        if(Data.menu().stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        // AllMatch 全部匹配
        boolean isHealthy = Data.menu().stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println("The dishes in menu is all healthy ? " + isHealthy);
        // NoneMatch 和AllMatch相对
        boolean isNotHealthy = Data.menu().stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("The dishes in menu is all healthy ? " + isNotHealthy);
    }
}
