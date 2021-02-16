package com.ReactorTest;

import cn.hutool.core.util.StrUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MainOperation {

    public static void main(String[] args) {
        AtomicInteger index = new AtomicInteger(1);
        List<String> words = new ArrayList<String>(){
            {
                add("the");
                add("fox");
                add("void");
            }
        };
        System.out.println(words.toArray());


//        words.stream()
//                .map(word -> StrUtil.format("{}. {}", index.getAndIncrement(), word))
//                .forEach(System.out::println);

        /**
         *  ①  fromArray 用于创建 Flux 响应流
         *  ②  range 用于整数 Flux 响应流，zipWith 用于合并两个响应流，将流中的元素一一对应
         *  ③  支持传递一个BiFunction函数式接口实现，用于定义如何合并两个数据流中的元素，
         *      这里的BiFunction为（ StrUtil.format("{}. {}", i, word)）
         *  ④  subscribe 为方法的订阅，此处为元素输出到中控台
         */
        Flux.fromArray(words.toArray())                                                   // ①
                .zipWith(Flux.range(1, Integer.MAX_VALUE),                      // ②
                        (word, i) -> StrUtil.format("{}. {}", i, word)) // ③
                .subscribe(System.out::println);      // ④

        /**
         * zipWith(Publisher<? extends T2> source2,
         *         BiFunction<? super T, ? super T2, ? extends V> combinator)
         * zipWith的两个传输参数，（发布者，BiFunction）
         */
        Mono.just("hello world").subscribe(System.out::println);
        Flux.just("This", " is", " a", " message!").subscribe(System.out::print);

    }

}
