package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 登陆成功后修改资料的页面；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class UpdateUSInfoPageElements {
	//修改密码按钮
	public static final String UPDATE_PW = ".//*[@id='pwd_btn']";
	
	//当前密码
	public static final String CURRENT_PW = ".//*[@id='password']";
	
	//新密码
	public static final String NEW_PW = ".//*[@id='newpassword']";
	
	//确认密码
	public static final String CONFIRM_PW = ".//*[@id='repassword']";

	//保存修改按钮
	public static final String SAVE_UPDATE_BTN = ".//*[@id='pwd_save']";
	
	//取消修改按钮
	public static final String CANCEL_UPDATE_BTN = ".//*[@id='pwd_cancel']";
	
	//当前密码的错误信息
	public static final String CUR_ERR_NOTICE = ".//*[@id='pwd_form']/div[2]/label";
	
	//新密码的错误信息
	public static final String NEW_ERR_NOTICE = ".//*[@id='pwd_form']/div[5]/label";
	
	//确认密码的错误信息
	public static final String CONFIRM_ERR_NOTICE = ".//*[@id='pwd_form']/div8]/label";
}
