package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.UserPage;

public class DashboardTest extends TestBase{
	
	public static UserPage up;
	
	@Test(priority = 1)
	public void verify_CourseList() {
		Assert.assertTrue(LoginTest.dp.checkAllCoures());
	}
	
	@Test(priority = 2)
	public void verify_ClickUserBTN() {
		up = LoginTest.dp.clickUsers();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}
	
}
