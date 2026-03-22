package com.pom.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.utilies.ExcelUtils;
import com.pom.utilies.SelectRadioOption;
import com.pom.utilies.SelectUtils;

public class AddUserPage {

	WebDriver driver;

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "mobile")
	private WebElement mobile;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "course")
	private WebElement course;

	@FindBy(xpath = "//input[@name='gender']")
	private List<WebElement> genders;

	@FindBy(tagName = "select")
	private WebElement state;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "submit")
	private WebElement submitBTN;

	// constructor
	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// methods
	public void typeUsername(String uname) {
		username.sendKeys(uname);
	}

	public void typeMobile(String moNO) {
		mobile.sendKeys(moNO);
	}

	public void typeEmail(String email) {
		this.email.sendKeys(email);
	}

	public void typeCourse(String course) {
		this.course.sendKeys(course);
	}

	public void selectGender(String text) {
		SelectRadioOption.selectRadios(genders, text);
	}

	public void selectState(String text) {
		SelectUtils.selectDropdown(state, text);
	}

	public void typePassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickSubmit() {
		submitBTN.click();
	}

	public String addUser() {
		String actualText = null;
		for (int i = 1; i <= 4; i++) {
			typeUsername(ExcelUtils.excelRead("LoginData", "Sheet2", i, 0));
			typeMobile(ExcelUtils.excelRead("LoginData", "Sheet2", i, 1));
			typeEmail(ExcelUtils.excelRead("LoginData", "Sheet2", i, 2));
			typeCourse(ExcelUtils.excelRead("LoginData", "Sheet2", i, 3));
			selectGender(ExcelUtils.excelRead("LoginData", "Sheet2", i, 4));
			selectState(ExcelUtils.excelRead("LoginData", "Sheet2", i, 5));
			typePassword(ExcelUtils.excelRead("LoginData", "Sheet2", i, 6));
			clickSubmit();
			Alert al =driver.switchTo().alert();
			actualText = al.getText();
			al.accept();
			System.out.println(actualText);
		}
		return actualText;
	}
}
