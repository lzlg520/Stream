package com.lzlg;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * 工具类
 */
public class Util {

    private Util() {
    }

    /**
     * 判断一个数是否是质数
     *
     * @param candidate
     * @return
     */
    public static boolean isPrime(int candidate) {
//        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
        int candidateRoot = (int) Math.sqrt((double) candidate);
        // 此时注意是rangeClosed
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    /**
     * 使用已有的质数列表来判断一个数是否是质数
     *
     * @param primes
     * @param candidate
     * @return
     */
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream()
                .noneMatch(p -> candidate % p == 0);
    }

    /**
     * 用来返回不大于数字candidateRoot的质数列表
     *
     * @param list
     * @param p
     * @param <A>
     * @return
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) { // 检查是否满足条件P
                return list.subList(0, i); // 如果不满足，则返回list之前的子列表
            }
            i++;
        }
        return list;// list中的所有元素都满足条件P
    }
}
