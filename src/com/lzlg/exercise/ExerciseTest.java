package com.lzlg.exercise;

import com.lzlg.Data;
import com.lzlg.Trader;
import com.lzlg.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExerciseTest {
    public static void main(String[] args) {

        test1();

        test2();

        test3();

        test4();
    }

    /**
     * 找出2011年所有交易并按交易额排序（从低到高）
     */
    public static void test1() {
        List<Transaction> list = Data.transactions().stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * 交易员都在哪些城市工作过
     */
    public static void test2() {
        List<String> list = Data.transactions().stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 查询来自剑桥的交易员，并按姓名排序
     */
    public static void test3() {
        List<Trader> list = Data.transactions().stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

    }

    /**
     * 返回所有交易员的姓名字符串并案字母顺序排序
     */
    public static void test4() {
//        String nameList = Data.transactions().stream()
//                .map(t -> t.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce("", (n, m) -> n + m);

        String nameList = Data.transactions().stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(nameList);
    }

    /**
     * 有没有交易员在米兰工作
     */
    public static void test5() {
        boolean flag = Data.transactions().stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    public static void test6() {
        Data.transactions().stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 所有交易中最高的交易额
     */
    public static void test7() {
        Optional<Integer> value = Data.transactions().stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    /**
     * 找到交易额最小的交易
     */
    public static void test8() {
        Optional<Transaction> optional = Data.transactions().stream()
                .reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t2 : t1);

//        Optional<Transaction> optional = Data.transactions().stream()
//                .min(Comparator.comparing(Transaction::getValue));
    }
}
