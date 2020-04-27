package com.uiatt.pcWeb;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.IndexPageElements;
import com.uiatt.pcPage.OneTopicPageElements;
import com.uiatt.pcPage.PersonHomePageElements;
import com.uiatt.pcPage.PublishTopicPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;

/**
 * 点击聊话题后弹出的编辑窗体的所有元素；
 * author:Change
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PublishTopicWebElements {
	//话题类型
	@FindBy(xpath = PublishTopicPageElements.TOPIC_TYPE_FIRST)
	public static WebElement topic_type_first;

	//话题标题
	@FindBy(xpath = PublishTopicPageElements.TOPIC_TITLE)
	public static WebElement topic_title;
	
	//话题标签
	@FindBy(xpath = PublishTopicPageElements.TOPIC_LABEL)
	public static WebElement topic_label;
	
	//话题标签第一个选项
	@FindBy(xpath = PublishTopicPageElements.TOPIC_LABEL_VALUE1)
	public static WebElement topic_label_value1;
	
	//文字讨论
	@FindBy(xpath = PublishTopicPageElements.TOPIC_TXT_DISCUSS)
	public static WebElement topic_txt_discuss;
	
	//添加第一张照片按钮
	@FindBy(xpath = PublishTopicPageElements.TOPIC_ADDFIRPHO_BTN)
	public static WebElement topic_addFirPho_btn;
	
	//添加第二章照片按钮
	@FindBy(xpath = PublishTopicPageElements.TOPIC_ADDSECPHO_BTN)
	public static WebElement topic_addSecPho_btn;
	
	//删除第二张照片按钮
	@FindBy(xpath = PublishTopicPageElements.TOPIC_FIRPHOREMOVE_BTN)
	public static WebElement topic_firPhoRemove_btn;
	
	//提醒谁看输入框
	@FindBy(xpath = PublishTopicPageElements.TOPIC_REMIND_INPUT)
	public static WebElement topic_remind_input;
	
	//此处不考虑匹配出的正确性，直接先选取第一个被匹配出的人
	@FindBy(xpath = PublishTopicPageElements.REMIND_MATCHED_FIRST)
	public static WebElement remind_matched_first;
	
	//话题发布按钮
	@FindBy(xpath = PublishTopicPageElements.TOPIC_PUBLISH)
	public static WebElement topic_publish;
	
	//话题标签隐藏的选项区
	@FindBy(xpath = PublishTopicPageElements.TOPIC_LABEL_DISPLAYLIST)
	public static WebElement topic_label_displayList;
	
	//新增话题时的编辑窗体
	@FindBy(xpath = PublishTopicPageElements.EDIT_WINDOW)
	public static WebElement edit_window;
	
	public static  WebDriver driver;
	public static String curPath;
	public static String phoExePath;
	public static JavascriptExecutor jse;
	public static Actions action ;
	
	public PublishTopicWebElements(WebDriver driver){
		PublishTopicWebElements.driver = driver;
		jse = (JavascriptExecutor)driver; 
		action = new Actions(driver);
		curPath = new File("").getAbsolutePath();
		BaseTest.logConf();
	}
	
	//判断新增话题时的编辑窗体是否存在
	public static boolean editWindIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.EDIT_WINDOW));
	}
	
	//判断话题类型是否存在
	public static boolean topicTypeFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_TYPE_FIRST));
	}
	
	//判断话题发布按钮是否存在
	public static boolean topicPublishIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_PUBLISH));
	}
	
	//判断添加第一张照片按钮是否存在
	public static boolean topicAddFirPhoBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_ADDFIRPHO_BTN));
	}
	
	//判断添加第二张照片按钮是否存在
	public static boolean topicAddSecPhoBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_ADDSECPHO_BTN));
	}
	
	//判断删除第一张照片按钮是否存在
	public static boolean topicFirPhoRemBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_FIRPHOREMOVE_BTN));
	}
	
	//判断第一个被匹配出的人是否存在
	public static boolean remindMatchedFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.REMIND_MATCHED_FIRST));
	}
	
	//判断话题标签第一个选项是否存在
	public static boolean topicLabelVal1IsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishTopicPageElements.TOPIC_LABEL_VALUE1));
	}
	
	
	/**
	 * 发布话题
	 * */
	public static void publishTopic(WebDriver driver){
		logger.info("开始新增话题前准备");
		Reporter.log("开始新增话题前准备");
		Utils.waitElement(driver, IndexPageElements.PUBLISH_TOPIC);
		Assertion.assertEquals(true, IndexWebElements.publishTopicIsExist(), "\"发布话题\"按钮未找到，页面不符或元素未找到，请检查！");
		IndexWebElements.publish_topic.click();
		Utils.sleep(2);
		logger.info("开始编辑要新增的话题内容");
		Reporter.log("开始编辑要新增的话题内容");
		Utils.waitElement(driver,PublishTopicPageElements.TOPIC_TYPE_FIRST);
		Assertion.assertEquals(true, PublishTopicWebElements.topicTypeFirstIsExist(), "\"话题类型\"选择按钮未找到，页面不符或元素未找到，请检查！");
		PublishTopicWebElements.topic_type_first.click();
		
		PublishTopicWebElements.topic_title.clear();
		PublishTopicWebElements.topic_title.sendKeys(Dom4jXml.getValue("TOPIC_TITLE"));
		PublishTopicWebElements.topic_title.click();
		
		PublishTopicWebElements.topic_label.click();
		Utils.waitElement(driver,PublishTopicPageElements.TOPIC_LABEL_VALUE1);
		Assertion.assertEquals(true, PublishTopicWebElements.topicLabelVal1IsExist(), "\"话题标签第一个选项\"未找到，页面不符或元素未找到，请检查！");
		PublishTopicWebElements.topic_label_value1.click();
		//强行收回标签选项隐藏域
		jse.executeScript("arguments[0].setAttribute('style','display:none');", PublishTopicWebElements.topic_label_displayList);
		
		Utils.sleep(2);
		PublishTopicWebElements.topic_txt_discuss.clear();
		PublishTopicWebElements.topic_txt_discuss.sendKeys(Dom4jXml.getValue("TOPIC_TXT_DISCUSSS"));
		PublishTopicWebElements.topic_txt_discuss.click();
		
		Assertion.assertEquals(true, PublishTopicWebElements.topicAddFirPhoBtnIsExist(), "\"话题添加第一张照片\"按钮未找到，页面不符或元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("TOPICFIRSTPHOTO");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PublishTopicWebElements.topic_addFirPho_btn.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishTopicWebElements.publishTopic");
			Assert.fail(e.toString());
		}
		
		Utils.waitElement(driver,PublishTopicPageElements.TOPIC_ADDSECPHO_BTN);
		Assertion.assertEquals(true, PublishTopicWebElements.topicAddSecPhoBtnIsExist(), "\"话题添加第二张照片\"按钮未找到，页面不符或元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("TOPICSECPHOTO");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PublishTopicWebElements.topic_addSecPho_btn.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishTopicWebElements.publishTopic");
			Assert.fail(e.toString());
		}
		
		Utils.sleep(8);
		Assertion.assertEquals(true, PublishTopicWebElements.topicFirPhoRemBtnIsExist(), "\"话题删除第二张照片\"按钮未找到，页面不符或元素未找到，请检查！");
		PublishTopicWebElements.topic_firPhoRemove_btn.click();
		
		Utils.sleep(3);
		PublishTopicWebElements.topic_remind_input.clear();
		PublishTopicWebElements.topic_remind_input.sendKeys(Dom4jXml.getValue("REMIND_INPUT"));
		PublishTopicWebElements.topic_remind_input.click();
		Utils.waitElement(driver, PublishTopicPageElements.REMIND_MATCHED_FIRST);
		Assertion.assertEquals(true, PublishTopicWebElements.remindMatchedFirstIsExist(), "\"第一个匹配出的用户\"未找到，没有匹配项或未找到该元素，请检查！");
		PublishTopicWebElements.remind_matched_first.click();
		
		Utils.sleep(2);
		PublishTopicWebElements.topic_publish.click();
		
		//如果提交动作没有执行完就持续等待，直到提交完
		int num = 0;
		while(PublishTopicWebElements.editWindIsExist() == true && num < 10) {
			Utils.sleep(2);
			num ++;
		}
		//在编辑窗体消失的瞬间，循环跳出，但是新的页面还没有跳转和加载完，所以仍需等待
		Utils.sleep(8);
			
		//悬浮至右上角姓名，等待悬浮菜单出现
		Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
		jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
		
		Utils.waitElement(driver,PersonHomePageElements.PUBLISHED_TOPICS);
		//进入“发布的话题”
		Assertion.assertEquals(true, PersonHomeWebElements.publishedTopicsIsExist(), "\"个人中心页右侧发布的话题\"菜单未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.published_topics.click();
		Utils.sleep(3);
		//再次点击以局部刷新数据
		PersonHomeWebElements.published_topics.click();
		Utils.waitElement(driver,PersonHomePageElements.FIRST_NEWS_TITLE);
		//跳转已发布的话题列表，判断第一条是否是刚才新发布的资源
		Assertion.assertEquals(true, PersonHomeWebElements.firstNewsTitleIsExist(), "\"发布的话题中最新一条\"标题未找到，未发布成功或元素未找到，请检查！");
		logger.info("获取最新一条发布的话题，标题为："+PersonHomeWebElements.first_news_title.getText());
		Reporter.log("获取最新一条发布的话题，标题为："+PersonHomeWebElements.first_news_title.getText());
		String ExpectTitle = "《"+Dom4jXml.getValue("TOPIC_TITLE")+"》";
		//提取标题，判断是否发布成功
		Assertion.assertEquals(ExpectTitle, PersonHomeWebElements.first_news_title.getText(), "\"所获取的最新一条话题的标题与编辑时输入值不符\"，未发布成功或元素未找对，请检查！");
		logger.info("新增话题"+PersonHomeWebElements.first_news_title.getText()+"发布成功");
		Reporter.log("新增话题"+PersonHomeWebElements.first_news_title.getText()+"发布成功");
	}
	
	
	/**
	 * 发布评论
	 * */
	public static void publishComment(WebDriver driver){
		PersonHomeWebElements.first_news_title.click();
		Utils.waitElement(driver,OneTopicPageElements.COMMENT_INPUT);
		Assertion.assertEquals(true, OneTopicWebElements.comInputIsExist(), "\"直接给资源主体评论的输入框\"未找到，元素未找对，请检查！");
		logger.info("开始对话题进行发布评论");
		Reporter.log("开始对话题进行发布评论");
		OneTopicWebElements.comment_input.click();
		OneTopicWebElements.comment_input.clear();
		OneTopicWebElements.comment_input.sendKeys(Dom4jXml.getValue("SICK_COMMENT_TEXT"));
		
		Utils.sleep(3);
		String addPhotoBtnState = OneTopicWebElements.add_photo_btn_state.getAttribute("style");
		String shouldBeState = "display: block;";			
		Assertion.assertEquals(shouldBeState, addPhotoBtnState, "\"直接给资源主体评论的添加图片按钮display状态还未变成block\"，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("SICK_COMMENTPHO_PATH");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		
		OneTopicWebElements.add_photo.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishTopicWebElements.publishComment");
			Assert.fail(e.toString());
		}
		
		Utils.waitElement(driver,OneTopicPageElements.REMIND_SOMEBODY);
		Assertion.assertEquals(true, OneTopicWebElements.remindSomeBodyIsExist(), "\"直接给资源主体评论的提醒谁看按钮\"未找到，元素未找对，请检查！");
		OneTopicWebElements.remind_somebody.click();
		Utils.waitElement(driver,OneTopicPageElements.SCCOM_REMIND_INPUT);
		Assertion.assertEquals(true, OneTopicWebElements.sccomRemInpIsExist(), "\"直接给资源主体评论的提醒谁看输入框\"未找到，元素未找对，请检查！");
		OneTopicWebElements.sccom_remind_input.clear();
		OneTopicWebElements.sccom_remind_input.sendKeys(Dom4jXml.getValue("SICK_COMMENT_REMIND_INPUT"));
		OneTopicWebElements.sccom_remind_input.click();
		Utils.waitElement(driver,OneTopicPageElements.SCCOM_REMI_FIR_MATCH);
		Assertion.assertEquals(true, OneTopicWebElements.sccomRemFirMatIsExist(), "\"直接给资源主体评论的提醒谁看第一个被匹配出来的用户\"未找到，元素未找对，请检查！");
		OneTopicWebElements.sccom_remi_fir_match.click();
		
		Utils.waitElement(driver,OneTopicPageElements.PUB_COM_BTN);
		Assertion.assertEquals(true, OneTopicWebElements.pubComBtnIsExist(), "\"直接给资源主体评论的发布按钮\"未找到，元素未找对，请检查！");
		OneTopicWebElements.pub_com_btn.click();
		
		logger.info("开始校验刚才发布的评论");
		Reporter.log("开始校验刚才发布的评论");
		Utils.sleep(3);
		Utils.waitElement(driver,OneTopicPageElements.FIRST_PUBLISHED_CONTENT);
		Assertion.assertEquals(true, OneTopicWebElements.firPubContIsExist(), "\"第一条已发布的评论文本内容\"未找到，元素未找对，请检查！");
		Assertion.assertEquals(Dom4jXml.getValue("SICK_COMMENT_TEXT"), OneTopicWebElements.first_published_content.getText(), "\"第一条已发布的评论文本内容与输入时内容不一致\"，请检查是否取值错误或元素未找对，请检查！");
		logger.info("直接对话题主体进行的评论发布成功");
		Reporter.log("直接对话题主体进行的评论发布成功");
		
		Utils.sleep(3);
		Utils.waitElement(driver,OneTopicPageElements.REMOVE_BTN);
		Assertion.assertEquals(true, OneTopicWebElements.removeBtnIsExist(), "\"第一条评论的删除图标\"未找到，元素未找对，请检查！");
		OneTopicWebElements.remove_btn.click();
		Utils.sleep(2);
		//悬浮至右上角姓名，等待悬浮菜单出现
		Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
		jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
			
		Utils.waitElement(driver,PersonHomePageElements.PUBLISHED_TOPICS);
		//进入“发布的病例”
		Assertion.assertEquals(true, PersonHomeWebElements.publishedTopicsIsExist(), "\"个人中心页右侧发布的话题\"菜单未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.published_topics.click();
		
		Utils.waitElement(driver,PersonHomePageElements.FIRST_NEWS_TITLE);
		//跳转已发布的话题列表，判断第一条是否是刚才新发布的资源
		Assertion.assertEquals(true, PersonHomeWebElements.firstNewsTitleIsExist(), "\"发布的话题中最新一条\"标题未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.first_news_title.click();
		Utils.waitElement(driver,OneTopicPageElements.COMMENT_INPUT);
		Assertion.assertEquals(true, OneTopicWebElements.comInputIsExist(), "\"直接给资源主体评论的输入框\"未找到，元素未找对，请检查！");
		Assertion.assertEquals(false, OneTopicWebElements.firPubContIsExist(), "\"第一条已发布的评论文本内容\"未删除成功，元素是否依然存在或未找对，请检查！");
		logger.info("直接对话题主体进行的评论删除成功");
		Reporter.log("直接对话题主体进行的评论删除成功");
		
	}
	
	
	
	
	
	
	
	
	
	
}
