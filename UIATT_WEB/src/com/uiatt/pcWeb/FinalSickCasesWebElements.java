package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.FinalSickCasesPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;
/**
 * 提取2.0 PC 病例终端页面所有功能按钮元素
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class FinalSickCasesWebElements {
	public static Logger logger = Logger.getLogger(FinalSickCasesWebElements.class );
	// 正在热议的第一条病例
	@FindBy(xpath = FinalSickCasesPageElements.FIRST_CASE)
	public static WebElement first_case;
	
	//第一个“更多”按钮，一般为“正在热议”的“更多”
	@FindBy(xpath = FinalSickCasesPageElements.FIRST_MORE)
	public static WebElement first_more;
	
	public static  WebDriver driver;
	
	
	//初始化
	public FinalSickCasesWebElements(WebDriver driver){
		FinalSickCasesWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断第一个“更多”按钮，一般为“正在热议”的“更多”是否存在
	public static boolean firstMoreIsExist() {
    	return Utils.isElementExist(driver, By.xpath(FinalSickCasesPageElements.FIRST_MORE));
    }
	
	//判断正在热议的第一条病例是否找到
	public static boolean firstCaseIsExist() {
    	return Utils.isElementExist(driver, By.xpath(FinalSickCasesPageElements.FIRST_CASE));
    }

}
