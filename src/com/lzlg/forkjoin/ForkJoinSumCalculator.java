package com.lzlg.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分支/合并计算求和
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    /**
     * 要求和的数组
     */
    private long[] numbers;
    /**
     * 子任务处理数组的起始位置
     */
    private int start;
    /**
     * 子任务处理数组的结束位置
     */
    private int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) { // 判断子任务分隔到什么程度
            return computeSequentially();
        }
        // 创建一个子任务为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        // 利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();

        // 创建一个子任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute(); // 同步执行第二个子任务，有可能允许进一步递归划分
        Long leftResult = leftTask.join(); // 读取第一个子任务的结果，如果未完成就等待

        // 返回两个子任务的结果的组合
        return rightResult + leftResult;
    }

    /**
     * 子任务不可再分时执行的 求和操作
     *
     * @return
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * 调用分支/合并求和
     *
     * @param n
     * @return
     */
    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
