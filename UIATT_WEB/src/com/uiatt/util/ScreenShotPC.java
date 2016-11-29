package com.uiatt.util;

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
import org.testng.Reporter;

public class ScreenShotPC {
		private static Logger logger = Logger.getLogger(ScreenShotPC.class );
		/**
		 * 暂时的异常截屏解决方案，未来或会使用testng监听类实现；
		 * @param claMethName : 传入出错的类名和方法名
		 * @author ：Change
		 * */
		public static String screenShot(String filename){
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
	    				//Reporter.log("<div ><a href=\""+reportPhotoPath+"\"/><img height=\"\"100\"\" width=\"\"100\"\" src=\""+reportPhotoPath+"\"></img></a><br/><a href=\""+reportPhotoPath+"\">点击查看异常大图</a></div>");
	    				
	    		} catch (IOException | SessionNotFoundException e) {
	    				logger.error("保存异常截图失败！");
	    				Reporter.log("[ERROR]保存异常截图失败！");
	    				e.printStackTrace();
	    		} 
	               
	        } catch (AWTException e) {  
	            e.printStackTrace();  
	        } 
			return reportPhotoPath;
		}
		
}
