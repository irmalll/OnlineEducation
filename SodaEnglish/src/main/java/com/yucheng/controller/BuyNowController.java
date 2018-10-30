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
public class BuyNowController {

	@RequestMapping("/buynow")
	public ModelAndView buyNow(String code) throws Exception{
		
		System.out.println("code:"+code);
		//用户id
		String openId = ExchangeCode2OpenId.exchange(code);
		//有效令牌
		String accessToken = AccessTokenUtil.getAccessToken();
		//获取用户信息
		WeixinUserInfo userInfo = AdvancedUtil.getUserInfo(accessToken, openId);
		System.out.println("=====userInfo===="+userInfo);
		//String imgUrl = userInfo.getHeadImgUrl();
		//String fileName = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\css\\images\\"+openId+".jpg";
		//DownloadUtils.download(imgUrl, fileName);
		//String headImgPath = "images/"+ openId+".jpg";
		// 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView mav = new ModelAndView("buynow");
        mav.addObject("userInfo", userInfo);
        //mav.addObject("headImgPath", headImgPath);
        

		
		return mav;
	}
	
}
