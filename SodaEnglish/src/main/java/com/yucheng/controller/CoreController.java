package com.yucheng.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yucheng.core.service.CoreService;
import com.yucheng.util.SignUtil;

/**
 * 签名controller
 * 
 * @author Yohann-Zhang
 * @since 2018-06-06
 * @version 0.0.1
 * 
 */

@RestController
@RequestMapping("/core")
public class CoreController {
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 微信加密签名
				String signature = request.getParameter("signature");
				// 时间戳
				String timestamp = request.getParameter("timestamp");
				// 随机数
				String nonce = request.getParameter("nonce");
				// 随机字符串
				String echostr = request.getParameter("echostr");

				//PrintWriter out = response.getWriter();
				// 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				}
		return echostr;
	}
	@ResponseBody
	@RequestMapping( value = "",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 接收参数微信加密签名、 时间戳、随机数
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		//PrintWriter out = response.getWriter();
		String respXml = "";
		// 请求校验
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			// 调用核心服务类接收处理请求
			 respXml = CoreService.processRequest(request);
		}
		System.out.println(respXml);
		try {
			Thread.sleep(400000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respXml;
	}

	

}
