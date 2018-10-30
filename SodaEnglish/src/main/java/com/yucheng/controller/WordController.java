package com.yucheng.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yucheng.core.service.CoreService;
import com.yucheng.util.SignUtil;

/**
 * 立即报名
 * 
 * @author Yohann-Zhang
 * @since 2018-06-06
 * @version 0.0.1
 * 
 */

@Controller
public class WordController {

	@RequestMapping("/actile")
	public String checkApply(){
		System.out.println("进入actile");
		return "actile";
	}
	
}
