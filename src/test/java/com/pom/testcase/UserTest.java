package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.AddUserPage;

public class UserTest extends TestBase {

	public static AddUserPage au;
	
	@Test(priority = 1)
	public void verify_printTable() {
		Assert.assertTrue(DashboardTest.up.verify_UserTable());
	}
	
	@Test(priority = 2)
	public void verify_gender() {
		Assert.assertTrue(DashboardTest.up.printGenderNameUserName());
	}
	
	@Test(priority = 3)
	public void verify_verifyUnameAndGenderwithExcel() {
		Assert.assertTrue(DashboardTest.up.verifyUnameAndGenderwithExcel());
	}
	
	@Test(priority = 4)
	public void verify_emailCode() {
		Assert.assertTrue(DashboardTest.up.verifyEmailCode());
	}
	
	@Test(priority = 5)
	public void verify_clickAddUser() {
		au = DashboardTest.up.clickAddUser();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Add User" );
	}
}
