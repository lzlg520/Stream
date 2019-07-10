package com.lzlg.collect;

import com.lzlg.Util;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义质数收集器
 *
 * @author lzlg
 */
public class PrimeCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    /**
     * supplier方法返回一个在调用时创建累加器的函数
     *
     * @return
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        };
    }

    /**
     * accumulator定义了收集流中元素的逻辑
     *
     * @return
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(Util.isPrime(acc.get(true), candidate))
                    .add(candidate);
        };
    }

    /**
     * combiner方法在并行收集时把俩个部分累加器合并起来
     *
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    /**
     * accumulator方法返回的就是收集器的接口，不用进一步转换
     *
     * @return
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     * UNORDERED：规约结果不受流中项目的遍历和累积顺序的影响
     * CONCURRENT：accumulator函数可以从多个线程同时调用，且收集器可以并行归约流
     * IDENTITY_FINISH：表明完成器方法返回的函数是一个恒等函数
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
