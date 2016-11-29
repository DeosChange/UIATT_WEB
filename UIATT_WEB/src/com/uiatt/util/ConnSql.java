package com.uiatt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnSql {
	private static Connection conn;
	private static Statement st;
	
	/**
	 * 数据库查询
	 * @param tableName	表名
	 * @param columnName 条件_列名
	 * @param value	条件_值
	 * @param column 要显示的列
	 */
	public static void selectSql(String tableName, String columnName, String value, String column){	
		try {       
            st = conn.createStatement();    											//创建用于执行静态sql语句的Statement对象，st属局部变量              
            ResultSet rs = st.executeQuery("SELECT * FROM " + tableName + " WHERE " + 				//执行sql查询语句，返回查询数据的结果集  
            							columnName + " = '" + value + "'");                
            while (rs.next()){
            	System.out.println(rs.getString(column));
            }           
          conn.close();       
          
        } catch (SQLException e) {  
            System.out.println("查询数据失败" + e.getMessage());  
        }  
	}	
	
	/**
	 * 数据库删除
	 * @param tableName	表名
	 * @param columnName 条件_列名
	 * @param value	条件_值
	 */
	public static void deleteSql(String tableName, String columnName, String value) {
		try {       
            st = conn.createStatement();    											            
            st.execute("DELETE FROM " + tableName + " WHERE " + 									//执行删除语句 
            		columnName + " = '" + value + "'");    											    
            conn.close();        
            
        } catch (SQLException e) {  
            System.out.println("删除数据失败" + e.getMessage());  
        }  
	}
	
	/**
	 * 创建数据库连接
	 * @param url	jdbc:mysql://localhost:3306/change
	 * @param username	数据库用户名
	 * @param password	数据库密码
	 */
	public static void connSql(String url, String username, String password) {  																		
        try {  
            Class.forName("com.mysql.jdbc.Driver");													// 加载Mysql数据驱动               
            conn = DriverManager.getConnection(url, username, password);								// 创建数据库连接           
            
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  												
    } 
	
	@Test
	public static void main(String args[]){
		connSql("jdbc:mysql://127.0.0.1:3306/uiatt_platform", "manager_conn", "changetest"); 
//		selectSql("py_books", "filename", "temp", "filepath");
		deleteSql("py_books", "filename", "temp");
	}
	
}
