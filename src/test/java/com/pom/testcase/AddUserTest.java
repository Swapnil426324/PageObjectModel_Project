package com.pom.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestBase;

public class AddUserTest extends TestBase{

	@Test
	public void verify_AddUser() {
		Assert.assertEquals(UserTest.au.addUser(), "User Added Successfully. You can not see added user.");
	}
}
