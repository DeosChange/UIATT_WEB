package com.uiatt.listener;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;

import com.uiatt.util.BaseTest;
 
public class Assertion {
    public static boolean flag = true;    
    public static List<Error> errors = new ArrayList<Error>();  
    public static Logger logger ;
    
    public static void assertEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        } catch (Error e){
            errors.add(e);
            flag = false;
        }
    }
     
    public static void assertEquals(Object actual, Object expected, String message){
    	BaseTest.logConf();
    	logger = Logger.getLogger(Assertion.class );
        try{
            Assert.assertEquals(actual, expected, message);
        } catch (Error e){
            errors.add(e);
            //并记录日志
           // logger.error(e);
            Reporter.log("[ERROR]"+e);;
            flag = false;
            Assert.fail(e.toString());
        }
    }
}
