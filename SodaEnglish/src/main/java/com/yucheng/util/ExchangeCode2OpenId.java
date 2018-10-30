package com.yucheng.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.json.ParseException;
import com.yucheng.constant.WechatConst;


/**
 * 通过code换取openId
 * 
 * @author 程高伟
 *
 * @date 2016年10月17日 下午7:05:34
 */
public class ExchangeCode2OpenId {
    private static Logger logger = LoggerFactory.getLogger(ExchangeCode2OpenId.class);

    public static String exchange(String code) {
        String openid = "";
        String appId = PropertiesUtil.getAppId();
        String appSecret = PropertiesUtil.getAppSecret();
        // 换取access_token 其中包含了openid
        // 这里通过code换取的是一个特殊的网页授权access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同。
        String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
                .replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
        String jsonStr = "";
		try {
			jsonStr = HttpUtil.httpRequest(URL, "GET", "");
				JSONObject jsonObj = (JSONObject) JSON.parse(jsonStr);
				openid = jsonObj.getString("openid");
			
			//logger.info("----------换取openid返回的结果:{}----------", jsonStr);
	        //JSONObject jsonObj = new JSONObject(jsonStr);
	        //openid = jsonObj.getString("openid");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        return openid;
    }
}
