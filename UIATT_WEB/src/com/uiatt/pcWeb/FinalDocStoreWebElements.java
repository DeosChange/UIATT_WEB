package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.FinalDocStorePageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 文库终端页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalDocStoreWebElements {
	public static Logger logger = Logger.getLogger(FinalDocStoreWebElements.class );
	// 推荐指南中的第一篇文章
	@FindBy(xpath = FinalDocStorePageElements.FIRST_DOCUMENT)
	public static WebElement first_document;
	
	public static  WebDriver driver;
	
	
	//初始化
	public FinalDocStoreWebElements(WebDriver driver){
		FinalDocStoreWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断推荐指南中的第一篇文章是否找到
	public static boolean firstDocumentIsExist() {
    	return Utils.isElementExist(driver, By.xpath(FinalDocStorePageElements.FIRST_DOCUMENT));
    }

}
