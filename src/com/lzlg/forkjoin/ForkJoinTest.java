package com.lzlg.forkjoin;

import com.lzlg.MeasureTime;

/**
 * 测试类
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        System.out.println("ForkJoin sum done in : " +
                MeasureTime.measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs.");
    }
}
