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
public class VideoController {

	@RequestMapping("/mainlesson")
	public String buyNow(String code) {
		
        System.out.println("进入mainlesson");

		
		return "mainlesson";
	}
	
}
