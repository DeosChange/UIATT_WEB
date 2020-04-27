package com.uiatt.pcWeb;

import java.io.File;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.RegPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.ReadWriteTxtFile;
import com.uiatt.util.TakeMsgValidCode;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 注册页面所有功能按钮元素
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class RegWebElements {
	// 注册用户名按钮
	@FindBy(xpath = RegPageElements.REG_USERNAME)
	public static WebElement reg_username;
	
	// 注册密码
	@FindBy(xpath = RegPageElements.REG_PWD)
	public static WebElement reg_pwd;
	
	// 确认密码
	@FindBy(xpath = RegPageElements.REG_PWD_CONFIRM)
	public static WebElement reg_pwd_confirm;
	
	// 邮箱注册验证码输入框
	@FindBy(xpath = RegPageElements.REG_EMAIL_VALIDCODE)
	public static WebElement reg_email_validcode;
	
	// 手机注册发送验证码按钮
	@FindBy(xpath = RegPageElements.SEND_PHONE_VALIDCODE)
	public static WebElement send_phone_validcode;
	
	// 手机注册验证码输入框
	@FindBy(xpath = RegPageElements.REG_PHONE_VALIDCODE)
	public static WebElement reg_phone_validcode;
	
	// 注册按钮
	@FindBy(xpath = RegPageElements.REG_BTN)
	public static WebElement reg_btn;
	
	// 用户名错误提示信息
	@FindBy(xpath = RegPageElements.REG_USERNAME_NOTICE)
	public static WebElement reg_username_notice;
	
	// 密码错误提示信息
	@FindBy(xpath = RegPageElements.REG_PWD_NOTICE)
	public static WebElement reg_pwd_notice;
	
	// 再次输入密码错误提示信息
	@FindBy(xpath = RegPageElements.REG_PWD_CONFIRM_NOTICE)
	public static WebElement reg_pwd_confirm_notice;
		
	// 邮箱验证码错误提示信息
	@FindBy(xpath = RegPageElements.REG_EMAIL_VALIDCODE_NOTICE)
	public static WebElement reg_email_validcode_notice;
	
	// 短信验证码错误提示信息
	@FindBy(xpath = RegPageElements.REG_PHONE_VALIDCODE_NOTICE)
	public static WebElement reg_phone_validcode_notice;
	
	public static  WebDriver driver;
	
	public static String authLastName;
	public static String authFirstName;
	public static String authName;
	
	//初始化
	public RegWebElements(WebDriver driver){
		RegWebElements.driver = driver;
		authLastName=ReadWriteTxtFile.getLastName();
		authFirstName=ReadWriteTxtFile.getFirstName();
		//下面验证是否成功跳转微信关注公众号中间页时判断要用
		authName=authLastName+authFirstName;
		BaseTest.logConf();
	}
	
	//判断注册用户名输入框是否存在
    public static boolean regUsnBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_USERNAME));
    }
    
    //判断注册用户名错误提示信息是否存在
    public static boolean regUsnNotiBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_USERNAME_NOTICE));
    }
    
    //判断注册密码错误信息是否存在
    public static boolean regPWDNotiBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_PWD_NOTICE));
    }
    
    //判断注册再次输入密码错误信息是否存在
    public static boolean regPWDConfNotiBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_PWD_CONFIRM_NOTICE));
    }
    
    //判断注册图片验证码错误信息是否存在
    public static boolean regEmValCoBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_EMAIL_VALIDCODE_NOTICE));
    }
    
    //判断注册手机验证码错误提示信息是否存在
    public static boolean regPhValCoBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_PHONE_VALIDCODE_NOTICE));
    }
    
    //判断注册按钮是否存在
    public static boolean regBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(RegPageElements.REG_BTN));
    }
	
	/**
     * 注册邮箱账户
     */
    public static void regEmailFlow(String username, String password,String globalValicode) {
    	LoginWebElements.regist_uiatt_btn.click();
    	Utils.sleep(5);
    	logger.info("跳转并加载注册页面元素");
    	Reporter.log("跳转并加载注册页面元素");
    	//PageFactory.initElements(driver, RegWebElements.class);
    	Utils.sleep(5);
    	Assertion.assertEquals(true, RegWebElements.regUsnBtnIsExist(), "\"注册用户名\"输入框未找到，页面不符或元素改变，请检查！");
    	//因为此次只是功能流程的自动化脚本，先有行为逻辑才能触发相应校验，所以此处不对校验做全面的覆盖触发，只简单的考虑做一步行为，触发一个校验的判断；若今后有专门针对校验提示的全面覆盖脚本的需求，再说；
    	logger.info("输入注册用户名："+username);
    	Reporter.log("输入注册用户名："+username);
    	reg_username.clear();
    	reg_username.sendKeys(username);
    	reg_username.click();
    	
    	logger.info("输入注册密码："+password);
    	Reporter.log("输入注册密码："+password);
    	reg_pwd.clear();
    	if(RegWebElements.regUsnNotiBtnIsExist() == true){
			logger.error(reg_username_notice.getText());
    		//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_username_notice");
    		Assert.fail(reg_username_notice.getText());
		}
    	reg_pwd.sendKeys(password);
    	reg_pwd.click();
    	
    	logger.info("输入确认密码："+password);
    	Reporter.log("输入确认密码："+password);
    	reg_pwd_confirm.clear();
    	//ajax校验，错误提示在鼠标点击下一个输入框时才触发，元素才显示出来
    	if(RegWebElements.regPWDNotiBtnIsExist() == true){
			logger.error(reg_pwd_notice.getText());
			Reporter.log("[ERROR]"+reg_pwd_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_pwd_notice");
			Assert.fail(reg_pwd_notice.getText());
		}
    	reg_pwd_confirm.sendKeys(password);
    	reg_pwd_confirm.click();
    	
    	
    	logger.info("输入图片的万能验证码："+globalValicode);
    	Reporter.log("输入图片的万能验证码："+globalValicode);
    	//邮箱注册为图片验证码，此处以万能验证码处理，所以图片验证码的错误提示信息校验此处略过；
    	reg_email_validcode.clear();
    	if(RegWebElements.regPWDConfNotiBtnIsExist() == true){
			logger.error(reg_pwd_confirm_notice.getText());
			Reporter.log("[ERROR]"+reg_pwd_confirm_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_pwd_confirm_notice");
			Assert.fail(reg_pwd_confirm_notice.getText());
		}
    	reg_email_validcode.sendKeys(globalValicode);
    	reg_email_validcode.click();
    	
    	Assertion.assertEquals(true, RegWebElements.regBtnIsExist(), "\"注册\"按钮未找到，页面不符或元素改变，请检查！");
    	reg_btn.click();
    	//这个判断也许有点多余，只有在直接点击注册按钮，全部触发校验的时候才会生效
    	if(RegWebElements.regEmValCoBtnIsExist() == true && RegWebElements.regUsnNotiBtnIsExist() == true 
				&& RegWebElements.regPWDNotiBtnIsExist() == true && RegWebElements.regPWDConfNotiBtnIsExist() == true){
			logger.error(reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_email_validcode_notice.getText());
			Reporter.log("[ERROR]"+reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_email_validcode_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow");
			Assert.fail(reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_email_validcode_notice.getText());
		}
    	
    	Utils.sleep(2);
    }
    
    /**
     * 注册手机账户
     */
    public static void regPhoneFlow(String username, String password) {
    	LoginWebElements.regist_uiatt_btn.click();
    	Utils.sleep(5);
    	logger.info("跳转并加载注册页面元素");
    	Reporter.log("跳转并加载注册页面元素");
    	Utils.sleep(5);
    	Assertion.assertEquals(true, RegWebElements.regUsnBtnIsExist(), "\"注册用户名\"输入框未找到，页面不符或元素改变，请检查！");
    	//因为此次只是功能流程的自动化脚本，先有行为逻辑才能触发相应校验，所以此处不对校验做全面的覆盖触发，只简单的考虑做一步行为，触发一个校验的判断；若今后有专门针对校验提示的全面覆盖脚本的需求，再说；
    	logger.info("输入注册用户名："+username);
    	Reporter.log("输入注册用户名："+username);
    	reg_username.clear();
    	reg_username.sendKeys(username);
    	reg_username.click();
    	
    	logger.info("输入注册密码："+password);
    	Reporter.log("输入注册密码："+password);
    	reg_pwd.clear();
    	if(RegWebElements.regUsnNotiBtnIsExist() == true){
			logger.error(reg_username_notice.getText());
			Reporter.log("[ERROR]"+reg_username_notice.getText());
    		//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_username_notice");
    		Assert.fail(reg_username_notice.getText());
		}
    	reg_pwd.sendKeys(password);
    	reg_pwd.click();
    	
    	logger.info("输入确认密码："+password);
    	Reporter.log("输入确认密码："+password);
    	reg_pwd_confirm.clear();
    	//ajax校验，错误提示在鼠标点击下一个输入框时才触发，元素才显示出来
    	if(RegWebElements.regPWDNotiBtnIsExist() == true){
			logger.error(reg_pwd_notice.getText());
			Reporter.log("[ERROR]"+reg_pwd_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_pwd_notice");
			Assert.fail(reg_pwd_notice.getText());
		}
    	reg_pwd_confirm.sendKeys(password);
    	reg_pwd_confirm.click();
    	
    	//点击发送短信验证码按钮
    	send_phone_validcode.click();
    	logger.info("已点击发送短信验证码按钮，等待响应返回值");
    	Reporter.log("已点击发送短信验证码按钮，等待响应返回值");
    	String mobileCheckCode = TakeMsgValidCode.takeMsgValidCode(username);
    	logger.info("成功获取短信验证码："+mobileCheckCode);
    	Reporter.log("成功获取短信验证码："+mobileCheckCode);
    	
    	
    	reg_phone_validcode.clear();
    	if(RegWebElements.regPWDConfNotiBtnIsExist() == true){
			logger.error(reg_pwd_confirm_notice.getText());
			Reporter.log("[ERROR]"+reg_pwd_confirm_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_pwd_confirm_notice");
			Assert.fail(reg_pwd_confirm_notice.getText());
		}
    	reg_phone_validcode.sendKeys(mobileCheckCode);
    	reg_phone_validcode.click();
    	
    	Assertion.assertEquals(true, RegWebElements.regBtnIsExist(), "\"注册\"按钮未找到，页面不符或元素改变，请检查！");
    	reg_btn.click();
    	if(RegWebElements.regPhValCoBtnIsExist() == true){
			logger.error(reg_phone_validcode_notice.getText());
			Reporter.log("[ERROR]"+reg_phone_validcode_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regEmailFlow.reg_phone_validcode_notice");
			Assert.fail(reg_phone_validcode_notice.getText());
		}
    	//这个判断也许有点多余，只有在直接点击注册按钮，全部触发校验的时候才会生效
    	if(RegWebElements.regPhValCoBtnIsExist() == true && RegWebElements.regUsnNotiBtnIsExist() == true 
				&& RegWebElements.regPWDNotiBtnIsExist() == true && RegWebElements.regPWDConfNotiBtnIsExist() == true){
			logger.error(reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_phone_validcode_notice.getText());
			Reporter.log("[ERROR]"+reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_phone_validcode_notice.getText());
			//ScreenShotPC.screenShot("RegWebElements.regPhoneFlow");
			Assert.fail(reg_username_notice.getText()+"\n"+reg_pwd_notice.getText()+"\n"+reg_pwd_confirm_notice.getText()+"\n"+reg_phone_validcode_notice.getText());
		}
    	
    	Utils.sleep(2);
    }
    
    /**
     * 跳过认证
     */
    public static void skipAuth() {
    	Utils.sleep(2);
    	logger.info("开始跳转并加载医师认证页面元素");
    	Reporter.log("开始跳转并加载医师认证页面元素");
    	Utils.sleep(5);
    	Assertion.assertEquals(true, DoctAuthWebElements.authSkipBtnIsExist(), "\"暂不认证\"按钮未找到，页面不符或元素改变，请检查！");
    	logger.info("暂不认证按钮元素确认存在并找到");
    	Reporter.log("暂不认证按钮元素确认存在并找到");
    	//点击暂不认证，跳转登录后的主页
    	DoctAuthWebElements.auth_skip_btn.click();
    	logger.info("点击暂不认证，跳转登录后的主页");
    	Reporter.log("点击暂不认证，跳转登录后的主页");
    	Utils.sleep(5);
    	//通过判断“立即认证”按钮是否存在来验证是否跳转成功
    	Assertion.assertEquals(true, IndexWebElements.authNowBtnIsExist(), "\"立即认证\"按钮未找到，页面不符或元素改变，请检查！");
    	logger.info("立即认证按钮元素确认存在并找到，暂不认证注册用户登录成功");
    	Reporter.log("立即认证按钮元素确认存在并找到，暂不认证注册用户登录成功");
    }
    
    /**
     * 完成认证，此处只对上传照片处做异常捕获与处理
     */
    public static void doneAuth() {
    	logger.info("开始跳转并加载医师认证页面元素");
    	Reporter.log("开始跳转并加载医师认证页面元素");
    	Utils.sleep(3);
    	Assertion.assertEquals(true, DoctAuthWebElements.lastNameBtnIsExist(), "\"姓\"输入框未找到，页面不符或元素改变，请检查！");
    	logger.info("开始进行认证信息的填写.");
    	Reporter.log("开始进行认证信息的填写.");
    	//姓
    	DoctAuthWebElements.auth_lastname.clear();
    	DoctAuthWebElements.auth_lastname.sendKeys(authLastName);
    	DoctAuthWebElements.auth_lastname.click();
    	//名
    	DoctAuthWebElements.auth_firstname.clear();
    	DoctAuthWebElements.auth_firstname.sendKeys(authFirstName);
    	DoctAuthWebElements.auth_firstname.click();
    	
    	logger.info("doneAuth医师认证姓名检查:"+authName);
    	Reporter.log("doneAuth医师认证姓名检查:"+authName);
    	//勾选 医师学历证
    	DoctAuthWebElements.auth_educ_papers.click();
    	//证件号码
    	DoctAuthWebElements.auth_papers_number.clear();
    	DoctAuthWebElements.auth_papers_number.sendKeys(Dom4jXml.getValue("AUTH_PAPER_NUMBER"));
    	DoctAuthWebElements.auth_papers_number.click();
    	
    	Assertion.assertEquals(true, DoctAuthWebElements.authPhotoIsExist(), "\"上传照片\"按钮未找到，页面不符或元素未找到，请检查！");
    	//上传证件照片
    	String curPath = new File("").getAbsolutePath();   //所得结果为workspace所在路径
        String filePath = curPath + Dom4jXml.getValue("AUTH_PHOTO_PATH");  
        logger.info("找到上传图片的按钮了吗？"+DoctAuthWebElements.authPhotoIsExist());
        logger.info("找到上传图片的路径："+filePath);
        logger.info("找到上传图片的定位路径："+DoctAuthWebElements.auth_photo); 
        Reporter.log("找到上传图片的按钮了吗？"+DoctAuthWebElements.authPhotoIsExist());
        Reporter.log("找到上传图片的路径："+filePath);
        Reporter.log("找到上传图片的定位路径："+DoctAuthWebElements.auth_photo); 
    	DoctAuthWebElements.auth_photo.sendKeys(filePath);
    	
    	//医院
    	DoctAuthWebElements.auth_hospital.clear();
    	DoctAuthWebElements.auth_hospital.sendKeys(Dom4jXml.getValue("AUTH_HOSPITAL"));
    	DoctAuthWebElements.auth_hospital.click();
    	//选择职称,先选择一个再取消一个
    	DoctAuthWebElements.auth_job.click();
    	DoctAuthWebElements.auth_resident_doct.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.selected_auth_resident_doct.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.auth_attend_doct.click();
    	DoctAuthWebElements.auth_lecturer.click();
    	DoctAuthWebElements.auth_master_tutor.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.auth_job_confirm.click();
    	
    	//选择专业,先选择一个再取消一个
    	DoctAuthWebElements.auth_professional.click();
    	
    	//此处只对上传照片处做异常捕获与处理
    	if(DoctAuthWebElements.authPhoNotiIsExist() == true){
    		logger.error(DoctAuthWebElements.auth_photo_noti.getText());
    		Reporter.log("[ERROR]"+DoctAuthWebElements.auth_photo_noti.getText());
    		//ScreenShotPC.screenShot("RegWebElements.doneAuth");
    		Assert.fail(DoctAuthWebElements.auth_photo_noti.getText());
    	}
    	
    	DoctAuthWebElements.auth_joint.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.selected_auth_join.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.auth_spine.click();
    	Utils.sleep(2);
    	DoctAuthWebElements.auth_prof_confirm.click();
    	//提交认证
    	DoctAuthWebElements.auth_sub_btn.click();
    	logger.info("医师认证流程已完成！等待审核...");
    	Reporter.log("医师认证流程已完成！等待审核...");
    }
    
    /**
     * 如果是从注册后直接到医师认证完成的微信关注页的跳过
     */
    public static void weixinMid(){
    	logger.info("开始跳转并加载微信关注公众号中间页面元素,此为专属从注册后直接到医师认证完成的微信关注页的跳过");
    	Reporter.log("开始跳转并加载微信关注公众号中间页面元素,此为专属从注册后直接到医师认证完成的微信关注页的跳过");
    	Utils.sleep(5);
    	//logger.info("weixinMid医师认证姓名检查:"+authName);
    	//通过判断
    	Assertion.assertEquals(true, WeiXinMiddleWebElements.assertGoToWeiXinMiddlePage(authName), "未跳转到微信关注公众号中间页，是否加载失败或认证流程未正常结束，请检查！");
    	logger.info("微信关注公众号中间页跳转成功！点击跳过，进入登录后的主页");
    	Reporter.log("微信关注公众号中间页跳转成功！点击跳过，进入登录后的主页");
    	Assertion.assertEquals(true, WeiXinMiddleWebElements.skipWXBtnIsExist(), "跳过按钮未找到，是否加载失败，请检查！");
    	WeiXinMiddleWebElements.skip_weixin_scan.click();
    	logger.info("点击跳过，进入登录后的主页");
    	Reporter.log("点击跳过，进入登录后的主页");
    }
    
    /**
     * 如果是注册后跳过认证，但在操作文库、病例、话题等终端的详情页造成的权限提示后，从该入口进入的医师认证后跳转的微信关注页的跳过按钮，路径值竟然与从注册后直接到医师认证完成的微信关注页的跳过路径值不同，坑啊！！！切记！
     */
    public static void weixinMidAccess(){
    	logger.info("开始跳转并加载微信关注公众号中间页面元素，此为专属注册后跳过认证，但在操作文库、病例、话题等终端的详情页造成的权限提示后，从该入口进入的医师认证后跳转的微信关注页的跳过按钮");
    	Reporter.log("开始跳转并加载微信关注公众号中间页面元素，此为专属注册后跳过认证，但在操作文库、病例、话题等终端的详情页造成的权限提示后，从该入口进入的医师认证后跳转的微信关注页的跳过按钮");
    	Utils.sleep(5);
    	//logger.info("weixinMid医师认证姓名检查:"+authName);
    	//通过判断
    	Assertion.assertEquals(true, WeiXinMiddleWebElements.assertGoToWeiXinMiddlePage(authName), "未跳转到微信关注公众号中间页，是否加载失败或认证流程未正常结束，请检查！");
    	logger.info("微信关注公众号中间页跳转成功！点击跳过，进入登录后的主页");
    	Reporter.log("微信关注公众号中间页跳转成功！点击跳过，进入登录后的主页");
    	Assertion.assertEquals(true, WeiXinMiddleWebElements.skipWXAccessBtnIsExist(), "跳过按钮未找到，是否加载失败，请检查！");
    	WeiXinMiddleWebElements.skip_weixin_scan_access.click();
    	logger.info("点击跳过，进入登录后的主页");
    	Reporter.log("点击跳过，进入登录后的主页");
    }
}
