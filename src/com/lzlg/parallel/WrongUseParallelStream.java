package com.lzlg.parallel;

import com.lzlg.MeasureTime;

import java.util.stream.LongStream;

/**
 * 错误的使用并行流的例子
 *
 * @author lzlg
 */
public class WrongUseParallelStream {

    public static void main(String[] args) {
        WrongUseParallelStream wrong = new WrongUseParallelStream();

        System.out.println("SideEffect parallel sum done in : " +
                MeasureTime.measureSumPerf(wrong::sideEffectParallelSum, 10_000_000) + " msecs.");
    }

    /**
     * 这段代码由于 += 操作不是原子操作，因此使用并行流会导致结果错误。
     * @param n
     * @return
     */
    public long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

}
