package com.zyb.tjpkg.util;

/**
 * Created by Yambo Zhang on 2020-06-18.
 */
public class Request {
    private String requestStr;//真正的Request对象中是包含很多信息的, 这里仅用一个字符串作模拟

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}
