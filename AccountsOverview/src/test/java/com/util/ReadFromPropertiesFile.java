package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ReadFromPropertiesFile {
	private Properties properties;
	private final String propertyFilePath = "D:\\Eclipse\\ExcelRWorkspace\\ParaBank\\AccountsOverview\\src\\resources\\Config.properties";

	public ReadFromPropertiesFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();

			properties.load(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			;
		}
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		return url;
	}
	
	public String getBrowserType() {
		String browserType = properties.getProperty("browser");
		return browserType;
	}
	
	public String testDataInputPath() {
		String testDataPath = properties.getProperty("testDataPath");
		return testDataPath;
	}
}
