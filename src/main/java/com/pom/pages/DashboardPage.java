package com.pom.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.utilies.ExcelUtils;

public class DashboardPage {

	WebDriver driver;
	
	@FindBy(tagName = "h3")
	private List<WebElement> coursesList;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement clickusers;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkAllCoures() {
		List<String> actaulCourseList = new ArrayList<>();
		List<String> expectedCourseList = new ArrayList<>();
		for(WebElement course : coursesList) {
			String courseText = course.getText();
			actaulCourseList.add(courseText);
		}
		
		for(int i=1;i<=4;i++) {
			for(int j=0;j<1;j++) {
				String expectedCourseText = ExcelUtils.excelRead("LoginData", "DashboardTest", i, j);
				expectedCourseList.add(expectedCourseText);
			}
		}
		
		System.out.println("Actual Course Text >> "+actaulCourseList);
		System.out.println("Expected Course Text >> "+expectedCourseList);
		if(actaulCourseList.equals(expectedCourseList)) {
			return true;
		}
		return false;	
	}
	
	public UserPage clickUsers() {
		clickusers.click();
		return new UserPage(driver);
	}
}
