package com.uiatt.pcPage;

/**
 * 提取2.0 PC 病例列表页面，即用于排序并筛选的页面，所有功能按钮元素
 * author : Change
 * 
 * */
public class SickCasesListsPageElements {
	//“最多评论”项
	public static final String MOST_COMMENT = ".//div[text()='最多评论']";

	//“最多浏览”项
	public static final String MOST_VISIT = ".//div[text()='最多浏览']";
	
	//“最新发布”项
	public static final String LATEST_PUBLISH = ".//div[text()='最新发布']";
	
	//"专业"选项
	public static final String PROFESSIONAL_ITEMS = ".//div[@id='downSelector']/div[1]/div[1]";
	
	//"标签"选项
	public static final String TITLE_ITEMS = ".//div[@id='downSelector']/div[1]/div[2]";
	
	//“专业”选项下的第一个选项，一般为“关节”
	public static final String JOINT_IN_PROFESSIONAL = ".//a[text()='关节']";
	
	//“标签”选项下的第一个选项，一般为“人工髋关节置换”
	public static final String HIP_JOINT_IN_TITLEITEMS = ".//a[text()='人工髋关节置换']";
	
	//列表中的“阅读：XX”，此路径返回多个，需要在webElement转换时循环取
	public static final String VISIT_VALUE = ".//li[contains(text(),'阅读')]";
	
	//列表中的“评论：XX”，此路径返回多个，需要在webElement转换时循环取
	public static final String COMMENT_VALUE = ".//li[contains(text(),'评论数')]";
	
	//列表中的日期，例如“2015-06-07”，此路径返回多个，需要在webElement转换时循环取
	public static final String TIME_VALUE = ".//li[@class='time']";
	
	//列表中的文章标题，此路径返回多个，需要在webElement转换时循环取
	public static final String MOST_COMMENTS = ".//div[@class='list_cont_name']";
}
