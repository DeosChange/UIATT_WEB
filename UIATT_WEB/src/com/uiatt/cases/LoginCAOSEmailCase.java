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
 * 2.0PC  CAOS邮箱账户登陆登出操作测试用例
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginCAOSEmailCase {
	public static WebDriver driver;
	/**
	public LoginCAOSEmailCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		LoginCAOSEmailCase.driver=BaseTest.chromeInit(driver);
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
	 * 验证"CAOS会员登录"按钮是否存在以确定页面正常跳转
	 */
	@Test (priority = 1)
	public void assertRegButton() {
		Assertion.assertEquals(true, LoginWebElements.caosBtnIsExist(), "\"CAOS会员登录\"按钮未找到，页面不符或元素改变，请检查！");
    }
	
	/**
	 * CAOS邮箱登录
	 */
	@Test (priority = 2,dependsOnMethods = { "assertRegButton" })
	@Parameters({"LOGIN_CAOS_EMAIL_USER", "GLOBAL_PASSWORD"})
	public void caosloginEmail(String LOGIN_CAOS_EMAIL_USER, String GLOBAL_PASSWORD) {
		System.out.println("login email");
		LoginWebElements.caosLogin(LOGIN_CAOS_EMAIL_USER, GLOBAL_PASSWORD);
	}
	
	/**
	 * CAOS邮箱退出
	 */
	@Test (priority = 3,dependsOnMethods = { "caosloginEmail" } )
	public void logout(){
		IndexWebElements.allinLogout();
	}
}
