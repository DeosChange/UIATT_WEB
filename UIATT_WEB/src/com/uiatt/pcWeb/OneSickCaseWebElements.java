package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.OneSickCasePageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 某个具体病例详情页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class OneSickCaseWebElements {
	public static Logger logger = Logger.getLogger(OneSickCaseWebElements.class );
	// 未登录查看病例详情，提示立即登录
	@FindBy(xpath = OneSickCasePageElements.LOGIN_NOW)
	public static WebElement login_now;
	
	//未登录查看文库详情，提示医师认证
	@FindBy(xpath = OneSickCasePageElements.DOCT_AUTH)
	public static WebElement doct_auth;
	
	// “标签”字样
	@FindBy(xpath = OneSickCasePageElements.TAG_TITLE)
	public static WebElement tag_title;
	
	//患者信息：性别和年龄
	@FindBy(xpath = OneSickCasePageElements.SEX_AGE)
	public static WebElement sex_age;
	
	//直接给资源主体评论的输入框
	@FindBy(xpath = OneSickCasePageElements.COMMENT_INPUT)
	public static WebElement comment_input;
	
	//直接给资源主体评论的添加图片按钮
	@FindBy(xpath = OneSickCasePageElements.ADD_PHOTO)
	public static WebElement add_photo;
	
	//直接给资源主体评论的提醒谁看按钮
	@FindBy(xpath = OneSickCasePageElements.REMIND_SOMEBODY)
	public static WebElement remind_somebody;
	
	//直接给资源主体评论的提醒谁看输入框
	@FindBy(xpath = OneSickCasePageElements.SCCOM_REMIND_INPUT)
	public static WebElement sccom_remind_input;
	
	//直接给资源主体评论的提醒谁看第一个被匹配出来的用户
	@FindBy(xpath = OneSickCasePageElements.SCCOM_REMI_FIR_MATCH)
	public static WebElement sccom_remi_fir_match;
	
	//直接给资源主体评论的发布按钮
	@FindBy(xpath = OneSickCasePageElements.PUB_COM_BTN)
	public static WebElement pub_com_btn;
	
	//第一条已发布的评论文本内容
	@FindBy(xpath = OneSickCasePageElements.FIRST_PUBLISHED_CONTENT)
	public static WebElement first_published_content;
	
	//第一条评论的删除图标
	@FindBy(xpath = OneSickCasePageElements.REMOVE_BTN)
	public static WebElement remove_btn;
		
	public static  WebDriver driver;
		
	//初始化
	public OneSickCaseWebElements(WebDriver driver){
		OneSickCaseWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断直接给资源主体评论的提醒谁看第一个被匹配出来的用户是否存在
	public static boolean sccomRemFirMatIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.SCCOM_REMI_FIR_MATCH));
	}
	
	//判断直接给资源主体评论的提醒谁看输入框是否存在
	public static boolean sccomRemInpIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.SCCOM_REMIND_INPUT));
	}
	
	//判断第一条评论的删除图标是否存在
	public static boolean removeBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.REMOVE_BTN));
	}
	
	//判断第一条已发布的评论文本内容是否存在
	public static boolean firPubContIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.FIRST_PUBLISHED_CONTENT));
	}
	
	//判断直接给资源主体评论的发布按钮是否存在
	public static boolean pubComBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.PUB_COM_BTN));
	}
	
	//判断直接给资源主体评论的提醒谁看按钮是否存在
	public static boolean remindSomeBodyIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.REMIND_SOMEBODY));
	}
	
	//判断直接给资源主体评论的添加图片按钮是否存在
	public static boolean addPhoIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.ADD_PHOTO));
	}
	
	//判断直接给资源主体评论的输入框是否存在
	public static boolean comInputIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.COMMENT_INPUT));
	}
	
	//判断患者信息：性别和年龄是否存在
	public static boolean sexAgeIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.SEX_AGE));
	}
	
	//判断未登录查看病例详情，提示医师认证的按钮是否找到
	public static boolean doctAuthBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.DOCT_AUTH));
	}
	
	//判断未登录查看病例详情，提示立即登录的按钮是否找到
	public static boolean loginNowBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.LOGIN_NOW));
    }
	
	//判断“标签”按钮是否找到
	public static boolean tagTitleBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneSickCasePageElements.TAG_TITLE));
	}

}
