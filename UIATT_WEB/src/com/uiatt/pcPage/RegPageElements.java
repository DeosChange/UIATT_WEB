package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 注册页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class RegPageElements {
	// 注册用户名按钮
	public static final String REG_USERNAME = ".//*[@id='popEmail']";
	
	// 注册密码
	public static final String REG_PWD = ".//*[@id='popCustomerPassword']";
	
	// 确认密码
	public static final String REG_PWD_CONFIRM = ".//*[@id='passwordRepeat']";
	
	// 邮箱注册验证码输入框
	public static final String REG_EMAIL_VALIDCODE = ".//*[@id='validCode1']";
	
	// 手机注册发送验证码按钮
	public static final String SEND_PHONE_VALIDCODE = ".//*[@id='getmesg']/div";
		
	// 手机注册验证码输入框
	public static final String REG_PHONE_VALIDCODE = ".//*[@id='validCode2']";
	
	// 注册按钮
	public static final String REG_BTN = ".//*[@id='popImageSubmit']/div";
	
	// 用户名错误提示信息
	public static final String REG_USERNAME_NOTICE = ".//label[@for='popEmail']";
	
	// 密码错误提示信息
	public static final String REG_PWD_NOTICE = ".//label[@for='popCustomerPassword']";
	
	// 再次输入密码错误提示信息
	public static final String REG_PWD_CONFIRM_NOTICE = ".//label[@for='passwordRepeat']";
	
	// 邮箱验证码错误提示信息
	public static final String REG_EMAIL_VALIDCODE_NOTICE = ".//label[@for='validCode1']";
	
	// 短信验证码错误提示信息
	public static final String REG_PHONE_VALIDCODE_NOTICE = ".//label[@for='validCode2']";
	
	
		

}
