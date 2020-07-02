package com.zyb.tjpkg.service.test.impl;

import com.zyb.tjpkg.service.test.Filter;
import com.zyb.tjpkg.util.Request;
import com.zyb.tjpkg.util.Response;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        request.setRequestStr(request.getRequestStr().replace("敏感", "正常"));
        System.out.println("在SensitiveFilter中处理request");
        fc.doFilter(request, response, fc);
        System.out.println("在SensitiveFilter中处理response");
    }
}
