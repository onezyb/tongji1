package com.zyb.tjpkg.util;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static String getPath() {
        return URLDecoder.decode(FileUtil.class.getResource("/").getPath());
    }

    public static byte[] read(String file) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            byte buf[] = new byte[in.available()];
            in.read(buf, 0, buf.length);
            in.close();
            return buf;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean write(String file, byte[] data, boolean append) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, append));
            out.write(data);
            out.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    /**
     * @Author：
     * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
     * @Date：
     */
    public static List<Object> getDirs(String path) {
        List<Object> files = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i]);
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
                files.add(tempList[i].getPath());
                System.out.println(tempList[i].getPath());
            }
        }
        return files;
    }

    /*public static List<File> getFiles(String path) {
    }*/

    //
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

    public static void main(String argv[]) throws IOException {
//		System.out.println(FileUtil.getPath());
        /*String path= "E:\\TEST\\test-files\\face-lines.txt";
        FileInputStream fis = new FileInputStream(path);
		// 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while ((line = br.readLine()) != null) {
		System.out.println(SMS4.decodeSMS4toString("91110108MA001K7YXU",line));
		}
		br.close();
		isr.close();
		fis.close();*/
        List<Object> listDir = getDirs("E:\\BaiduPan\\Download\\周杰伦 - 全部专辑（无损或320K）");
        for (Object dir : listDir) {
            List<Object> files = getDirs((String) dir);
            for (Object file : files) {
                try {
                    String musicName = null;
                    try {
                        musicName = ((File) file).getName();
                    } catch (Exception e) {
                        System.err.println(musicName);
                        System.err.println(dir);
                        continue;
                    }
                    copy(((File) file).getAbsolutePath(), "E:\\jayAll\\" + musicName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
