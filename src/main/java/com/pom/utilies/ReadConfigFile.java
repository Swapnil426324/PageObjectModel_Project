package com.pom.utilies;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

	public static String readConfig(String key) {
		String path = System.getProperty("user.dir")+"/src/main/resources/Config.properties";
		FileInputStream fis = null;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
