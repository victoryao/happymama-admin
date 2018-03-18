/*
* @(#)ObjectToMap.java  2013-1-7
*
* Copyright 2012 Mobile Internet, Inc. All rights reserved.
* XiaoMi PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/
package com.happymama.admin.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghui
 * @email zhanghui@xiaomi.com
 * @date   2013-1-7 上午11:23:00
 *
 */
public class ObjectUtil {
	/**
	 * 对象转MAP
	 * @param obj
	 * @return
	 */
	public static  Map<String, Object>  toMap(Object obj){
		Map<String, Object> map=new HashMap<String, Object>();
		if (null!=obj) {
			String[] fieldNames=getFiledName(obj);  
		    for(int i=0;i<fieldNames.length;i++){  
		        Object value=getFieldValueByName(fieldNames[i], obj); 
		        //System.out.println(fieldNames[i]+" "+value);
		        map.put(fieldNames[i], value);
		    } 
		}
		return map;
	}
	
	public static  Map<String, String>  toStrMap(Object obj){
		Map<String, String> map=new HashMap<String, String>();
		if (null!=obj) {
			String[] fieldNames=getFiledName(obj);  
		    for(int i=0;i<fieldNames.length;i++){  
		        String value=String.valueOf(getFieldValueByName(fieldNames[i], obj)); 
		        //System.out.println(fieldNames[i]+" "+value);
		        map.put(fieldNames[i], value);
		    } 
		}
		return map;
	}
	/** 
	 * 根据属性名获取属性值 
	* */  
	public static Object getFieldValueByName(String fieldName, Object o) {  
       try {    
           String firstLetter = fieldName.substring(0, 1).toUpperCase();    
           String getter = "get" + firstLetter + fieldName.substring(1);    
           Method method = o.getClass().getMethod(getter, new Class[] {});    
           Object value = method.invoke(o, new Object[] {});    
           return value;    
       } catch (Exception e) {      
           return null;    
       }    
   }   
	     
   /** 
    * 获取属性名数组 
    * */  
   public static String[] getFiledName(Object o){  
    Field[] fields=o.getClass().getDeclaredFields();  
        String[] fieldNames=new String[fields.length];  
    for(int i=0;i<fields.length;i++){  
        fieldNames[i]=fields[i].getName();  
    }  
    return fieldNames;  
   }  
     
   /** 
    * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list 
    * */  
   public static List getFiledsInfo(Object o){  
    Field[] fields=o.getClass().getDeclaredFields();  
        String[] fieldNames=new String[fields.length];  
        List list = new ArrayList();  
        Map infoMap=null;  
    for(int i=0;i<fields.length;i++){  
        infoMap = new HashMap();  
        infoMap.put("type", fields[i].getType().toString());  
        infoMap.put("name", fields[i].getName());  
        infoMap.put("value", getFieldValueByName(fields[i].getName(), o));  
        list.add(infoMap);  
    }  
    return list;  
   }  
     
   /** 
    * 获取对象的所有属性值，返回一个对象数组 
    * */  
   public static Object[] getFiledValues(Object o){  
    String[] fieldNames=getFiledName(o);  
    Object[] value=new Object[fieldNames.length];  
    for(int i=0;i<fieldNames.length;i++){  
        value[i]=getFieldValueByName(fieldNames[i], o);  
    }  
    return value;  
   }
}
