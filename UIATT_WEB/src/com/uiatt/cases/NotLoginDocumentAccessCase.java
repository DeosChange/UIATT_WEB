package com.uiatt.cases;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uiatt.listener.Assertion;
import com.uiatt.pcWeb.FinalDocStoreWebElements;
import com.uiatt.pcWeb.IndexWebElements;
import com.uiatt.pcWeb.LoginNowWebElements;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.OneDocmentWebElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 未登录情况下对文库终端页的操作的权限判断以及登陆后返回来源页校验测试用例
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class NotLoginDocumentAccessCase {
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(NotLoginDocumentAccessCase.class );
	public static String currentWindowHandler;
	public static Set<String> allWindowHandlers;
	
	public NotLoginDocumentAccessCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		//NotLoginDocumentAccessCase.driver=BaseTest.chromeInit(driver);		
		BaseTest.logConf();		
	}
	
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, FinalDocStoreWebElements.class);
		PageFactory.initElements(driver, OneDocmentWebElements.class);
		PageFactory.initElements(driver, LoginNowWebElements.class);
		PageFactory.initElements(driver, IndexWebElements.class);
		currentWindowHandler = driver.getWindowHandle();
		logger.info("初始化driver值检查 ： "+driver);
		Reporter.log("初始化driver值检查 ： "+driver);
	}
	
	@AfterClass  
	public void tearDown() {
		driver.quit();
		Reporter.log("================================================*********用例结束**********==========================================================================");
	}
	
	/**
	 * 未登录情况下对文库终端页的操作的权限判断以及登陆后返回来源页校验
	 */
	@Test (priority = 1)
	@Parameters({"LOGIN_EMAIL_USER", "GLOBAL_PASSWORD"})
	public void notLoginDocumentAccess(String LOGIN_EMAIL_USER, String GLOBAL_PASSWORD) {
		Assertion.assertEquals(true, LoginWebElements.docStroeBtnIsExist(), "\"文库\"按钮未找到，页面不符或元素改变，请检查！");
		logger.info("点击'文库'按钮");
		Reporter.log("点击'文库'按钮");
		LoginWebElements.docStore_btn.click();
		Utils.sleep(2);
		Assertion.assertEquals(true, FinalDocStoreWebElements.firstDocumentIsExist(), "\"推荐指南中的第一篇文章\"标题链接未找到，页面不符或元素改变，请检查！");
		logger.info("进入文章终端页的推荐指南中的第一篇文章的标题");
		Reporter.log("进入文章终端页的推荐指南中的第一篇文章的标题");
		FinalDocStoreWebElements.first_document.click();
		Utils.sleep(3);
		allWindowHandlers = driver.getWindowHandles();
		logger.info("当前窗口句柄值： "+currentWindowHandler);
		logger.info("获取所有窗口句柄值：  "+allWindowHandlers);
		Reporter.log("当前窗口句柄值： "+currentWindowHandler);
		Reporter.log("获取所有窗口句柄值：  "+allWindowHandlers);
		//移除旧窗口
		allWindowHandlers.remove(currentWindowHandler);
		Iterator<String> it= allWindowHandlers.iterator();
		while(it.hasNext()){
			String handle = it.next();
			logger.info("切换至文章详情页窗口");
			logger.info("driver值检查：  "+driver+" ;当前窗口句柄值检查："+handle);
			Reporter.log("切换至病例详情页窗口");
			Reporter.log("driver值检查：  "+driver+" ;当前窗口句柄值检查："+handle);
			driver.switchTo().window(handle);
			Utils.sleep(3);
			Assertion.assertEquals(true, OneDocmentWebElements.loginNowBtnIsExist(), "\"立即登录\"按钮未找到，页面不符或元素改变，请检查！");
			logger.info("以未登录身份进入文章详情页，产生权限控制提示，点击'立即登录'按钮");
			Reporter.log("以未登录身份进入文章详情页，产生权限控制提示，点击'立即登录'按钮");
			OneDocmentWebElements.login_now.click();
			Utils.sleep(3);
			Assertion.assertEquals(true, LoginNowWebElements.allinUSNBtnIsExist(), "\"用户名\"输入框未找到，页面不符或元素改变，请检查！");
			logger.info("输入邮箱账户名和密码");
			Reporter.log("输入邮箱账户名和密码");
			LoginNowWebElements.allin_username.clear();
			LoginNowWebElements.allin_username.sendKeys(LOGIN_EMAIL_USER);
			LoginNowWebElements.allin_username.click();
			LoginNowWebElements.allin_pw.clear();
			LoginNowWebElements.allin_pw.sendKeys(GLOBAL_PASSWORD);
			LoginNowWebElements.allin_pw.click();
			LoginNowWebElements.allin_login_btn.click();
			//因为在即使用户名和密码都填对的情况下，直接".//*[@id='popLoginForm']/div[1]/div"搜索错误提示元素的定位路径，都存在一个值：“不正确的账号或密码,请重新输入！”   ，而此处不对校验做全面覆盖，所以只有针对性的捕获
			if(LoginNowWebElements.wrongUsnorpwNotiIsExist() == true && LoginNowWebElements.wrong_usnorpw_noti.getText().equals("用户名或密码错误！")){
				logger.error(LoginNowWebElements.wrong_usnorpw_noti.getText());
				Reporter.log("ERROR"+LoginNowWebElements.wrong_usnorpw_noti.getText());
	    		//ScreenShotPC.screenShot("NotLoginDocumentAccessCase.notLoginDocumentAccess.wrong_usnorpw_noti");
	    		Assert.fail(LoginNowWebElements.wrong_usnorpw_noti.getText());
			}
			Utils.sleep(2);
			Assertion.assertEquals(true, OneDocmentWebElements.tagTitleBtnIsExist(), "\"文章详情页的标签\"按钮未找到，页面不符或元素改变，请检查！");
			logger.info("登录后成功返回来源页");
			Reporter.log("登录后成功返回来源页");
		}
		
    }
	
	/**
	 * 邮箱退出
	 */
	@Test (priority = 2,dependsOnMethods = { "notLoginDocumentAccess" })
	public void logout(){
		IndexWebElements.allinLogout();
	}
	
}
