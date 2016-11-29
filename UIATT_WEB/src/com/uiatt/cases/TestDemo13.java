package com.uiatt.cases;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.uiatt.util.Utils;



public class TestDemo13 {
	public static  WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor jse;
	public static Logger logger = Logger.getLogger(TestDemo13.class );
	public static Actions action ;
	public static String styleValue;
	
	public static void main(String[] arg0) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		jse = (JavascriptExecutor)driver; 
		wait = new WebDriverWait(driver,50);
		action = new Actions(driver);
		driver.get("http://www.uiatt.cn");
		Utils.sleep(5);
		styleValue = driver.findElement(By.xpath(".//*[@id='search_launch']")).getAttribute("style");
		System.out.println("1111"+styleValue+"11111");
		driver.findElement(By.xpath(".//*[@id='search_default']/a/img")).click();
		Utils.sleep(8);
	    styleValue = driver.findElement(By.xpath(".//*[@id='search_launch']")).getAttribute("style");
		System.out.println("2222"+styleValue+"22222");
		Utils.sleep(5);
		driver.findElement(By.xpath(".//*[@id='allinLogin']/div[1]/div[1]")).click();
		Utils.sleep(5);
		styleValue = driver.findElement(By.xpath(".//*[@id='search_launch']")).getAttribute("style");
		System.out.println("3333"+styleValue+"33333");
		Utils.sleep(5);
		driver.quit();
		
	}
	
	
	


}
