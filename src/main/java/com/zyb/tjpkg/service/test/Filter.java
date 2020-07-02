package com.zyb.tjpkg.service.test;

import com.zyb.tjpkg.service.test.impl.FilterChain;
import com.zyb.tjpkg.util.Request;
import com.zyb.tjpkg.util.Response;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public interface Filter {
    public void doFilter(Request request, Response response, FilterChain fc);
}
