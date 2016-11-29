package com.uiatt.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
 

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

 
public class TestReport implements IReporter{
     
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        List<ITestResult> list = new ArrayList<ITestResult>();
        for (ISuite suite : suites) {          
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult suiteResult : suiteResults.values()) {
                ITestContext testContext = suiteResult.getTestContext();           
                IResultMap passedTests = testContext.getPassedTests();
                IResultMap failedTests = testContext.getFailedTests();
                IResultMap skippedTests = testContext.getSkippedTests();
                IResultMap failedConfig = testContext.getFailedConfigurations();   
                list.addAll(this.listTestResult(passedTests));
                list.addAll(this.listTestResult(failedTests));
                list.addAll(this.listTestResult(skippedTests));
                list.addAll(this.listTestResult(failedConfig));
            }          
        }
        this.sort(list);
        this.outputResult(list, outputDirectory+"/test-pc.txt");
        this.outputResult(list, outputDirectory+"/report-pc.html");
    }
     
    private ArrayList<ITestResult> listTestResult(IResultMap resultMap){
        Set<ITestResult> results = resultMap.getAllResults();    
        return new ArrayList<ITestResult>(results);
    }
     
    private void sort(List<ITestResult> list){
        Collections.sort(list, new Comparator<ITestResult>() {
            @Override
            public int compare(ITestResult r1, ITestResult r2) {
                if(r1.getStartMillis()>r2.getStartMillis()){
                    return 1;
                }else{
                    return -1;
                }              
            }
        });
    }
     
    private void outputResult(List<ITestResult> list, String path){ 
    	ArrayList<ITestResult> passArrayList=new ArrayList<ITestResult>();
    	ArrayList<ITestResult> failedArrayList=new ArrayList<ITestResult>();
    	ArrayList<ITestResult> skipArrayList=new ArrayList<ITestResult>();
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(new File(path)));
            StringBuffer sb = new StringBuffer();
            for (ITestResult result : list) {
            	if(result.getStatus()==1)
            	{
            		passArrayList.add(result);
            	}
            	if(result.getStatus()==2)
            	{
            		failedArrayList.add(result);
            	}
            	if(result.getStatus()==3)
            	{
            		skipArrayList.add(result);
            	}
            }
            
             sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
              sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n");
              sb.append("<meta http-equiv=\"Content-Type\"content=\"text/html; charset=GBK\" />\n");
              sb.append("<title>无标题文档</title>\n");
              sb.append("<style type=\"text/css\">\n");
              sb.append(".total{\n");
              sb.append("float:left;\n");
              sb.append("margin_left:20px;\n");
              sb.append("margin_left:20px;");
              sb.append("margin-top:0px;");
              sb.append("}\n#report_total\n}\n");
              sb.append("border:none;\n}\n");
              sb.append("table\n{border-top-width: 1px;\n");
          	  sb.append("border-right-width: 1px;\n");
          	  sb.append("border-bottom-width: 1px;\n");
          	  sb.append("border-left-width: 1px;\n");
          	 /*以上分别设置的是表格边框中上右下左的边框宽度*/
          	  sb.append("border-top-style: solid;\n");
          	  sb.append("border-right-style: solid;\n");
          	  sb.append("border-bottom-style: solid;\n");
          	  sb.append("border-left-style: solid;\n");
          	/*设置边框的表现样式，solid为实线*/
          	  sb.append("border-top-color: #0000FF;\n");
          	  sb.append("border-right-color: #0000FF;\n");
          	  sb.append("border-bottom-color: #0000FF;\n");
          	  sb.append("border-left-color: #0000FF;}\n");
          	 /*设置边框的颜色*/
              sb.append("</style>\n</head>\n");
              sb.append("<body>\n");
              sb.append("<div id=\"report_title\">\n");
              sb.append("<div align=\"center\">测试报告</div>\n");
              sb.append("</div>\n");
              sb.append("<div id=\"report_total\">\n");
              sb.append("<div style=\"font-size:20px;font-weight:bold\">测试结果汇总</div>\n");
              sb.append("<table width=\"900\" border=\"1\" cellspacing=\"0\"  cellpadding=\"0\" bordercolor=\"#000000\">\n");
              sb.append("<tr>\n<td width=\"84\"><div align=\"center\">用例总数</div></td>\n");
              sb.append("<td width=\"152\"><div align=\"center\">通过数（pass）</div></td>\n");
              sb.append("<td width=\"125\"><div align=\"center\">失败数(failed)</div></td>\n");
              sb.append("<td width=\"96\"><div align=\"center\">跳过数(skip)</div></td>\n");
              sb.append("<td width=\"91\"><div align=\"center\">通过率</div></td>\n</tr>\n");
              sb.append(" <tr>\n<td><div align=\"center\">");
              sb.append(passArrayList.size()+failedArrayList.size()+skipArrayList.size());
              sb.append("</div></td>\n<td><div align=\"center\">");
              sb.append(passArrayList.size());
              sb.append("</div></td>\n <td><div align=\"center\">");
              sb.append(failedArrayList.size());
              sb.append("</div></td>\n<td><div align=\"center\">");
              sb.append(skipArrayList.size());
              sb.append("</div></td>\n<td><div align=\"center\">");
              float total=passArrayList.size()+failedArrayList.size()+skipArrayList.size();
              float s=passArrayList.size()/total;              
              sb.append(s*100);
              sb.append("%");
              sb.append("</div></td>\n</tr>\n</table>\n");
              sb.append("<div style=\"font-size:20px;font-weight:bold\">详细测试结果</div>\n");
              sb.append("<table width=\"900\" border=\"1\" cellspacing=\"0\"  cellpadding=\"0\" bordercolor=\"#000000\" style=\"color:green\">\n<tr>\n");
              sb.append("<tr>\n<td colspan=5 align=\"left\" style=\"color:green;font-size:14px;font-weight:bold\">成功测试用例</td>\n</tr>\n");
              sb.append("<td width=\"440\">用例名称</td>\n");
              sb.append("<td width=\"155\">类名.方法名</td>\n");
              sb.append("<td width=\"134\">开始时间</td>\n");
              sb.append("<td width=\"87\">耗时</td>\n");
              sb.append("<td width=\"84\">测试结果</td>\n");
              sb.append("<tr>\n");
              
              for (ITestResult passresult : passArrayList)
              {
          	   if(sb.length()!=0){
                  sb.append("\r\n");
                  }
          	 float t=passresult.getEndMillis()-passresult.getStartMillis();
          	 sb.append("<tr>")
          	   .append("<td width=\"440\">"+passresult.getMethod().getDescription()+"</td>\n")
               .append(" ")
               .append("<td width=\"155\">"+passresult.getMethod().getMethodName()+"</td>\n")
               .append(" ")
               .append("<td width=\"134\">"+this.formatDate(passresult.getStartMillis())+"</td>\n")
               .append(" ")
               .append("<td width=\"87\">"+Float.toString(t)+"毫秒"+"</td>\n")
               .append("<td width=\"84\">"+this.getStatus(passresult.getStatus())+"</td>\n")
               .append("</tr>\n");
          	   
             }
            if(sb.length()!=0){
              sb.append("\r\n");
              }          
 
              sb.append("</table>\n");
              sb.append("<table width=\"900\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\" bordercolor=\"#000000\" style=\"color:red;margin-top:10px\">\n<tr>\n");
              sb.append("<tr>\n<td colspan=5 align=\"left\" style=\"color:red;font-size:14px;font-weight:bold\">成功测试用例</td>\n</tr>\n");
              sb.append("<td width=\"440\">用例名称</td>\n");
              sb.append("<td width=\"155\">类名.方法名</td>\n");
              sb.append("<td width=\"134\">开始时间</td>\n");
              sb.append("<td width=\"87\">耗时</td>\n");
              sb.append("<td width=\"84\">测试结果</td>\n");
              sb.append("<tr>\n");
              sb.append("<tr>\n");
            
              for (ITestResult failedresult : failedArrayList)
              {
          	   if(sb.length()!=0){
                  sb.append("\r\n");
                  }
          	 float t=failedresult.getEndMillis()-failedresult.getStartMillis();
          	 sb.append("<tr>")
          	   .append("<td width=\"440\">"+failedresult.getMethod().getDescription()+"</td>\n")
               .append(" ")
               .append("<td width=\"155\">"+failedresult.getTestClass().getRealClass().getName()+"</td>\n")
               .append(" ")
               .append("<td width=\"134\">"+this.formatDate(failedresult.getStartMillis())+"</td>\n")
               .append(" ")
               .append("<td width=\"87\">"+Float.toString(t)+"毫秒"+"</td>\n")
               .append("<td width=\"84\">"+this.getStatus(failedresult.getStatus())+"</td>\n")
               .append("</tr>\n");
          	   
             }
              
              sb.append("</table>\n</div>\n</body>\n</html>\n");

            output.write(sb.toString());
            output.flush();
            output.close();
        } catch (IOException e) {          
            e.printStackTrace();
        }
         
    }
     
    private String getStatus(int status){
        String statusString = null;
        switch (status) {      
        case 1:
            statusString = "Passed";
            break;
        case 2:
            statusString = "Failed";
            break;
        case 3:
            statusString = "Skiped";
            break;
        default:           
            break;
        }
        return statusString;
    }
     
    private String formatDate(long date){     
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return formatter.format(date);
    }
 
}