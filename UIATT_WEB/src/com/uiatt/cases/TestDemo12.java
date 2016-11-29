package com.uiatt.cases;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.uiatt.util.Utils;



public class TestDemo12 {
	public static  WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	public static Logger logger = Logger.getLogger(TestDemo12.class );
	public static Actions action ;
	
	
	public static void main(String[] arg0) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		jse = (JavascriptExecutor)driver; 
		wait = new WebDriverWait(driver,50);
		action = new Actions(driver);
		driver.get("http://127.0.0.1:8101/edus_auto/login_main.do");
		Utils.sleep(5);
		
		WebElement usname=driver.findElement(By.xpath(".//*[@id='loginName']"));
		WebElement pwd=driver.findElement(By.xpath(".//*[@id='password']"));
		WebElement subm=driver.findElement(By.xpath(".//input[@class='log_btn']"));
		usname.clear();
		usname.sendKeys("main");
		usname.click();
		pwd.clear();
		pwd.sendKeys("000000");
		pwd.click();
		
		logger.info("1111111"+subm);
		//jse.executeScript("function noneDIV(){ var eles = document.getElementsByTagName('input'); for(var i=0;i<eles.length;i++){ if(eles[i].className == 'log_btn'){ eles[i].click();}}}");
		//subm.click();
		action.click(subm).perform();
		//Utils.sleep(15);
		logger.info("333333"+subm);
		
	}



}
