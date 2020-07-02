package com.zyb.tjpkg.util.demo;

import java.util.*;

/**
 * Created by Yambo Zhang on 2020-04-17.
 */
public class EnumMapDemo {
    enum LifeCycle {ONE, TWO, THREE;}
    final String name;
    final LifeCycle lifeCycle;

    EnumMapDemo(String name,LifeCycle lifeCycle){
        this.lifeCycle=lifeCycle;
        this.name=name;
    }

    @Override
    public String toString() {
        return "EnumMapDemo{" +
                "name='" + name + '\'' +
                ", lifeCycle=" + lifeCycle +
                '}';
    }

    public static void main(String[] args) {
        /*Set<EnumMapDemo>[] demoSet =(Set<EnumMapDemo>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < demoSet.length; i++) {
            demoSet[i]= new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            EnumMapDemo p = new EnumMapDemo("plant"+i,LifeCycle.ONE);
            demoSet[p.lifeCycle.ordinal()].add(p);

        }*/
//        Long id = 123L;
//        System.out.println("123".equals(id.toString()));
        List<String> listy = Arrays.asList("1","2","3","4");
        listy.forEach(list->{
            if("3".equals(list)){
                System.out.println("return");
                return;
            }
            System.out.println("yy");
        });
    }
}
