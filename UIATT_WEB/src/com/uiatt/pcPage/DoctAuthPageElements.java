package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 提取2.0 PC 医师认证页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class DoctAuthPageElements extends BaseElements{
	// 姓
	public static final String AUTH_LASTNAME = ".//input[@name='lastName']";
	//public static final String AUTH_LASTNAME = ".//*[@id='renzhengForm']/div[1]/div[2]/div[1]/input";
	
	// 名
	public static final String AUTH_FIRSTNAME = ".//input[@name='firstName']";
	//public static final String AUTH_FIRSTNAME = ".//*[@id='renzhengForm']/div[1]/div[1]/div[1]/input";
	
	// 医师学历证
	public static final String AUTH_EDUC_PAPERS = ".//*[@id='renzhengForm']/div[2]/div[1]";

	// 医师资格证
	public static final String AUTH_IDENTITY_PAPERS = ".//*[@id='renzhengForm']/div[2]/div[2]";
		
	// 医师执业证
	public static final String AUTH_PRACTICING_PAPERS = ".//*[@id='renzhengForm']/div[2]/div[4]";
		
	// 医师学位证
	public static final String AUTH_DEGREE_PAPERS = ".//*[@id='renzhengForm']/div[2]/div[3]";
	
	// 医师资格证号/医师学历证号/医师学位证号/医师执业证号
	public static final String AUTH_PAPERS_NUMBER = ".//input[@name='attCode']";
	//public static final String AUTH_PAPERS_NUMBER = ".//*[@id='renzhengForm']/div[3]/div[1]/input";
	
	// 上传证件照片按钮
	public static final String AUTH_PHOTO = ".//*[@id='file1']";
	
	// 上传证件照片错误提示
	public static final String AUTH_PHOTO_NOTI = ".//div[@class='renzhengForm']/div[4]/div[2]/span/label";
	
	// 医院
	public static final String AUTH_HOSPITAL = ".//*[@id='company']";
	
	// 职称
	public static final String AUTH_JOB = ".//*[@id='medical_title']/ul";
	
	// 住院医师
	public static final String AUTH_RESIDENT_DOCT = ".//*[@id='medicalMenu']/dl/dd[1]/ul/li[1]";
	
	// 已选的住院医师
	public static final String SELECTED_AUTH_RESIDENT_DOCT = ".//*[@id='medicalMenu']/div/ul/li";
	
	// 主治医师
	public static final String AUTH_ATTEND_DOCT = ".//*[@id='medicalMenu']/dl/dd[1]/ul/li[2]";
	
	// 讲师
	public static final String AUTH_LECTURER = ".//*[@id='medicalMenu']/dl/dd[2]/ul/li[1]";
	
	// 硕士生导师
	public static final String AUTH_MASTER_TUTOR = ".//*[@id='medicalMenu']/dl/dd[3]/ul/li[1]";
	
	// 已选职称确定按钮
	public static final String AUTH_JOB_CONFIRM = ".//*[@id='medicalMenu']/div/a/span";
	
	// 专业按钮
	public static final String AUTH_PROFESSIONAL = ".//*[@id='proFieldshow']";
	
	// 关节
	public static final String AUTH_JOINT = ".//*[@id='areasMenu']/dl/dd/ul/li[1]";
	
	// 已选的关节
	public static final String SELECTED_AUTH_JOINT = ".//*[@id='areasMenu']/div/ul/li";
	
	// 脊柱
	public static final String AUTH_SPINE = ".//*[@id='areasMenu']/dl/dd/ul/li[2]";
	
	// 已选专业确定按钮
	public static final String AUTH_PROF_CONFIRM = ".//*[@id='areasMenu']/div/a/span";
	
	// 提交认证按钮
	public static final String AUTH_SUB_BTN = ".//*[@id='renzhengForm']/div[8]/div";
	
	// 暂不认证按钮
	public static final String AUTH_SKIP_BTN = ".//*[@id='renzhengForm']/div[9]";
	
	public static final String AUTH_SKIP_BTN_1 = ".//*[@id='renzhengForm']/div[8]";
	
}
