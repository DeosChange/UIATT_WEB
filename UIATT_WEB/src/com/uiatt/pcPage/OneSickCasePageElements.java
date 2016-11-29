package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 某个具体病例详情页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class OneSickCasePageElements {
	//未登录查看病例详情，提示立即登录
	//public static final String LOGIN_NOW = ".//img[@class='login_mask']";
	public static final String LOGIN_NOW = ".//div[@class='mask_text_but']/a/img";
	
	//未登录查看文库详情，提示医师认证
	//public static final String LOGIN_NOW = ".//img[@class='renzheng_mask']";
	public static final String DOCT_AUTH = ".//div[@class='mask_text_but']/a/img";
	
	//“标签”字样
	public static final String TAG_TITLE = ".//div[@class='video_tag_title']";
	
	//患者信息：性别和年龄
	public static final String SEX_AGE = "(.//div[@class='cdr_xb'])[1]";

	//直接给资源主体评论的输入框
	public static final String COMMENT_INPUT = ".//textarea[@class='evModuleReplyForm']";
	
	//直接给资源主体评论的添加图片按钮
	public static final String ADD_PHOTO = ".//div[@class='photo_bg']/div/input";
	
	//直接给资源主体评论的提醒谁看按钮
	public static final String REMIND_SOMEBODY = ".//div[@class='btn_place']/div[2]";
	
	//直接给资源主体评论的提醒谁看输入框
	public static final String SCCOM_REMIND_INPUT = ".//input[@class='remind_input']";
	
	//直接给资源主体评论的提醒谁看第一个被匹配出来的用户
	public static final String SCCOM_REMI_FIR_MATCH = ".//ul[@class='remind_list']/li[1]";
	
	//直接给资源主体评论的发布按钮
	public static final String PUB_COM_BTN = ".//div[@class='video_c_but']/div[2]";
	
	//第一条已发布的评论文本内容
	public static final String FIRST_PUBLISHED_CONTENT = "(.//div[@class='v_all_cont_v2']/div[2])[1]";
	
	//第一条评论的删除图标
	public static final String REMOVE_BTN = "(.//a[@class='off'])[1]";
}
