package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.utilies.ReadConfigFile;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(id = "email")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button")
	private WebElement signBTN;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	 
	}
	
	public void typeUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void typePassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSignBTN() {
		signBTN.click();
	}
	
	public DashboardPage validLogin() {
		typeUsername(ReadConfigFile.readConfig("username"));
		typePassword(ReadConfigFile.readConfig("password"));
		clickSignBTN();
		return new DashboardPage(driver);
	}
}
