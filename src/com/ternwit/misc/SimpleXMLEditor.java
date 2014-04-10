package com.ternwit.misc;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.ternwit.common.basic.TWTStringUtils;

public class SimpleXMLEditor {
	
	/**
	 * @author Cai, Alex Zou
	 * @param inputPath
	 * @param elementName
	 * @param attributeName
	 * @param oldAttributeValue
	 * @param newAttributeValue
	 * @param outputPath
	 * @throws DocumentException
	 * @throws IOException
	 */
	
	public void edit(String inputPath, String elementName, String attributeName,  String oldAttributeValue, String newAttributeValue, String outputPath) throws DocumentException, IOException {
		/* if inputPath is null or empty
		 * return */
		if (TWTStringUtils.isBlank(inputPath)) {
			return;
		}
		/* if inputPath does not end with forward slash
		 * append a forward slash on it */
		
		if (!TWTStringUtils.endsWithForwardSlash(inputPath)) {
			inputPath += "/";
		}
		/* if outputPath is null or empty
		 * make a directory outputXMLs under input path */
		if (TWTStringUtils.isBlank(outputPath)) {
			outputPath = inputPath + "outputXMLs/";
		}
		/* if outputPath does not end with a forward slash
		 * append a forward slash on it */
		if (!TWTStringUtils.endsWithForwardSlash(outputPath)) {
			outputPath += "/";
		}
		
		File dir = new File(inputPath);
		
		if (!dir.isDirectory()) {
			return;
		}
		
		/* this filter will return all files end with .hbm.xml */
		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				String fileName = file.getName().toLowerCase();
				if (fileName.endsWith(".hbm.xml")) {
					return true;
				}
				return false;
			}
			
		});
		
		System.out.println("Success find HBM directory!!There are " + files.length + " will be processed.");
		
		int remained = files.length;
		
		String tempInputPath = "";
		String tempOutputPath = "";
		
		for (File file : files) {
			
			tempInputPath = inputPath + file.getName();
			Document doc = parse(tempInputPath);
			
			tempOutputPath = outputPath + file.getName();
			
			modify(doc, elementName, attributeName, oldAttributeValue, newAttributeValue, tempOutputPath);
			System.out.println(file.getName() + " processed successfully.");
			System.out.println("remained: "+(--remained));
		}
		System.out.println("All HBM files process completed!");
		
	}
	
	/**
	 * @author Cai
	 * @param filePath
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	private Document parse(String filePath) throws DocumentException, IOException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new FileInputStream(filePath));
		return document;
	}

	/**
	 * @author Cai
	 * @param document
	 * @param elementName
	 * @param attributeName
	 * @param oldAttributeValue
	 * @param newAttributeValue
	 * @param exportPath
	 * @throws IOException
	 */
	private void modify(Document document, String elementName, String attributeName, String oldAttributeValue, String newAttributeValue, String outputPath) throws IOException {
		/* get root element */
		Element root = document.getRootElement();
		/* get required element node */
		Element element = root.element(elementName);
		/* get required attribute node */
		Attribute attribute = element.attribute(attributeName);
		
		/* if old attribute value the same as new attribute value
		 * return */
		if (oldAttributeValue.equalsIgnoreCase(newAttributeValue)) {
			return;
		}
		
		/* set new attribute value to attribute node */
		attribute.setValue(newAttributeValue);
		
		/* declare a format */
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		/* check if output directory is exist */
		File exportDir = new File(outputPath.substring(0, outputPath.lastIndexOf("/")));
		
		if (!exportDir.exists()) {
			exportDir.mkdir();
		}
		
		XMLWriter writer = new XMLWriter(new FileWriter(new File(outputPath)), format);
		writer.write(document);
		writer.close();
	}
	
	/**
	 * @author Alex
	 * @param attributeName
	 * @param oldAttributeValue
	 * @param newAttributeValue
	 * @param exportPath
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyAppXmlWithDataBase(String filePath, String url, 
			String DBName, String userName, String password) 
	throws DocumentException, IOException {
		Document appDocument = this.parse(filePath);
		System.out.println("Success find applicationContext.xml!!");
		Element temp = null;
		//modify DataBase address
		List<Node> nodes = appDocument.selectNodes("//*[@name='url']");
		Iterator<Node> iterator = nodes.iterator();
		if(iterator.hasNext()) {
			temp = (Element)iterator.next();
			//jdbc:mysql://192.168.1.199:3306/tms2th?characterEncoding=utf8
			String dbAddress = "jdbc:mysql://" + url + "/" + DBName + "?characterEncoding=utf8";
			temp.attribute("value").setValue(dbAddress);
		}
		
		//modify user name value
		nodes = appDocument.selectNodes("//*[@name='username']");
		iterator = nodes.iterator();
		if(iterator.hasNext()) {
			temp = (Element)iterator.next();
			temp.attribute("value").setValue(userName);
		}
		
		//modify password
		nodes = appDocument.selectNodes("//*[@name='password']");
		iterator = nodes.iterator();
		if(iterator.hasNext()) {
			temp = (Element)iterator.next();
			temp.attribute("value").setValue(password);
		}
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileWriter(new File(filePath)), format);
		writer.write(appDocument);
		writer.close();
		System.out.println("ApplicationContext.xml process completed!!!");
	}
}
