package com.uiatt.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uiatt.listener.Assertion;
import com.uiatt.pcWeb.IndexWebElements;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.OneSickCaseWebElements;
import com.uiatt.pcWeb.PersonHomeWebElements;
import com.uiatt.pcWeb.PublishSickCaseWebElements;
import com.uiatt.util.BaseTest;


/**
 * 2.0PC 邮箱账户登陆-发布病例-修改病例-发布评论-删除评论-登出操作测试用例
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PublishSickCaseCase {
	public static WebDriver driver;
	/**
	public PublishSickCaseCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		PublishSickCaseCase.driver=BaseTest.chromeInit(driver);
	}
	*/
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, IndexWebElements.class);
		PageFactory.initElements(driver, PublishSickCaseWebElements.class);
		PageFactory.initElements(driver, PersonHomeWebElements.class);
		PageFactory.initElements(driver, OneSickCaseWebElements.class);
	}
	
	@AfterClass  
	public void tearDown() {
		driver.quit();
		Reporter.log("================================================*********用例结束**********==========================================================================");
	} 
	
	/**
	 * 验证"会员登录"按钮是否存在以确定页面正常跳转
	 */
	@Test (priority = 1)
	public void assertRegButton() {
		Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist(), "\"会员登录\"按钮未找到，页面不符或元素改变，请检查！");
    }
	
	/**
	 * 邮箱账户登陆-发布病例-校验发布成功
	 */
	@Test (priority = 2,dependsOnMethods = { "assertRegButton" })
	@Parameters({"LOGIN_EMAIL_USER", "GLOBAL_PASSWORD"})
	public void publishSickCase(String LOGIN_EMAIL_USER, String GLOBAL_PASSWORD) {
		Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist(), "\"会员登录\"按钮未找到，页面不符或元素未找到，请检查！");
		LoginWebElements.allinLogin(LOGIN_EMAIL_USER, GLOBAL_PASSWORD);
		PublishSickCaseWebElements.beforeEditSickCase(driver);
		PublishSickCaseWebElements.editAndPubSickCase(driver);
	}
	
	/**
	 * 修改病例-校验修改成功
	 */
	@Test (priority = 3,dependsOnMethods = { "publishSickCase" })
	public void updateSickCase() {
		PublishSickCaseWebElements.updateSickCase(driver);
	}
	
	/**
	 * 发布评论-校验评论成功-删除评论
	 */
	@Test (priority = 4,dependsOnMethods = { "updateSickCase" })
	public void pubSCComment() {
		PublishSickCaseWebElements.publishComment(driver);
	}
	
	/**
	 * 邮箱退出
	 */
	@Test (priority = 5,dependsOnMethods = { "pubSCComment" })
	public void logout(){
		IndexWebElements.allinLogout();
	}

}
