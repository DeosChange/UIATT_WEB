package com.uiatt.cases;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uiatt.listener.Assertion;
import com.uiatt.pcWeb.DoctAuthWebElements;
import com.uiatt.pcWeb.FinalDocStoreWebElements;
import com.uiatt.pcWeb.IndexWebElements;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.OneDocmentWebElements;
import com.uiatt.pcWeb.RegWebElements;
import com.uiatt.pcWeb.WeiXinMiddleWebElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.RandomStr;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 未认证情况下对文库终端页的操作的权限判断以及认证后跳过微信关注页返回来源页校验测试用例
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class NotAuthDocumentAccessCase {
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(NotAuthDocumentAccessCase.class );
	public static String currentWindowHandler;
	public static Set<String> allWindowHandlers;
	public static String USERNAME;
	public static WebDriverWait wait;
	
	public NotAuthDocumentAccessCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		//NotAuthDocumentAccessCase.driver=BaseTest.chromeInit(driver);
		USERNAME = RandomStr.randomEmail();
		BaseTest.logConf();
	}
	
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, FinalDocStoreWebElements.class);
		PageFactory.initElements(driver, OneDocmentWebElements.class);
		PageFactory.initElements(driver, DoctAuthWebElements.class);
		PageFactory.initElements(driver, RegWebElements.class);
		PageFactory.initElements(driver, WeiXinMiddleWebElements.class);
		PageFactory.initElements(driver, IndexWebElements.class);
		currentWindowHandler = driver.getWindowHandle();
		wait=new WebDriverWait(driver,50);
		logger.info("初始化driver值检查 ： "+driver);
		Reporter.log("初始化driver值检查 ： "+driver);
	}
	
	@AfterClass  
	public void tearDown() {
		driver.quit();
		Reporter.log("================================================*********用例结束**********==========================================================================");
	}
	
	/**
	 * 未认证情况下对文库终端页的操作的权限判断以及认证后返回来源页校验
	 */
	@Test (priority = 1)
	@Parameters({"GLOBAL_PASSWORD","GLOBAL_VALIDCODE"})
	public void notAuthDocumentAccess(String GLOBAL_PASSWORD,String GLOBAL_VALIDCODE) {
		//先注册一个跳过认证的邮箱用户，并登陆
		//先进行传值的非空判断并处理
		if(USERNAME.length() != 0 && GLOBAL_PASSWORD.length() != 0 && GLOBAL_VALIDCODE.length() != 0 ){
			RegWebElements.regEmailFlow(USERNAME, GLOBAL_PASSWORD,GLOBAL_VALIDCODE);
			RegWebElements.skipAuth();
		}else{
			logger.warn("用户名或密码或验证码为空，请检查！");
			Reporter.log("[WARN]用户名或密码或验证码为空，请检查！");
			Assert.fail("用户名或密码或验证码为空，请检查！");
		}
		
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
			Reporter.log("切换至文章详情页窗口");
			Reporter.log("driver值检查：  "+driver+" ;当前窗口句柄值检查："+handle);
			driver.switchTo().window(handle);
			Utils.sleep(5);
			Assertion.assertEquals(true, OneDocmentWebElements.doctAuthBtnIsExist(), "\"医师认证\"按钮未找到，页面不符或元素改变，请检查！");
			logger.info("以未认证身份进入文章详情页，产生权限控制提示，点击'医师认证'按钮");
			Reporter.log("以未认证身份进入文章详情页，产生权限控制提示，点击'医师认证'按钮");
			wait.until(ExpectedConditions.elementToBeClickable(OneDocmentWebElements.doct_auth));
			OneDocmentWebElements.doct_auth.click();
			Utils.sleep(3);
			//开始认证操作
			RegWebElements.doneAuth();
			RegWebElements.weixinMidAccess();
	    	logger.info("点击跳过，进入登录后的主页");
	    	Reporter.log("点击跳过，进入登录后的主页");
			Utils.sleep(2);
			Assertion.assertEquals(true, OneDocmentWebElements.tagTitleBtnIsExist(), "\"文章详情页的标签\"按钮未找到，页面不符或元素改变，请检查！");
			logger.info("登录后成功返回来源页");
			Reporter.log("登录后成功返回来源页");
		}
		
    }
	
	/**
	 * 邮箱退出
	 */
	@Test (priority = 2,dependsOnMethods = { "notAuthDocumentAccess" })
	public void logout(){
		IndexWebElements.allinLogout();
	}
}
