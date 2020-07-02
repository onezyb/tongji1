package com.zyb.tjpkg.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyb.tjpkg.conf.qiniu.QiNiuConfig;
import com.zyb.tjpkg.mapper.TongjiOutlogMapper;
import com.zyb.tjpkg.model.TongjiOutlog;
import com.zyb.tjpkg.util.SMS4;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ZZBcontroller {
    private Logger logger = LoggerFactory.getLogger(ZZBcontroller.class);
    @Autowired
    private TongjiOutlogMapper tongjiOutlogMapper;
    @Autowired
    private QiNiuConfig qiNiuConfig;

    @RequestMapping(value = "face")
    public String get1() throws IOException {
        String path = "D://filess.txt";
        path = "D://filess0316.txt";
//        Map<String, String> map = readFile(path);
        List<String> idcards = readFileList(path);
        //228户 tongji_outlog_1912；
        //60户 tongji_outlog
        List<Integer> ids = tongjiOutlogMapper.getTableIds("");
        for (Integer pKey : ids) {
            TongjiOutlog one = tongjiOutlogMapper.selectByPrimaryKey(pKey);
            String params = one.getParams();
            JSONObject jsbParams = null;
            if (params.indexOf("{\"userNm\":") > -1) {//以前的不解密
                jsbParams = JSON.parseObject(params);
            } else {
                params = SMS4.decodeSMS4toString("91110108MA001K7YXU", params);
                jsbParams = JSON.parseObject(params);
            }
            String userNm = jsbParams.getString("userNm");
            String userId = jsbParams.getString("userId");
            if (!idcards.contains(userId)) continue;
            int j = idcards.indexOf(userId);
            String pkg_img = null;
            JSONObject jsbResult = JSON.parseObject(one.getResult());
            try {
                pkg_img = jsbResult.getString("package_image");
            } catch (Exception e) {
                logger.info("pkg_img empty,entity-ID:" + one.getId());
                continue;
            }
            if (StringUtils.isEmpty(pkg_img)) {
                logger.info("package_image empty,entity-ID:" + one.getId());
                continue;
            }
            String sout = userNm + "_" + userId + "_" + j + "_" + one.getId();
            if (pkg_img.length() < 37) {//七牛云
                try {
                    byte[] bt = qiNiuConfig.getBytes(pkg_img);
                    byteToImage(bt, sout);
                    logger.info(sout + jsbResult.toJSONString());
                } catch (Exception e) {
                    logger.error("id:{},e:{}", j, e);
                }
            } else {
                base64StringToImage(pkg_img, sout);
                jsbResult.remove("package_image");
                logger.info(sout + jsbResult.toJSONString());
            }
//                } catch (Exception e) {//七牛欠费了
//                    e.printStackTrace();
        }
        return "Ok D://";
    }

    @RequestMapping(value = "testGetimg")
    private void gets() {
        try {
            byte[] bt = qiNiuConfig.getBytes("c36085cc-590f-4235-b1fc-b6e1bdd7c8d4");
            byteToImage(bt, "888");
        } catch (Exception e) {
            logger.error("e:" + e);
        }
    }

    private static void base64StringToImage(String base64String, String fileName) {
        try {
            byte[] bytes1 = Base64.getDecoder().decode(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File f1 = new File("D://face/" + fileName + ".jpg");
            ImageIO.write(bi1, "jpg", f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteToImage(byte[] bytes1, String fileName) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File f1 = new File("D://face/" + fileName + ".jpg");
            ImageIO.write(bi1, "jpg", f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> readFile(String shfileUri) throws IOException {
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
                String name = s.substring(0, s.indexOf(";")).trim();
                map.put("name" + count, name);
                map.put("id" + count, s.substring(s.indexOf(";") + 1).trim());
                count++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    ////list
    public static List<String> readFileList(String shfileUri) throws IOException {
        List<String> map = new ArrayList<>();
        File file = new File(shfileUri);
        if (!(file.exists() && file.isFile() && file.canRead())) {
            System.err.println("Error: File not found or not readable");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                map.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //    public static String delSpace(String str) throws Exception {
//        if (str == null) {
//            return null;
//        }
//        String regStartSpace = "^[　 ]*";
//        String regEndSpace = "[　 ]*$";
//        // 连续两个 replaceAll
//        // 第一个是去掉前端的空格， 第二个是去掉后端的空格
//        String strDelSpace = str.replaceAll(regStartSpace, "").replaceAll(regEndSpace, "");
//        return strDelSpace;
//    }
    public static void main(String[] args) throws IOException {
//        String path = "D://360MoveData/Users/admin/Desktop/人脸识别诉讼资料/face图片";
//        Map<String, String> map = new HashMap<>();
//        File file = new File(path);        //获取其file对象
//        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
//        for (File f : fs) {                    //遍历File[]数组
//            if (!f.isDirectory()) {
//                String name = f.getName();//若非目录(即文件)，则打印
//                System.out.println();
//                map.put(name.substring(0, name.indexOf("_")), "str");
//            }
//
//        }
//        System.out.println(JSONObject.toJSONString(map));
//        List<String> list = new ArrayList<>();
//        list.add("qqq");
//        list.add("www");
//        list.add("eee");
//        System.out.println(list.indexOf("eee"));
        learnFlatMap();

    }
    private static void learnFlatMap() {
        //(广州  深圳  上海  北京)的全拼的一些组合,下面我们就把每一个城市都划分一下
        List<String> citys = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen",
                "ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

        //这里打印的数组对应的地址
        citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" "))).forEach(System.out::println);//note1

        System.out.println(1);

        //流里面的元素还是一个数组
        citys.stream()
                .map(mCities -> Arrays.stream(mCities.split(" ")))//流里面的每个元素还是数组
                .forEach(cities ->cities.forEach(city-> System.out.print(city+" ")));//note2

        System.out.println(22);
        System.out.println(22);

        //直接一个flatMap()就把数组合并到映射流里面了
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).forEach(System.out::println);//note3

        System.out.println();

        //使用distinct()方法去重！
        List<String> addl = new LinkedList<>();
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).distinct().forEach(e->{
            addl.add(e);
        });//note4
        for (int i = 0; i < addl.size(); i++) {
            System.out.println(addl.get(i));
        }
        List<String> addl2 = addl.stream().sorted().collect(Collectors.toList());//根据创建时间倒排
//        Collections.sort(addl);
        System.out.println();
    }

}
