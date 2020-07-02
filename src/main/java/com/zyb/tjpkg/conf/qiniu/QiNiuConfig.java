package com.zyb.tjpkg.conf.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.codec.binary.Base64;

import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 * 七牛云存储图片上传demo
 * @author p
 *
 */
@org.springframework.context.annotation.Configuration
public class QiNiuConfig {
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	private String ACCESS_KEY = "RyBi68IB2c1rv3F1wYFaTnkW-5el_u2sgHzsSe5k";
	private String SECRET_KEY = "wh_ZyN2a7v1izkUaEoHSuSBJmpAv5MTSQEdNxdie";
	// 要上传的空间
	private String bucketname = "interface-images";

	private String baseUrl = "http://api-image.i-xinnuo.com/";

	// 密钥配置
	private Auth auth;
	// 创建上传对象
	private UploadManager uploadManager;

	@PostConstruct
	public void init() {
		auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		uploadManager = new UploadManager(new Configuration());
	}

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}
	/**
	 * 字符串格式上传
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String upload(String data) throws IOException {
		try {

			UUID uuid = UUID.randomUUID();
			// 调用put方法上传
			Response res = uploadManager.put(data.getBytes(), uuid.toString(), getUpToken());

			return uuid.toString();
			
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		
		return null;
	}

	/**
	 * 数组上传
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String upload(byte[] data) throws IOException{
		try {
			UUID uuid = UUID.randomUUID();
			Response res = uploadManager.put(data, uuid.toString(), getUpToken());
			return uuid.toString();
		} catch (QiniuException e) {
			Response r = e.response;
			System.out.println(r.toString());
			try {
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
			}
		}
		return null;
	}
	
	
	
	public String get(String uuid) {
		return auth.privateDownloadUrl(baseUrl + uuid);
	}

	public byte[] getBytes(String uuid) throws Exception{

		String url = auth.privateDownloadUrl(baseUrl + uuid);


		return getFile(url);
	}


	/**
	 * 获取 文件 流
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	private byte[] getFile(String urlStr) throws IOException{

		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//设置超时间为3秒
		conn.setConnectTimeout(3*1000);
		//防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		//得到输入流
		InputStream inputStream = conn.getInputStream();
		byte[] bytes = readInputStream(inputStream);

		return generateImage(new String(bytes));
	}

	public static byte[] generateImage(String imgStr){
		try
		{
			//Base64解码
			byte[] b = Base64.decodeBase64(imgStr);
			for(int i=0;i<b.length;++i)
			{
				if(b[i]<0)
				{//调整异常数据
					b[i]+=256;
				}
			}
			//生成jpeg图片

			return b;
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		return null;
	}

	/**
	 * 从输入流中获取字节数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static  byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void main(String args[]) throws IOException {
	 // 上传文件的路径
	    String fileName = "D:/b.PNG";
		String upload = new QiNiuConfig().upload(fileName);

		System.out.println(new QiNiuConfig().get("ae833aa8-b09d-4d55-8e73-2129aed95f9c"));
	}

}