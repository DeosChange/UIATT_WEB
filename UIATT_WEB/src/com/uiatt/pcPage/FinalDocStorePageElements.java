package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 文库终端页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalDocStorePageElements {
	//推荐指南中的第一篇文章
	public static final String FIRST_DOCUMENT = ".//div[@class='doc_fl_list']/ul/li[1]/div[2]/a";
	

}
