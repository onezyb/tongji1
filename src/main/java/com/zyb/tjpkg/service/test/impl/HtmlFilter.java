package com.zyb.tjpkg.service.test.impl;

import com.zyb.tjpkg.service.test.Filter;
import com.zyb.tjpkg.util.Request;
import com.zyb.tjpkg.util.Response;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public class HtmlFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        request.setRequestStr(request.getRequestStr().replace("<", "[").replace(">","]"));
        System.out.println("在HtmlFilter中处理request");//先处理request
        fc.doFilter(request, response, fc);//调用过滤器链的doFilter方法, 让它去执行下一个Filter的doFilter方法, 处理response的代码将被挂起
        System.out.println("在HtmlFilter中处理response");
    }
}
