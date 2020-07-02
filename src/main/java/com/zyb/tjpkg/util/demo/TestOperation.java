package com.zyb.tjpkg.util.demo;

/**
 * Created by Yambo Zhang on 2020-05-06.
 */
public class TestOperation {
    interface MathOperation {
        int operation(int a, int b);
    }

    public static void main(String args[]) {
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println(addition.operation(6,7));
    }
}
