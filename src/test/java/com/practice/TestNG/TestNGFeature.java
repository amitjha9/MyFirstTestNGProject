package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestNGFeature {

	@Test
	public void loginTest()
	{
		try {
			System.out.println("Login into application");
			int a=9;
			int b=a/0;
			System.out.println("Value of b is:" +b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=2,dependsOnMethods="loginTest")
	public void registerPageTest()
	{
		System.out.println("Register page test");
	}

	@Test(priority=3,dependsOnMethods="loginTest")
	public void searchPageTest()
	{
		System.out.println("Search page test");
	}

	@Test(priority=4)
	public void contactPageTest()
	{
		System.out.println("Contact page test");
	}
}
