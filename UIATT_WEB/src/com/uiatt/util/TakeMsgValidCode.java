package com.uiatt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.testng.Reporter;
/**
 * 获取短信验证码、邮箱日志链接，这个方法在截取返回值时，截取的位数写死了，如果以后返回值样式或位数更改了，此处也需要更改，否则会截取到不正确的结果
 * */
public class TakeMsgValidCode {
	public static Logger logger = Logger.getLogger(TakeMsgValidCode.class );
	public TakeMsgValidCode(){
		BaseTest.logConf();
	}
	public static String sendPost(String url) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            logger.info(conn+"\n");
            Reporter.log(conn+"\n");
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            logger.info(out+"\n");
            Reporter.log(out+"\n");
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            logger.info(in+"\n");
            Reporter.log(in+"\n");
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            logger.info(result+"\n");
            Reporter.log(result+"\n");
        } catch (Exception e) {
        	logger.error("短信发送请求出现异常！"+e);
        	Reporter.log("[ERROR]短信发送请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
	
	public static String takeMsgValidCode(String regPhoNum){
		String postUrl=Dom4jXml.getValue("MsgValidCodeUrl1")+regPhoNum+Dom4jXml.getValue("MsgValidCodeUrl2");
		String respon=sendPost(postUrl);
		char b= 'a';
		String mobileCode="";
		//只有非空并不等于“”才能去进行截取
		if(respon == null && "".equals(respon) ){
			logger.error("短信接口返回的结果为空，无法进行验证码截取，请检查！");
        	Reporter.log("[ERROR]短信接口返回的结果为空，无法进行验证码截取，请检查！");
		}else{
			try{
				//自定义灵活截取短信验证码的方法，但首先返回格式为“您在唯医的短信验证码是287635”，验证按紧接在“是”字之后，多其它字符都不行；
				for(int i=0;i< respon.length();i++){
					b =respon.charAt(i);
					if(b == '是'){
						mobileCode = ""+respon.charAt(i+1)+respon.charAt(i+2)+respon.charAt(i+3)+respon.charAt(i+4)+respon.charAt(i+5)+respon.charAt(i+6);
						mobileCode = mobileCode.trim();
						logger.info("成功获取短信验证码："+mobileCode); 
			        	Reporter.log("成功获取短信验证码："+mobileCode); 
						break;
					}else{
						continue;
					}
				}
	        }catch(Exception e){
	        	logger.error("短信验证码截取出现异常！"+e);
	        	Reporter.log("[ERROR]短信验证码截取出现异常！"+e);
	        	e.printStackTrace();
	        }
		}
		return mobileCode;
	}
	
	public static String takeEmailLogUrl(String forgetPWEmail){
		String postUrl=Dom4jXml.getValue("ForgetPWEmail1")+forgetPWEmail+Dom4jXml.getValue("ForgetPWEmail2");
		String respon=sendPost(postUrl);
		String emailLogUrl="";
		try{
			//emailLogUrl=respon.substring(1221,1365).trim();
			emailLogUrl=respon.substring(1222,1354).trim();
			//去除截取的反斜杠
			emailLogUrl=emailLogUrl.replaceAll("\\\\", "");
        	logger.info("成功获取找回密码的邮箱日志url："+emailLogUrl); 
        	Reporter.log("成功获取找回密码的邮箱日志url："+emailLogUrl); 
        }catch(Exception e){
        	logger.error("找回密码的邮箱日志url截取出现异常！"+e);
        	Reporter.log("[ERROR]找回密码的邮箱日志url截取出现异常！"+e);
        	e.printStackTrace();
        }
		return emailLogUrl;
	}
	
	public static String takeEmailLogUrlNew(String forgetPWEmail) {
		String emailLogUrl="";
		String postUrl=Dom4jXml.getValue("ForgetPWEmail1")+forgetPWEmail+Dom4jXml.getValue("ForgetPWEmail2");
		String respon=sendPost(postUrl).replaceAll("\\\\", "");
		//使用正则表达式对邮箱日志进行截取，避免了把截取数写死而受改动的影响大
		String pattern = "(http://)(www|m).uiatt.cn/call/customer/reset/password/input/\\?itemId=[0-9]{4,5}&resetSite=[0-9]&validCode=[0-9a-z]{32}&flag=null"; 
		Pattern patcher1 = Pattern.compile(pattern); 
		Matcher matcher1 = patcher1.matcher(respon);
		if(matcher1.find()){
			emailLogUrl = matcher1.group();
			logger.info("成功获取找回密码的邮箱日志url："+emailLogUrl); 
			Reporter.log("成功获取找回密码的邮箱日志url："+emailLogUrl); 
		}else{
			logger.error("找回密码的邮箱日志url截取出现异常！可能是正则表达式匹配出现问题，请检查！");
			Reporter.log("[ERROR]找回密码的邮箱日志url截取出现异常！可能是正则表达式匹配出现问题，请检查！");
		}
		return emailLogUrl;
		
	}
	
	
	
	public static void main(String[] arg0){
		//takeEmailLogUrl("xyypg7001@163.com");
		
		//takeEmailLogUrlNew("xyypg7001@163.com");
		takeMsgValidCode("17700080521");
		/**
		String respon="wefergergregr<a>http://www.uiatt.cn/call/customer/reset/password/input/?itemId=15359&resetSite=1&validCode=20617a00f85875dd83531d13a09456c7&flag=null</a>dfbdfbfgnfgngh";
		String pattern = "(http://)(www|m).uiatt.cn/call/customer/reset/password/input/\\?itemId=[0-9]{4,5}&resetSite=[0-9]&validCode=[0-9a-z]{32}&flag=null"; 
		
		Pattern patcher1 = Pattern.compile(pattern); 
		Matcher matcher1 = patcher1.matcher(respon);
		
		//System.out.println(matcher1.find());
		if(matcher1.find()){
		
	       System.out.println(matcher1.group()); 
		
		}
		*/
	}
	

}
