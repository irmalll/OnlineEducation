package com.yucheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yucheng.core.service.CoreService;
import com.yucheng.util.SignUtil;

/**
 *微信认证登陆处理类
 * @author Yohann-Zhang
 * @since 2018-06-06
 * @version 0.0.1
 * 
 */

@RestController
public class RedirectController {
	
	@ResponseBody
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String redirectUrl = URLEncoder.encode("http://soda.s1.natapp.cc/vip");
		String Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa2e858736eec406c&redirect_uri="+redirectUrl+"?response_type=code&scope=snsapi_userinfo&state=1&connect_redirect=1#wechat_redirect";
		response.sendRedirect(Url);
	}

	

}
