package com.uiatt.util;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.uiatt.pcWeb.LoginWebElements;


/**
 * 用于提取一些公共通用的各种配置，要修改的话，只需修改这一处即可
 * author:Change
 * */
public class BaseTest {
	public static String curPath ;
	//确保引用类中的所有driver值都保持一致
	public static WebDriver chromeInit(WebDriver driver){
		System.setProperty(Dom4jXml.getValue("chromeDriverName"), Dom4jXml.getValue("chromeDriverPath"));
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		return driver;
	}
	/**
	//chome浏览器初始化并访问唯医2.0,利用反射将字符串转为一个类的实例
	public static void chromeConnAllin(WebDriver driver,String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class claObj=Class.forName(Dom4jXml.getValue(className));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get(Dom4jXml.getValue("loginUrl"));
		//通过反射获取的类的实例进行页面元素初始化
		PageFactory.initElements(driver, claObj);
		Utils.sleep(5);
	}
	*/
	
	//浏览器初始化并访问唯医2.0
	public static void connAllin(WebDriver driver) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get(Dom4jXml.getValue("loginUrl"));
		//通过反射获取的类的实例进行页面元素初始化
		PageFactory.initElements(driver, LoginWebElements.class);
		Utils.sleep(5);
	}
	
	//初始化log4j配置文件路径
	public static void logConf(){
		curPath = new File("").getAbsolutePath();   //所得结果为workspace所在路径
        String poperFilePath = curPath + Dom4jXml.getValue("log4jConfigPath");
		PropertyConfigurator.configure(poperFilePath);
	}
	
	
	

}
