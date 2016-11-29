package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.LoginPageElements;
import com.uiatt.util.Utils;
import com.uiatt.util.BaseTest;
/**
 * 提取2.0 PC 登陆页面所有功能按钮元素,变成WebElements
 * author : Change
 * 
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginWebElements {
		public static Logger logger = Logger.getLogger(LoginWebElements.class );
		// 会员登录按钮
		@FindBy(xpath = LoginPageElements.LOGIN_uiatt_BTN)
		public static WebElement login_uiatt_btn;
		
		// 登录输入账户
		@FindBy(xpath = LoginPageElements.LOGIN_uiatt_USER)
		public static WebElement login_uiatt_user;
		
		// 登录输入密码
		@FindBy(xpath = LoginPageElements.LOGIN_uiatt_PW)
		public static WebElement login_uiatt_pw;
		
		// CAOS会员登录按钮
		@FindBy(xpath = LoginPageElements.LOGIN_CAOS_BTN)
		public static WebElement login_caos_btn;
		
		// CAOS输入账户
		@FindBy(xpath = LoginPageElements.LOGIN_CAOS_USER)
		public static WebElement login_caos_user;
		
		// CAOS输入密码
		@FindBy(xpath = LoginPageElements.LOGIN_CAOS_PW)
		public static WebElement login_caos_pw;
		
		// 登录错误信息
		@FindBy(xpath = LoginPageElements.ERROR_MESSAGE)
		public static WebElement error_message;
				
		// 忘记密码
		@FindBy(xpath = LoginPageElements.FORGET_PWD)
		public static WebElement forget_pwd;
				
		// 登陆
		@FindBy(xpath = LoginPageElements.uiatt_SUBMIT_BTN)
		public static WebElement uiatt_submit_btn;
		
		// 登陆
		@FindBy(xpath = LoginPageElements.CAOS_SUBMIT_BTN)
		public static WebElement caos_submit_btn;
		
		// 立即注册
		@FindBy(xpath = LoginPageElements.REGIST_uiatt_BTN)
		public static WebElement regist_uiatt_btn;
		
		//病例
		@FindBy(xpath = LoginPageElements.SICKCASE_BTN)
		public static WebElement sickCase_btn;
		
		//文库
		@FindBy(xpath = LoginPageElements.DOCSTORE_BTN)
		public static WebElement docStore_btn;
		
		//话题
		@FindBy(xpath = LoginPageElements.TOPIC_BTN)
		public static WebElement topic_btn;
		
		//首页
		@FindBy(xpath = LoginPageElements.INDEX_BTN)
		public static WebElement index_btn;
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中取他的登陆用户名，而非姓名
		@FindBy(xpath = LoginPageElements.REF_uiatt_CAOS_USN)
		public static WebElement ref_uiatt_caos_usn;
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中的提示语
		@FindBy(xpath = LoginPageElements.REF_uiatt_CAOS_NOTE)
		public static WebElement ref_uiatt_caos_note;
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中他的登陆用户名已有，直接输入的密码
		@FindBy(xpath = LoginPageElements.REF_uiatt_CAOS_PW)
		public static WebElement ref_uiatt_caos_pw;
		
		//已注册过的caos账户登陆，会跳转一个中间页，登陆按钮
		@FindBy(xpath = LoginPageElements.REF_uiatt_CAOS_LOGIN_BTN)
		public static WebElement ref_uiatt_caos_login_btn;
		
		//已注册过的caos账户登陆，会跳转一个中间页，错误提示信息
		@FindBy(xpath = LoginPageElements.REF_uiatt_CAOS_ERRORMSG)
		public static WebElement ref_uiatt_caos_errorMSG;
		
		//导航栏搜索按钮
		@FindBy(xpath = LoginPageElements.SEARCH_BTN)
		public static WebElement search_btn;
		
		//搜索文本输入框状态
		@FindBy(xpath = LoginPageElements.SEARCH_INPUT_STATE)
		public static WebElement search_input_state;
		
		//搜索输入框
		@FindBy(xpath = LoginPageElements.SEARCH_INPUT)
		public static WebElement search_input;
		
		//输入后的搜索按钮
		@FindBy(xpath = LoginPageElements.SEARCH_INPUT_BTN)
		public static WebElement search_input_btn;
		
		//logo图片，可跳转登陆页
		@FindBy(xpath = LoginPageElements.uiatt_LOGO_IMG)
		public static WebElement uiatt_logo_img;
		
		public static  WebDriver driver;
		
		
		//初始化
		public LoginWebElements(WebDriver driver){
			LoginWebElements.driver = driver;
			BaseTest.logConf();
		}
		
		//判断导航栏搜索按钮是否存在
		public static boolean searchBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.SEARCH_BTN));
	    }
		
		//已注册过的caos账户登陆，会跳转一个中间页，错误提示信息
		public static boolean refuiattCaosErrorMSGIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REF_uiatt_CAOS_ERRORMSG));
	    }
		
		//已注册过的caos账户登陆，会跳转一个中间页，登陆按钮
		public static boolean refuiattCaosLoginBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REF_uiatt_CAOS_LOGIN_BTN));
	    }
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中他的登陆用户名已有，直接输入的密码
		public static boolean refuiattCaosPWIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REF_uiatt_CAOS_PW));
	    }
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中的提示语
		public static boolean refuiattCaosNoteIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REF_uiatt_CAOS_NOTE));
	    }
		
		//已注册过的caos账户登陆，会跳转一个中间页，其中取他的登陆用户名，而非姓名
		public static boolean refuiattCaosUSNIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REF_uiatt_CAOS_USN));
	    }
		
		//判断首页按钮是否存在
		public static boolean indexBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.INDEX_BTN));
	    }
		
		//判断话题按钮是否存在
		public static boolean topicBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.TOPIC_BTN));
	    }
		
		//判断文库按钮是否存在
		public static boolean docStroeBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.DOCSTORE_BTN));
	    }
		
		//判断病例按钮是否存在
		public static boolean sickCaseBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.SICKCASE_BTN));
	    }
		
		//忘记密码按钮是否存在
		public static boolean forgetPWBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.FORGET_PWD));
	    }
		
		//判断"会员登录"按钮是否存在
	    public static boolean allmdBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.LOGIN_uiatt_BTN));
	    }
	    
	    //判断"CAOS会员登录"按钮是否存在
	    public static boolean caosBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.LOGIN_CAOS_BTN));
	    }
		
	    //判断"立即注册"按钮是否存在
	    public static boolean reguiattBtnIsExist() {
	    	return Utils.isElementExist(driver, By.xpath(LoginPageElements.REGIST_uiatt_BTN));
	    }
	    
	    /**
	     * 登录
	     * @param username
	     * @param password
	     */
	    public static void uiattLogin(String username, String password) {
	    	logger.info("邮箱账户开始登录");
	    	Reporter.log("邮箱账户开始登录");
	    	login_uiatt_btn.click();
	    	//Utils.sleep(5);
	    	Utils.waitElement(driver, LoginPageElements.LOGIN_uiatt_USER);
	    	login_uiatt_user.sendKeys(username);
	    	login_uiatt_pw.sendKeys(password);
	    	Utils.sleep(2);
	    	uiatt_submit_btn.click();	
	    	Utils.sleep(5);
	    	//判断是否在输入用户名或密码时报错，如果报错写入日志，并全屏截取
	    	if(Utils.isElementExist(driver, By.xpath(LoginPageElements.ERROR_MESSAGE)) == true && error_message.getText() != ""){
	    		logger.error(error_message.getText());
	    		Reporter.log("[ERROR]"+error_message.getText());
		    	//ScreenShotPC.screenShot("LoginWebElements.uiattLogin");
		    	Assert.fail(error_message.getText());
	    	}else{
	    		//如果没有报错，那么初始化个人中心页，监听是否登录成功
	    		logger.info("邮箱账户名与密码输入正确，跳转登陆成功后的页面");
	    		Reporter.log("邮箱账户名与密码输入正确，跳转登陆成功后的页面");
		    	Utils.sleep(5);
		    	Assertion.assertEquals(true, IndexWebElements.assertGoToIndex(), "未跳转到首页，是否登录失败，请检查！");
		    	logger.info("邮箱账户登录成功");
		    	Reporter.log("邮箱账户登录成功");
	    	}
	    }
	    
	    /**
	     * CAOS登录
	     * @param username
	     * @param password
	     */
	    public static void caosLogin(String username, String password) {
	    	logger.info("CAOS邮箱账户开始登录");
	    	Reporter.log("CAOS邮箱账户开始登录");
	    	login_caos_btn.click();
	    	Utils.sleep(5);
	    	login_caos_user.sendKeys(username);
	    	login_caos_pw.sendKeys(password);
	    	Utils.sleep(2);
	    	caos_submit_btn.click();	
	    	Utils.sleep(5);
	    	if(refuiattCaosUSNIsExist() == true ){
	    		Assertion.assertEquals(username, ref_uiatt_caos_usn.getText(), "已注册过的caos账号获取值与登陆时输入值不一致，请检查！");
	    		logger.info("已注册过的caos账号:"+ref_uiatt_caos_usn.getText()+"与登陆时输入值一致");
	    		Reporter.log("已注册过的caos账号:"+ref_uiatt_caos_usn.getText()+"与登陆时输入值一致");
	    		Assertion.assertEquals(true, refuiattCaosNoteIsExist(), "已注册过的caos账号跳转后提示语获取失败，是否元素定位错误，请检查！");
	    		String noteMSG = "你已使用"+ref_uiatt_caos_usn.getText()+"注册过，请输入当时设置的密码";
	    		Assertion.assertEquals(noteMSG, ref_uiatt_caos_note.getText(), "已注册过的caos登陆跳转后提示语获取值与登陆时输入值不一致，请检查！");
	    		logger.info("已注册过的caos登陆跳转后提示语为:"+ref_uiatt_caos_note.getText());
	    		Reporter.log("已注册过的caos登陆跳转后提示为:"+ref_uiatt_caos_note.getText());
	    		Assertion.assertEquals(true, refuiattCaosPWIsExist(), "已注册过的caos账号跳转后密码输入框获取失败，是否元素定位错误，请检查！");
	    		ref_uiatt_caos_pw.clear();
	    		ref_uiatt_caos_pw.sendKeys(password);
	    		ref_uiatt_caos_pw.click();
	    		Assertion.assertEquals(true, refuiattCaosLoginBtnIsExist(), "已注册过的caos账号跳转后登陆按钮获取失败，是否元素定位错误，请检查！");
	    		ref_uiatt_caos_login_btn.click();
	    		Utils.sleep(2);
	    		if(refuiattCaosErrorMSGIsExist() == true && ref_uiatt_caos_errorMSG.getText() != ""){
	    			logger.error(ref_uiatt_caos_errorMSG.getText());
		    		Reporter.log("[ERROR]"+ref_uiatt_caos_errorMSG.getText());
			    	//ScreenShotPC.screenShot("LoginWebElements.caosLogin");
			    	Assert.fail(ref_uiatt_caos_errorMSG.getText());
	    		}else{
	    			//如果没有报错，那么初始化个人中心页，监听是否登录成功
		    		logger.info("已注册过的caos账户名与密码输入正确，跳转登陆成功后的页面");
		    		Reporter.log("已注册过的caos账户名与密码输入正确，跳转登陆成功后的页面");
			    	Utils.sleep(5);
			    	Assertion.assertEquals(true, IndexWebElements.assertGoToIndex(), "未跳转到首页，是否登录失败，请检查！");
			    	logger.info("已注册过的caos账户登录成功");
			    	Reporter.log("已注册过的caos账户登录成功");
	    		}
	    	}
	    	
	    	//判断是否在输入用户名或密码时报错，如果报错写入日志，并全屏截取
	    	if(Utils.isElementExist(driver, By.xpath(LoginPageElements.ERROR_MESSAGE)) == true && error_message.getText() != ""){
	    		logger.error(error_message.getText());
	    		Reporter.log("[ERROR]"+error_message.getText());
		    	//ScreenShotPC.screenShot("LoginWebElements.caosLogin");
		    	Assert.fail(error_message.getText());
	    	}else{
	    		//如果没有报错，那么初始化个人中心页，监听是否登录成功
	    		logger.info("caos账户名与密码输入正确，跳转登陆成功后的页面");
	    		Reporter.log("caos账户名与密码输入正确，跳转登陆成功后的页面");
		    	Utils.sleep(5);
		    	Assertion.assertEquals(true, IndexWebElements.assertGoToIndex(), "未跳转到首页，是否登录失败，请检查！");
		    	logger.info("caos账户登录成功");
		    	Reporter.log("caos账户登录成功");
	    	}
	    }
		
		
}
