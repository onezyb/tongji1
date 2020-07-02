package com.zyb.tjpkg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyb.tjpkg.model.BasicInfoXlsEnty;
import com.zyb.tjpkg.model.KongzhirenXlsEnty;
import com.zyb.tjpkg.model.QyRetrievalXlsEnty;
import com.zyb.tjpkg.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "testTime")
    public void test1() {

        String shQz = "00110";//114_MA012HTC8J
        String shHz = "MA012HTC8J";
        Map<String, Object> map = new HashMap<>();
        for (int i = 100; i < 150; i++) {
            map.put("orgName", "有限公司1212");
            map.put("sh", shQz + (i + "") + shHz);
            map.put("zfjh", i % 2);
//            System.out.println(postDataByJson("http://127.0.0.1:8081/e-contract/consign/hash", map));
//            System.out.println(postDataByJson("http://172.46.16.14:8099/e-contract/consign/hash", map));
            System.out.println(postDataByJson("http://172.46.16.23:8099/e-contract/consign/hash", map));
        }
    }

    @RequestMapping(value = "testZxzy")
    public void test2() throws IOException {
        Map<String, String> map = readFile("E:\\TEST\\test-files\\mcsh.txt");
        List<BasicInfoXlsEnty> listBasic = new ArrayList<>();
        List<QyRetrievalXlsEnty> listQyRetrieval = new ArrayList<>();
        List<KongzhirenXlsEnty> listShareholder = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String s = map.get(i + "");
            String mc = s.substring(0, s.indexOf("\t"));
            String sh = s.substring(s.lastIndexOf("\t") + 1);
            System.out.println(mc + ":" + sh);
            /*String json = "{\"apiName\":\"zxzyGsxx\",\"fromCache\":\"false\",\"sign\":\"494bc09d77742d3c1191cb8e1fdc27b7\",\"userName\":\"ixinnuo_dev\"," +
                    "\"apiType\":\"basicInfo\",\"entName\":\"" +
                    mc +
                    "\"}";
            listBasic = basicinfo(json, listBasic);*/
            //2
            /*String json2 = "{\"apiName\":\"zxzyGsxx\",\"fromCache\":\"false\",\"sign\":\"494bc09d77742d3c1191cb8e1fdc27b7\",\"userName\":\"ixinnuo_dev\"," +
                    "\"apiType\":\"qyRetrieval\",\"keyword\":\"" +
                    sh +
                    "\",\"type\":\"1\"}";
            listQyRetrieval = qyRetrieval(json2, listQyRetrieval);*/
            //3
            String json3 = "{\"apiName\":\"zxzyGsxx\",\"fromCache\":\"false\",\"sign\":\"494bc09d77742d3c1191cb8e1fdc27b7\",\"userName\":\"ixinnuo_dev\"," +
                    "\"apiType\":\"shareholder\",\"entName\":\"" +
                    mc +
                    "\",\"level\":\"1\",\"attIds\":\"R102\"}";
            String json33 = "{\"apiName\":\"zxzyGsxx\",\"fromCache\":\"false\",\"sign\":\"494bc09d77742d3c1191cb8e1fdc27b7\",\"userName\":\"ixinnuo_dev\"," +
                    "\"apiType\":\"shareholder\",\"entName\":\"" +
                    mc +
                    "\",\"level\":\"1\",\"attIds\":\"R104\"}";
            //KongzhirenXlsEnty
            listShareholder = shareholder(json3, json33, listShareholder);
//            if(i==1) break;

        }//http://localhost:8066/testZxzy
//        ExcelUtil.writeExcel(listBasic, BasicInfoXlsEnty.class, "E:\\TEST\\test-files\\basicInfo.xlsx");//.\default.xlsx
        //2
