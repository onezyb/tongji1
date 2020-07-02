package com.zyb.tjpkg.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Yambo Zhang on 2020-04-03.
 */
public class Yambo {











    /**
     * 耗时 1.1 < 2.1 < 2.2
     * 百万级别 1.1 < 2.1 = 2.2
     * @param args
     */
    /*public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a11","a11");
        map.put("a15","a15");
        map.put("a13","a13");
        long aa = System.currentTimeMillis();
        //1.1
        *//*Map<String, Object> sortMap =
                new TreeMap<String, Object>(Comparator.naturalOrder());
        sortMap.putAll(map);
        long bb = System.currentTimeMillis();
        System.out.println(bb - aa);*//*
        //1.2
        *//*Map<String,Object> map2 = new HashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e->{
            map2.put(e.getKey(),e.getValue());
        });
        System.out.println(System.currentTimeMillis() - aa);*//*
        long cc = System.currentTimeMillis();
        List<Map.Entry<String, Object>> arrayList = new LinkedList(map.entrySet());
        //2.1
        Collections.sort(arrayList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry obj1 = (Map.Entry) o1;
                Map.Entry obj2 = (Map.Entry) o2;
                return obj1.getKey().toString().compareTo(obj2.getKey().toString());
            }
        });
//        Collections.sort(arrayList,Comparator.comparing(Map.Entry::getKey));
        //2.2
        *//*arrayList = arrayList.stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toList());*//*

        //put
        Map<String, Object> mapN = arrayList.stream()
                .collect(
                        Collectors.toMap(e1->e1.toString(), v->v)
                );
        System.out.println(System.currentTimeMillis()-cc);
    }*/
    public static void main(String[] args) {
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(1).plusHours(1);
        System.out.println(today_start.toString());
    }
}
