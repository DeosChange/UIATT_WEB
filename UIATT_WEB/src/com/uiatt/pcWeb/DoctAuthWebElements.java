package com.uiatt.pcWeb;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import com.uiatt.pcPage.DoctAuthPageElements;
import com.uiatt.util.BaseTest;
import com.uiatt.util.Utils;

/**
 * 提取2.0 PC 医师认证页面所有功能按钮元素
 * author : Change
 * 
 * */
@Log4j2
@Listeners({com.uiatt.listener.AssertionListener.class})
public class DoctAuthWebElements {
	// 姓
	@FindBy(xpath = DoctAuthPageElements.AUTH_LASTNAME)
	public static WebElement auth_lastname;
	
	// 名
	@FindBy(xpath = DoctAuthPageElements.AUTH_FIRSTNAME)
	public static WebElement auth_firstname;
	
	// 医师学历证
	@FindBy(xpath = DoctAuthPageElements.AUTH_EDUC_PAPERS)
	public static WebElement auth_educ_papers;
	
	// 医师资格证
	@FindBy(xpath = DoctAuthPageElements.AUTH_IDENTITY_PAPERS)
	public static WebElement auth_idenitity;
	
	// 医师执业证
	@FindBy(xpath = DoctAuthPageElements.AUTH_PRACTICING_PAPERS)
	public static WebElement auth_practicing_papers;
	
	// 医师学位证
	@FindBy(xpath = DoctAuthPageElements.AUTH_DEGREE_PAPERS)
	public static WebElement auth_degree_papers;
	
	// 医师资格证号/医师学历证号/医师学位证号/医师执业证号
	@FindBy(xpath = DoctAuthPageElements.AUTH_PAPERS_NUMBER)
	public static WebElement auth_papers_number;
	
	// 上传证件照片按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_PHOTO)
	public static WebElement auth_photo;
	
	// 上传证件照片错误提示
	@FindBy(xpath = DoctAuthPageElements.AUTH_PHOTO_NOTI)
	public static WebElement auth_photo_noti;
	
	// 医院
	@FindBy(xpath = DoctAuthPageElements.AUTH_HOSPITAL)
	public static WebElement auth_hospital;
	
	// 职称
	@FindBy(xpath = DoctAuthPageElements.AUTH_JOB)
	public static WebElement auth_job;
	
	// 住院医师
	@FindBy(xpath = DoctAuthPageElements.AUTH_RESIDENT_DOCT)
	public static WebElement auth_resident_doct;
	
	// 已选的住院医师
	@FindBy(xpath = DoctAuthPageElements.SELECTED_AUTH_RESIDENT_DOCT)
	public static WebElement selected_auth_resident_doct;
	
	// 主治医师
	@FindBy(xpath = DoctAuthPageElements.AUTH_ATTEND_DOCT)
	public static WebElement auth_attend_doct;
	
	// 讲师
	@FindBy(xpath = DoctAuthPageElements.AUTH_LECTURER)
	public static WebElement auth_lecturer;
	
	// 硕士生导师
	@FindBy(xpath = DoctAuthPageElements.AUTH_MASTER_TUTOR)
	public static WebElement auth_master_tutor;
		
	// 已选职称确定按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_JOB_CONFIRM)
	public static WebElement auth_job_confirm;
	
	// 专业按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_PROFESSIONAL)
	public static WebElement auth_professional;
	
	// 关节
	@FindBy(xpath = DoctAuthPageElements.AUTH_JOINT)
	public static WebElement auth_joint;
	
	// 已选的关节
	@FindBy(xpath = DoctAuthPageElements.SELECTED_AUTH_JOINT)
	public static WebElement selected_auth_join;
	
	// 脊柱
	@FindBy(xpath = DoctAuthPageElements.AUTH_SPINE)
	public static WebElement auth_spine;
	
	// 已选专业确定按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_PROF_CONFIRM)
	public static WebElement auth_prof_confirm;
	
	// 提交认证按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_SUB_BTN)
	public static WebElement auth_sub_btn;
	
	// 暂不认证按钮
	@FindBy(xpath = DoctAuthPageElements.AUTH_SKIP_BTN)
	public static WebElement auth_skip_btn;
	
	public static  WebDriver driver;
		
	//初始化
	public DoctAuthWebElements(WebDriver driver){
		DoctAuthWebElements.driver = driver;
		BaseTest.logConf();
	}

	//判断"暂不认证"按钮是否存在
    public static boolean authSkipBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(DoctAuthPageElements.AUTH_SKIP_BTN));
    }
    
    //判断"上传照片"错误提示是否存在
    public static boolean authPhoNotiIsExist() {
    	return Utils.isElementExist(driver, By.xpath(DoctAuthPageElements.AUTH_PHOTO_NOTI));
    }
    
    //判断"上传照片"按钮是否存在
    public static boolean authPhotoIsExist() {
    	return Utils.isElementExist(driver, By.xpath(DoctAuthPageElements.AUTH_PHOTO));
    }
    
    //判断"姓"输入框是否存在
    public static boolean lastNameBtnIsExist() {
    	return Utils.isElementExist(driver, By.xpath(DoctAuthPageElements.AUTH_LASTNAME));
    }
    
    
    
    
    
    
    
    
    
    
    

}
