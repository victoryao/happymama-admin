package com.happymama.admin.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

@SuppressWarnings("restriction")
public class Base64Utils {

	public static String encrypt(String key){
		return (new BASE64Encoder()).encodeBuffer(key.getBytes()); 
	}
	
	public static String decrypt(String data) throws IOException
	{
		 BASE64Decoder decoder = new BASE64Decoder();
		 byte[] bytes = decoder.decodeBuffer(data);
		 return new String(bytes);
	}
}
