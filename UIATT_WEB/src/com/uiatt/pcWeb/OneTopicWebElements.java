package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.OneDocmentPageElements;
import com.uiatt.pcPage.OneTopicPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 某个具体话题详情页面所有功能按钮元素
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class OneTopicWebElements {
	// 未登录查看话题详情，提示立即登录
	@FindBy(xpath = OneTopicPageElements.LOGIN_NOW)
	public static WebElement login_now;
	
	//未登录查看文库详情，提示医师认证
	@FindBy(xpath = OneTopicPageElements.DOCT_AUTH)
	public static WebElement doct_auth;
	
	// “标签”字样
	@FindBy(xpath = OneTopicPageElements.TAG_TITLE)
	public static WebElement tag_title;
	
	
	//直接给资源主体评论的输入框
	@FindBy(xpath = OneTopicPageElements.COMMENT_INPUT)
	public static WebElement comment_input;
		
	//直接给资源主体评论的添加图片按钮
	@FindBy(xpath = OneTopicPageElements.ADD_PHOTO)
	public static WebElement add_photo;
		
	//直接给资源主体评论的提醒谁看按钮
	@FindBy(xpath = OneTopicPageElements.REMIND_SOMEBODY)
	public static WebElement remind_somebody;
		
	//直接给资源主体评论的提醒谁看输入框
	@FindBy(xpath = OneTopicPageElements.SCCOM_REMIND_INPUT)
	public static WebElement sccom_remind_input;
		
	//直接给资源主体评论的提醒谁看第一个被匹配出来的用户
	@FindBy(xpath = OneTopicPageElements.SCCOM_REMI_FIR_MATCH)
	public static WebElement sccom_remi_fir_match;
		
	//直接给资源主体评论的发布按钮
	@FindBy(xpath = OneTopicPageElements.PUB_COM_BTN)
	public static WebElement pub_com_btn;
		
	//第一条已发布的评论文本内容
	@FindBy(xpath = OneTopicPageElements.FIRST_PUBLISHED_CONTENT)
	public static WebElement first_published_content;
		
	//第一条评论的删除图标
	@FindBy(xpath = OneTopicPageElements.REMOVE_BTN)
	public static WebElement remove_btn;
	
	//评论框中的添加图片按钮元素一直存在在页面上，但是其状态必须display:block时才可以操作，为none时不可以
	@FindBy(xpath = OneTopicPageElements.ADD_PHOTO_BTN_STATE)
	public static WebElement add_photo_btn_state;
	
	public static  WebDriver driver;
	
	
	//初始化
	public OneTopicWebElements(WebDriver driver){
		OneTopicWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断直接给资源主体评论的提醒谁看第一个被匹配出来的用户是否存在
	public static boolean sccomRemFirMatIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.SCCOM_REMI_FIR_MATCH));
	}
		
	//判断直接给资源主体评论的提醒谁看输入框是否存在
	public static boolean sccomRemInpIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.SCCOM_REMIND_INPUT));
	}
		
	//判断第一条评论的删除图标是否存在
	public static boolean removeBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.REMOVE_BTN));
	}
		
	//判断第一条已发布的评论文本内容是否存在
	public static boolean firPubContIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.FIRST_PUBLISHED_CONTENT));
	}
		
	//判断直接给资源主体评论的发布按钮是否存在
	public static boolean pubComBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.PUB_COM_BTN));
	}
		
	//判断直接给资源主体评论的提醒谁看按钮是否存在
	public static boolean remindSomeBodyIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.REMIND_SOMEBODY));
	}
		
	//判断直接给资源主体评论的添加图片按钮是否存在
	public static boolean addPhoIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.ADD_PHOTO));
	}
		
	//判断直接给资源主体评论的输入框是否存在
	public static boolean comInputIsExist() {
		return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.COMMENT_INPUT));
	}
	
	//判断未登录查看病例详情，提示医师认证的按钮是否找到
	public static boolean doctAuthBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.DOCT_AUTH));
	}
	
	//判断未登录查看话题详情，提示立即登录的按钮是否找到
	public static boolean loginNowBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(OneTopicPageElements.LOGIN_NOW));
    }
	
	//判断“标签”按钮是否找到
	public static boolean tagTitleBtnIsExist() {
	    return Utils.isElementExist(driver, By.xpath(OneDocmentPageElements.TAG_TITLE));
	}
}
