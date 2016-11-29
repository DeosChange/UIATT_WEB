package com.uiatt.util;



import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utils {
	public static Logger logger = Logger.getLogger(Utils.class );
	public static WebDriverWait wait;
	public Utils(){
		BaseTest.logConf();
	}
	/**
     * 判断元素是否存在
     * @param driver
     * @return true or false
     */
	public static boolean isElementExist(WebDriver driver, By by) { 
        try { 
            driver.findElement(by);
            return true; 
        } catch(NoSuchElementException e) { 
        	//logger.info("密码错误提示元素定位报错信息："+e);
            return false; 
        } 
    } 
	
	/**
     * 取得元素文本
     * @param by
     * @return 未找到返回"Text not existed!"
     */
	public static String getText(WebDriver driver, By by) { 
        try { 
        	return driver.findElement(by).getText();
        } catch (NoSuchElementException e) { 
            return "Text not existed!"; 
        } 
    }
	
	/**
	 * Thread.sleep
	 * @param d
	 */
	public static void sleep(double d) {
		try {
			d *= 1000;
			Thread.sleep((int)d);
		} catch(Exception e) {
			
		}
	}
	
	/**
	 * 判断Alert是否存在
	 * 
	 */
	public static boolean isAlertPresent(WebDriver driver){  
        try {  
            driver.switchTo().alert();  
            return true;  
        }catch (NoAlertPresentException e){ 
            return false;  
        }  
	}
	
	/**
	 * 获取Alert上的Message
	 * 
	 */
	public static  String getAlert(WebDriver driver){  
	     Alert alert = driver.switchTo().alert();  
	     String str = alert.getText();  
	     //alert.accept();  
	     return str;  
	}  
	
	/**
	 * 等待跳转页面的某个元素出现
	 * 
	 * @param driver
	 * @param
	 */
	public static void waitElement(WebDriver driver, String pageElementXpath) {
		int num = 0;
		By by = By.xpath(pageElementXpath);
		while(Utils.isElementExist(driver, by) == false && num < 10) {
			Utils.sleep(2);
			num ++;
		}
		Utils.sleep(0.5);
	}
	
	
}
