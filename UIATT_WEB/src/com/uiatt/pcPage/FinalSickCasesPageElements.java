package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 病例终端页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalSickCasesPageElements {
	//正在热议的第一条病例
	public static final String FIRST_CASE = ".//ul[@class='v_l_list']/li[1]/div[2]/div[1]/a";
	
	//第一个“更多”按钮，一般为“正在热议”的“更多”
	public static final String FIRST_MORE = "(.//div[@class='new_sc_more']/a)[1]";

}
