package com.ternwit.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * Audit Log
 * 2012-01-31 This class is created by Jobn Doe (can NOT remember his name)
 * 
 * */
/*
 * load properties file by name
 * full path is NOT required 
 * */
public class PropertiesManager {
	private static volatile PropertiesManager INSTANCE;

	protected PropertiesManager() {

	}

	public synchronized Properties loadProperties(String propertiesFile) {

		Properties properties = new Properties();
		try {
			InputStream in = PropertiesManager.class.getClassLoader()
					.getResourceAsStream(propertiesFile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return properties;

	}

	private static synchronized PropertiesManager tryCreateInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PropertiesManager();
		}
		return INSTANCE;
	}

	public static PropertiesManager getInstance() {
		PropertiesManager manager = INSTANCE;
		if (manager == null) {
			manager = tryCreateInstance();
		}
		return manager;
	}

}