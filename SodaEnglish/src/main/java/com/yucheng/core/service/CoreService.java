package com.yucheng.core.service;


import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


import com.yucheng.core.req.TextMessage;
import com.yucheng.util.MessageUtil;

/*
 * Yohann-Zhang
 */
public class CoreService {

	public static String processRequest(HttpServletRequest request) {
		String respXml = null;
		String respContent = "欢迎关注";
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			//如果是关注事件，自动回复欢迎，并入库保存
            if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(msgType)){
            	TextMessage textMessage = new TextMessage();
    			textMessage.setToUserName(fromUserName);
    			textMessage.setFromUserName(toUserName);
    			textMessage.setCreateTime(new Date().getTime());
    			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
    			textMessage.setContent(respContent);
    			respXml = MessageUtil.messageToXml(textMessage);
    			
            }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
