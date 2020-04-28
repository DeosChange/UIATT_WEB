package com.uiatt.pcPage;


import org.testng.annotations.Listeners;



/**
 * 提取2.0 PC 登陆页面所有功能按钮元素
 * author : Change
 * 
 * */

@Listeners({com.uiatt.listener.AssertionListener.class})
public class LoginPageElements extends BaseElements{
	// 会员登录按钮
	public static final String LOGIN_uiatt_BTN = ".//*[@id='allinLogin']/div[1]/div[1]";
		
	// 登录输入账户
	public static final String LOGIN_uiatt_USER = ".//input[@placeholder='邮箱或已验证手机']";
		
	// 登录输入密码
	public static final String LOGIN_uiatt_PW = ".//input[@placeholder='你的密码']";
		
	// CAOS会员登录按钮
	public static final String LOGIN_CAOS_BTN = ".//*[@id='allinLogin']/div[1]/div[2]";
		
	// CAOS输入账户
	public static final String LOGIN_CAOS_USER = ".//input[@placeholder='你在CAOS的用户名']";
		
	// CAOS输入密码
	public static final String LOGIN_CAOS_PW = ".//input[@placeholder='你在CAOS的密码']";
		
	// 登录错误信息
	public static final String ERROR_MESSAGE = ".//*[@id='allinLogin']/div[2]/div/div";	
	
	// 忘记密码
	public static final String FORGET_PWD = ".//*[@id='allinLogin']/div[5]/div[2]/a";	
	
	// 登陆
	public static final String ALLIN_SUBMIT_BTN = ".//div[@id='allinSubmitBtn']/img";
	
	// CAOS登陆
	public static final String CAOS_SUBMIT_BTN = ".//*[@id='caosSubmitBtn']/img";
	
	// 立即注册
	public static final String REGIST_ALLIN_BTN = ".//*[@id='allinLogin']/div[7]/a";
	
	//病例
	public static final String SICKCASE_BTN = ".//div[@class='metting']/a";
	
	// 文库
	public static final String DOCSTORE_BTN = ".//a[@href='http://www.uiatt.cn/html/index/doc/doc_home.html']";
		
	// 话题
	public static final String TOPIC_BTN = ".//a[@href='http://www.uiatt.cn/html/index/topic/topic_home.html']";
	
	// 首页
	public static final String INDEX_BTN = ".//a[@class='login_index']";
	
	//已注册过的caos账户登陆，会跳转一个中间页，其中取他的登陆用户名，而非姓名
	public static final String REF_ALLIN_CAOS_USN = ".//div[@class='tishi']/span";
	
	//已注册过的caos账户登陆，会跳转一个中间页，其中的提示语
	public static final String REF_ALLIN_CAOS_NOTE = ".//div[@class='tishi']";
	
	//已注册过的caos账户登陆，会跳转一个中间页，其中他的登陆用户名已有，直接输入的密码
	public static final String REF_ALLIN_CAOS_PW = ".//*[@id='wanshanPasswd']";
	
	//已注册过的caos账户登陆，会跳转一个中间页，登陆按钮
	public static final String REF_ALLIN_CAOS_LOGIN_BTN = ".//*[@id='wanShanForm']/div[3]/div";
	
	//已注册过的caos账户登陆，会跳转一个中间页，错误提示信息
	public static final String REF_ALLIN_CAOS_ERRORMSG = ".//label[@class='error']";
	
	//导航栏搜索按钮
	public static final String SEARCH_BTN = ".//*[@id='search_default']/a/img";
	
	//搜索文本输入框状态
	public static final String SEARCH_INPUT_STATE = ".//div[@id='search_launch']";
	
	//搜索输入框
	public static final String SEARCH_INPUT = ".//*[@id='serch_input']";
	
	//输入后的搜索按钮
	public static final String SEARCH_INPUT_BTN = ".//div[@class='search_but_botton']/img";
	
	//logo图片，可跳转登陆页
	public static final String ALLIN_LOGO_IMG = ".//div[@class='logo']/a/img";
}
