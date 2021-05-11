package com.uiatt.listener;

import java.io.File;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.log4testng.Logger;

public class ScreenshotListener extends TestListenerAdapter{
	private static Logger logger = Logger.getLogger(ScreenshotListener.class);
	public static final String CONFIG = "config.properties";
	public static  WebDriver driver;
	
	//初始化
	public ScreenshotListener(WebDriver driver){
		ScreenshotListener.driver = driver;
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		takeScreenshot(tr);	
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
        takeScreenshot(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		logger.info(tr.getName() + " Finished");
	}
	/**
	 * 自动截图，保存图片到本地以及html结果文件中
	 * 
	 * @param tr
	 */
	private void takeScreenshot(ITestResult tr) {
		try {
			screenshot((TakesScreenshot)driver, generateRandomFilename(tr.getThrowable()));
		} catch (java.nio.channels.ClosedByInterruptException e){
			e.printStackTrace();
		}

	}
	
	/**
	 *  调用TakesScreenshot接口的getScreenshotAs方法对屏幕截图
	 * @param driver
	 * @param filename
	 */
	public void screenshot(TakesScreenshot driver, String filename) throws ClosedByInterruptException {
		String currentPath = System.getProperty("user.dir"); // get current work
		String screenshotPath = currentPath + "\\screenshot\\" + filename;
		File file = new File(screenshotPath);
		try {
			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			if (!file.exists()) {
				System.out.println("保存异常截图:" + screenshotPath);
				FileUtils.copyFile(scrFile, file);
			} else {
				System.out.println("保存异常截图:1" + screenshotPath);
				FileUtils.copyFile(scrFile, new File("1" + screenshotPath));
			}
		} catch (IOException | SessionNotFoundException e) {
			System.out.println("保存异常截图失败！");
			e.printStackTrace();
		}
	}
	
	 /**
     * 错误截图前，生成图片名字
     * @param ex
     * @return
     */
    private String generateRandomFilename(Throwable ex) {
        Calendar c = Calendar.getInstance();
        String filename = ex.getMessage();
        if (filename != null && filename.length() > 0) {
	        int i = filename.indexOf('\n');
	        filename = filename.substring(0, i).replaceAll("\\s", "_").replaceAll(":", "").replaceAll("/", "_").
	        		replaceAll("<", "_").replaceAll(">", "_").replaceAll("\"", "_").replaceAll("\\*", "_") + ".jpg";
	        filename = "" + c.get(Calendar.YEAR) + 
	        		"-" + c.get(Calendar.MONTH) + 
	        		"-" + c.get(Calendar.DAY_OF_MONTH) + 
	        		"-" + c.get(Calendar.HOUR_OF_DAY) + 
	        		"-" + c.get(Calendar.MINUTE) + 
	        		"-" + c.get(Calendar.SECOND) + 
	        		"-" + filename;
        } else {
        	filename = "" + c.get(Calendar.YEAR) + 
	        		"-" + c.get(Calendar.MONTH) + 
	        		"-" + c.get(Calendar.DAY_OF_MONTH) + 
	        		"-" + c.get(Calendar.HOUR_OF_DAY) + 
	        		"-" + c.get(Calendar.MINUTE) + 
	        		"-" + c.get(Calendar.SECOND)  + ".jpg";
        }
        
        return filename;
    }
    

}
