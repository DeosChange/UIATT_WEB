package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.UpdateUSInfoPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;


/**
 * 提取2.0 PC 登陆后修改密码
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class UpdateUSInfoWebElements {
	// 修改密码按钮
	@FindBy(xpath = UpdateUSInfoPageElements.UPDATE_PW)
	public static WebElement update_pw;
	
	//当前密码
	@FindBy(xpath = UpdateUSInfoPageElements.CURRENT_PW)
	public static WebElement current_pw;
	
	//新密码
	@FindBy(xpath = UpdateUSInfoPageElements.NEW_PW)
	public static WebElement new_pw;
	
	//确认密码
	@FindBy(xpath = UpdateUSInfoPageElements.CONFIRM_PW)
	public static WebElement confirm_pw;
	
	//保存修改按钮
	@FindBy(xpath = UpdateUSInfoPageElements.SAVE_UPDATE_BTN)
	public static WebElement save_update_btn;
	
	//取消修改按钮
	@FindBy(xpath = UpdateUSInfoPageElements.CANCEL_UPDATE_BTN)
	public static WebElement cancel_update_btn;
	
	//当前密码的错误信息
	@FindBy(xpath = UpdateUSInfoPageElements.CUR_ERR_NOTICE)
	public static WebElement cur_err_notice;
	
	//新密码的错误信息
	@FindBy(xpath = UpdateUSInfoPageElements.NEW_ERR_NOTICE)
	public static WebElement new_err_notice;
	
	//确认密码的错误信息
	@FindBy(xpath = UpdateUSInfoPageElements.CONFIRM_ERR_NOTICE)
	public static WebElement confirm_err_notice;
	
	public static  WebDriver driver;
	
	public static Actions action ;
	
	public static WebDriverWait wait;
	
	public static JavascriptExecutor jse;
	
	//初始化
	public UpdateUSInfoWebElements(WebDriver driver){
		UpdateUSInfoWebElements.driver = driver;
		wait=new WebDriverWait(driver,50);
		action = new Actions(driver);
		jse = (JavascriptExecutor)driver; 
		BaseTest.logConf();
	}
	
	//判断修改密码按钮是否存在
    public static boolean updatePWBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(UpdateUSInfoPageElements.UPDATE_PW));
    }
    
    //判断当前密码输入框是否存在
    public static boolean currentPWBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(UpdateUSInfoPageElements.CURRENT_PW));
    }
    
    //当前密码错误提示信息是否存在
    public static boolean curErrNotiIsExist() {
    	return Utils.isElementExist(driver, By.xpath(UpdateUSInfoPageElements.CUR_ERR_NOTICE));
    }
    
    //新密码错误提示信息是否存在
    public static boolean newErrNotiIsExist() {
    	return Utils.isElementExist(driver, By.xpath(UpdateUSInfoPageElements.NEW_ERR_NOTICE));
    }
    
    //确认密码错误提示信息是否存在
    public static boolean confErrNotiIsExist() {
    	return Utils.isElementExist(driver, By.xpath(UpdateUSInfoPageElements.CONFIRM_ERR_NOTICE));
    }
    
    /**
     * 修改密码操作
     * */
    public static void updatePW(String newPWValue,String curPWValue){
    	if(IndexWebElements.usernameBtnIsExist() == true){
    		//Utils.sleep(3);
    		//如果右上角绑定微信悬浮框的删除按钮存在，关闭它，以免影响姓名悬浮框的出现
    		if(IndexWebElements.removeWXNotiIsExist() == true){
    			jse.executeScript("arguments[0].click();", IndexWebElements.remove_weixin_noti);
    		}   		
			logger.info("鼠标移至登陆后右上角用户名按钮上");
			Reporter.log("鼠标移至登陆后右上角用户名按钮上");
			action.moveToElement(IndexWebElements.username_btn).perform();
			//等待操作菜单出现
			Utils.sleep(5);
			//判断悬浮菜单是否出现，“修改资料”按钮元素是否被加载
			if(IndexWebElements.updateUSInfoBtnIsExist() == true){
				logger.info("确认悬浮菜单上的“修改资料”按钮存在并单击");
				Reporter.log("确认悬浮菜单上的“修改资料”按钮存在并单击");
				Utils.sleep(3);
				jse.executeScript("arguments[0].click();", IndexWebElements.update_userinfo);
				Utils.sleep(3);
				//加载修改资料页面元素
				Assertion.assertEquals(true, UpdateUSInfoWebElements.updatePWBtnIsExist(), "未跳转到修改资料页，是否加载失败，请检查！");
				logger.info("成功跳转到修改资料页");
				Reporter.log("成功跳转到修改资料页");
				update_pw.click();
				Utils.sleep(2);
				Assertion.assertEquals(true, UpdateUSInfoWebElements.currentPWBtnIsExist(), "未找到当前密码输入框，是否加载失败，请检查！");
				current_pw.clear();
				current_pw.sendKeys(curPWValue);
				current_pw.click();
				new_pw.clear();
				//判断当前密码输入是否符合规范
				if(UpdateUSInfoWebElements.curErrNotiIsExist() == true){
					logger.error(cur_err_notice.getText());
					Reporter.log("[ERROR]"+cur_err_notice.getText());
		    		//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW.cur_err_notice");
		    		Assert.fail(cur_err_notice.getText());
				}
				new_pw.sendKeys(newPWValue);
				new_pw.click();
				confirm_pw.clear();
				////判断新密码输入是否符合规范。点击确认密码输入框，会触发确认密码的一个提示“请再次输入密码”，这个不加以捕获
				if(UpdateUSInfoWebElements.newErrNotiIsExist() == true){
					logger.error(new_err_notice.getText());
					Reporter.log("[ERROR]"+new_err_notice.getText());
		    		//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW.new_err_notice");
		    		Assert.fail(new_err_notice.getText());
				}
				confirm_pw.sendKeys(newPWValue);
				confirm_pw.click();
				
				save_update_btn.click();
				//判断当前密码值是否填写错误
				if(UpdateUSInfoWebElements.curErrNotiIsExist() == true){
					logger.error(cur_err_notice.getText());
					Reporter.log("[ERROR]"+cur_err_notice.getText());
		    		//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW.cur_err_notice");
		    		Assert.fail(cur_err_notice.getText());
				}
				//判断两次密码输入是否一致
				if(UpdateUSInfoWebElements.confErrNotiIsExist() == true){
					logger.error(confirm_err_notice.getText());
					Reporter.log("[ERROR]"+confirm_err_notice.getText());
		    		//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW.confirm_err_notice");
		    		Assert.fail(confirm_err_notice.getText());
				}
				Utils.sleep(2);
				//修改密码成功后，编辑选项会再次隐藏，恢复为“修改密码按钮”，以此判断是否修改密码后保存成功
				Assertion.assertEquals(true, UpdateUSInfoWebElements.updatePWBtnIsExist(), "未找到当前密码输入框，是否加载失败，请检查！");
				logger.info("修改密码保存成功");
				Reporter.log("修改密码保存成功");
				
				
			}else{
				logger.error("会员修改资料失败，可能是“修改资料”按钮未找到！");
				Reporter.log("[ERROR]"+"会员修改资料失败，可能是“修改资料”按钮未找到！");
				//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW");
			}
				
		}else{
			logger.error("会员登出失败，可能是右上角用户名未找到！");
			Reporter.log("[ERROR]"+"会员登出失败，可能是右上角用户名未找到！");
			//ScreenShotPC.screenShot("UpdateUSInfoWebElements.updatePW");
		}
    	
    }
}
