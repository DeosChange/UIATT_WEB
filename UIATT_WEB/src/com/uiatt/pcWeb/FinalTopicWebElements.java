package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.FinalTopicPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 话题终端页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalTopicWebElements {
	public static Logger logger = Logger.getLogger(FinalTopicWebElements.class );
	// 正在热议的第一篇话题
	@FindBy(xpath = FinalTopicPageElements.FIRST_TOPIC)
	public static WebElement first_topic;
	
	public static  WebDriver driver;
	
	
	//初始化
	public FinalTopicWebElements(WebDriver driver){
		FinalTopicWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断正在热议的第一篇话题是否找到
	public static boolean firstTopicIsExist() {
    	return Utils.isElementExist(driver, By.xpath(FinalTopicPageElements.FIRST_TOPIC));
    }
}
