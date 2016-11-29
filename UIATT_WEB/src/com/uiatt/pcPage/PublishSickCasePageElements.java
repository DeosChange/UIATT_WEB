package com.uiatt.pcPage;

import org.testng.annotations.Listeners;

/**
 * 点击发布病例后的所有元素；
 * author:Change
 * */
@Listeners({com.uiatt.listener.AssertionListener.class})
public class PublishSickCasePageElements {
	//普通上传
	public static final String NORMAL_PUBLISH = ".//div[@class='dh_middle']/div[2]";
	
	//标题
	public static final String SICKCASE_TITLE = ".//*[@id='case_name']";
	
	//所属专业
	public static final String PROFESSIONAL_BELONG = ".//*[@id='areaTitle']";
	
	//所属专业选项中的第一个值
	public static final String PROFE_BELO_FIRST = ".//ul[@id='areaExp']/li[1]";
	
	//所属专业选项中的第二个值
	public static final String PROFE_BELO_SECOND = ".//ul[@id='areaExp']/li[2]";
	
	//第一个所选专业的删除按钮
	public static final String REMOVE_PROFE_BELO_FIRST = ".//*[@id='areaSel']/li[1]/div[2]/img";
	
	//性别：男
	public static final String SEX_MAN = ".//div[@class='publish_sexy_radio']/div[1]/input";
	
	//岁
	public static final String AGE = ".//*[@id='age']";
	
	//主诉
	public static final String MAIN_MARRATE = ".//*[@id='main_narrate']";
	
	//现病史
	public static final String ILLNESS_HISTORY = ".//*[@id='illness_history']";
	
	//专科检查
	public static final String SPECIALIST_CHECK = ".//*[@id='professional_checking']";
	
	//文字讨论
	public static final String TXT_DISCUSS = ".//*[@id='discussion']";
	
	//添加第一张照片按钮
	public static final String SICKCASE_FIRPHOTOS_BTN = ".//div[@id='uploadify']/object";
	
	//添加之后照片按钮
	public static final String SICKCASE_AFTPHOTOS_BTN = ".//div[@id='uploadify_con']/object";
	
	//第一张照片的手术阶段选项：术前
	public static final String FIRPHO_BEFO_OPER_BTN = ".//*[@id='case_img_queue']/li[1]/div[3]/ul/li[1]";
	
	//第一张照片描述
	public static final String FIRPHO_BEFO_EXPLAIN = ".//*[@id='case_img_queue']/li[1]/div[4]/input";
	
	//第二张照片的手术阶段选项：术中
	public static final String SECPHO_DUR_OPER_BTN = ".//*[@id='case_img_queue']/li[2]/div[3]/ul/li[2]";
		
	//第二张照片描述
	public static final String SECPHO_BEFO_EXPLAIN = ".//*[@id='case_img_queue']/li[2]/div[4]/input";
	
	//第三张照片的手术阶段选项：术后
	public static final String THIPHO_DUR_OPER_BTN = ".//*[@id='case_img_queue']/li[3]/div[3]/ul/li[3]";
			
	//第三张照片描述
	public static final String THIPHO_BEFO_EXPLAIN = ".//*[@id='case_img_queue']/li[3]/div[4]/input";
		
	//提醒谁看输入框	
	public static final String REMIND_INPUT = ".//div[@class='remind_par']/input";
	
	//此处不考虑匹配出的正确性，直接先选取第一个被匹配出的人
	public static final String REMIND_MATCHED_FIRST = ".//ul[@class='remind_list']/li[1]";
	
	//继续完善病例按钮
	public static final String ADD_MORE = ".//*[@id='addMore']";
	
	//既往史
	public static final String PAST_HISTORY = ".//*[@id='past_history']";
	
	//个人史
	public static final String PERSONAL_HISTORY = ".//*[@id='personal_history']";
	
	//家族史
	public static final String FAMILY_HISTORY = ".//*[@id='family_history']";
	
	//辅助检查
	public static final String AUXILIARY_INFO = ".//*[@id='auxiliary_info']";
	
	//诊断
	public static final String DIAGNOSIS_INFO = ".//*[@id='diagnosis_info']";
	
	//诊疗记录
	public static final String TREATMENT_RECORD = ".//*[@id='treatment_record']";
	
	//手术名称
	public static final String OPERATION_NAME = ".//*[@id='operation_name']";
	
	//术中信息
	public static final String INTRAOPERATIVE_INFO = ".//*[@id='intraoperative_info']";
	
	//产品信息
	public static final String PRODUCT_INFO = ".//*[@id='product_info']";
	
	//新增时的发布按钮
	public static final String PUBLISH_BTN = ".//*[@id='publish_sup']";
	
	//修改时的发布按钮
	public static final String PUBLISH_UPDATE_BTN = ".//*[@id='publish_case']";
	
	//取消按钮
	public static final String CANCEL_BTN = ".//*[@id='cancel_sup']";
	
	//所属专业选项的隐藏域
	public static final String PROFESSIONAL_DISPLAYLIST = ".//div[@class='publish_zy_position']";
	
	//整个发布病例的编辑窗体
	public static final String EDIT_WINDOW = ".//div[@class='fb_doc']";
}
