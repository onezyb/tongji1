package com.zyb.tjpkg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Yambo Zhang on 2020-06-28.
 */
public class PkeyRegion2BianryRegions {
    private static  Long maxPkey = 706592311L;
    private static  Long minPkey = 0L;
    public static List<Long[]> getListByBianrycounts(int bCounts) {
        //todo 例如bCounts = 10
        Double add0 = Math.floor((maxPkey-minPkey)/bCounts);
        long add = add0.longValue();
        List<Long[]> list = new ArrayList<>();
        for (int i = 0; i < bCounts; i++) {
            Long[] ids = new Long[2];
            ids[0] = minPkey;
            minPkey += (add-1);
            ids[1] = minPkey;
            minPkey++;
            list.add(ids);
        }
        return list;
    }


    public static void main(String[] args) {
        List<Long[]> list = getListByBianrycounts(100);
        System.out.println();
    }
}