//        ExcelUtil.writeExcel(listQyRetrieval, QyRetrievalXlsEnty.class, "E:\\TEST\\test-files\\qyRetrieval.xlsx");
        //3
        ExcelUtil.writeExcel(listShareholder, KongzhirenXlsEnty.class, "E:\\TEST\\test-files\\kongzhiren.xlsx");
    }

    private List<BasicInfoXlsEnty> basicinfo(String json2, List<BasicInfoXlsEnty> list) {
        String result = postDataByJson("http://172.46.16.23:8088/api-platform", json2);
        JSONObject jsb = JSON.parseObject(result);
        JSONObject contentObj = JSON.parseObject(jsb.getString("content"));
        JSONArray jsa = JSON.parseArray(contentObj.getString("content"));
        BasicInfoXlsEnty enty = JSON.toJavaObject(jsa.getJSONObject(0), BasicInfoXlsEnty.class);
        list.add(enty);
        return list;
    }

    //
    private List<QyRetrievalXlsEnty> qyRetrieval(String json2, List<QyRetrievalXlsEnty> list) {
        String result = postDataByJson("http://172.46.16.23:8088/api-platform", json2);
        JSONObject jsb = JSON.parseObject(result);
        JSONObject contentObj = JSON.parseObject(jsb.getString("content"));
        JSONArray jsa = JSON.parseArray(contentObj.getString("content"));
        QyRetrievalXlsEnty enty = JSON.toJavaObject(jsa.getJSONObject(0), QyRetrievalXlsEnty.class);
        list.add(enty);
        return list;
    }

    private List<KongzhirenXlsEnty> shareholder(String json2, String json22, List<KongzhirenXlsEnty> list) {
        String result = postDataByJson("http://172.46.16.23:8088/api-platform", json2);
        JSONObject jsb = JSON.parseObject(result);
        JSONObject contentObj = JSON.parseObject(jsb.getString("content"));
        JSONArray jsa = null;
        KongzhirenXlsEnty enty00 = new KongzhirenXlsEnty();
        try {
            jsa = JSON.parseArray(contentObj.getString("content"));
            KongzhirenXlsEnty enty = JSON.toJavaObject(jsa.getJSONObject(0), KongzhirenXlsEnty.class);
            if (enty.getLASTNODE().equals("0") && enty.getCHILDREN().get(0).getLASTNODE().equals("1")) {
                enty.setKGGS(enty.getCHILDREN().get(0).getNUMBERTYPE() + enty.getCHILDREN().get(0).getTYPE() + enty.getCHILDREN().get(0).getNAME());
                enty00 = enty;
            }
            result = postDataByJson("http://172.46.16.23:8088/api-platform", json22);
            jsb = JSON.parseObject(result);
            contentObj = JSON.parseObject(jsb.getString("content"));
            jsa = JSON.parseArray(contentObj.getString("content"));
            try {
                KongzhirenXlsEnty enty1 = JSON.toJavaObject(jsa.getJSONObject(0), KongzhirenXlsEnty.class);
                if (enty1.getLASTNODE().equals("0") && enty1.getCHILDREN().get(0).getLASTNODE().equals("1")) {
                    enty00.setKGGR(enty1.getCHILDREN().get(0).getNUMBERTYPE() + enty1.getCHILDREN().get(0).getTYPE() + enty1.getCHILDREN().get(0).getNAME());
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            try {
                result = postDataByJson("http://172.46.16.23:8088/api-platform", json22);
                jsb = JSON.parseObject(result);
                contentObj = JSON.parseObject(jsb.getString("content"));
                jsa = JSON.parseArray(contentObj.getString("content"));
                KongzhirenXlsEnty enty = JSON.toJavaObject(jsa.getJSONObject(0), KongzhirenXlsEnty.class);
                if (enty.getLASTNODE().equals("0") && enty.getCHILDREN().get(0).getLASTNODE().equals("1")) {
                    enty.setKGGR(enty.getCHILDREN().get(0).getNUMBERTYPE() + enty.getCHILDREN().get(0).getTYPE() + enty.getCHILDREN().get(0).getNAME());
                    enty00 = enty;
                }
            } catch (Exception e1) {
            }
        }
        list.add(enty00);
        return list;
    }

    private String postDataByJson(String url, Map<String, Object> paramMap) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        String paramJson = JSONObject.toJSONString(paramMap);
        HttpEntity<String> formEntity = new HttpEntity<>(paramJson, headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }

    private String postDataByJson(String url, String jspn) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        HttpEntity<String> formEntity = new HttpEntity<>(jspn, headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }

    public Map<String, String> readFile(String shfileUri) throws IOException {
        Map<String, String> map = new HashMap<>();
        File file = new File(shfileUri);
        if (!(file.exists() && file.isFile() && file.canRead())) {
            System.err.println("Error: File not found or not readable");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = null;
            int count = 0;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                map.put("" + count, s);
                count++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "123";
        for (char a : s.toCharArray()) {
            System.out.println(a);
        }
    }


}
