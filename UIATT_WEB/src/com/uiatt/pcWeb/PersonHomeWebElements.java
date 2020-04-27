package com.uiatt.pcWeb;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.uiatt.listener.Assertion;
import com.uiatt.pcPage.PersonHomePageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;

/**
 * 个人中心页面
 * author:Change
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PersonHomeWebElements {
	//个人中心页“已发布的xx”中的第一条，可由此来验证刚发布的资源的标题是否正确
	@FindBy(xpath = PersonHomePageElements.FIRST_NEWS_TITLE)
	public static WebElement first_news_title;
	
	//右侧“发布的病例”菜单
	@FindBy(xpath = PersonHomePageElements.PUBLISHED_SICKCASES)
	public static WebElement published_sickCases;
	
	//病例编辑按钮
	@FindBy(xpath = PersonHomePageElements.UPDATE_SC_BTN)
	public static WebElement update_sc_btn;
	
	//头像
	@FindBy(xpath = PersonHomePageElements.HEAD_PHOTO)
	public static WebElement head_photo;
	
	//选择照片按钮
	@FindBy(xpath = PersonHomePageElements.SELECT_IMAG)
	public static WebElement select_imag;
	
	//上传照片的保存按钮
	@FindBy(xpath = PersonHomePageElements.SAVE_IMAG_BTN)
	public static WebElement save_imag_btn;
	
	//查看更多医师
	@FindBy(xpath = PersonHomePageElements.SEARCH_MORE_DOCT)
	public static WebElement search_more_doct;
	
	//更多医师列表中的第一个
	@FindBy(xpath = PersonHomePageElements.DOCT_LIST_FIRST)
	public static WebElement doct_list_first;
	
	//他的主页
	@FindBy(xpath = PersonHomePageElements.HIS_PERHOME)
	public static WebElement his_perHome;
	
	//添加关注
	@FindBy(xpath = PersonHomePageElements.ADD_ATTENTION)
	public static WebElement add_attention;
	
	//个人主页正中头像下的名字
	@FindBy(xpath = PersonHomePageElements.PERHOME_USNAME)
	public static WebElement perHome_usName;
	
	//右侧关注
	@FindBy(xpath = PersonHomePageElements.ATTENTION_TEXT)
	public static WebElement attention_text;
	
	//关注的人列表的第一个
	@FindBy(xpath = PersonHomePageElements.ATTENTION_LIST_FIRST)
	public static WebElement attention_list_first;
	
	//右侧“发布的话题”菜单
	@FindBy(xpath = PersonHomePageElements.PUBLISHED_TOPICS)
	public static WebElement published_topics;
	
	public static  WebDriver driver;
	public static String curPath;
	public static String phoExePath;
	public static JavascriptExecutor jse;
	public static WebDriverWait wait;
	public static String currentWindowHandler1;
	public static String currentWindowHandler2;
	public static String currentWindowHandler3;
	public static Set<String> allWindowHandlers;

	public PersonHomeWebElements(WebDriver driver){
		PersonHomeWebElements.driver = driver;
		wait = new WebDriverWait(driver,5000);
		jse = (JavascriptExecutor)driver; 
		curPath = new File("").getAbsolutePath();
		BaseTest.logConf();
	}
	
	//判断关注的人列表的第一个是否存在
	public static boolean attentionListFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.ATTENTION_LIST_FIRST));
	}
	
	//判断右侧关注是否存在
	public static boolean attentionTextIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.ATTENTION_TEXT));
	}
	
	//判断个人主页正中头像下的名字
	public static boolean perHomeUsnameIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.PERHOME_USNAME));
	}
	
	//判断添加关注是否存在
	public static boolean addAttentionIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.ADD_ATTENTION));
	}
	
	//判断他的主页是否存在
	public static boolean hisPerHomeIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.HIS_PERHOME));
	}
	
	//判断更多医师列表中的第一个是否存在
	public static boolean doctListFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.DOCT_LIST_FIRST));
	}
	
	//判断查看更多医师是否存在
	public static boolean searchMoreDoctIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.SEARCH_MORE_DOCT));
	}
	
	//判断保存照片按钮是否存在
	public static boolean saveImagBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.SAVE_IMAG_BTN));
	}
	
	//判断选择照片按钮是否存在
	public static boolean selectImagIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.SELECT_IMAG));
	}
	
	//判断头像是否存在
	public static boolean headPhotoIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.HEAD_PHOTO));
	}
	
	//判断个人中心页“全部动态”中的第一条是否存在
	public static boolean firstNewsTitleIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.FIRST_NEWS_TITLE));
	}
	
	//判断右侧“发布的病例”菜单是否存在
	public static boolean publishedSCIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.PUBLISHED_SICKCASES));
	}
	
	//判断病例编辑按钮是否存在
	public static boolean updateSCBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.UPDATE_SC_BTN));
	}
	
	////判断右侧“发布的话题”菜单是否存在
	public static boolean publishedTopicsIsExist() {
		return Utils.isElementExist(driver, By.xpath(PersonHomePageElements.PUBLISHED_TOPICS));
	}
	
	/**
	 * 更换头像
	 * */
	public static void updateHeadPhoto(WebDriver driver){
		//去往个人中心
		//如果右上角绑定微信悬浮框的删除按钮存在，关闭它，以免影响姓名悬浮框的出现
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
		Reporter.log("oldPhoto的src是："+oldPhoto);
		PersonHomeWebElements.head_photo.click();
		
		Utils.waitElement(driver,PersonHomePageElements.SELECT_IMAG);
		Assertion.assertEquals(true, PersonHomeWebElements.selectImagIsExist(), "\"选择头像照片\"按钮未找到，元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("NEWHEADPHOTO");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PersonHomeWebElements.select_imag.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("ERROR"+e);
			//ScreenShotPC.screenShot("PersonHomeWebElements.updateHeadPhoto");
			Assert.fail(e.toString());
		}
		
		Utils.sleep(5);
		Utils.waitElement(driver,PersonHomePageElements.SAVE_IMAG_BTN);
		Assertion.assertEquals(true, PersonHomeWebElements.saveImagBtnIsExist(), "\"保存头像照片\"按钮未找到，元素未找到，请检查！");
		wait.until(ExpectedConditions.elementToBeClickable(PersonHomeWebElements.save_imag_btn));
		logger.info("save_imag_btn是："+PersonHomeWebElements.save_imag_btn);
		Reporter.log("save_imag_btn是："+PersonHomeWebElements.save_imag_btn);
		PersonHomeWebElements.save_imag_btn.click();
		//jse.executeScript("arguments[0].click();", PersonHomeWebElements.save_imag_btn);
		
		//如果提交动作没有执行完就持续等待，直到提交完,等待选择头像照片按钮元素的消失
		int num = 0;
		while(PersonHomeWebElements.selectImagIsExist() == true && num < 10) {
			Utils.sleep(2);
			num ++;
		}
		
		Utils.waitElement(driver,PersonHomePageElements.HEAD_PHOTO);
		Assertion.assertEquals(true, PersonHomeWebElements.headPhotoIsExist(), "\"个人头像\"未找到，元素未找到，请检查！");
		String newPhoto = PersonHomeWebElements.head_photo.getAttribute("src");
		logger.info("newPhoto的src是："+newPhoto);
		Reporter.log("newPhoto的src是："+newPhoto);
		if(newPhoto.equals(oldPhoto)){
			logger.warn("newPhoto的src与oldPhoto的src一致，请检查是不是照片没有更新还是哪里出错了！");
			Reporter.log("[WARN]newPhoto的src与oldPhoto的src一致，请检查是不是照片没有更新还是哪里出错了！");
			Assert.fail("newPhoto的src与oldPhoto的src一致，请检查是不是照片没有更新还是哪里出错了！");
		}else{
			logger.info("newPhoto的src与oldPhoto的src不一致，以此判断为头像照片更换成功！");
			Reporter.log("newPhoto的src与oldPhoto的src不一致，以此判断为头像照片更换成功！");
		}
	}
	
	
	/**
	 * 跳转他的主页，添加关注，返回我的主页，验证关注成功
	 * */
	public static void attentionOtherPerHome(WebDriver driver){
		Utils.sleep(2);
		currentWindowHandler1 = driver.getWindowHandle();
		logger.info("当前窗口句柄值1： "+currentWindowHandler1);
		Reporter.log("当前窗口句柄值1： "+currentWindowHandler1);
		Utils.waitElement(driver,PersonHomePageElements.SEARCH_MORE_DOCT);
		Assertion.assertEquals(true, PersonHomeWebElements.searchMoreDoctIsExist(), "\"查看更多医师\"链接未找到，元素未找到，请检查！");
		//点击“查看更多医师”
		PersonHomeWebElements.search_more_doct.click();
		
		Utils.sleep(3);
		//跳转医师列表页面
		allWindowHandlers = driver.getWindowHandles();
		logger.info("获取所有窗口句柄值1：  "+allWindowHandlers);
		Reporter.log("获取所有窗口句柄值1：  "+allWindowHandlers);
		//移除旧窗口
		allWindowHandlers.remove(currentWindowHandler1);
		Iterator<String> it1= allWindowHandlers.iterator();
		while(it1.hasNext()){
			String handle1 = it1.next();
			logger.info("切换至更多医师列表页窗口");
			Reporter.log("切换至更多医师列表页窗口");
			logger.info("driver值检查1：  "+driver+" ;当前窗口句柄值检查2："+handle1);
			Reporter.log("driver值检查1：  "+driver+" ;当前窗口句柄值检查2："+handle1);
			driver.switchTo().window(handle1);
			Utils.sleep(3);
			Utils.waitElement(driver,PersonHomePageElements.DOCT_LIST_FIRST);
			Assertion.assertEquals(true, PersonHomeWebElements.doctListFirstIsExist(), "\"更多医师列表第一个医师姓名\"链接未找到，元素未找到，请检查！");
			
			String his_name = PersonHomeWebElements.doct_list_first.getText();
			logger.info("第一个医师的名字是："+his_name);
			Reporter.log("第一个医师的名字是："+his_name);
			PersonHomeWebElements.doct_list_first.click();
			currentWindowHandler2 = driver.getWindowHandle();
			logger.info("当前窗口句柄值3： "+currentWindowHandler2);
			Reporter.log("当前窗口句柄值3： "+currentWindowHandler2);
			Utils.sleep(3);
			//跳转他的主页
			allWindowHandlers = driver.getWindowHandles();
			logger.info("获取所有窗口句柄值2：  "+allWindowHandlers);
			Reporter.log("获取所有窗口句柄值2：  "+allWindowHandlers);
			//移除旧窗口
			allWindowHandlers.remove(currentWindowHandler2);
			Iterator<String> it2= allWindowHandlers.iterator();
			while(it2.hasNext()){
				String handle2 = it2.next();
				while(currentWindowHandler2.equals(handle2) || currentWindowHandler1.equals(handle2)){
					handle2 = it2.next();
				}
				logger.info("切换至更多他的主页窗口");
				Reporter.log("切换至更多他的主页窗口");
				logger.info("driver值检查2：  "+driver+" ;当前窗口句柄值检查4："+handle2);
				Reporter.log("driver值检查2：  "+driver+" ;当前窗口句柄值检查4："+handle2);
				driver.switchTo().window(handle2);
				Utils.sleep(3);
				Utils.waitElement(driver,PersonHomePageElements.PERHOME_USNAME);
				Assertion.assertEquals(true, PersonHomeWebElements.perHomeUsnameIsExist(), "\"他的主页中他的姓名\"未找到，元素未找到，请检查！");
				Assertion.assertEquals(his_name, PersonHomeWebElements.perHome_usName.getText(), "\"他的主页中他的姓名\"与跳转前不一致，跳转错误还是元素值取错，请检查！");
				logger.info("正确跳转至"+his_name+":他的主页");
				Reporter.log("正确跳转至"+his_name+":他的主页");
				Assertion.assertEquals(true, PersonHomeWebElements.addAttentionIsExist(), "\"他的主页中添加关注\"按钮未找到，元素未找到，请检查！");
				String addAttentionBtn = PersonHomeWebElements.add_attention.getAttribute("src");
				logger.info("添加关注按钮值："+addAttentionBtn);
				Reporter.log("添加关注按钮值："+addAttentionBtn);
				PersonHomeWebElements.add_attention.click();
				Utils.sleep(2);
				String cancelAttentionBtn = PersonHomeWebElements.add_attention.getAttribute("src");
				logger.info("取消关注按钮值："+cancelAttentionBtn);
				Reporter.log("取消关注按钮值："+cancelAttentionBtn);
				if(cancelAttentionBtn.equals(addAttentionBtn)){
					logger.warn("cancelAttentionBtn的src与addAttentionBtn的src一致，请检查是不是没有成功点击添加关注按钮还是哪里出错了！");
					Reporter.log("[WARN]cancelAttentionBtn的src与addAttentionBtn的src一致，请检查是不是没有成功点击添加关注按钮还是哪里出错了！");
					Assert.fail("cancelAttentionBtn的src与addAttentionBtn的src一致，请检查是不是没有成功点击添加关注按钮还是哪里出错了！");
				}else{
					logger.info("cancelAttentionBtn的src与addAttentionBtn的src不一致，以此判断为在他的主页点击添加关注按钮成功！接下来，再回到我的主页中去验证关注列表中是否已有该人存在！");
					Reporter.log("cancelAttentionBtn的src与addAttentionBtn的src不一致，以此判断为在他的主页点击添加关注按钮成功！接下来，再回到我的主页中去验证关注列表中是否已有该人存在！");
				}
				
				//去我的主页验证关注列表中是否已有该人存在
				//悬浮至右上角姓名，等待悬浮菜单出现
				Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
				jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
				
				Utils.waitElement(driver,PersonHomePageElements.ATTENTION_TEXT);
				Assertion.assertEquals(true, PersonHomeWebElements.attentionTextIsExist(), "\"我的主页中右侧关注\"文字未找到，元素未找到，请检查！");
				PersonHomeWebElements.attention_text.click();
				Utils.sleep(2);
				Utils.waitElement(driver,PersonHomePageElements.ATTENTION_LIST_FIRST);
				Assertion.assertEquals(true, PersonHomeWebElements.attentionListFirstIsExist(), "\"我的主页中关注列表第一个人姓名\"链接未找到，元素未找到，请检查！");
				Assertion.assertEquals(his_name, PersonHomeWebElements.attention_list_first.getText(), "\"我的主页中关注列表第一个人姓名\"与跳转前不一致，跳转错误还是元素值取错，验证为关注失败，请检查！");
				logger.info("我的主页关注列表中存在该人："+PersonHomeWebElements.attention_list_first.getText()+"，以此验证为关注成功！");
				Reporter.log("我的主页关注列表中存在该人："+PersonHomeWebElements.attention_list_first.getText()+"，以此验证为关注成功！");
			}
			
		}
	}
}
