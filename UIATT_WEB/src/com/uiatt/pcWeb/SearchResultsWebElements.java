package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.SearchResultsPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 搜索结果页面所有功能按钮元素
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class SearchResultsWebElements {
	//搜索出的病例结果选项
	@FindBy(xpath = SearchResultsPageElements.SICKCASE_OPTION)
	public static WebElement sickCase_option;

	//病例结果统计
	@FindBy(xpath = SearchResultsPageElements.SICKCASE_STATISTICS)
	public static WebElement sickCase_statistics;

	//搜索出的话题结果选项
	@FindBy(xpath = SearchResultsPageElements.TOPIC_OPTION)
	public static WebElement topic_option;

	//话题结果统计
	@FindBy(xpath = SearchResultsPageElements.TOPIC_STATISTICS)
	public static WebElement topic_statistics;

	//搜索出的视频结果选项
	@FindBy(xpath = SearchResultsPageElements.VIDEO_OPTION)
	public static WebElement video_option;

	//视频结果统计
	@FindBy(xpath = SearchResultsPageElements.VIDEO_STATISTICS)
	public static WebElement video_statistics;

	//搜索出的文章结果选项
	@FindBy(xpath = SearchResultsPageElements.DOCUMENT_OPTION)
	public static WebElement document_option;

	//文章结果统计
	@FindBy(xpath = SearchResultsPageElements.DOCUMENT_STATISTICS)
	public static WebElement document_statistics;

	//搜索出的用户结果选项
	@FindBy(xpath = SearchResultsPageElements.USER_OPTION)
	public static WebElement user_option;

	//用户结果统计
	@FindBy(xpath = SearchResultsPageElements.USER_STATISTICS)
	public static WebElement user_statistics;
	
	//各个项搜索出的结果的关键字匹配
	@FindBy(xpath = SearchResultsPageElements.OPTION_RESULT_KEYWORD)
	public static WebElement option_result_keyword;
	
	//各个项搜索出的结果的统计数字匹配
	@FindBy(xpath = SearchResultsPageElements.OPTION_RESULT_STATISTICS)
	public static WebElement option_result_statistics;

	public static  WebDriver driver;
	public static WebDriverWait wait;
	public static String searchInputStyleValue ;
	
	public SearchResultsWebElements(WebDriver driver){
		SearchResultsWebElements.driver = driver;
		wait = new WebDriverWait(driver,1000);
		searchInputStyleValue = "";
		BaseTest.logConf();
	}
		
	//判断搜索出的病例结果选项是否存在
	public static boolean sickCaseOptIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.SICKCASE_OPTION));
    }
	
	//搜索出的话题结果选项
	public static boolean topicOptIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.TOPIC_OPTION));
    }
	
	//搜索出的视频结果选项
	public static boolean userOptIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.USER_OPTION));
    }
	
	//搜索出的文章结果选项
	public static boolean videoOptIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.VIDEO_OPTION));
    }
	
	//搜索出的用户结果选项
	public static boolean documentOptIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.DOCUMENT_OPTION));
    }
	
	//病例结果统计
	public static boolean sickCaseStatIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.SICKCASE_STATISTICS));
    }
	
	//话题结果统计
	public static boolean topicStatIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.TOPIC_STATISTICS));
    }
	
	//视频结果统计
	public static boolean videoStatIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.VIDEO_STATISTICS));
    }
	
	//文章结果统计
	public static boolean documentStatIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.DOCUMENT_STATISTICS));
    }
	
	//用户结果统计
	public static boolean userStatIsExist() {
    	return Utils.isElementExist(driver, By.xpath(SearchResultsPageElements.USER_STATISTICS));
    }
		
	/**
	 * 医师姓名搜索
	 * */
	public static void searchDoctorName(){
		logger.info("开始输入医师姓名");
		Reporter.log("开始输入医师姓名");
		LoginWebElements.search_btn.click();
		Utils.sleep(2);
		searchInputStyleValue = LoginWebElements.search_input_state.getAttribute("style");
		logger.info("检查搜索文本输入框的状态："+searchInputStyleValue);
		Reporter.log("检查搜索文本输入框的状态："+searchInputStyleValue);
		if("display: block;".equals(searchInputStyleValue)){
			LoginWebElements.search_input.clear();
			LoginWebElements.search_input.sendKeys(Dom4jXml.getValue("searchDoctorname"));
			LoginWebElements.search_input.click();
			
			LoginWebElements.search_input_btn.click();
			wait.until(ExpectedConditions.textToBePresentInElement(sickCase_option, "病例"));
			//验证病例
			Assertion.assertEquals(true, sickCaseOptIsExist(),"未找到病例结果项文本，");
			Assertion.assertEquals(true, sickCaseStatIsExist(),"未找到病例结果项统计值，");
			String scs = sickCase_statistics.getText();
			sickCase_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchDoctorname"), option_result_keyword.getText(),"验证在病例匹配结果，不是所输入的医师姓名，请检查");
			Assertion.assertEquals(scs, option_result_statistics.getText(),"验证在病例匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出病例结果项为："+scs);
			Reporter.log("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出病例结果项为："+scs);
			
			//验证话题
			Assertion.assertEquals(true, topicOptIsExist(),"未找到话题结果项文本，");
			Assertion.assertEquals(true, topicStatIsExist(),"未找到话题结果项统计值，");
			String ts = topic_statistics.getText();
			topic_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchDoctorname"), option_result_keyword.getText(),"验证在话题匹配结果，不是所输入的医师姓名，请检查");
			Assertion.assertEquals(ts, option_result_statistics.getText(),"验证在话题匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出话题结果项为："+ts);
			Reporter.log("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出话题结果项为："+ts);
			
			//验证视频
			Assertion.assertEquals(true, videoOptIsExist(),"未找到视频结果项文本，");
			Assertion.assertEquals(true, videoStatIsExist(),"未找到视频结果项统计值，");
			String vs = video_statistics.getText();
			video_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchDoctorname"), option_result_keyword.getText(),"验证在视频匹配结果，不是所输入的医师姓名，请检查");
			Assertion.assertEquals(vs, option_result_statistics.getText(),"验证在视频匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出视频结果项为："+vs);
			Reporter.log("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出视频结果项为："+vs);
			
			//验证文章
			Assertion.assertEquals(true, documentOptIsExist(),"未找到文章结果项文本，");
			Assertion.assertEquals(true, documentStatIsExist(),"未找到文章结果项统计值，");
			String ds = document_statistics.getText();
			document_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchDoctorname"), option_result_keyword.getText(),"验证在文章匹配结果，不是所输入的医师姓名，请检查");
			Assertion.assertEquals(ds, option_result_statistics.getText(),"验证在文章匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出文章结果项为："+ds);
			Reporter.log("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出文章结果项为："+ds);
			
			//验证用户
			Assertion.assertEquals(true, userOptIsExist(),"未找到用户结果项文本，");
			Assertion.assertEquals(true, userStatIsExist(),"未找到用户结果项统计值，");
			String us = user_statistics.getText();
			user_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchDoctorname"), option_result_keyword.getText(),"验证在用户匹配结果，不是所输入的医师姓名，请检查");
			Assertion.assertEquals(us, option_result_statistics.getText(),"验证在用户匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出用户结果项为："+us);
			Reporter.log("搜索医师姓名："+Dom4jXml.getValue("searchDoctorname")+"匹配出用户结果项为："+us);
			
		}else{
			logger.error("搜索文本输入框还没有显现出来，无法输入，请检查");
			Reporter.log("[ERROR]搜索文本输入框还没有显现出来，无法输入，请检查");
			Assert.fail("搜索文本输入框还没有显现出来，无法输入，请检查");
		}
		
	}
	
	/**
	 * 关键字搜索
	 * */
	public static void searchKeyword(){
		LoginWebElements.uiatt_logo_img.click();
		wait.until(ExpectedConditions.textToBePresentInElement(LoginWebElements.login_uiatt_btn, "会员登录"));
		Assertion.assertEquals(true, LoginWebElements.allmdBtnIsExist(), "\"会员登录\"按钮未找到，页面不符或元素改变，请检查！");
		logger.info("开始输入关键字");
		Reporter.log("开始输入关键字");
		LoginWebElements.search_btn.click();
		Utils.sleep(2);
		searchInputStyleValue = LoginWebElements.search_input_state.getAttribute("style");
		logger.info("检查搜索文本输入框的状态："+searchInputStyleValue);
		Reporter.log("检查搜索文本输入框的状态："+searchInputStyleValue);
		if("display: block;".equals(searchInputStyleValue)){
			LoginWebElements.search_input.clear();
			LoginWebElements.search_input.sendKeys(Dom4jXml.getValue("searchKeyword"));
			LoginWebElements.search_input.click();
			
			LoginWebElements.search_input_btn.click();
			wait.until(ExpectedConditions.textToBePresentInElement(sickCase_option, "病例"));
			//验证病例
			Assertion.assertEquals(true, sickCaseOptIsExist(),"未找到病例结果项文本，");
			Assertion.assertEquals(true, sickCaseStatIsExist(),"未找到病例结果项统计值，");
			String scs = sickCase_statistics.getText();
			sickCase_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchKeyword"), option_result_keyword.getText(),"验证在病例匹配结果，不是所输入的关键字，请检查");
			Assertion.assertEquals(scs, option_result_statistics.getText(),"验证在病例匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出病例结果项为："+scs);
			Reporter.log("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出病例结果项为："+scs);
			
			//验证话题
			Assertion.assertEquals(true, topicOptIsExist(),"未找到话题结果项文本，");
			Assertion.assertEquals(true, topicStatIsExist(),"未找到话题结果项统计值，");
			String ts = topic_statistics.getText();
			topic_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchKeyword"), option_result_keyword.getText(),"验证在话题匹配结果，不是所输入的关键字，请检查");
			Assertion.assertEquals(ts, option_result_statistics.getText(),"验证在话题匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出话题结果项为："+ts);
			Reporter.log("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出话题结果项为："+ts);
			
			//验证视频
			Assertion.assertEquals(true, videoOptIsExist(),"未找到视频结果项文本，");
			Assertion.assertEquals(true, videoStatIsExist(),"未找到视频结果项统计值，");
			String vs = video_statistics.getText();
			video_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchKeyword"), option_result_keyword.getText(),"验证在视频匹配结果，不是所输入的关键字，请检查");
			Assertion.assertEquals(vs, option_result_statistics.getText(),"验证在视频匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出视频结果项为："+vs);
			Reporter.log("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出视频结果项为："+vs);
			
			//验证文章
			Assertion.assertEquals(true, documentOptIsExist(),"未找到文章结果项文本，");
			Assertion.assertEquals(true, documentStatIsExist(),"未找到文章结果项统计值，");
			String ds = document_statistics.getText();
			document_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchKeyword"), option_result_keyword.getText(),"验证在文章匹配结果，不是所输入的关键字，请检查");
			Assertion.assertEquals(ds, option_result_statistics.getText(),"验证在文章匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出文章结果项为："+ds);
			Reporter.log("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出文章结果项为："+ds);
			
			//验证用户
			Assertion.assertEquals(true, userOptIsExist(),"未找到用户结果项文本，");
			Assertion.assertEquals(true, userStatIsExist(),"未找到用户结果项统计值，");
			String us = user_statistics.getText();
			user_option.click();
			Utils.sleep(3);
			Assertion.assertEquals(Dom4jXml.getValue("searchKeyword"), option_result_keyword.getText(),"验证在用户匹配结果，不是所输入的关键字，请检查");
			Assertion.assertEquals(us, option_result_statistics.getText(),"验证在用户匹配结果，统计数目左侧菜单与详情菜单显示不一致，请检查");
			logger.info("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出用户结果项为："+us);
			Reporter.log("搜索关键字："+Dom4jXml.getValue("searchKeyword")+"匹配出用户结果项为："+us);
			
		}else{
			logger.error("搜索文本输入框还没有显现出来，无法输入，请检查");
			Reporter.log("[ERROR]搜索文本输入框还没有显现出来，无法输入，请检查");
			Assert.fail("搜索文本输入框还没有显现出来，无法输入，请检查");
		}
		
		
	}
	
}
