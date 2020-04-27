package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.WeiXinMiddlePageElements;
import com.uiatt.util.Utils;

/**
 * 注册并完成医师认证后跳转的微信扫码关注公众号的中间页面；
 * author:Change
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class WeiXinMiddleWebElements {
	// 显示为“欢迎你，XX”
	@FindBy(xpath = WeiXinMiddlePageElements.WELCOME_TITLE)
	public static WebElement welcome_title;

	// 跳过,如果是从注册后直接到医师认证完成的微信关注页的跳过，为此路径
	@FindBy(xpath = WeiXinMiddlePageElements.SKIP_WEIXIN_SCAN)
	public static WebElement skip_weixin_scan;
	
	//跳过，如果是注册后跳过认证，但在操作文库、病例、话题等终端的详情页造成的权限提示后，从该入口进入的医师认证后跳转的微信关注页的跳过按钮，路径值竟然与从注册后直接到医师认证完成的微信关注页的跳过路径值不同，坑啊！！！切记！
	@FindBy(xpath = WeiXinMiddlePageElements.SKIP_WEIXIN_SCAN_ACCESS)
	public static WebElement skip_weixin_scan_access;
	
	public static  WebDriver driver;
	
	//初始化
	public WeiXinMiddleWebElements(WebDriver driver){
		WeiXinMiddleWebElements.driver = driver;
	}
	
	//验证认证完成后是否成功跳转至微信关注的中间页
	public static boolean assertGoToWeiXinMiddlePage(String authName) {
		String welcome_title="欢迎你，"+authName;
		logger.info("weixinMid医师认证姓名检查:"+welcome_title);
		Reporter.log("weixinMid医师认证姓名检查:"+welcome_title);
		return Utils.getText(driver, By.xpath(WeiXinMiddlePageElements.WELCOME_TITLE)).equals(welcome_title);
	}
	
	//判断跳过按钮是否存在
	public static boolean skipWXBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(WeiXinMiddlePageElements.SKIP_WEIXIN_SCAN));
    }
	
	//判断跳过按钮是否存在
	public static boolean skipWXAccessBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(WeiXinMiddlePageElements.SKIP_WEIXIN_SCAN_ACCESS));
    }
}
