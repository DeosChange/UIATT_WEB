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
import com.uiatt.pcPage.OneSickCasePageElements;
import com.uiatt.pcPage.PersonHomePageElements;
import com.uiatt.pcPage.PublishSickCasePageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Dom4jXml;
import com.uiatt.util.Utils;


/**
 * 点击发布病例后的所有元素；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PublishSickCaseWebElements {
	public static Logger logger = Logger.getLogger(PublishSickCaseWebElements.class );
	//普通上传
	@FindBy(xpath = PublishSickCasePageElements.NORMAL_PUBLISH)
	public static WebElement normal_publish;
	
	//标题
	@FindBy(xpath = PublishSickCasePageElements.SICKCASE_TITLE)
	public static WebElement sickCase_title;
	
	//所属专业选项中的第一个值
	@FindBy(xpath = PublishSickCasePageElements.PROFE_BELO_FIRST)
	public static WebElement profe_belo_first;
	
	//所属专业
	@FindBy(xpath = PublishSickCasePageElements.PROFESSIONAL_BELONG)
	public static WebElement professional_belong;
	
	//所属专业选项的隐藏域
	@FindBy(xpath = PublishSickCasePageElements.PROFESSIONAL_DISPLAYLIST)
	public static WebElement professional_displayList;
	
	//所属专业选项中的第二个值
	@FindBy(xpath = PublishSickCasePageElements.PROFE_BELO_SECOND)
	public static WebElement profe_belo_second;
	
	//第一个所选专业的删除按钮
	@FindBy(xpath = PublishSickCasePageElements.REMOVE_PROFE_BELO_FIRST)
	public static WebElement remove_profe_belo_first;
	
	//性别：男
	@FindBy(xpath = PublishSickCasePageElements.SEX_MAN)
	public static WebElement sex_man;
	
	//岁
	@FindBy(xpath = PublishSickCasePageElements.AGE)
	public static WebElement age;
	
	//主诉
	@FindBy(xpath = PublishSickCasePageElements.MAIN_MARRATE)
	public static WebElement main_marrate;
	
	//现病史
	@FindBy(xpath = PublishSickCasePageElements.ILLNESS_HISTORY)
	public static WebElement illness_history;
	
	//专科检查
	@FindBy(xpath = PublishSickCasePageElements.SPECIALIST_CHECK)
	public static WebElement specialist_check;

	//文字讨论
	@FindBy(xpath = PublishSickCasePageElements.TXT_DISCUSS)
	public static WebElement txt_discuss;
	
	//添加第一张照片按钮
	@FindBy(xpath = PublishSickCasePageElements.SICKCASE_FIRPHOTOS_BTN)
	public static WebElement sickCase_firphotos_btn;
	
	//添加之后照片按钮
	@FindBy(xpath = PublishSickCasePageElements.SICKCASE_AFTPHOTOS_BTN)
	public static WebElement sickCase_aftphotos_btn;
	
	//第一张照片的手术阶段选项：术前
	@FindBy(xpath = PublishSickCasePageElements.FIRPHO_BEFO_OPER_BTN)
	public static WebElement firPho_befo_oper_btn;
	
	//第一张照片描述
	@FindBy(xpath = PublishSickCasePageElements.FIRPHO_BEFO_EXPLAIN)
	public static WebElement firPho_befo_explain;
	
	//第二张照片的手术阶段选项：术中
	@FindBy(xpath = PublishSickCasePageElements.SECPHO_DUR_OPER_BTN)
	public static WebElement secPho_dur_oper_btn;
	
	//第二张照片描述
	@FindBy(xpath = PublishSickCasePageElements.SECPHO_BEFO_EXPLAIN)
	public static WebElement secPho_befo_explain;
	
	//第三张照片的手术阶段选项：术后
	@FindBy(xpath = PublishSickCasePageElements.THIPHO_DUR_OPER_BTN)
	public static WebElement thiPho_dur_oper_btn;
	
	//第三张照片描述
	@FindBy(xpath = PublishSickCasePageElements.THIPHO_BEFO_EXPLAIN)
	public static WebElement thiPho_befo_explain;
	
	//提醒谁看输入框	
	@FindBy(xpath = PublishSickCasePageElements.REMIND_INPUT)
	public static WebElement remind_input;
	
	//此处不考虑匹配出的正确性，直接先选取第一个被匹配出的人
	@FindBy(xpath = PublishSickCasePageElements.REMIND_MATCHED_FIRST)
	public static WebElement remind_matched_first;

	//继续完善病例按钮
	@FindBy(xpath = PublishSickCasePageElements.ADD_MORE)
	public static WebElement add_more;
	
	//既往史
	@FindBy(xpath = PublishSickCasePageElements.PAST_HISTORY)
	public static WebElement past_history;
	
	//个人史
	@FindBy(xpath = PublishSickCasePageElements.PERSONAL_HISTORY)
	public static WebElement personal_history;
	
	//家族史
	@FindBy(xpath = PublishSickCasePageElements.FAMILY_HISTORY)
	public static WebElement family_history;
	
	//辅助检查
	@FindBy(xpath = PublishSickCasePageElements.AUXILIARY_INFO)
	public static WebElement auxiliary_info;
	
	//诊断
	@FindBy(xpath = PublishSickCasePageElements.DIAGNOSIS_INFO)
	public static WebElement diagnosis_info;
	
	//诊疗记录
	@FindBy(xpath = PublishSickCasePageElements.TREATMENT_RECORD)
	public static WebElement treatment_record;
	
	//手术名称
	@FindBy(xpath = PublishSickCasePageElements.OPERATION_NAME)
	public static WebElement operate_name;
	
	//术中信息
	@FindBy(xpath = PublishSickCasePageElements.INTRAOPERATIVE_INFO)
	public static WebElement intraoperative_info;
	
	//产品信息
	@FindBy(xpath = PublishSickCasePageElements.PRODUCT_INFO)
	public static WebElement product_info;

	//新增时的发布按钮
	@FindBy(xpath = PublishSickCasePageElements.PUBLISH_BTN)
	public static WebElement publish_btn;
	
	//修改时的发布按钮
	@FindBy(xpath = PublishSickCasePageElements.PUBLISH_UPDATE_BTN)
	public static WebElement publish_update_btn;
	
	//取消按钮
	@FindBy(xpath = PublishSickCasePageElements.CANCEL_BTN)
	public static WebElement cancel_btn;
	
	//整个发布病例的编辑窗体
	@FindBy(xpath = PublishSickCasePageElements.EDIT_WINDOW)
	public static WebElement edit_window;
	
	public static  WebDriver driver;
	public static String curPath;
	public static String phoExePath;
	public static JavascriptExecutor jse;
	public static Actions action ;
	
	public PublishSickCaseWebElements(WebDriver driver){
		PublishSickCaseWebElements.driver = driver;
		jse = (JavascriptExecutor)driver; 
		action = new Actions(driver);
		curPath = new File("").getAbsolutePath();
		BaseTest.logConf();
	}
	
	//判断修改时的发布按钮是否存在
	public static boolean pubUpdBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.PUBLISH_UPDATE_BTN));
	}
	
	//判断整个发布病例的编辑窗体是否存在，用于判断是否提交完成
	public static boolean editWindIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.EDIT_WINDOW));
	}
	
	//判断普通上传按钮是否存在
	public static boolean normalPublishBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.NORMAL_PUBLISH));
	}
	
	//判断病例标题输入框是否存在
	public static boolean sickCaseTitleIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SICKCASE_TITLE));
	}
	
	//判断所属专业的第一个值是否存在
	public static boolean profeBeloFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.PROFE_BELO_FIRST));
	}
	
	//判断所属专业的第一个值得删除按钮是否存在
	public static boolean remProfeBeloFirstIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.REMOVE_PROFE_BELO_FIRST));
	}
	
	// 判断“男”性别单选框是否存在
	public static boolean sexManRadioIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SEX_MAN));
	}
	
	//判断添加第一张照片按钮是否存在
	public static boolean sickCaseFirPhoBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SICKCASE_FIRPHOTOS_BTN));
	}
	
	//判断添加之后照片按钮是否存在
	public static boolean sickCaseAftPhoBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SICKCASE_AFTPHOTOS_BTN));
	}
	
	//判断术前阶段按钮是否存在
	public static boolean firPhoOperBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.FIRPHO_BEFO_OPER_BTN));
	}
	
	//判断第一张照片的描述输入框是否存在
	public static boolean firPhoExpIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.FIRPHO_BEFO_EXPLAIN));
	}

	//判断术中阶段按钮是否存在
	public static boolean secPhoOperBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SECPHO_DUR_OPER_BTN));
	}
	
	//判断第二章照片的描述输入框是否存在
	public static boolean secPhoExpIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.SECPHO_BEFO_EXPLAIN));
	}
	
	//判断术后阶段按钮是否存在
	public static boolean thiPhoOperBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.THIPHO_DUR_OPER_BTN));
	}
	
	//判断第三张照片描述的输入框是否存在
	public static boolean thiPhoExpIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.THIPHO_BEFO_EXPLAIN));
	}
	
	//判断第一个被匹配出来的提醒用户是否存在
	public static boolean remindMatFirIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.REMIND_MATCHED_FIRST));
	}
	
	//判断继续完善病例按钮是否存在
	public static boolean addMoreBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.ADD_MORE));
	}
	
	//判断既往史输入框是否存在
	public static boolean pastHistIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.PAST_HISTORY));
	}
	
	//判断病例发布按钮是否存在
	public static boolean publishBtnIsExist() {
		return Utils.isElementExist(driver, By.xpath(PublishSickCasePageElements.PUBLISH_BTN));
	}
	
	/**
	 * 发布病例的编辑窗体出现前的进入步骤
	 * */
	public static void beforeEditSickCase(WebDriver driver){
		logger.info("开始新增病例前准备");
		Reporter.log("开始新增病例前准备");
		Utils.waitElement(driver, IndexPageElements.PUBLISH_SICKCASE);
		Assertion.assertEquals(true, IndexWebElements.publishSickCaseIsExist(), "\"发布病例\"按钮未找到，页面不符或元素未找到，请检查！");
		IndexWebElements.publish_sickcase.click();
		Utils.waitElement(driver, PublishSickCasePageElements.NORMAL_PUBLISH);
		Assertion.assertEquals(true, PublishSickCaseWebElements.normalPublishBtnIsExist(), "\"普通发布\"按钮未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.normal_publish.click();
	}
	
	
	/**
	 * 发布病例的编辑窗体操作
	 * */
	public static void editAndPubSickCase(WebDriver driver){
		logger.info("开始编辑要新增的病例内容");
		Reporter.log("开始编辑要新增的病例内容");
		Utils.waitElement(driver,PublishSickCasePageElements.SICKCASE_TITLE);
		Assertion.assertEquals(true, PublishSickCaseWebElements.sickCaseTitleIsExist(), "\"病例标题\"输入框未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.sickCase_title.clear();
		PublishSickCaseWebElements.sickCase_title.sendKeys(Dom4jXml.getValue("SICKCASE_TITLE"));
		PublishSickCaseWebElements.sickCase_title.click();
		
		PublishSickCaseWebElements.professional_belong.click();
		Assertion.assertEquals(true, PublishSickCaseWebElements.profeBeloFirstIsExist(), "\"所属专业的第一个选项元素\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.profe_belo_first.click();
		Utils.sleep(1);
		PublishSickCaseWebElements.profe_belo_second.click();
		Assertion.assertEquals(true, PublishSickCaseWebElements.remProfeBeloFirstIsExist(), "\"所属专业的第一个选项删除按钮\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.remove_profe_belo_first.click();
		//选完专业后，选项框还在，会把性别和年龄元素遮挡住，要想让它消失，使用js传参，强行让其隐藏 
		jse.executeScript("arguments[0].setAttribute('style','display:none');", PublishSickCaseWebElements.professional_displayList);
		
		Assertion.assertEquals(true, PublishSickCaseWebElements.sexManRadioIsExist(), "\"性别男按钮\"未找到，页面不符或元素未找到，请检查！");
		//因为性别元素被专业的隐藏域遮挡，放弃遍历隐藏域div，直接用js对性别元素点击，会更快
		jse.executeScript("arguments[0].click();", PublishSickCaseWebElements.sex_man);
		Assertion.assertEquals(true, PublishSickCaseWebElements.sex_man.isSelected(), "\"性别按钮\"未选中，页面不符或元素未找到，请检查！");
		
		PublishSickCaseWebElements.age.sendKeys(Dom4jXml.getValue("SICK_AGE"));
		PublishSickCaseWebElements.main_marrate.clear();
		PublishSickCaseWebElements.main_marrate.sendKeys(Dom4jXml.getValue("MAIN_MARRATE"));
		PublishSickCaseWebElements.main_marrate.click();
		PublishSickCaseWebElements.illness_history.clear();
		PublishSickCaseWebElements.illness_history.sendKeys(Dom4jXml.getValue("ILLNESS_HISTORY"));
		PublishSickCaseWebElements.illness_history.click();
		PublishSickCaseWebElements.specialist_check.clear();
		PublishSickCaseWebElements.specialist_check.sendKeys(Dom4jXml.getValue("SPECIALIST_CHECK"));
		PublishSickCaseWebElements.specialist_check.click();
		PublishSickCaseWebElements.txt_discuss.clear();
		PublishSickCaseWebElements.txt_discuss.sendKeys(Dom4jXml.getValue("TXT_DISCUSS"));
		PublishSickCaseWebElements.txt_discuss.click();
		
		//添加第一张照片，术前及描述
		Assertion.assertEquals(true, PublishSickCaseWebElements.sickCaseFirPhoBtnIsExist(), "\"添加第一张照片按钮\"未找到，页面不符或元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("SICK_FIRPHO_PATH");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PublishSickCaseWebElements.sickCase_firphotos_btn.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishSickCase");
			Assert.fail(e.toString());
		}
		Utils.waitElement(driver, PublishSickCasePageElements.FIRPHO_BEFO_OPER_BTN);
		Assertion.assertEquals(true, PublishSickCaseWebElements.firPhoOperBtnIsExist(), "\"术前阶段按钮\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.firPho_befo_oper_btn.click();
		Assertion.assertEquals(true, PublishSickCaseWebElements.firPhoExpIsExist(), "\"第一张照片的描述输入框\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.firPho_befo_explain.clear();
		PublishSickCaseWebElements.firPho_befo_explain.sendKeys(Dom4jXml.getValue("FIRPHO_BEFO_EXPLAIN"));
		PublishSickCaseWebElements.firPho_befo_explain.click();
		
		Utils.waitElement(driver, PublishSickCasePageElements.SICKCASE_AFTPHOTOS_BTN);
		//添加第二张照片，术中及描述
		Assertion.assertEquals(true, PublishSickCaseWebElements.sickCaseAftPhoBtnIsExist(), "\"添加之后照片按钮\"未找到，页面不符或元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("SICK_SECPHO_PATH");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PublishSickCaseWebElements.sickCase_aftphotos_btn.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishSickCase");
			Assert.fail(e.toString());
		}
		Utils.waitElement(driver, PublishSickCasePageElements.SECPHO_DUR_OPER_BTN);
		Assertion.assertEquals(true, PublishSickCaseWebElements.secPhoOperBtnIsExist(), "\"术中阶段按钮\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.secPho_dur_oper_btn.click();
		Assertion.assertEquals(true, PublishSickCaseWebElements.secPhoExpIsExist(), "\"第二张照片的描述输入框\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.secPho_befo_explain.clear();
		PublishSickCaseWebElements.secPho_befo_explain.sendKeys(Dom4jXml.getValue("SECPHO_BEFO_EXPLAIN"));
		PublishSickCaseWebElements.secPho_befo_explain.click();
		
		Utils.waitElement(driver, PublishSickCasePageElements.SICKCASE_AFTPHOTOS_BTN);
		//添加第三张照片，术后及描述
		Assertion.assertEquals(true, PublishSickCaseWebElements.sickCaseAftPhoBtnIsExist(), "\"添加照片按钮\"未找到，页面不符或元素未找到，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("SICK_THIPHO_PATH");
		logger.info(phoExePath);
		Reporter.log(phoExePath);
		PublishSickCaseWebElements.sickCase_aftphotos_btn.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishSickCase");
			Assert.fail(e.toString());
		}
		Utils.waitElement(driver, PublishSickCasePageElements.THIPHO_DUR_OPER_BTN);
		Assertion.assertEquals(true, PublishSickCaseWebElements.thiPhoOperBtnIsExist(), "\"术后阶段按钮\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.thiPho_dur_oper_btn.click();
		Assertion.assertEquals(true, PublishSickCaseWebElements.thiPhoExpIsExist(), "\"第三张照片的描述输入框\"未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.thiPho_befo_explain.clear();
		PublishSickCaseWebElements.thiPho_befo_explain.sendKeys(Dom4jXml.getValue("THIPHO_BEFO_EXPLAIN"));
		PublishSickCaseWebElements.thiPho_befo_explain.click();
		
		Utils.waitElement(driver, PublishSickCasePageElements.REMIND_INPUT);
		//提醒谁看
		PublishSickCaseWebElements.remind_input.clear();
		PublishSickCaseWebElements.remind_input.sendKeys(Dom4jXml.getValue("REMIND_INPUT"));
		PublishSickCaseWebElements.remind_input.click();
		Utils.waitElement(driver, PublishSickCasePageElements.REMIND_MATCHED_FIRST);
		Assertion.assertEquals(true, PublishSickCaseWebElements.remindMatFirIsExist(), "\"第一个匹配出的用户\"未找到，没有匹配项或未找到该元素，请检查！");
		PublishSickCaseWebElements.remind_matched_first.click();
		
		//继续完善病例
		Assertion.assertEquals(true, PublishSickCaseWebElements.addMoreBtnIsExist(), "\"继续完善病例\"按钮未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.add_more.click();
		Utils.waitElement(driver, PublishSickCasePageElements.PAST_HISTORY);
		Assertion.assertEquals(true, PublishSickCaseWebElements.pastHistIsExist(), "\"既往史\"输入框未找到，页面不符或元素未找到，请检查！");
		PublishSickCaseWebElements.past_history.clear();
		PublishSickCaseWebElements.past_history.sendKeys(Dom4jXml.getValue("PAST_HISTORY"));
		PublishSickCaseWebElements.past_history.click();
		
		PublishSickCaseWebElements.personal_history.clear();
		PublishSickCaseWebElements.personal_history.sendKeys(Dom4jXml.getValue("PERSONAL_HISTORY"));
		PublishSickCaseWebElements.personal_history.click();
		
		PublishSickCaseWebElements.family_history.clear();
		PublishSickCaseWebElements.family_history.sendKeys(Dom4jXml.getValue("FAMILY_HISTORY"));
		PublishSickCaseWebElements.family_history.click();
		
		PublishSickCaseWebElements.auxiliary_info.clear();
		PublishSickCaseWebElements.auxiliary_info.sendKeys(Dom4jXml.getValue("AUXILIARY_INFO"));
		PublishSickCaseWebElements.auxiliary_info.click();
		
		PublishSickCaseWebElements.diagnosis_info.clear();
		PublishSickCaseWebElements.diagnosis_info.sendKeys(Dom4jXml.getValue("DIAGNOSIS_INFO"));
		PublishSickCaseWebElements.diagnosis_info.click();
		
		PublishSickCaseWebElements.treatment_record.clear();
		PublishSickCaseWebElements.treatment_record.sendKeys(Dom4jXml.getValue("TREATMENT_RECORD"));
		PublishSickCaseWebElements.treatment_record.click();
		
		PublishSickCaseWebElements.operate_name.clear();
		PublishSickCaseWebElements.operate_name.sendKeys(Dom4jXml.getValue("OPERATION_NAME"));
		PublishSickCaseWebElements.operate_name.click();
		
		PublishSickCaseWebElements.intraoperative_info.clear();
		PublishSickCaseWebElements.intraoperative_info.sendKeys(Dom4jXml.getValue("INTRAOPERATIVE_INFO"));
		PublishSickCaseWebElements.intraoperative_info.click();
		
		PublishSickCaseWebElements.product_info.clear();
		PublishSickCaseWebElements.product_info.sendKeys(Dom4jXml.getValue("PRODUCT_INFO"));
		PublishSickCaseWebElements.product_info.click();
		
		Assertion.assertEquals(true, PublishSickCaseWebElements.publishBtnIsExist(), "\"新增时的病例发布\"按钮未找到，页面不符或元素未找到，请检查！");
		
		PublishSickCaseWebElements.publish_btn.click();
		
		if(Utils.isAlertPresent(driver) == true){
			String alertWarn = Utils.getAlert(driver);
			logger.warn(alertWarn);
			Reporter.log("[WARN]"+alertWarn);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishSickCase");
			Assert.fail(alertWarn);
		}
		//如果提交动作没有执行完就持续等待，直到提交完
		int num = 0;
		while(PublishSickCaseWebElements.editWindIsExist() == true && num < 10) {
			Utils.sleep(2);
			num ++;
		}
		//在编辑窗体消失的瞬间，循环跳出，但是新的页面还没有跳转和加载完，所以仍需等待
		Utils.sleep(8);
			
		//悬浮至右上角姓名，等待悬浮菜单出现
		Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
		jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
	
		Utils.waitElement(driver,PersonHomePageElements.PUBLISHED_SICKCASES);
		//进入“发布的病例”
		Assertion.assertEquals(true, PersonHomeWebElements.publishedSCIsExist(), "\"个人中心页右侧发布的病例\"菜单未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.published_sickCases.click();
		Utils.sleep(3);
		//再次点击以局部刷新数据
		PersonHomeWebElements.published_sickCases.click();
		Utils.waitElement(driver,PersonHomePageElements.FIRST_NEWS_TITLE);
		//跳转已发布的病例列表，判断第一条是否是刚才新发布的资源
		Assertion.assertEquals(true, PersonHomeWebElements.firstNewsTitleIsExist(), "\"发布的病例中最新一条\"标题未找到，未发布成功或元素未找到，请检查！");
		logger.info("获取最新一条发布的病例，标题为："+PersonHomeWebElements.first_news_title.getText());
		Reporter.log("获取最新一条发布的病例，标题为："+PersonHomeWebElements.first_news_title.getText());
		String ExpectTitle = "《"+Dom4jXml.getValue("SICKCASE_TITLE")+"》";
		//提取标题，判断是否发布成功
		Assertion.assertEquals(ExpectTitle, PersonHomeWebElements.first_news_title.getText(), "\"所获取的最新一条病例的标题与编辑时输入值不符\"，未发布成功或元素未找对，请检查！");
		logger.info("新增病例"+PersonHomeWebElements.first_news_title.getText()+"发布成功");
		Reporter.log("新增病例"+PersonHomeWebElements.first_news_title.getText()+"发布成功");
	}
	
	/**
	 * 修改病例
	 * */
	public static void updateSickCase(WebDriver driver){
		String oldTitle = PersonHomeWebElements.first_news_title.getText() ;
		String fromUrl = driver.getCurrentUrl();
		PersonHomeWebElements.first_news_title.click();
		//跳转具体的病例详情页
		Utils.waitElement(driver,OneSickCasePageElements.SEX_AGE);
		Assertion.assertEquals(true, OneSickCaseWebElements.sexAgeIsExist(), "\"性别与年龄信息\"区域元素未找到，页面未跳转成功或元素未找对，请检查！");
		String OldSexAge = OneSickCaseWebElements.sex_age.getText() ;
		//从病例详情页返回个人中心页
		driver.get(fromUrl);
		logger.info("开始对刚才新增的病例进行修改前准备");
		Reporter.log("开始对刚才新增的病例进行修改前准备");
		Utils.waitElement(driver,PersonHomePageElements.UPDATE_SC_BTN);
		//跳转已发布的病例列表，判断第一条病例的编辑按钮是否存在
		Assertion.assertEquals(true, PersonHomeWebElements.updateSCBtnIsExist(), "\"第一条病例的编辑\"按钮未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.update_sc_btn.click();
		Utils.sleep(5);
		Utils.waitElement(driver,PublishSickCasePageElements.SICKCASE_TITLE);
		Assertion.assertEquals(true, PublishSickCaseWebElements.sickCaseTitleIsExist(), "\"病例标题\"输入框未找到，页面不符或元素未找到，请检查！");
		
		PublishSickCaseWebElements.sickCase_title.clear();
		PublishSickCaseWebElements.sickCase_title.sendKeys(Dom4jXml.getValue("SICKCASE_UPDATE_TITLE"));
		PublishSickCaseWebElements.sickCase_title.click();
		
		
		PublishSickCaseWebElements.age.clear();
		PublishSickCaseWebElements.age.sendKeys(Dom4jXml.getValue("SICK__UPDATE_AGE"));
		PublishSickCaseWebElements.age.click();
		
		//因为刚打开的修改窗口是只有上半部分显示可见的，所以需要滚动一下页面
		int elementPosition = PublishSickCaseWebElements.txt_discuss.getLocation().getY();
		logger.info("获取文字讨论输入框位于窗口的Y坐标:"+elementPosition);
		Reporter.log("获取文字讨论输入框位于窗口的Y坐标:"+elementPosition);
		String js = String.format("window.scroll(0, %s)", elementPosition);
		jse.executeScript(js);
		Utils.waitElement(driver,PublishSickCasePageElements.PUBLISH_UPDATE_BTN);
		Assertion.assertEquals(true, PublishSickCaseWebElements.pubUpdBtnIsExist(), "\"修改时的病例发布\"按钮未找到，页面不符或元素未找到，请检查！");
		//利用js使页面滚动到发布按钮元素所在位置
		PublishSickCaseWebElements.publish_update_btn.click();
		
		if(Utils.isAlertPresent(driver) == true){
			String alertWarn = Utils.getAlert(driver);
			logger.warn(alertWarn);
			Reporter.log("[WARN]"+alertWarn);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishSickCase");
			Assert.fail(alertWarn);
		}
		//如果提交动作没有执行完就持续等待，直到提交完
		int num = 0;
		while(PublishSickCaseWebElements.editWindIsExist() == true && num < 10) {
			Utils.sleep(2);
			num ++;
		}
		//在编辑窗体消失的瞬间，循环跳出，但是新的页面还没有跳转和加载完，所以仍需等待
		Utils.sleep(8);
		logger.info("病例修改完成后提交成功，开始校验标题与年龄是否修改成功");
		Reporter.log("病例修改完成后提交成功，开始校验标题与年龄是否修改成功");
		//点击“发布的病例”，进行手动再次刷新
		Assertion.assertEquals(true, PersonHomeWebElements.publishedSCIsExist(), "\"个人中心页右侧发布的病例\"菜单未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.published_sickCases.click();
		Utils.waitElement(driver,PersonHomePageElements.FIRST_NEWS_TITLE);
		//跳转已发布的病例列表，判断第一条病例标题是否存在
		Assertion.assertEquals(true, PersonHomeWebElements.firstNewsTitleIsExist(), "\"第一条病例\"标题未找到，未发布成功或元素未找到，请检查！");
		String ExpectTitle = "《"+Dom4jXml.getValue("SICKCASE_UPDATE_TITLE")+"》";
		//提取标题，判断是否修改成功
		Assertion.assertEquals(ExpectTitle, PersonHomeWebElements.first_news_title.getText(), "\"所获取的被修改的第一条病例的标题与修改时输入值不符\"，未修改成功或元素未找对，请检查！");
		logger.info("被修改病例的原标题为："+oldTitle+"；修改后的病例标题为："+PersonHomeWebElements.first_news_title.getText()+"；病例标题修改成功！");
		Reporter.log("被修改病例的原标题为："+oldTitle+"；修改后的病例标题为："+PersonHomeWebElements.first_news_title.getText()+"；病例标题修改成功！");
		PersonHomeWebElements.first_news_title.click();
		//跳转具体的病例详情页
		Utils.waitElement(driver,OneSickCasePageElements.SEX_AGE);
		Assertion.assertEquals(true, OneSickCaseWebElements.sexAgeIsExist(), "\"性别与年龄信息\"区域元素未找到，页面未跳转成功或元素未找对，请检查！");
		String ExpectSexAge = "男 "+Dom4jXml.getValue("SICK__UPDATE_AGE")+"岁";
		Assertion.assertEquals(ExpectSexAge, OneSickCaseWebElements.sex_age.getText(), "\"所获取的被修改的第一条病例的年龄与修改时输入值不符\"，未修改成功或元素未找对，请检查！");
		logger.info("被修改病例的原性别年龄为："+OldSexAge+"；修改后的性别年龄为："+OneSickCaseWebElements.sex_age.getText()+"；病例年龄修改成功！");
		Reporter.log("被修改病例的原性别年龄为："+OldSexAge+"；修改后的性别年龄为："+OneSickCaseWebElements.sex_age.getText()+"；病例年龄修改成功！");
	}
	
	/**
	 * 发布评论
	 * */
	public static void publishComment(WebDriver driver){
		logger.info("开始对病例进行发布评论");
		Reporter.log("开始对病例进行发布评论");
		Utils.waitElement(driver,OneSickCasePageElements.COMMENT_INPUT);
		Assertion.assertEquals(true, OneSickCaseWebElements.comInputIsExist(), "\"直接给资源主体评论的输入框\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.comment_input.clear();
		OneSickCaseWebElements.comment_input.sendKeys(Dom4jXml.getValue("SICK_COMMENT_TEXT"));
		OneSickCaseWebElements.comment_input.click();
		
		Assertion.assertEquals(true, OneSickCaseWebElements.addPhoIsExist(), "\"直接给资源主体评论的添加图片按钮\"未找到，元素未找对，请检查！");
		phoExePath = curPath + Dom4jXml.getValue("SICK_COMMENTPHO_PATH");
		logger.info(phoExePath);
		OneSickCaseWebElements.add_photo.click();
		Utils.sleep(3);
		try {
			//调用autoit exe来上传照片
			Runtime.getRuntime().exec(phoExePath);
		} catch (IOException e) {
			logger.error(e);
			Reporter.log("[ERROR]"+e);
			//ScreenShotPC.screenShot("PublishSickCaseWebElements.publishComment");
			Assert.fail(e.toString());
		}
		
		Utils.waitElement(driver,OneSickCasePageElements.REMIND_SOMEBODY);
		Assertion.assertEquals(true, OneSickCaseWebElements.remindSomeBodyIsExist(), "\"直接给资源主体评论的提醒谁看按钮\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.remind_somebody.click();
		Utils.waitElement(driver,OneSickCasePageElements.SCCOM_REMIND_INPUT);
		Assertion.assertEquals(true, OneSickCaseWebElements.sccomRemInpIsExist(), "\"直接给资源主体评论的提醒谁看输入框\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.sccom_remind_input.clear();
		OneSickCaseWebElements.sccom_remind_input.sendKeys(Dom4jXml.getValue("SICK_COMMENT_REMIND_INPUT"));
		OneSickCaseWebElements.sccom_remind_input.click();
		Utils.waitElement(driver,OneSickCasePageElements.SCCOM_REMI_FIR_MATCH);
		Assertion.assertEquals(true, OneSickCaseWebElements.sccomRemFirMatIsExist(), "\"直接给资源主体评论的提醒谁看第一个被匹配出来的用户\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.sccom_remi_fir_match.click();
		
		Utils.waitElement(driver,OneSickCasePageElements.PUB_COM_BTN);
		Assertion.assertEquals(true, OneSickCaseWebElements.pubComBtnIsExist(), "\"直接给资源主体评论的发布按钮\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.pub_com_btn.click();
		
		logger.info("开始校验刚才发布的评论");
		Reporter.log("开始校验刚才发布的评论");
		Utils.sleep(3);
		Utils.waitElement(driver,OneSickCasePageElements.FIRST_PUBLISHED_CONTENT);
		Assertion.assertEquals(true, OneSickCaseWebElements.firPubContIsExist(), "\"第一条已发布的评论文本内容\"未找到，元素未找对，请检查！");
		Assertion.assertEquals(Dom4jXml.getValue("SICK_COMMENT_TEXT"), OneSickCaseWebElements.first_published_content.getText(), "\"第一条已发布的评论文本内容与输入时内容不一致\"，请检查是否取值错误或元素未找对，请检查！");
		logger.info("直接对病例主体进行的评论发布成功");
		Reporter.log("直接对病例主体进行的评论发布成功");
		
		Utils.sleep(3);
		Utils.waitElement(driver,OneSickCasePageElements.REMOVE_BTN);
		Assertion.assertEquals(true, OneSickCaseWebElements.removeBtnIsExist(), "\"第一条评论的删除图标\"未找到，元素未找对，请检查！");
		OneSickCaseWebElements.remove_btn.click();
		Utils.sleep(2);
		//悬浮至右上角姓名，等待悬浮菜单出现
		Assertion.assertEquals(true, IndexWebElements.usernameBtnIsExist(), "\"右上角姓名\"按钮未找到，元素未找到，请检查！");
		jse.executeScript("arguments[0].click();", IndexWebElements.username_btn);
			
		Utils.waitElement(driver,PersonHomePageElements.PUBLISHED_SICKCASES);
		//进入“发布的病例”
		Assertion.assertEquals(true, PersonHomeWebElements.publishedSCIsExist(), "\"个人中心页右侧发布的病例\"菜单未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.published_sickCases.click();
		
		Utils.waitElement(driver,PersonHomePageElements.FIRST_NEWS_TITLE);
		//跳转已发布的病例列表，判断第一条是否是刚才新发布的资源
		Assertion.assertEquals(true, PersonHomeWebElements.firstNewsTitleIsExist(), "\"发布的病例中最新一条\"标题未找到，未发布成功或元素未找到，请检查！");
		PersonHomeWebElements.first_news_title.click();
		Utils.waitElement(driver,OneSickCasePageElements.COMMENT_INPUT);
		Assertion.assertEquals(true, OneSickCaseWebElements.comInputIsExist(), "\"直接给资源主体评论的输入框\"未找到，元素未找对，请检查！");
		Assertion.assertEquals(false, OneSickCaseWebElements.firPubContIsExist(), "\"第一条已发布的评论文本内容\"未删除成功，元素是否依然存在或未找对，请检查！");
		logger.info("直接对病例主体进行的评论删除成功");
		Reporter.log("直接对病例主体进行的评论删除成功");
	}
	
	
}
