package com.zyb.tjpkg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyb.tjpkg.mapper.OutInterfaceLogMapper;
import com.zyb.tjpkg.model.OutInterfaceLog;
import com.zyb.tjpkg.util.SMS4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Tjupsylsys {

    private Logger logger = LoggerFactory.getLogger(Tjupsylsys.class);
    @Autowired
    private OutInterfaceLogMapper upsylsysDao;

    @RequestMapping(value = "tj1")
    @ResponseBody
    public void test1() throws IOException {

        //data
        List<OutInterfaceLog> all = upsylsysDao.getAll();
        Map<String, String> map1 = all.stream().collect(Collectors.toMap(OutInterfaceLog::getSerialNumber, OutInterfaceLog::getParams, (val1, val2) -> val1));

        //file
        String path = "E:\\TEST\\test-files\\tjylsys.txt";
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String orderId = "";
        while ((orderId = br.readLine()) != null) {
            String data = (String) map1.get(orderId);
            String params = SMS4.decodeSMS4toString("91110108MA001K7YXU", data);
            //{"apiName":"ups","apiType":"ylsys","bankCardNo":"6230580000199763447","fromCache":"true","idcardNo":"37030619690307252X","mobilePhone":"13964427766",
            // "name":"翟峥","sign":"f02ecdf17c03b226f1a789508229eb09","userName":"asrVz"}
            JSONObject jsb = JSON.parseObject(params);
            String name = null;
            try {
                name = jsb.getString("name");
            } catch (Exception e) {
                System.out.println("errorName:" + name + ":" + orderId);
                continue;
            }
            String id = null;
            try {
                id = jsb.getString("idcardNo");
            } catch (Exception e) {
                System.out.println("errorId:" + id + ":" + orderId);
                continue;
            }
//            name = name.length() == 2 ? name.substring(0, 1) + "*" : name.substring(0, 1) + "*" + name.substring(2, 3);
//            id = id.substring(0, 5) + "***********" + id.substring(16, 18);
            System.out.println(name + "+" + id);
        }
        br.close();
        isr.close();
        fis.close();
    }


    @RequestMapping(value = "tj2")
    @ResponseBody
    public void test2() throws IOException {

        //data
//        List<OutInterfaceLog> all = upsylsysDao.getAll();
//        Map<String, String> map1 = all.stream().collect(Collectors.toMap(OutInterfaceLog::getSerialNumber, OutInterfaceLog::getParams, (val1, val2) -> val1));

        //file
        String path = "E:\\TEST\\test-files\\tjauth.txt";//统计userName与接口对应
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String orderId = "";
        while ((orderId = br.readLine()) != null) {
            String params = SMS4.decodeSMS4toString("91110108MA001K7YXU", orderId);
            //{"apiName":"ups","apiType":"ylsys","bankCardNo":"6230580000199763447","fromCache":"true","idcardNo":"37030619690307252X","mobilePhone":"13964427766",
            // "name":"翟峥","sign":"f02ecdf17c03b226f1a789508229eb09","userName":"asrVz"}
            JSONObject jsb = JSON.parseObject(params);
            System.out.println(jsb.toJSONString());
        }
        br.close();
        isr.close();
        fis.close();
    }

    @RequestMapping(value = "tjtj")
    @ResponseBody
    public void tjFaces()throws IOException {
        String path = "E:\\TEST\\test-files\\tj222.txt";//统计userName与接口对应
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String orderId = "";
        while ((orderId = br.readLine()) != null) {
            String params = SMS4.decodeSMS4toString("91110108MA001K7YXU", orderId);
            JSONObject jsb = JSON.parseObject(params);
            logger.info(jsb.toJSONString());
        }
        br.close();
        isr.close();
        fis.close();
    }

    public static void main(String argv[]) throws IOException {
//        String path = "E:\\TEST\\test-files\\tjauth.txt";//统计userName与接口对应
        String path = "E:\\TEST\\test-files\\tj222.txt";//统计userName与接口对应
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String orderId = "";
        while ((orderId = br.readLine()) != null) {
            String params = SMS4.decodeSMS4toString("91110108MA001K7YXU", orderId);
            //{"apiName":"ups","apiType":"ylsys","bankCardNo":"6230580000199763447","fromCache":"true","idcardNo":"37030619690307252X","mobilePhone":"13964427766",
            // "name":"翟峥","sign":"f02ecdf17c03b226f1a789508229eb09","userName":"asrVz"}
            JSONObject jsb = JSON.parseObject(params);
            System.out.println(jsb.toJSONString());
        }
        br.close();
        isr.close();
        fis.close();
    }
}
