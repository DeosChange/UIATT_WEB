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
import com.uiatt.util.BaseTest;

/**
 * 2.0PC手机账户登陆登出操作测试用例
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginAllinPhoneCase {
	public static WebDriver driver;
	/**
	public LoginAllinPhoneCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		LoginAllinPhoneCase.driver=BaseTest.chromeInit(driver);
	}
	*/
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, IndexWebElements.class);
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
	 * 手机登录
	 */
	@Test (priority = 2,dependsOnMethods = { "assertRegButton" })
	@Parameters({"LOGIN_PHONE_USER", "GLOBAL_PASSWORD"})
	public void allinLoginPhone(String LOGIN_PHONE_USER, String GLOBAL_PASSWORD) {
		LoginWebElements.allinLogin(LOGIN_PHONE_USER, GLOBAL_PASSWORD);
	}

	/**
	 * 手机退出
	 */
	@Test (priority = 3,dependsOnMethods = { "allinLoginPhone" })
	public void logout(){
		Reporter.log("==========");
		IndexWebElements.allinLogout();
	}
}
