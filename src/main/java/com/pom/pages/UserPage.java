package com.pom.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.utilies.ExcelUtils;

public class UserPage {

	WebDriver driver;

	@FindBy(xpath = "//tr")
	private List<WebElement> tRow;

	@FindBy(xpath = "//td[6]")
	private List<WebElement> genders;
	
	@FindBy(xpath = "//td[2]")
	private List<WebElement> unamesColumn;
	
	@FindBy(xpath = "//td[3]")
	private List<WebElement> emailColumn;
	
	@FindBy(xpath = "//button[text()='Add User']")
	private WebElement clickAddUser;

	
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// verify tables
	public boolean verify_UserTable() {
		List<WebElement> list = null;
		List<String> actualTableData = new ArrayList<String>();
		for (WebElement row : tRow) {		
			if (tRow.indexOf(row) == 0) {				
				list = row.findElements(By.tagName("th"));
			} else {
				list = row.findElements(By.tagName("td"));
			}
			for (WebElement data : list) {
				actualTableData.add(data.getText());
			}
		}
		
		ArrayList<String> exceptedTableData = new ArrayList<>();
		for(int i=0;i<5;i++) {
			for(int j=0;j<8;j++) {
				String exp = ExcelUtils.excelRead("LoginData", "UserPage", i, j);
				exceptedTableData.add(exp);
			}
		}
		
		System.out.println("Actual Table Data "+actualTableData);
		System.out.println("Excepted Table Data "+exceptedTableData);
		
		if(actualTableData.equals(exceptedTableData)) {
			return true;
		}
		return false;
	}
	
	

	// check uname and gender from excel file
	public boolean verifyUnameAndGenderwithExcel() {
		HashMap<Integer, List<String>> actualHm = new HashMap<Integer, List<String>>();
		List<String> al = null ;
		for (int i = 0; i < unamesColumn.size(); i++) {
			String uname = unamesColumn.get(i).getText();
			String gender = genders.get(i).getText();
            al = new ArrayList<String>();
			al.add(uname);
			al.add(gender);		
		}

		HashMap<Integer, List<String>> expHm = new HashMap<Integer, List<String>>();
		for(int j=1 ;j<4;j++) {
			String uname = ExcelUtils.excelRead("LoginData", "UserPage", j, 1);
			String gender = ExcelUtils.excelRead("LoginData", "UserPage",j, 5);
			al = new ArrayList<String>();
			al.add(uname);
			al.add(gender);
		}
		
		if(actualHm.equals(expHm)) {
			return true;
		}	
		return false;	
	}
	
	
	
	// check email code e.g. gmail.com
	public boolean verifyEmailCode() {
	   for(WebElement element : emailColumn) {
		   String text = element.getText();
		   if(text.contains("gmail.com")) {
			   return true;
		   }else {
			   return false;
		   }
	   }
		return false;
	}

	
	
	//print gender and Names
	public boolean printGenderNameUserName() {
		ArrayList<String> gender = new ArrayList<String>();
		String str = null;
		
		for(int i=0;i<genders.size();i++) {
			 str = genders.get(i).getText();
			String names = unamesColumn.get(i).getText();
			System.out.println("Names is : "+names +" And Gender is: "+str);
//			boolean value = str.equals("Male") || str.equals("Female");
			gender.add(str);
		}
		if(str.equals("Male") || str.equals("Female")) {
			return true;
		}
		return false;
	}
	
	
	public AddUserPage clickAddUser()  {
		clickAddUser.click();
		return new AddUserPage(driver);
	}
}
