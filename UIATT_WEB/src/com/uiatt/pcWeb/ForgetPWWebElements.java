package com.uiatt.pcWeb;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.ForgetPWPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.TakeMsgValidCode;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 忘记密码页面所有功能按钮元素，此处整合了邮箱、手机找回并重置的所有步骤
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class ForgetPWWebElements {
	public static Logger logger = Logger.getLogger(ForgetPWWebElements.class );
	// 忘记密码的邮箱或手机
	@FindBy(xpath = ForgetPWPageElements.RESET_USNAME)
	public static WebElement reset_usname;
	
	// 下一步
	@FindBy(xpath = ForgetPWPageElements.RESET_NEXT_BTN)
	public static WebElement reset_next_btn;
	
	// 又想起来了
	@FindBy(xpath = ForgetPWPageElements.REMEMBER_AGAIN)
	public static WebElement remeber_again;
	
	// 进入邮箱按钮
	@FindBy(xpath = ForgetPWPageElements.NAVIGATE_TO_EMAIL)
	public static WebElement navigate_to_email;
	
	// 没收到邮件，改为使用手机
	@FindBy(xpath = ForgetPWPageElements.NAVIGATE_TO_PHONE)
	public static WebElement navigate_to_phone;

	// 设置新密码
	@FindBy(xpath = ForgetPWPageElements.RESET_NEW_PW)
	public static WebElement reset_new_pw;
	
	// 确认密码
	@FindBy(xpath = ForgetPWPageElements.RESET_CONFIRM_PW)
	public static WebElement reset_confirm_pw;
	
	// 重置密码的确定按钮
	@FindBy(xpath = ForgetPWPageElements.RESET_PW_SUBMIT)
	public static WebElement reset_pw_submit;
	
	// 进入首页按钮，其实是跳转登陆页
	@FindBy(xpath = ForgetPWPageElements.NAVIGATE_TO_LOGINPAGE)
	public static WebElement navigate_to_loginpage;
	
	// 短信验证码的输入框
	@FindBy(xpath = ForgetPWPageElements.MOBILE_VALIDCODE)
	public static WebElement mobile_validcode;
	
	// 发送短信验证码
	@FindBy(xpath = ForgetPWPageElements.SEND_VALIDCODE)
	public static WebElement send_validcode;
	
	// 手机申请重置的下一步
	@FindBy(xpath = ForgetPWPageElements.VALIDCODE_NEXT_BTN)
	public static WebElement validcode_next_btn;
	
	public static  WebDriver driver;
	
	//初始化
	public ForgetPWWebElements(WebDriver driver){
		ForgetPWWebElements.driver = driver;
		BaseTest.logConf();
	}
	
	//判断"忘记密码的邮箱或手机"输入框是否存在
	public static boolean resetUSNIsExist() {
		return Utils.isElementExist(driver, By.xpath(ForgetPWPageElements.RESET_USNAME));
	}
	
	//进入邮箱按钮是否存在
	public static boolean enterInIsExist() {
		return Utils.isElementExist(driver, By.xpath(ForgetPWPageElements.NAVIGATE_TO_EMAIL));
	}
	
	//设置新密码输入框是否存在
	public static boolean resetPWIsExist() {
		return Utils.isElementExist(driver, By.xpath(ForgetPWPageElements.RESET_NEW_PW));
	}
	
	//进入首页按钮，其实是跳转登陆页按钮是否存在
	public static boolean toLoginIsExist() {
		return Utils.isElementExist(driver, By.xpath(ForgetPWPageElements.NAVIGATE_TO_LOGINPAGE));
	}
	
	//发送短信验证码的按钮是否存在
	public static boolean mobileValidIsExist() {
		return Utils.isElementExist(driver, By.xpath(ForgetPWPageElements.SEND_VALIDCODE));
	}
	
	/**
     * 登录
     * @param username
     * @param password
     */
    public static void forgetAndResetPW(String username, String password) {
    	Assertion.assertEquals(true,LoginWebElements.forgetPWBtnIsExist(),"未找到'忘记密码'按钮,是否加载失败，请检查！");
    	LoginWebElements.forget_pwd.click();
    	Utils.sleep(3);
    	Assertion.assertEquals(true,ForgetPWWebElements.resetUSNIsExist(),"未找到'忘记密码的邮箱或手机'输入框,是否加载失败，请检查！");
    	reset_usname.clear();
    	reset_usname.sendKeys(username);
    	reset_usname.click();
    	reset_next_btn.click();
    	Utils.sleep(3);
    	/**
         * 正则表达式：验证忘记密码的是手机号还是邮箱
         */
        String REGEX_MOBILE = "^[\\d]{11}$";
        String REGEX_EMAIL = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
        if (true == Pattern.matches(REGEX_EMAIL, username)){
        	logger.info("忘记密码的账户匹配为邮箱用户");
        	logger.info("重置密码的链接已发至邮箱，请判断'进入邮箱'按钮是否存在.");
        	Reporter.log("忘记密码的账户匹配为邮箱用户");
        	Reporter.log("重置密码的链接已发至邮箱，请判断'进入邮箱'按钮是否存在.");
        	Assertion.assertEquals(true,ForgetPWWebElements.enterInIsExist(),"未找到'进入邮箱'按钮,是否加载失败，请检查！");
        	//navigate_to_email.click();
        	String emailResetPWUrl = TakeMsgValidCode.takeEmailLogUrlNew(username);
        	logger.info("emailResetPWUrl检查是：111"+emailResetPWUrl);
        	Reporter.log("emailResetPWUrl检查是：111"+emailResetPWUrl);
        	driver.get(emailResetPWUrl);
        	//driver.get("http://www.uiatt.cn/call/customer/reset/password/input/?itemId=15422&resetSite=1&validCode=595279293bf5bb7dee24f0869fb6fb2");
        }else if(true == Pattern.matches(REGEX_MOBILE, username)){
        	logger.info("忘记密码的账户匹配为手机用户");
        	Reporter.log("忘记密码的账户匹配为手机用户");
        	Assertion.assertEquals(true,ForgetPWWebElements.mobileValidIsExist(),"未找到'发送短信验证码'按钮,是否加载或跳转失败，请检查！");
        	send_validcode.click();
        	logger.info("已点击发送短信验证码按钮，等待响应返回值");
        	Reporter.log("已点击发送短信验证码按钮，等待响应返回值");
        	String mobileCheckCode = TakeMsgValidCode.takeMsgValidCode(username);
        	logger.info("成功获取短信验证码："+mobileCheckCode);
        	Reporter.log("成功获取短信验证码："+mobileCheckCode);
        	mobile_validcode.clear();
        	mobile_validcode.sendKeys(mobileCheckCode);
        	mobile_validcode.click();
        	validcode_next_btn.click();
        }else{
        	logger.error("输入忘记密码的账户后，跳转下一步失败，请检查！");
        	Reporter.log("[ERROR]输入忘记密码的账户后，跳转下一步失败，请检查！");
        	Assert.fail("输入忘记密码的账户后，跳转下一步失败，请检查！");
        }
        Utils.sleep(5);
    	Assertion.assertEquals(true,ForgetPWWebElements.resetPWIsExist(),"未找到'设置新密码'输入框,是否加载失败，请检查！");
    	reset_new_pw.clear();
    	reset_new_pw.sendKeys(password);
    	reset_new_pw.click();
    	reset_confirm_pw.clear();
    	reset_confirm_pw.sendKeys(password);
    	reset_confirm_pw.click();
    	reset_pw_submit.click();
    	logger.info("密码重置成功");
    	Reporter.log("密码重置成功");
    	Utils.sleep(3);
    	Assertion.assertEquals(true,ForgetPWWebElements.toLoginIsExist(),"未找到'进入首页'按钮,是否加载失败，请检查！");
    	navigate_to_loginpage.click();
    	Utils.sleep(5);
    	//判断是否跳转登陆页
    	Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist());
    	logger.info("用重置后的密码进行登陆验证是否可以登陆");
    	Reporter.log("用重置后的密码进行登陆验证是否可以登陆");
    	LoginWebElements.uiattLogin(username, password);
    	logger.info("用重置后的密码进行登陆成功");
    	Reporter.log("用重置后的密码进行登陆成功");
    	
    }
	
}
