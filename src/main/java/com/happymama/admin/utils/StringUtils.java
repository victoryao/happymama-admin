/*
 * @(#)StringUtils.java	2012-11-26
 *
 * Copyright 2012 Mobile Internet, Inc. All rights reserved.
 * XiaoMi PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.happymama.admin.utils;

/**
 * @author edwin
 * @email wangfuye@xiaomi.com
 * @date 2012-11-26 下午08:45:53
 * 
 */
public abstract class StringUtils {

	public static boolean isBlank(String s){
		return s == null || s.trim().length() == 0;
	}
	public static boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	}

	public static boolean isUpperCase(char c) {
		return c >= 'A' && c <= 'Z';
	}

	public static char toLowerCase(char c) {
		if (!isUpperCase(c)) return c;
		return (char) (c + 32);
	}
	
	/**
	 * 补全0
	 * @param value
	 * @return
	 */
	public static String fillStr(Integer value){
		  String mkup_zero = "00000";
		  String new_value = mkup_zero+value;
		  new_value=new_value.substring(new_value.length()-5, new_value.length());
		  return new_value;
	 }
	
	/**
	 * 验证数字
	 * @param str
	 * @return
	 */
    public static boolean isNumber(String str) 
    { 
        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[1-9][0-9]*"); 
        java.util.regex.Matcher match=pattern.matcher(str); 
        if(match.matches()==false)  { 
           return false; 
        } else { 
           return true; 
        } 
    }
    
	/**
	 * 正则验证
	 * @param str
	 * @return
	 */
    public static boolean checkRegex(String str,String regex) 
    { 
        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile(regex); 
        java.util.regex.Matcher match=pattern.matcher(str); 
        if(match.matches()==false)  { 
           return false; 
        } else { 
           return true; 
        } 
    }
    
    /**
	 * 去掉换行符
	 * @param str
	 * @return
	 */
    public static String trimEnter(String str){
    	return str.replace("\\n", "").replace("\\r", "");
    }
	
}
