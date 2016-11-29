package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 个人中心页面
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PersonHomePageElements {
	//个人中心页“已发布的xx”中的第一条，可由此来验证刚发布的资源的标题是否正确
	public static final String FIRST_NEWS_TITLE = "(.//div[@class='p_cont_list_r']/div[2]/a)[1]";

	//右侧“发布的病例”菜单
	public static final String PUBLISHED_SICKCASES = ".//div[@class='p_cont_r_center']/ul/li[1]";
	
	//病例编辑按钮
	public static final String UPDATE_SC_BTN = "(.//div[@class='bianji']/span[2])[1]";
	
	//头像
	public static final String HEAD_PHOTO = ".//a[@class='ev-logoUrl']/img";
	
	//选择照片按钮
	public static final String SELECT_IMAG = ".//*[@id='uploadPersonalImg']";
	
	//上传照片的保存按钮
	public static final String SAVE_IMAG_BTN = ".//*[@id='saveBtn']";
	
	//查看更多医师
	public static final String SEARCH_MORE_DOCT = ".//div[@class='more_hospital_cont']";
	
	//更多医师列表中的第一个
	public static final String DOCT_LIST_FIRST = "(.//div[@class='doctor_c']/div[1]/a)[1]";
	
	//他的主页
	public static final String HIS_PERHOME = ".//div[@class='p_b_l']/div[4]/div[2]/a/img";
	
	//添加关注
	public static final String ADD_ATTENTION = ".//div[@class='p_b_l']/div[4]/div[1]/div/img";
	
	//个人主页正中头像下的名字
	public static final String PERHOME_USNAME = ".//div[@class='p_b_l']/div[2]";
	
	//右侧关注
	public static final String ATTENTION_TEXT = "(.//div[@class='gz_text'])[1]";
	
	//关注的人列表的第一个
	public static final String ATTENTION_LIST_FIRST = "(.//div[@class='info_name']/a)[1]";
	
	//右侧“发布的话题”菜单
	public static final String PUBLISHED_TOPICS = ".//div[@class='p_cont_r_center']/ul/li[2]";
		
	
		
}
