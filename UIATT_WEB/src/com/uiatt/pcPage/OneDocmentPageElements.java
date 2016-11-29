package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 某个具体文章详情页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class OneDocmentPageElements {
	//未登录查看文库详情，提示立即登录
	//public static final String LOGIN_NOW = ".//img[@class='login_mask']";
	public static final String LOGIN_NOW = ".//div[@class='mask_text_but']/a/img";
	
	//未登录查看文库详情，提示医师认证
	//public static final String LOGIN_NOW = ".//img[@class='renzheng_mask']";
	public static final String DOCT_AUTH = ".//div[@class='mask_text_but']/a/img";
		
	//“标签”字样
	public static final String TAG_TITLE = ".//div[@class='video_tag_title']";
	
}
