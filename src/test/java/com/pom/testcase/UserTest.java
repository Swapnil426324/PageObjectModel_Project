package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestBase;

public class UserTest extends TestBase {

	@Test
	public void verify_printTable() {
		Assert.assertTrue(DashboardTest.up.verify_UserTable());
	}
	
	@Test
	public void verify_gender() {
		Assert.assertTrue(DashboardTest.up.printGenderNameUserName());
	}
	
	@Test
	public void verify_verifyUnameAndGenderwithExcel() {
		Assert.assertTrue(DashboardTest.up.verifyUnameAndGenderwithExcel());
	}
}
