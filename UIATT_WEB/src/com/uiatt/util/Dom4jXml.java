package com.uiatt.util;


import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.Reporter;

public class Dom4jXml {	
	public static Logger logger = Logger.getLogger(Dom4jXml.class );
	/**
	 * 读取xml文件
	 * @param regInfoPath string	文件路径
	 */ 
    public static Map<String, String> parserXml(String regInfoPath) {
        Map<String, String> temp = new LinkedHashMap<String, String>();
    	String path = System.getProperty("user.dir");
    	path += regInfoPath;
    	File inputXml = new File(path);
        SAXReader saxReader = new SAXReader();    
        try {    
            Document document = saxReader.read(inputXml);   //把文件读入到文档 
            Element employees = document.getRootElement();   	//获取文档根节点            
            for(Iterator<?> i = employees.elementIterator(); i.hasNext();) {            	
                Element employee = (Element) i.next();   
				for(Iterator<?> j = employee.elementIterator(); j.hasNext();) { 
					Element node = (Element) j.next();                  
					String key = node.getName();
					String value = node.getText();
					temp.put(key, value);
				}
            }           
        } catch (DocumentException e) {    
            System.out.println(e.getMessage());    
            logger.error(e.getMessage()); 
            Reporter.log("[ERROR]"+e.getMessage());
        } 
        return temp;
    }
    
    /**
     * 返回节点value
     * @param key
     * @return
     */
    public static String getValue(String key) {        
    	Map<String, String> init = Dom4jXml.parserXml("\\data\\init.xml");
	System.out.println(key);
    	return init.get(key);
    }  
}
