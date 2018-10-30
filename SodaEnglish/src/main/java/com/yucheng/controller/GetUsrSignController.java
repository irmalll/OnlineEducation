package com.yucheng.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({""})
public class GetUsrSignController
{
  @ResponseBody
  @RequestMapping(value={"/getSignJson"}, method={org.springframework.web.bind.annotation.RequestMethod.GET}, produces={"application/json;charset=UTF-8"})
  public String getSingJson(HttpServletRequest request, HttpServletResponse response) throws IOException { 
   
    System.out.println("进入getSignJson");
    
    return "{\"signDay\":\"09\"},{\"signDay\":\"11\"},{\"signDay\":\"12\"},{\"signDay\":\"13\"}";
  }
}