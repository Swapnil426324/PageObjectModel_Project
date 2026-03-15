package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.DashboardPage;
import com.pom.pages.LoginPage;
import com.pom.pages.UserPage;

public class LoginTest extends TestBase{

	LoginPage lp = null;
	public static DashboardPage dp = null;
	UserPage up = null;

	@BeforeSuite
	public void setUp() {
		driver = initialization();
		lp = new LoginPage(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void verify_Login() {
		dp = lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test(priority = 2, enabled = false)
	public void verify_ClickUserBTN() {
		up = dp.clickUsers();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}
	
	@Test(priority = 3, enabled = false)
	public void verify_printTable() {	
		Assert.assertTrue(up.verify_UserTable());
	}

}
