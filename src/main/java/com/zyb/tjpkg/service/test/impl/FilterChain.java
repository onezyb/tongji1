package com.zyb.tjpkg.service.test.impl;

import com.zyb.tjpkg.service.test.Filter;
import com.zyb.tjpkg.util.Request;
import com.zyb.tjpkg.util.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public class FilterChain implements Filter {
    private List<Filter> list = new ArrayList<>();

    private int index = 0;

    public FilterChain add(Filter filter){
        this.list.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        if(index == list.size()){
            return;//这里是逆序处理响应的关键, 当index为容器大小时, 证明对request的处理已经完成, 下面进入对response的处理.
        }
        Filter f = list.get(index);//过滤器链按index的顺序拿到filter
        index++;
        f.doFilter(request, response, fc);
    }
}
