package com.zyb.tjpkg.controller;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class XieyiScriptController {


    private static List<String> makeTpl() {
        List<String> listSh = new ArrayList<>();
        File file = new File("D:\\shs.txt");
        if (!(file.exists() && file.isFile() && file.canRead())) {
            System.err.println("Error: File not found or not readable");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                listSh.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSh;
    }

    public static byte[] getMubanFile(String remote) throws Exception {
        File file = new File(remote);
        if (!file.exists()) {
            throw new Exception();
        }
        return readNIO(file);
    }

    private static byte[] readNIO(File file) throws Exception {
        FileInputStream fin = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            fin = new FileInputStream(file);
            FileChannel channel = fin.getChannel();
            int capacity = 1024 << 3;//每次8K
            ByteBuffer bf = ByteBuffer.allocate(capacity);
//			System.out.println("限制是：" + bf.limit() + ",容量是：" + bf.capacity() + " ,位置是：" + bf.position());
            int length = -1;
            while ((length = channel.read(bf)) != -1) {
                bf.clear();
                outputStream.write(bf.array(), 0, length);
//				System.out.println("限制是：" + bf.limit() + "容量是：" + bf.capacity() + "位置是：" + bf.position());
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return outputStream.toByteArray();
    }

    public static void putFile(String remote, byte[] buf) throws Exception {
        if (remote.endsWith(File.separator)) {
            throw new Exception("111111111111111111111");
        }

        int index = 0;
        //根据最后一个分隔符，获取文件的路径，并创建相应的目录
        if ((index = remote.lastIndexOf(File.separator)) > 0 ||
                (index = remote.lastIndexOf("/")) > 0) {
            //获取文件存储的路径
            String s = remote.substring(0, index);
            //创建文件夹
        }

        File file = new File(remote);
        if (file.exists()) {
        }
        //创建新文件
        file.createNewFile();
        writeNIO(file, buf);
    }

    private static void writeNIO(File file, byte[] data) throws Exception {
        FileOutputStream fos = null;
        fos = new FileOutputStream(file);
        FileChannel channel = fos.getChannel();
        try {
            ByteBuffer bf = ByteBuffer.allocate(data.length);
            bf.put(data);
            bf.flip();
            channel.write(bf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fos != null) {
                try {
                    channel.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        byte[] data = getMubanFile("E:\\TEST\\test-files\\tpls\\tpl0");
        List<String> list = makeTpl();
        for (String sh : list) {
            putFile("E:\\TEST\\test-files\\tpls\\" + sh, data);
        }
        //
        byte[] data2 = getMubanFile("E:\\TEST\\test-files\\xlsxs\\1.xlsx");
        for (String sh : list) {
            putFile("E:\\TEST\\test-files\\xlsxs\\" + sh + ".xlsx", data2);
        }
    }
}
