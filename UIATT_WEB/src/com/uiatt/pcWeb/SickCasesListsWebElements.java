package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.SickCasesListsPageElements;

/**
 * 提取2.0 PC 病例列表页面，即用于排序并筛选的页面，所有功能按钮元素
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class SickCasesListsWebElements {
	public static Logger logger = Logger.getLogger(SickCasesListsWebElements.class );
	//“最多评论”项
	@FindBy(xpath = SickCasesListsPageElements.MOST_COMMENT)
	public static WebElement most_comment;
	
	//“最多浏览”项
	@FindBy(xpath = SickCasesListsPageElements.MOST_VISIT)
	public static WebElement most_visit;
	
	//“最新发布”项
	@FindBy(xpath = SickCasesListsPageElements.LATEST_PUBLISH)
	public static WebElement latest_publish;

	
	
	
	
}
