package com.zyb.tjpkg.util.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yambo Zhang on 2020-04-17.
 */
public enum EnumFun {
    PLUS,
    MINUS;

    public double apply(double a, double b){
        System.out.println(ordinal());
        switch (this){
            case PLUS: return 11;
            case MINUS: return 22;
        }
        throw new AssertionError(this);
    }

    public static void main(String[] args) {
//        System.out.println(MINUS.apply(1, 2));
//        System.out.println(EnumFun.MINUS.apply(1,2));
        Set<Object>[] setArray = (Set<Object>[])new Set[5];
        for (int i = 0; i <5 ; i++) {
            setArray[i] = new HashSet<>();
        }

    }


    }
