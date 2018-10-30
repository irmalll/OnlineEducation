package com.yucheng.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static String FileName = "WxTokenUtil.properties";
	public static String getAppId() {
		Properties prop = new Properties();// 属性集合对象
        InputStream fis = AccessTokenUtil.class.getClassLoader().getResourceAsStream(FileName);
        try {
			prop.load(fis);
			fis.close();// 关闭流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将属性文件流装载到Properties对象中
        
        //获取Appid，APPsecret
        String APPID = prop.getProperty("APPID");
		return APPID;
	}
	public static String getAppSecret() {
		Properties prop = new Properties();// 属性集合对象
        InputStream fis = AccessTokenUtil.class.getClassLoader().getResourceAsStream(FileName);
        try {
			prop.load(fis);
			fis.close();// 关闭流
		} catch (IOException e) {
			e.printStackTrace();
		}// 将属性文件流装载到Properties对象中
        
        //获取Appid，APPsecret
        String APPSECRET = prop.getProperty("APPSECRET");
		return APPSECRET;
	}
	

}
