package com.lzlg.parallel;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行方法类
 */
public class ParallelFunction {

    private ParallelFunction() {
    }

    /**
     * 不使用并行流
     *
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {

        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    /**
     * 传统使用for循环 等价于sequentialSum方法
     *
     * @param n
     * @return
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 使用并行流处理
     *
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /**
     * 使用不产生拆箱，装箱的LongStream 顺序流
     *
     * @param n
     * @return
     */
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /**
     * 使用不产生拆箱，装箱的LongStream 并行流
     *
     * @param n
     * @return
     */
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
}
