package com.ternwit.common.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import com.ternwit.common.CommonConstants;
import com.ternwit.common.PropertiesManager;

/**
 * 
 * @version 1.2
 * v1.1 add 
 *			public String getFileEncoding(String url) 
 * v1.2 add 
 * 			public String escapeUnicode(String unicodeStr)
 * 			public Properties getPropertiesManager(String propertiesFile)
 */
public final class TWTFileUtils {

	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;

	private FileWriter fileWriter = null;
	private BufferedWriter bufferedWriter = null;
	
	/**
	 * @return an instance of FileReader
	 */
	public FileReader getFileReader(String url) {
		
		try {
			fileReader = new FileReader(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileReader;
	}

	/**
	 * @return an instance of FileReader
	 * @param append true: append file, false: overwrite file
	 */
	public FileWriter getFileWriter(String url, boolean append) {
		try {
			fileWriter = new FileWriter(url, append);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileWriter;
	}

	/**
	 * @param url
	 * @return an instance of BufferedReader
	 */
	public BufferedReader getBufferedReader(String url) {

		fileReader = getFileReader(url);
		bufferedReader = new BufferedReader(fileReader);

		return bufferedReader;
	}

	/**
	 * @param append true: append file, false: overwrite file
	 * @return an instance of BufferedWriter
	 */
	public BufferedWriter getBufferedWriter(String url, boolean append) {

		fileWriter = getFileWriter(url, append);
		bufferedWriter = new BufferedWriter(fileWriter);

		return bufferedWriter;
	}

	private void closeReader() {
		if (null != bufferedReader) {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (null != fileReader) {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeWriter() {
		if (null != bufferedWriter) {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (null != fileWriter) {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeFile(String content, String url) {

		/*
		 * append is false, overwrite original file
		 */
		bufferedWriter = getBufferedWriter(url, false);

		try {
			bufferedWriter.write(content);
			bufferedWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		closeWriter();
	}

	public void appendFile(String content, String url) {

		/*
		 * append is true, append original file
		 */
		bufferedWriter = getBufferedWriter(url, true);

		try {
			bufferedWriter.write(content);
			bufferedWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		closeWriter();
	}

	/**
	 * @return file content
	 */
	public String readFileToString(String url) {

		String temp = CommonConstants.EMPTYSTRING;
		String content = CommonConstants.EMPTYSTRING;

		try {
			bufferedReader = getBufferedReader(url);
			while (null != (temp = bufferedReader.readLine())) {
				content = content + temp + "\r\n";
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		closeReader();

		return content;
	}

	/*
	 * This method uses icu4j lib to detect file encoding but it will make
	 * mistake. If confidence is less than 50 will return UTF-8 as default
	 * encoding, but most time this is not correct. icu4j detect encoding
	 * according to file content, seems first 8000 characters
	 * 
	 * added in version 1.1
	 */
	/**
	 * @return encoding String
	 */
	public String getFileEncoding(String url) {
		String encoding = "UTF-8";
		int confidence = 50;
		try {
			CharsetDetector detector = new CharsetDetector();
			InputStream inputStream = new BufferedInputStream(
					new FileInputStream(new File(url)));
			detector.setText(inputStream);
			CharsetMatch match = detector.detect();
			confidence = match.getConfidence();
			if (confidence >= 50) {
				encoding = match.getName();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return encoding;
	}

	/*
	 * This method accept Unicode String as parameter, for example \u8521\u94ee
	 * and escape this String value into original value for example Chinese
	 * characters. It is NOT well TESTED
	 * 
	 * added in version 1.2
	 */
	/**
	 * @return escaped string value
	 */
	public String escapeUnicode(String unicodeStr) {
		String resultStr = CommonConstants.EMPTYSTRING;
		
		/*
		 * validate if input parameter unicodeStr is really a unicode String
		 * if not start with \\, return original String
		 */
		if (!unicodeStr.startsWith("\\")) {
			resultStr = unicodeStr;
			return resultStr;
		}
		
		try {
			StringReader stringReader = new StringReader(unicodeStr);
			UnicodeUnescapeReader unicodeUnescapeReader = new UnicodeUnescapeReader(stringReader);

			StringBuffer stringBuffer = new StringBuffer(); 
			for(int c = unicodeUnescapeReader.read(); c != -1; c = unicodeUnescapeReader.read())
			{ 
				stringBuffer.append((char)c); 
			} 
			resultStr = stringBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultStr;
	}
	
	/*
	 * This method returns an instance of Properties with properties file loaded.
	 * This method requires properties file included in class folder.
	 * To include a properties file in class folder, right click on project, build path, 
	 * Argument propertiesFile can be properties file name, full path is NOT required
	 * 
	 * added in version 1.2
	 */
	/**
	 * @return returns an instance of PropertiesManager 
	 */
	public Properties getProperties(String propertiesFile) {
		PropertiesManager manager = PropertiesManager.getInstance();
		Properties properties = manager.loadProperties(propertiesFile);
		return properties;
	}
	
}
