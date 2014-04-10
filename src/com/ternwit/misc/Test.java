package com.ternwit.misc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.dom4j.DocumentException;

public class Test {

	public static void main(String[] args) throws Exception {
		new Test().changeToTh();
	//	new Test().changeToDev();
	}
	
	public void changeToTh() throws DocumentException, IOException{
		SimpleXMLEditor editor = new SimpleXMLEditor();
		//edit HBM
		String inputPath = "src/com/ternwit/tms/entity/";
		String elementName = "class";
		String attributeName = "catalog";
		String oldAttributeValue = "tms2dev";
		String newAttributeValue = "tms2th";
		String outputPath = inputPath;
		editor.edit(inputPath, elementName, attributeName,
				oldAttributeValue, newAttributeValue, outputPath);
	
		//edit APP
		String filePath = "src/jdbc.properties";
		String url = "192.168.1.175:3306";
		String DBName = newAttributeValue;
		String userName = "root";
		String password = "123456";
		
		
		//jdbc:mysql://192.168.1.199:3306/tms2th?characterEncoding=utf8
		String fullUrl = "jdbc:mysql://" + url + "/" + DBName + "?characterEncoding=utf8";
		Test.writeProperties(filePath, "url", fullUrl);
		Test.writeProperties(filePath, "username", userName);
		Test.writeProperties(filePath, "password", password);
		System.out.println("Property file modify successfully!!");
	}
	
	public void changeToDev() throws DocumentException, IOException{
		SimpleXMLEditor editor = new SimpleXMLEditor();
		//edit HBM
		String inputPath = "src/com/ternwit/tms/entity/";
		String elementName = "class";
		String attributeName = "catalog";
		String oldAttributeValue = "tms2th";
		String newAttributeValue = "tms2dev";
		String outputPath = inputPath;
		editor.edit(inputPath, elementName, attributeName,
				oldAttributeValue, newAttributeValue, outputPath);
	
		//edit APP
//		String filePath = "src/applicationContext.xml";
//		String url = "192.168.1.199:3306";
//		String DBName = newAttributeValue;
//		String userName = "root";
//		String password = "123456";
//		editor.modifyAppXmlWithDataBase(filePath, url, DBName, userName, password);
		
		String filePath = "src/jdbc.properties";
		String url = "192.168.1.175:3306";
		String DBName = newAttributeValue;
		String userName = "root";
		String password = "123456";
		System.out.println("Property file modify successfully!!");
		
		
		//jdbc:mysql://192.168.1.199:3306/tms2th?characterEncoding=utf8
		String fullUrl = "jdbc:mysql://" + url + "/" + DBName + "?characterEncoding=utf8";
		Test.writeProperties(filePath, "url", fullUrl);
		Test.writeProperties(filePath, "username", userName);
		Test.writeProperties(filePath, "password", password);
	}
	
	public static void writeProperties(String filePath,String parameterName,String parameterValue) {
		Properties prop = new Properties();
		try {
			InputStream fis = new FileInputStream(filePath);
				        //从输入流中读取属性列表（键和元素对）
			prop.load(fis);
			//调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
			//强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(parameterName, parameterValue);
			//以适合使用 load 方法加载到 Properties 表中的格式，
			//将此 Properties 表中的属性列表（键和元素对）写入输出流
			prop.store(fos, "Update '" + parameterName + "' value");
		} catch (IOException e) {
			System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");
	    }
	}
}
