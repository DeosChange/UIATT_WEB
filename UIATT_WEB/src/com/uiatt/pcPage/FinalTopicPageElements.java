package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 话题终端页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalTopicPageElements {
	//正在热议的第一篇话题
	public static final String FIRST_TOPIC = ".//ul[@class='v_l_list']/li[1]/div[2]/div[1]/a";

}
