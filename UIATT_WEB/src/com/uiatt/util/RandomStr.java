package com.uiatt.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

/**
 * 生成唯一序列号
 * @author sun
 *
 */
public class RandomStr {
	
	/**
     * 用当前日期生成唯一序列号
     * 格式：年+月+日+小时+分钟      20150421113300
	 * @return 
     */ 
	public static String random(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Calendar cal = Calendar.getInstance();
		String times = format.format(cal.getTime()).substring(0,19);
		Pattern pattern = Pattern.compile("[^0-9]");  
		Matcher matcher = pattern.matcher(times); 
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sbr,"");
		}
		matcher.appendTail(sbr);
//		System.out.println(sbr.toString());
		return sbr.toString();	
	}
	
	/**
	 * 返回随机数（范围）
	 * @param min 最小数字
	 * @param max 最大数字
	 * @return
	 */
	public static int randomNum(int min, int max){		
		return new Random().nextInt(max - min + 1) + min;	
	}
	
	/**
	 * 生成邮箱
	 * 规则：3个字母 + ypg70 + 2个数字 + 合法邮箱后缀
	 * @return
	 */
	public static String randomEmail() {
        String str = "";
        String[] hGroup = {"@sina.com", "@163.com", "@126.com", "@qq.com", "@hotmail.com", "@gmail.com", "@sohu.com"};
        String[] qGroup = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", 
        		"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};                   
        for(int n = 0; n < 3; n++) {
            str += qGroup[randomNum(0, 25)];
        }
        return str + "ypg70" + randomNum(10, 99) + hGroup[randomNum(0, 6)];
	}
	
	/**
	 * 生成手机号
	 * 规则：177000 + 当前时间戳最后五位数字
	 * @return
	 */
	public static String randomPhone() {
		long currenTime = System.currentTimeMillis();
		String time = Long.toString(currenTime);
		String str = time.substring(time.length()-5, time.length());
		return "177000" + str;
	}
	
	@Test
	public void f() {
		System.out.println(randomEmail());
		System.out.println(randomPhone());
	}
}
