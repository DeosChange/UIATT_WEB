package com.uiatt.cases;

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
import com.uiatt.pcWeb.DoctAuthWebElements;
import com.uiatt.pcWeb.IndexWebElements;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.RegWebElements;
import com.uiatt.pcWeb.WeiXinMiddleWebElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.RandomStr;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 邮箱注册并完成认证测试用例
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class RegEmailDoneAuthCase {
	public static WebDriver driver;
	public static Logger logger = Logger.getLogger(RegEmailDoneAuthCase.class );
	
	public RegEmailDoneAuthCase(){
		//将基类中初始化的driver值传回本类，这样tearDown()方法的driver就能取到基类中初始化的值了；
		//RegEmailDoneAuthCase.driver=BaseTest.chromeInit(driver);
		BaseTest.logConf();
	}
	
	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, RegWebElements.class);
		PageFactory.initElements(driver, DoctAuthWebElements.class);
		PageFactory.initElements(driver, IndexWebElements.class);
		PageFactory.initElements(driver, WeiXinMiddleWebElements.class);
	}
	
	@AfterClass  
	public void tearDown() {
		driver.quit();
		Reporter.log("================================================*********用例结束**********==========================================================================");
	} 
	
	/**
	 * 验证"立即注册"按钮是否存在以确定页面正常跳转
	 */
	@Test (priority = 1)
	public void assertRegButton() {
		Assertion.assertEquals(true, LoginWebElements.regAllinBtnIsExist(), "\"立即注册\"按钮未找到，页面不符或元素改变，请检查！");
    }
	
	/**
	 * 邮箱注册并完成认证
	 */
	@Test (priority = 2,dependsOnMethods = { "assertRegButton" })
	@Parameters({"GLOBAL_PASSWORD","GLOBAL_VALIDCODE"})
	public void regEmailDoneAuth(String GLOBAL_PASSWORD,String GLOBAL_VALIDCODE) {
		String USERNAME = RandomStr.randomEmail();
		//先进行传值的非空判断并处理
		if(USERNAME.length() != 0 && GLOBAL_PASSWORD.length() != 0 && GLOBAL_VALIDCODE.length() != 0 ){
			RegWebElements.regEmailFlow(USERNAME, GLOBAL_PASSWORD,GLOBAL_VALIDCODE);
			RegWebElements.doneAuth();
			RegWebElements.weixinMid();
			Utils.sleep(5);
	    	Assertion.assertEquals(true, IndexWebElements.assertGoToIndex(), "未跳转到登录后的主页，是否登录失败，请检查！");
	    	Assertion.assertEquals(true, IndexWebElements.attenNowBtnIsExist(), "未找到立即关注按钮，是否登录或加载失败，请检查！");
	    	/**
	    	if(Utils.getText(driver, By.xpath(IndexPageElements.USERNAME_BTN)).equals(authName)){
	    		logger.info("登陆后右上角账户名检查是否是认证所填："+Utils.getText(driver, By.xpath(IndexPageElements.USERNAME_BTN)));
	        	logger.info("医师认证完成并成功进入登录后的主页");
	    	}else{
	    		logger.warn("登录后的姓名与认证的不匹配，是否登录或加载失败，请检查！");
	    		ScreenShotPC.screenShot("RegWebElements.weixinMid");
	    	}
	    	*/
		}else{
			logger.warn("用户名或密码或验证码为空，请检查！");
			Reporter.log("[WARN]用户名或密码或验证码为空，请检查！");
			Assert.fail("用户名或密码或验证码为空，请检查！");
		}
	}
	
	/**
	 * 未认证的邮箱注册用户登录成功后退出
	 */
	@Test (priority = 3,dependsOnMethods = { "regEmailDoneAuth" })
	public void logout(){
		IndexWebElements.allinLogout();
	}

}
