package com.uiatt.listener;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.uiatt.util.BaseTest;

public class ScreenShotPC extends TestListenerAdapter{
		private static Logger logger = Logger.getLogger(ScreenShotPC.class );
		@Override
		public void onTestFailure(ITestResult tr) {
			super.onTestFailure(tr);
			logger.info(tr.getName() + " Failure");
			Reporter.log(tr.getName() + " Failure");
			screenShot();	
			
		}

		@Override
		public void onTestSkipped(ITestResult tr) {
			super.onTestSkipped(tr);
			logger.info(tr.getName() + " Skipped");
			Reporter.log(tr.getName() + " Skipped");
		}

		@Override
		public void onTestSuccess(ITestResult tr) {
			super.onTestSuccess(tr);
			logger.info(tr.getName() + " Success");
			Reporter.log(tr.getName() + " Success");
		}

		@Override
		public void onTestStart(ITestResult tr) {
			super.onTestStart(tr);
			logger.info(tr.getName() + " Start");
			Reporter.log(tr.getName() + " Start");
		}

		@Override
		public void onFinish(ITestContext testContext) {
			super.onFinish(testContext);

		}

		
		
		
		/**
		 * 自定义使用场合，但不够灵活，不能全部判断并捕获异常的话会失效，所以暂时弃用，改为通过监听
		 * 暂时的异常截屏解决方案，未来或会使用testng监听类实现；
		 * @param claMethName : 传入出错的类名和方法名
		 * @author ：Change
		 * */
		public static void screenShot(String filename){
			BaseTest.logConf();
			String reportPhotoPath ="";
			try {  
				//获取所在设备屏幕分辨率：width,height，以全屏截屏；
	            int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();  //要截取的宽度
	            int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();  //要截取的高度
	            Robot robot = new Robot();  
	            BufferedImage image = robot.createScreenCapture(new Rectangle(width,height)); 
	            image = image.getSubimage(0, 0, width, height);
	            
	            Calendar c = Calendar.getInstance();
	            String photename = "" + c.get(Calendar.YEAR) + 
		        		"-" + c.get(Calendar.MONTH) + 
		        		"-" + c.get(Calendar.DAY_OF_MONTH) + 
		        		"-" + c.get(Calendar.HOUR_OF_DAY) + 
		        		"-" + c.get(Calendar.MINUTE) + 
		        		"-" + c.get(Calendar.SECOND) + "-" +filename + ".png";
	           
	            String currentPath = System.getProperty("user.dir"); // get current work
	    		String screenshotPath = currentPath + "\\screenshot\\" + photename;
	    		reportPhotoPath = "../screenshot/"+photename;
	    		File file = new File(screenshotPath);
	    		try {
	    				ImageIO.write (image, "png" , file); 
	    				logger.info("成功保存异常截图:" + screenshotPath);
	    				Reporter.log("成功保存异常截图:" + screenshotPath);
	    				Reporter.log(reportPhotoPath);
	    		} catch (IOException | SessionNotFoundException e) {
	    				logger.error("保存异常截图失败！");
	    				Reporter.log("[ERROR]保存异常截图失败！");
	    				e.printStackTrace();
	    		} 
	               
	        } catch (AWTException e) {  
	            e.printStackTrace();  
	        } 
		}
		
		
		/**
		 * 通过监听，不必判断异常有多少种，只要方法失败，就会执行，通过监听会更方便灵活
		 * */
		public static void screenShot(){
			BaseTest.logConf();
			String reportPhotoPath ="";
			try {  
				//获取所在设备屏幕分辨率：width,height，以全屏截屏；
	            int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();  //要截取的宽度
	            int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();  //要截取的高度
	            Robot robot = new Robot();  
	            BufferedImage image = robot.createScreenCapture(new Rectangle(width,height)); 
	            image = image.getSubimage(0, 0, width, height);
	            
	            Calendar c = Calendar.getInstance();
	            String photename = "" + c.get(Calendar.YEAR) + 
		        		"-" + c.get(Calendar.MONTH) + 
		        		"-" + c.get(Calendar.DAY_OF_MONTH) + 
		        		"-" + c.get(Calendar.HOUR_OF_DAY) + 
		        		"-" + c.get(Calendar.MINUTE) + 
		        		"-" + c.get(Calendar.SECOND) + ".png";
	           
	            String currentPath = System.getProperty("user.dir"); // get current work
	    		String screenshotPath = currentPath + "\\screenshot\\" + photename;
	    		reportPhotoPath = "../screenshot/"+photename;
	    		File file = new File(screenshotPath);
	    		try {
	    				ImageIO.write (image, "png" , file); 
	    				logger.info("通过监听成功保存异常截图:" + screenshotPath);
	    				//Reporter.log("通过监听成功保存异常截图:" + screenshotPath);
	    				//Reporter.log(reportPhotoPath);
	    		} catch (IOException | SessionNotFoundException e) {
	    				logger.error("通过监听保存异常截图失败！");
	    				Reporter.log("[ERROR]通过监听保存异常截图失败！");
	    				e.printStackTrace();
	    		} 
	               
	        } catch (AWTException e) {  
	            e.printStackTrace();  
	        } 
		}
		
}
