package com.zyb.tjpkg.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yambo Zhang on 2020-04-07.
 */
public class GenSsFiles {

    public static final List<String> ss = Arrays.asList("武昌;	91420106MA4K274N6H",
            "汉口;	914201047680582504",
            "汉阳;	91420105MA4KN51E2R",
            "鄂州;	914207007707545702",
            "黄石;	91420200747658599M",
            "黄冈;	914211007739450306",
            "咸宁;	91421200764104029F",
            "孝感;	91420900770783806Q",
            "随州;	91421300767429988Q",
            "襄阳;	914206007476584176",
            "十堰;	9142030074765810XQ",
            "荆州;	91421000747697686T",
            "荆门;	91420800665482155G",
            "宜昌;	914205007444646939W",
            "恩施;	91422801767443624X",
            "潜江;	914290057739123943",
            "仙桃;	914290047707578434",
            "天门;	91429006773930189M");
    public static void main(String[] args) {
        /*ss.forEach(s->{
            try {
                mkdirs("E:\\PROJECTSS\\DZHT\\midArea\\湖北\\"+s.substring(0,s.indexOf(";")).trim());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });*/
        copy();
    }

    public static void copy() {
        ss.forEach(s->{
            //copy tpl
            try {
                copyAndReplace("E:\\PROJECTSS\\DZHT\\midArea\\湖北\\91420106737921226H",
                        "E:\\PROJECTSS\\DZHT\\midArea\\湖北\\"+s.substring(0,s.indexOf(";")).trim()+"\\"+s.substring(s.indexOf(";")+1).trim(),
                        s.substring(0,s.indexOf(";")).trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                copyAndReplace("E:\\PROJECTSS\\DZHT\\midArea\\湖北\\91420106737921226H",
                        "E:\\PROJECTSS\\DZHT\\midArea\\湖北\\tpl\\"+s.substring(s.indexOf(";")+1).trim(),
                        s.substring(0,s.indexOf(";")).trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //copy excel
            try {
                copy("E:\\PROJECTSS\\DZHT\\midArea\\湖北\\91420106737921226H.xlsx",
                        "E:\\PROJECTSS\\DZHT\\midArea\\湖北\\"+s.substring(0,s.indexOf(";")).trim()+"\\"+s.substring(s.indexOf(";")+1).trim()+".xlsx");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                copy("E:\\PROJECTSS\\DZHT\\midArea\\湖北\\91420106737921226H.xlsx",
                        "E:\\PROJECTSS\\DZHT\\midArea\\湖北\\xlsx\\"+s.substring(s.indexOf(";")+1).trim()+".xlsx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void mkdirs(String remote) throws Exception {
        if (!remote.endsWith(File.separator)) {
            remote = remote + File.separator;
        }

        File dir = new File(remote);
        if (dir.exists()) {
            return;
        }
        dir.mkdirs();
    }

    public static void copy(String src, String dst) throws Exception {
        File srcFile = new File(src);
        if (!srcFile.exists()) {
            throw new Exception();
        }

        File destFile = new File(dst);
        if (destFile.exists()) {
            destFile.delete();
        } else {
            destFile.getParentFile().mkdirs();
            destFile.createNewFile();
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int byteread = 0;
            while ((byteread = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteread);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    public static void copyAndReplace(String src, String dst,String replaceName) throws Exception {
        File srcFile = new File(src);
        if (!srcFile.exists()) {
            throw new Exception();
        }

        File destFile = new File(dst);
        if (destFile.exists()) {
            destFile.delete();
        } else {
            destFile.getParentFile().mkdirs();
            destFile.createNewFile();
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int byteread = 0;
            //替换txt再转成inputstream
            /*String result = new BufferedReader(new InputStreamReader(is))
                    .lines().parallel().collect(Collectors.joining(System.lineSeparator()));
            result = result.replace("乙方：湖北航天信息技术有限公司","乙方：湖北航天信息技术有限公司"+replaceName+"分公司");
            is = new ByteArrayInputStream(result.getBytes());*/

            while ((byteread = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteread);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }
}
