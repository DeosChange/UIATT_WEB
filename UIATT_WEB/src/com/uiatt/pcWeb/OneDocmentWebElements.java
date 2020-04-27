package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.OneDocmentPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 某个具体文章详情页面所有功能按钮元素
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class OneDocmentWebElements {
	// 未登录查看文章详情，提示立即登录
	@FindBy(xpath = OneDocmentPageElements.LOGIN_NOW)
	public static WebElement login_now;
	
	//未登录查看文库详情，提示医师认证
	@FindBy(xpath = OneDocmentPageElements.DOCT_AUTH)
	public static WebElement doct_auth;
	
	// “标签”字样
	@FindBy(xpath = OneDocmentPageElements.TAG_TITLE)
	public static WebElement tag_title;
	
	public static  WebDriver driver;
	
	
	//初始化
	public OneDocmentWebElements(WebDriver driver){
		OneDocmentWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断未登录查看病例详情，提示医师认证的按钮是否找到
	public static boolean doctAuthBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(OneDocmentPageElements.DOCT_AUTH));
    }
	
	//判断未登录查看病例详情，提示立即登录的按钮是否找到
	public static boolean loginNowBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(OneDocmentPageElements.LOGIN_NOW));
    }
	
	//判断“标签”按钮是否找到
	public static boolean tagTitleBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneDocmentPageElements.TAG_TITLE));
	}

}
