package com.uiatt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

public class SaveUserName {
	private static int num;
	private static String str;
	
	public SaveUserName() {
		num = Integer.parseInt(Dom4jXml.getValue("switch"));
	}
	
	/**
	 * 执行py文件，得到Python HOME
	 */
	public static void runPython() {
        String line = "";
		String currentPath = System.getProperty("user.dir");
		String path = "cmd /c python " + currentPath + "\\scripts\\getpythonpath.py";
		try {
			Process process = Runtime.getRuntime().exec(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));	 			
	        while ((line = reader.readLine()) != null) {
	        	str = line.toString();	        	
	        }
	        process.waitFor();
	     
		} catch (IOException | InterruptedException e) {
			e.getMessage();
		}
	}
	
	public static void emailName(String username) {	
		runPython();
		switch(num){
			case 1:
				ReadWriteTxtFile.writeTxt(username, str + "\\Lib\\site-packages\\UtilsLibrary\\userinfo\\username_email_line.txt");
				break;
			case 2:	
				ReadWriteTxtFile.writeTxt(username, str + "\\Lib\\site-packages\\UtilsLibrary\\userinfo\\username_email_test.txt");
				break;
			default:
				break;
		}
	}
	
	public static void phoneName(String username) {
		runPython();
		switch(num){
			case 1:
				ReadWriteTxtFile.writeTxt(username, str + "\\Lib\\site-packages\\UtilsLibrary\\userinfo\\username_phone_line.txt");
				break;
			case 2:	
				ReadWriteTxtFile.writeTxt(username, str + "\\Lib\\site-packages\\UtilsLibrary\\userinfo\\username_phone_test.txt");
				break;
			default:
				break;
		}
	}
	
	@Test
	public void f() {
		runPython();
		System.out.println(str);
	}
}
