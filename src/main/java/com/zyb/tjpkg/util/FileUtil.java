package com.zyb.tjpkg.util;

import java.io.*;
import java.net.URLDecoder;

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



	public static int getFileCount(String path) {
		int ret = -1;
		File file = new File(path);
		if(!file.exists()){
			System.out.println("路径不存在");
		}else {
			File[] files = file.listFiles();
			ret = files.length;
		}
		return ret;
	}

	public static String getFileType(int type) {
		String docType = "";
		if(type == 1){
			docType = "docx";
		}else if(type == 2){
			docType = "doc";
		}
		else if(type == 3){
			docType = "pdf";
		}
		else if(type == 4){
			docType = "html";
		}
		return docType;
	}

	public static int getFileType(String type) {
		int docType = 0;
		if(type.equals("docx")){
			docType = 1;
		}else if(type.equals("doc")){
			docType = 2;
		}
		else if(type.equals("pdf")){
			docType = 3;
		}
		else if(type.equals("html")){
			docType = 4;
		}
		return docType;
	}


	
	public static void main(String argv[]) throws IOException {
//		System.out.println(FileUtil.getPath());
		String path= "E:\\TEST\\test-files\\face-lines.txt";
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
		fis.close();
	}
}
