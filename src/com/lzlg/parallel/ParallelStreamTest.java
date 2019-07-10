package com.lzlg.parallel;

import com.lzlg.MeasureTime;

public class ParallelStreamTest {

    public static void main(String[] args) {
        // 使用顺序流处理
        System.out.println("Sequential sum done in : " +
                MeasureTime.measureSumPerf(ParallelFunction::sequentialSum, 10_000_000) + " msecs.");

        // 传统的迭代处理
        System.out.println("Iterative sum done in : " +
                MeasureTime.measureSumPerf(ParallelFunction::iterativeSum, 10_000_000) + " msecs.");

        // 使用并行流处理
        System.out.println("Parallel sum done in : " +
                MeasureTime.measureSumPerf(ParallelFunction::parallelSum, 10_000_000) + " msecs.");
        // 发现使用传统的迭代更加迅速
        // 原因：
        // 1.iterate生成的是装箱的对象，必须再次拆箱成数字才能求和。
        // 2.很难把iterate分成多个独立块来并行执行

        // 使用LongStream避免装箱拆箱操作
        System.out.println("Ranged sum done in : " +
                MeasureTime.measureSumPerf(ParallelFunction::rangedSum, 10_000_000) + " msecs.");
        // 使用正确的数据结构能够使并行工作保证最佳的性能
        System.out.println("Parallel ranged sum done in : " +
                MeasureTime.measureSumPerf(ParallelFunction::parallelRangedSum, 10_000_000) + " msecs.");
    }

}