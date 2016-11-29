package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 搜索结果页面所有功能按钮元素
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class SearchResultsPageElements {
	//搜索出的病例结果选项
	public static final String SICKCASE_OPTION = "(.//div[@class='list_left_text'])[1]";
	
	//病例结果统计
	public static final String SICKCASE_STATISTICS = "(.//div[@class='list_left_num']/span)[1]";
	
	//搜索出的话题结果选项
	public static final String TOPIC_OPTION = "(.//div[@class='list_left_text'])[2]";
	
	//话题结果统计
	public static final String TOPIC_STATISTICS = "(.//div[@class='list_left_num']/span)[2]";
		
	//搜索出的视频结果选项
	public static final String VIDEO_OPTION = "(.//div[@class='list_left_text'])[3]";
	
	//视频结果统计
	public static final String VIDEO_STATISTICS = "(.//div[@class='list_left_num']/span)[3]";
		
	//搜索出的文章结果选项
	public static final String DOCUMENT_OPTION = "(.//div[@class='list_left_text'])[4]";
	
	//文章结果统计
	public static final String DOCUMENT_STATISTICS = "(.//div[@class='list_left_num']/span)[4]";
		
	//搜索出的用户结果选项
	public static final String USER_OPTION = "(.//div[@class='list_left_text'])[5]";
	
	//用户结果统计
	public static final String USER_STATISTICS = "(.//div[@class='list_left_num']/span)[5]";
	
	//各个项搜索出的结果的关键字匹配
	public static final String OPTION_RESULT_KEYWORD = ".//div[@class='search_floor']/div[1]/span[1]";
	
	//各个项搜索出的结果的统计数字匹配
	public static final String OPTION_RESULT_STATISTICS = ".//div[@class='search_floor']/div[1]/span[2]";
	
	
	
}
