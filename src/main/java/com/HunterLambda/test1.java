package com.HunterLambda;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * lambda 的基本语法表达式为
 *
 * 基本语法:
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 */
public class test1 {

    interface MathOperation {
        int operation(int x, int y);
    }

    public static void main(String[] args) throws Exception {

        test1 demo1 = new test1();

        /**
         *  x + y
         */
        List<String> a = new ArrayList<>();
        a.add("John");
        a.add("Kobe");
        a.add("Curry");

        a.forEach((x) -> {
            System.out.println(x);
        });

        a.forEach(System.out::println);

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(1);
        list.add(67);

        list.forEach((x)->{
            System.out.println(x * 5);
        });

        /**
         * 使用Lambda表达式 实现inteface，并且进行算数运算
         */
        MathOperations add = ((x, y) -> x + y);
        MathOperations div = ((x, y) -> {
            if(y == 0) {
                throw new Exception("Error");
            }
            return x / y;
        });

        /**
         *  通过对接口 MathOperations 的实现，更加灵活
         */
        MathOperationsImpl mathOperations = new MathOperationsImpl();
        System.out.println(mathOperations.operation(8, 0, div));


    }

}
