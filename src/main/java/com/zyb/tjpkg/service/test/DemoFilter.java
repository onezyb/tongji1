package com.zyb.tjpkg.service.test;

import com.zyb.tjpkg.service.test.impl.ExpressionFilter;
import com.zyb.tjpkg.service.test.impl.FilterChain;
import com.zyb.tjpkg.service.test.impl.HtmlFilter;
import com.zyb.tjpkg.service.test.impl.SensitiveFilter;
import com.zyb.tjpkg.util.Request;
import com.zyb.tjpkg.util.Response;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public class DemoFilter {
    public static void main(String[] args) {
        String msg = "大家好 :), <script>haha</script> 我要说超级敏感的话";//以下三行模拟一个请求
        Request request = new Request();
        request.setRequestStr(msg);

        Response response = new Response();//响应

        FilterChain fc = new FilterChain();//过滤器链
        HtmlFilter f1 = new HtmlFilter();//创建过滤器
        SensitiveFilter f2 = new SensitiveFilter();
        ExpressionFilter f3 = new ExpressionFilter();
        fc.add(f1);//把过滤器添加到过滤器链中
        fc.add(f2);
        fc.add(f3);

        fc.doFilter(request, response, fc);//直接调用过滤器链的doFilter()方法进行处理
        System.out.println(request.getRequestStr());
    }
}
