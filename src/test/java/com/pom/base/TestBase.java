package com.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pom.utilies.ReadConfigFile;

public class TestBase {

	public static WebDriver driver = null;
	
	public WebDriver initialization() {
		driver = new ChromeDriver();
		driver.get(ReadConfigFile.readConfig("url"));
		return driver;
	}
	
}
