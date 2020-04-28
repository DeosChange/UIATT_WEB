package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 忘记密码页面所有功能按钮元素，此处整合了邮箱、手机找回并重置的所有步骤
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class ForgetPWPageElements extends BaseElements{
	// 忘记密码的邮箱或手机
	public static final String RESET_USNAME = ".//*[@id='account']";
	
	// 下一步
	public static final String RESET_NEXT_BTN = ".//*[@id='resetInvalidNextBtn']";
	
	//又想起来了
	public static final String REMEMBER_AGAIN = ".//*[@id='rememberAgain']";
	
	//进入邮箱按钮
	public static final String NAVIGATE_TO_EMAIL = ".//div[@class='zhmm_but']";
	
	//没收到邮件，改为使用手机
	public static final String NAVIGATE_TO_PHONE = ".//*[@id='refMobile']";
	
	//设置新密码
	public static final String RESET_NEW_PW = ".//*[@id='password']";
	
	//确认密码
	public static final String RESET_CONFIRM_PW = ".//*[@id='passwordRepeat']";
	
	//重置密码的确定按钮
	public static final String RESET_PW_SUBMIT = ".//*[@id='setPassword']";
	
	//进入首页按钮，其实是跳转登陆页
	public static final String NAVIGATE_TO_LOGINPAGE = ".//div[@class='zh_width02']/a/div";
	
	//短信验证码的输入框
	public static final String MOBILE_VALIDCODE = ".//*[@id='validCode']";
	
	//发送短信验证码
	public static final String SEND_VALIDCODE = ".//*[@id='getmesg']";
	
	//手机找回下一步按钮
	public static final String VALIDCODE_NEXT_BTN = ".//*[@id='validSms']";
}
