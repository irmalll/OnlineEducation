package com.yucheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yucheng.pojo.WeixinUserInfo;
import com.yucheng.util.AccessTokenUtil;
import com.yucheng.util.AdvancedUtil;
import com.yucheng.util.ExchangeCode2OpenId;

/**
 * 立即报名
 * 
 * @author Yohann-Zhang
 * @since 2018-06-06
 * @version 0.0.1
 * 
 */

@Controller
public class VipController {
	

	@RequestMapping("/vip")
	public ModelAndView vip(String code) throws Exception{
		
		//用户id
		String openId = ExchangeCode2OpenId.exchange(code);
		//有效令牌
		String accessToken = AccessTokenUtil.getAccessToken();
		//获取用户信息
		WeixinUserInfo userInfo = AdvancedUtil.getUserInfo(accessToken, openId);
		
        ModelAndView mav = new ModelAndView("vip");
        mav.addObject("nickName", userInfo.getNickname());
        mav.addObject("headImgUrl", userInfo.getHeadImgUrl());
      
		
		return mav;
	}
	
}
