package com.uiatt.cases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.PersonHomePageElements;
import com.uiatt.pcWeb.IndexWebElements;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.PersonHomeWebElements;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;



public class TestDemo11 {
	public static  WebDriver driver;
	public static JavascriptExecutor jse;
	public static Logger logger = Logger.getLogger(TestDemo11.class );
	public static String curPath = new File("").getAbsolutePath();
	public static String phoExePath;
	@Test
	public static void mai() {
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LoginWebElements.class);
		PageFactory.initElements(driver, IndexWebElements.class);
		PageFactory.initElements(driver, PersonHomeWebElements.class);
		jse = (JavascriptExecutor)driver; 
		driver.get("http://www.allinmd.cn");
		Utils.sleep(3);
		LoginWebElements.allinLogin("xyypg7003@163.com", "12345678");
		Utils.sleep(3);
		if(IndexWebElements.removeWXNotiIsExist() == true){
			jse.executeScript("arguments[0].click();", IndexWebElements.remove_weixin_noti);
		}
		//悬浮至右上角姓名，等待悬浮菜单出现
		Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
		jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
		Utils.waitElement(driver,PersonHomePageElements.HEAD_PHOTO);
		Assertion.assertEquals(true, PersonHomeWebElements.headPhotoIsExist(), "\"个人头像\"未找到，元素未找到，请检查！");
		String oldPhoto = PersonHomeWebElements.head_photo.getAttribute("src");
		logger.info("oldPhoto的src是："+oldPhoto);
		PersonHomeWebElements.head_photo.click();
		
		Utils.waitElement(driver,PersonHomePageElements.SELECT_IMAG);
		Assertion.assertEquals(true, PersonHomeWebElements.selectImagIsExist(), "\"选择头像照片\"按钮未找到，元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("NEWHEADPHOTO");
		logger.info(phoExePath);
		PersonHomeWebElements.select_imag.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			//ScreenShotPC.screenShot("PersonHomeWebElements.updateHeadPhoto");
			Assert.fail(e.toString());
		}
		Utils.sleep(2);
		Utils.waitElement(driver,PersonHomePageElements.SAVE_IMAG_BTN);
		Assertion.assertEquals(true, PersonHomeWebElements.saveImagBtnIsExist(), "\"保存头像照片\"按钮未找到，元素未找到，请检查！");
		//logger.info("save_imag_btn是："+save_imag_btn);
		//PersonHomeWebElements.save_imag_btn.click();
		driver.findElement(By.xpath(".//div[@class='personal_sc_img_but']/div[1]")).click();
		//jse.executeScript("arguments[0].click();", PersonHomeWebElements.save_imag_btn);
		logger.info("11111111");
		
		
		
	}



}
