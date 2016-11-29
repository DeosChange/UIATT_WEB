package com.uiatt.cases;

import org.apache.log4j.Logger;
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
import com.uiatt.pcWeb.UpdateUSInfoWebElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;

/**
 * 2.0PC 修改密码测试用例
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class UpdatePWCase {
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(UpdatePWCase.class );
	public static  String new_pw_value;
	
	public UpdatePWCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		//UpdatePWCase.driver=BaseTest.chromeInit(driver);
		BaseTest.logConf();
		new_pw_value=Dom4jXml.getValue("newPWValue");
	}
	
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, IndexWebElements.class);
		PageFactory.initElements(driver, UpdateUSInfoWebElements.class);
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
	 * 修改密码
	 */
	@Test (priority = 2,dependsOnMethods = { "assertRegButton" })
	@Parameters({"LOGIN_EMAIL_USER", "GLOBAL_PASSWORD"})
	public void updatePW(String LOGIN_EMAIL_USER, String GLOBAL_PASSWORD) {
		//用旧密码登陆
		LoginWebElements.allinLogin(LOGIN_EMAIL_USER, GLOBAL_PASSWORD);
		//修改为新密码
		UpdateUSInfoWebElements.updatePW(new_pw_value, GLOBAL_PASSWORD);
		//登出
		IndexWebElements.allinLogout();
		Utils.sleep(3);
		//断言登出后是否能找到登陆按钮元素，判断是否登出成功
		Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist());
		//使用新密码登陆
		LoginWebElements.allinLogin(LOGIN_EMAIL_USER, new_pw_value);
		//还原为全局密码
		UpdateUSInfoWebElements.updatePW(GLOBAL_PASSWORD, new_pw_value);
	}
	
	/**
	 * 邮箱退出
	 */
	@Test (priority = 3,dependsOnMethods = { "updatePW" })
	public void logout(){
		IndexWebElements.allinLogout();
	}
}
