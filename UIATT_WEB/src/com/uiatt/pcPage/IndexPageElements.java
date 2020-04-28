package com.uiatt.pcPage;


import org.testng.annotations.Listeners;


/**
 * 登陆成功后跳转的页面，此页面是登陆成功后所有操作的源头类，包括登出等都在此页面进行；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class IndexPageElements extends BaseElements{
	// 你的首页
	public static final String YOUR_HOMEPAGE = ".//div[@class='p_home_b']";
	
	// 会员登陆后的右上角用户名，鼠标悬停之上会出现登出操作菜单
	public static final String USERNAME_BTN = ".//*[@id='nicknameView']/a";
		
	//登出操作菜单中的登出按钮
	public static final String LOGOUT_ALLIN_BTN = ".//*[@id='login_msg']/ul/li[3]/a";
	
	//右上角用户名出现的悬浮菜单中的“修改资料”按钮
	public static final String UPDATE_USERINFO = ".//*[@id='login_msg']/ul/li[2]/a";
	
	//右上角用户名出现的悬浮菜单中的“个人中心”按钮
	public static final String PERSONAL_CENTER_BTN = ".//*[@id='login_msg']/ul/li[1]/a";
	
	//未认证用户登录后页面正中显示的“立即认证按钮”
	public static final String AUTH_NOW_BTN = ".//*[@id='trilogy']/div/div[3]";
	
	//认证用户登录后页面正中显示的“立即关注按钮”
	public static final String ATTENTION_NOW_BTN = ".//*[@id='trilogy']/div/div[3]/div";
	
	//发布病例按钮
	public static final String PUBLISH_SICKCASE = ".//*[@id='case_upload']/div[1]/a/img";
	
	//发布病例成功后返回登陆后的首页，在“你关注的动态”的第一条内容即为你刚发布的病例
	public static final String FIRST_SICKCASE_TITLE = "(.//div[@class='p_cont_list_r']/div[2]/a)[1]";
	
	//右上角绑定微信悬浮框的删除按钮
	public static final String REMOVE_WEIXIN_NOTI = ".//div[@class='ev-headerBindWeixin']/img";
	
	//聊话题按钮
	public static final String PUBLISH_TOPIC = ".//*[@id='topic_upload']/div[1]/a/img";

}
