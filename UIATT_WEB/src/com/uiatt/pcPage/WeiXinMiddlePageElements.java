package com.uiatt.pcPage;


import org.testng.annotations.Listeners;


/**
 * 注册并完成医师认证后跳转的微信扫码关注公众号的中间页面；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class WeiXinMiddlePageElements {
	// 显示为“欢迎你，XX”
	public static final String WELCOME_TITLE = ".//div[@class='weixin_con']/div[1]";
	
	// 跳过,如果是从注册后直接到医师认证完成的微信关注页的跳过，为此路径
	public static final String SKIP_WEIXIN_SCAN = ".//div[@class='LightBox-regist']";
	
	//跳过，如果是注册后跳过认证，但在操作文库、病例、话题等终端的详情页造成的权限提示后，从该入口进入的医师认证后跳转的微信关注页的跳过按钮，路径值竟然与从注册后直接到医师认证完成的微信关注页的跳过路径值不同，坑啊！！！切记！
	public static final String SKIP_WEIXIN_SCAN_ACCESS = ".//div[@class='LightBox-btns']/div";
	

	
}
