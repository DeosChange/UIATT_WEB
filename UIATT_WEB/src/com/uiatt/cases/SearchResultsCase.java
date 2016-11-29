package com.uiatt.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.uiatt.listener.Assertion;
import com.uiatt.pcWeb.LoginWebElements;
import com.uiatt.pcWeb.SearchResultsWebElements;
import com.uiatt.util.BaseTest;



/**
 * 2.0PC 导航栏医师姓名、关键字、title搜索并验证测试用例
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class SearchResultsCase {
	public static WebDriver driver;
	

	@BeforeClass
	public void setUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Reporter.log("================================================*********用例开始**********==========================================================================");
		driver=BaseTest.chromeInit(driver);
		BaseTest.connAllin(driver);
		PageFactory.initElements(driver, SearchResultsWebElements.class);
	}
	
	@AfterClass  
	public void tearDown() {
		driver.quit();
		Reporter.log("================================================*********用例结束**********==========================================================================");
	} 
	
	/**
	 * 验证登陆页面导航栏搜索按钮是否存在以确定页面正常跳转
	 */
	@Test (priority = 1)
	public void assertSearchButton() {
		Assertion.assertEquals(true, LoginWebElements.searchBtnIsExist(), "\"登陆页面导航栏搜索\"按钮未找到，页面不符或元素改变，请检查！");
    }

	/**
	 * 验证医师姓名搜索
	 */
	@Test (priority = 2,dependsOnMethods = {"assertSearchButton"})
	public void searchDoctorName(){
		SearchResultsWebElements.searchDoctorName();
	}
	
	/**
	 * 验证关键字搜索
	 */
	@Test (priority = 3,dependsOnMethods = {"searchDoctorName"})
	public void searchKeyword(){
		SearchResultsWebElements.searchKeyword();
	}
	
}
