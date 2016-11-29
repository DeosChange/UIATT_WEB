package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 点击聊话题后弹出的编辑窗体的所有元素；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PublishTopicPageElements {
	//话题类型:随便聊聊
	public static final String TOPIC_TYPE_FIRST = "(.//input[@name='topicType'])[1]";
	
	//话题标题
	public static final String TOPIC_TITLE = ".//*[@id='topic_name']";
	
	//话题标签
	public static final String TOPIC_LABEL = ".//*[@id='areaTitle1']";
	
	//话题标签第一个选项
	public static final String TOPIC_LABEL_VALUE1 = ".//ul[@id='areaExp1']/li[1]";
	
	//文字讨论
	public static final String TOPIC_TXT_DISCUSS = ".//*[@id='topic_discuss']";
	
	//添加第一张照片按钮
	public static final String TOPIC_ADDFIRPHO_BTN = ".//div[@id='uploadifyToc']/object";
	
	//添加第二章照片按钮
	public static final String TOPIC_ADDSECPHO_BTN = ".//div[@id='uploadifyTop_con']/object";
	
	//删除第二张照片按钮
	public static final String TOPIC_FIRPHOREMOVE_BTN = "(.//ul[@id='topic_img_queue']/li/div/img)[2]";
	
	//提醒谁看输入框
	public static final String TOPIC_REMIND_INPUT = ".//div[@class='remind_par']/input";
	
	//此处不考虑匹配出的正确性，直接先选取第一个被匹配出的人
	public static final String REMIND_MATCHED_FIRST = ".//ul[@class='remind_list']/li[1]";
	
	//话题发布按钮
	public static final String TOPIC_PUBLISH = ".//*[@id='topic_save']";
	
	//话题标签隐藏的选项区
	public static final String TOPIC_LABEL_DISPLAYLIST = ".//div[@class='publish_zy_position']";
	
	//新增话题时的编辑窗体
	public static final String EDIT_WINDOW = ".//div[@class='fb_doc']";
}
