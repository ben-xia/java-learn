package com.ben.java.algorithm.encryption;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.*;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 签名是非对称加密技术和摘要技术的综合运用用户A将明文和使用私钥加密的明文摘要一起发送给用户B,用户B使用公钥解密出摘要,
 * 然后使用相同的摘要算法将明文摘要,将两个摘要字符串比较如果相等 则表明内容没有被篡改 原理实现过程如下
 * 
 * @author ben xia
 * @date 2018年10月6日上午10:35:36
 */
public class DSATest01 {
	
	public static void main(String[] args) throws Exception {
		//获取公钥和私钥
		KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
		kpg.initialize(512);
		KeyPair kp=kpg.generateKeyPair();
		PublicKey pk=kp.getPublic();
		PrivateKey prk=kp.getPrivate(); 
		//使用私钥签名
		String message="hello my name is jiaozi";
		//返回的byte就可以进行传输
		byte[] srcByte=sign(message.getBytes(),prk);
		//假设这里模拟篡改数据 肯定会出现异常 或者检验不通过
		srcByte[9]=10;
		//存在公钥的用户 接受到该srcByte 就可以验证是否被篡改
		System.out.println(verify(srcByte,pk));
	}
	/**
	 * 签名过程
	 */
	public static byte[] sign(byte[] content,PrivateKey pk) throws Exception{
		//对明文进行摘要
		MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] zy=md.digest(content);
		
		//对摘要进行加密
		Cipher cp=Cipher.getInstance("RSA");
		cp.init(Cipher.ENCRYPT_MODE, pk);
		byte[] enZy=cp.doFinal(zy);
		//要一起传送的数据 双方约定好使用Map
		Map map=new HashMap();
		map.put("content", content);
		map.put("enZy", enZy);
		//传输过程使用byte数组 这里使用序列化将对象打包转换为字节数组
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
	    ObjectOutputStream oos=new ObjectOutputStream(baos);
	    oos.writeObject(map);
	    oos.close();
	    return baos.toByteArray();
	}
	
	/**
	 * 验证签名过程
	 */
	public static boolean verify(byte[] content,PublicKey pk) throws Exception{
		//将获取的数据转换为Map 
		ByteArrayInputStream baos=new ByteArrayInputStream(content);
	    ObjectInputStream oos=new ObjectInputStream(baos);
	    Map map=(Map)oos.readObject();
	    oos.close();
	    //获取到明文和加密的摘要信息
	    byte[] srcContent=(byte[])map.get("content");
	    byte[] enZy=(byte[])map.get("enZy");
	    
	    //使用相同的摘要算法 将明文摘要
	    MessageDigest md=MessageDigest.getInstance("MD5");
		byte[] contentZy=md.digest(srcContent);
	    //将加密的摘要解密
		Cipher cp=Cipher.getInstance("RSA");
		cp.init(Cipher.DECRYPT_MODE, pk);
		byte[] zy=cp.doFinal(enZy);
//		BASE64Encoder bas=new BASE64Encoder();
		Encoder bas = Base64.getEncoder();
		if(bas.encode(contentZy).equals(bas.encode(zy))){
			return true;
		}
		return false;
	}

	
	
}
