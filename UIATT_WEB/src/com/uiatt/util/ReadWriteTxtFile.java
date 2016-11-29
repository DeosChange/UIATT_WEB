package com.uiatt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.uiatt.util.RandomStr;

public class ReadWriteTxtFile {
	public static Logger logger = Logger.getLogger(ReadWriteTxtFile.class );
	private static String currentPath = System.getProperty("user.dir");
	
	/**
	 * 读取txt文件,注意，必须确保txt文件保存格式为UTF-8无BOM编码格式,可利用notepa++工具将txt文件另存为一下；然后再在java代码中采用UTF-8解码处理，才可以，两边保持一致格式；
	 * @param path
	 * @return
	 */
	private static String ReadTxtLine(String path){
		String lineTxt = "";
		String[] data = null;
        try {
            File file = new File(currentPath + path);
            if(file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                lineTxt = bufferedReader.readLine();
//                while((lineTxt = bufferedReader.readLine()) != null){				//按行读取
//                    System.out.println(lineTxt);
//                }
                read.close();
                data = lineTxt.split(",");
	        } else {
	            System.out.println("找不到指定的文件");
	            logger.error("找不到指定的文件");
	            Reporter.log("[ERROR]找不到指定的文件");
	        }           
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            logger.error("读取文件内容出错");
            Reporter.log("[ERROR]读取文件内容出错");
            e.printStackTrace();
        }
        
        int num = RandomStr.randomNum(0, data.length - 1);
        String name = data[num];
        if (name == null) {
        	name = "李";
        }
        logger.info("成功取出用户名信息："+name);
        Reporter.log("成功取出用户名信息："+name);
        return name;
    }
	
	/**
	 * 写入txt
	 * @param username
	 * @param fileName
	 */
	public static void writeTxt(String username, String fileName) {  
		try {  
			FileOutputStream output = new FileOutputStream(fileName, true); 
			username += "\r\n";
			output.write(username.getBytes("UTF-8"));  
			output.close();   
		} catch (Exception e) {  
			e.printStackTrace();  
		}
	}
	
	/**
	 * 返回lastname
	 * @return
	 */
	public static String getLastName() {
        return ReadTxtLine("\\data\\lastname.txt");
	}
	
	/**
	 * 返回firstname
	 * @return
	 */
	public static String getFirstName() {
		return ReadTxtLine("\\data\\firstname.txt");
	}
	
	@Test
	public void f() {
		//writeTxt("test", "\\data\\username_test.txt");
	}
	
	
}
