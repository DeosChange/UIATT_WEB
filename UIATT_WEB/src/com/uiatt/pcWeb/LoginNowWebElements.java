package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.LoginNowPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 立即登录页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginNowWebElements {
	public static Logger logger = Logger.getLogger(LoginNowWebElements.class );
	// 未登录查看病例详情，提示立即登录
	@FindBy(xpath = LoginNowPageElements.uiatt_USERNAME)
	public static WebElement uiatt_username;
	
	//默认的会员登录密码
	@FindBy(xpath = LoginNowPageElements.uiatt_PW)
	public static WebElement uiatt_pw;
	
	//默认的会员登录按钮
	@FindBy(xpath = LoginNowPageElements.uiatt_LOGIN_BTN)
	public static WebElement uiatt_login_btn;
	
	//捕获不正确的用户名或密码的错误提示
	@FindBy(xpath = LoginNowPageElements.WRONG_USNORPW_NOTI)
	public static WebElement wrong_usnorpw_noti;
	
	public static  WebDriver driver;
	
	
	//初始化
	public LoginNowWebElements(WebDriver driver){
		LoginNowWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//捕获不正确的用户名或密码的错误提示是否存在
	public static boolean wrongUsnorpwNotiIsExist() {
    	return Utils.isElementExist(driver, By.xpath(LoginNowPageElements.WRONG_USNORPW_NOTI));
    }
	
	//判断立即登录页用户名输入框是否找到
	public static boolean uiattUSNBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(LoginNowPageElements.uiatt_USERNAME));
    }
}
