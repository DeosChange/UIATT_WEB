package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.IndexPageElements;
import com.uiatt.pcPage.LoginPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;
/**
 * 登陆成功后跳转的页面，此页面是登陆成功后所有操作的源头类，包括登出等都在此页面进行；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class IndexWebElements {
	public static Logger logger = Logger.getLogger(IndexPageElements.class );
	// 会员登录后右上角的用户名按钮
	@FindBy(xpath = IndexPageElements.USERNAME_BTN)
	public static WebElement username_btn;
	
	// 右上角用户名出现的悬浮菜单中的登出按钮
	@FindBy(xpath = IndexPageElements.LOGOUT_uiatt_BTN)
	public static WebElement logout_uiatt_btn;
	
	// 右上角用户名出现的悬浮菜单中的“修改资料”按钮
	@FindBy(xpath = IndexPageElements.UPDATE_USERINFO)
	public static WebElement update_userinfo;
		
	// 未认证用户登录后页面正中显示的“立即认证按钮”
	@FindBy(xpath = IndexPageElements.AUTH_NOW_BTN)
	public static WebElement auth_now_btn;
	
	// 认证用户登录后页面正中显示的“立即关注按钮”
	@FindBy(xpath = IndexPageElements.ATTENTION_NOW_BTN)
	public static WebElement attention_now_btn;
	
	// 右侧你的首页按钮
	@FindBy(xpath = IndexPageElements.YOUR_HOMEPAGE)
	public static WebElement your_homepage;
	
	//发布病例按钮
	@FindBy(xpath = IndexPageElements.PUBLISH_SICKCASE)
	public static WebElement publish_sickcase;
	
	//发布病例成功后返回登陆后的主页，在“你关注的动态”的第一条内容即为你刚发布的病例
	@FindBy(xpath = IndexPageElements.FIRST_SICKCASE_TITLE)
	public static WebElement first_sickCase_title;
	
	//右上角用户名出现的悬浮菜单中的“个人中心”按钮
	@FindBy(xpath = IndexPageElements.PERSONAL_CENTER_BTN)
	public static WebElement personal_center_btn;
	
	//右上角绑定微信悬浮框的删除按钮
	@FindBy(xpath = IndexPageElements.REMOVE_WEIXIN_NOTI)
	public static WebElement remove_weixin_noti;
	
	//聊话题按钮
	@FindBy(xpath = IndexPageElements.PUBLISH_TOPIC)
	public static WebElement publish_topic;
	
	public static  WebDriver driver;
	
	public static Actions action ;
	
	public static WebDriverWait wait;
	
	public static JavascriptExecutor jse;
	
	//初始化
	public IndexWebElements(WebDriver driver){
		IndexWebElements.driver = driver;
		wait=new WebDriverWait(driver,50);
		action = new Actions(driver);
		jse = (JavascriptExecutor)driver; 
		BaseTest.logConf();
	}
	
	public static boolean assertGoToIndex() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.YOUR_HOMEPAGE));
	}
	
	//判断聊话题按钮是否存在
	public static boolean publishTopicIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.PUBLISH_TOPIC));
	}
	
	//右上角绑定微信悬浮框的删除按钮是否存在
	public static boolean removeWXNotiIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.REMOVE_WEIXIN_NOTI));
	}
	
	//判断右上角用户名出现的悬浮菜单中的“个人中心”按钮是否存在
	public static boolean personCenBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.PERSONAL_CENTER_BTN));
	}
	
	//判断病例是否发布成功
	public static boolean firstSCTitleIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.FIRST_SICKCASE_TITLE));
	}
	
	//判断发布病例按钮是否存在
	public static boolean publishSickCaseIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.PUBLISH_SICKCASE));
	}
	
	//判断 右上角用户名出现的悬浮菜单中的“修改资料”按钮是否存在
	public static boolean updateUSInfoBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.UPDATE_USERINFO));
	}
	
	//判断"立即关注"按钮是否存在
	public static boolean attenNowBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.ATTENTION_NOW_BTN));
	}
	
	//判断"立即认证"按钮是否存在
	public static boolean authNowBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.AUTH_NOW_BTN));
	}
		
	//判断"右上角姓名"按钮是否存在
	public static boolean usernameBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.USERNAME_BTN));
	}
		
	//判断"会员登出"按钮是否存在
	public static boolean logoutBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(IndexPageElements.LOGOUT_uiatt_BTN));
	}
	
	//判断确认退出的提示弹层是否被触发显示出来了
	
		
	public static void uiattLogout(){
		
		//如果右上角绑定微信悬浮框的删除按钮存在，关闭它，以免影响姓名悬浮框的出现
		if(IndexWebElements.removeWXNotiIsExist() == true){
			jse.executeScript("arguments[0].click();", IndexWebElements.remove_weixin_noti);
		}
		
		//Utils.sleep(3);
		if(usernameBtnIsExist() == true){
			logger.info("鼠标移至登陆后右上角用户名按钮上");
			Reporter.log("鼠标移至登陆后右上角用户名按钮上");
			action.moveToElement(username_btn).perform();
			//等待操作菜单出现
			//Utils.sleep(5);
			Utils.waitElement(driver, IndexPageElements.LOGOUT_uiatt_BTN);
			//判断悬浮菜单是否出现，登出按钮元素是否被加载
			if(logoutBtnIsExist() == true){
				logger.info("确认悬浮菜单上的退出按钮存在并单击以获取确认退出的提示弹层");
				Reporter.log("确认悬浮菜单上的退出按钮存在并单击以获取确认退出的提示弹层");
				//action.moveToElement(logout_uiatt_btn).perform();
				//Utils.sleep(3);
				//从隐式等待换成自定义显示等待
				//wait.until(ExpectedConditions.elementToBeClickable(logout_uiatt_btn));
				//logout_uiatt_btn.click();
				//试过N种方法，悬浮框总是不能每次稳定的出现，所以别怪我粗暴，暂时只能先这样了，呵呵哈哈哈哈哈~
				jse.executeScript("arguments[0].click();", IndexWebElements.logout_uiatt_btn);
				
				try{
					//处理确认弹层
					Alert confirm = driver.switchTo().alert();
					//wait.until(ExpectedConditions.alertIsPresent());
					logger.info("登出的确认弹层是否被触发显示出来了："+ExpectedConditions.alertIsPresent());
			        logger.info("获取弹层提示信息:"+confirm.getText());
			        Reporter.log("登出的确认弹层是否被触发显示出来了："+ExpectedConditions.alertIsPresent());
			        Reporter.log("获取弹层提示信息:"+confirm.getText());
			        Utils.sleep(2);
			        //点击“确认”按钮
			        confirm.accept();
					Utils.sleep(5);
					logger.info("会员退出，加载登陆页面");
					Reporter.log("会员退出，加载登陆页面");
				}catch(NoAlertPresentException e){
					logger.warn("确认退出的提示alert弹层未被触发显现！"+e);
					Reporter.log("[WARN]确认退出的提示alert弹层未被触发显现！"+e);
					Assert.fail("确认退出的提示alert弹层未被触发显现！");
					e.printStackTrace();
				}
				
			}else{
				logger.error("会员登出失败，可能是登出按钮未找到！");
				Reporter.log("[ERROR]会员登出失败，可能是登出按钮未找到！");
				//ScreenShotPC.screenShot("IndexPageElements.uiattLogout");
			}
				
		}else{
			logger.error("会员登出失败，可能是右上角用户名未找到！");
			Reporter.log("[ERROR]会员登出失败，可能是右上角用户名未找到！");
			//ScreenShotPC.screenShot("IndexPageElements.uiattLogout");
		}
		
		Utils.waitElement(driver, LoginPageElements.LOGIN_uiatt_BTN);
		//断言登出后是否能找到登陆按钮元素，判断是否登出成功
		Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist(),"'会员登录'按钮为找到，页面未正常跳转或加载失败，请检查！");
		logger.info("会员登出成功");
		Reporter.log("会员登出成功");
			
	}
}
