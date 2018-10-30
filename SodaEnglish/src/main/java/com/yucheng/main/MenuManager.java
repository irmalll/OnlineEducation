
package com.yucheng.main;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yucheng.menu.Button;
import com.yucheng.menu.ClickButton;
import com.yucheng.menu.ComplexButton;
import com.yucheng.menu.Menu;
import com.yucheng.menu.ViewButton;
import com.yucheng.pojo.Token;
import com.yucheng.util.AccessTokenUtil;
import com.yucheng.util.CommonUtil;
import com.yucheng.util.MenuUtil;


/**
 * 菜单管理器类
 * 
 * @author liufeng
 * @date 2013-10-17
 */

public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
/**
	 * 定义菜单结构
	 * 
	 * @return
	 */

	private static Menu getMenu() {
		
ClickButton btn11 = new ClickButton();
		btn11.setName("立即报名");
		btn11.setType("click");
		btn11.setKey("buyNow");


		
        ClickButton btn12 = new ClickButton();
		btn12.setName("ITeye");
		btn12.setType("click");
		btn12.setKey("iteye");


		ViewButton btn13 = new ViewButton();
		btn13.setName("立即报名");
		btn13.setType("view");
		//btn13.setUrl("http://gy3hfj.natappfree.cc/redirect");
		btn13.setUrl("http://soda.s1.natapp.cc/redirect");
		//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa2e858736eec406c&redirect_uri=gy3hfj.natappfree.cc/buynow?response_type=code&scope=snsapi_base&state=1&connect_redirect=1#wechat_redirect

		ViewButton btn21 = new ViewButton();
		btn21.setName("开始学习");
		btn21.setType("view");
		btn21.setUrl("http://soda.s1.natapp.cc/info");

		
        ViewButton btn22 = new ViewButton();
		btn22.setName("京东");
		btn22.setType("view");
		btn22.setUrl("http://m.jd.com");

		ViewButton btn23 = new ViewButton();
		btn23.setName("唯品会");
		btn23.setType("view");
		btn23.setUrl("http://m.vipshop.com");

		ViewButton btn24 = new ViewButton();
		btn24.setName("当当网");
		btn24.setType("view");
		btn24.setUrl("http://m.dangdang.com");


		ViewButton btn25 = new ViewButton();
		btn25.setName("苏宁易购");
		btn25.setType("view");
		btn25.setUrl("http://m.suning.com");


		ViewButton btn31 = new ViewButton();
		btn31.setName("免费公开课");
		btn31.setType("view");
		btn31.setUrl("http://m.suning.com");

		ViewButton btn32 = new ViewButton();
		btn32.setName("课程试听");
		btn32.setType("view");
		btn32.setUrl("http://www.yi588.com");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("技术交流");
		mainBtn1.setSub_button(new Button[] { btn11, btn12 });


		
        ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("开始学习");
		mainBtn2.setSub_button(new Button[] { btn21, btn22 });


		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("新人福利");
		mainBtn3.setSub_button(new Button[] { btn31, btn32 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { btn13, btn21, mainBtn3 });

		return menu;
	}

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wxa2e858736eec406c";
		// 第三方用户唯一凭证密钥
		String appSecret = "a3861d0bcf8ecc7965f265f6bca72723";

		// 调用接口获取凭证
		String token = AccessTokenUtil.getAccessToken();

		if (null != token) {
			// 创建菜单
			boolean result = MenuUtil.createMenu(getMenu(), token);

			// 判断菜单创建结果
			if (result)
			System.out.println("菜单创建成功");
			else
			System.out.println("菜单创建失败");
		}
	}
}

