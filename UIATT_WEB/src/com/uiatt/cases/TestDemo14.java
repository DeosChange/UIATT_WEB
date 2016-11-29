package com.uiatt.cases;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.uiatt.util.Utils;



public class TestDemo14 {
	public static  WebDriver driver;

	
	public static void main(String[] arg0) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	
		driver.get("http://www.baidu.com");
		Utils.sleep(5);
		 String title=driver.getTitle();
		    //获取当前页面的title属性的值，一般利用这个属性可以判断页面是否跳转成功。

		    System.out.println(title);
		    //打印当前页面的title

		    String pagesource = driver.getPageSource();
		    //获取当前页面整个页面的源码，可以在后台打印出来查看。

		    System.out.println(pagesource);
		    //打印整个页面的源码。
		    

		Utils.sleep(15);
		driver.quit();
		
	}
	
	
	


}
