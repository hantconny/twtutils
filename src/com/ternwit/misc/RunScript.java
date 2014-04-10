package com.ternwit.misc;

import java.io.IOException;
import java.util.Scanner;

import org.dom4j.DocumentException;

public class RunScript {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException, IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your database url");
		String url = scanner.nextLine();
		
		System.out.println("Please enter your database name");
		String databaseName = scanner.nextLine();
		
		System.out.println("Please enter your database user name");
		String userName = scanner.nextLine();
		
		System.out.println("Please enter your database password");
		String password = scanner.nextLine();
		
		SimpleXMLEditor editor = new SimpleXMLEditor();
		//edit HBM
		String inputPath = "src/com/ternwit/tms/entity/";
		String elementName = "class";
		String attributeName = "catalog";
		String oldAttributeValue = "tms2th";
		String newAttributeValue = databaseName;
		String outputPath = inputPath;
		editor.edit(inputPath, elementName, attributeName,
				oldAttributeValue, newAttributeValue, outputPath);
	
		//edit APP
		String filePath = "src/applicationContext.xml";
		String DBName = databaseName;
		editor.modifyAppXmlWithDataBase(filePath, url, DBName, userName, password);
	}

}
