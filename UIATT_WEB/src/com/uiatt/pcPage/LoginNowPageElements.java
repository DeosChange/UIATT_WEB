package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 立即登录页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginNowPageElements {
	//默认的会员登录用户名
	public static final String ALLIN_USERNAME = ".//input[@name='email']";
	
	//默认的会员登录密码
	public static final String ALLIN_PW = ".//input[@name='passwd']";
	
	//默认的会员登录按钮
	public static final String ALLIN_LOGIN_BTN = ".//div[@class='login_but']/div";
	
	//捕获不正确的用户名或密码的错误提示
	public static final String WRONG_USNORPW_NOTI = ".//*[@id='popLoginForm']/div[1]/div";
	

}
