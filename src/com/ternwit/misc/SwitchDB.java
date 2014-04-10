package com.ternwit.misc;

import java.io.IOException;

import org.dom4j.DocumentException;

public class SwitchDB {

	public static void main(String[] args) throws Exception {
		new Test().changeToTh();
//		new Test().changeToDev();
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
		String filePath = "src/applicationContext.xml";
		String url = "192.168.1.199:3306";
		String DBName = newAttributeValue;
		String userName = "root";
		String password = "123456";
		editor.modifyAppXmlWithDataBase(filePath, url, DBName, userName, password);
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
		String filePath = "src/applicationContext.xml";
		String url = "192.168.1.199:3306";
		String DBName = newAttributeValue;
		String userName = "root";
		String password = "123456";
		editor.modifyAppXmlWithDataBase(filePath, url, DBName, userName, password);
	}

}
