package com.HunterLambda;

/**
 * 中间类，用于实现MathOperation接口的调用
 */
public class MathOperationsImpl {

    public MathOperations add = ((x, y) -> x + y);

    public MathOperations div = ((x, y) -> {
        if(y == 0) {
            throw new Exception("");
        }
        return x / y;
    });

    public int operation(int a, int b , MathOperations operations) throws Exception {
        return operations.operation(a, b);
    }

}
