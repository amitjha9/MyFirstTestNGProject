package com.practice.TestNG;

import org.testng.annotations.Test;

public class TestNGGroupFeature {
	
	@Test(groups="Regression",priority=1)
	public void loginTest()
	{
		System.out.println("Login Test");
		//int a=10;
		//int b = a/0;
	}
	
	@Test(dependsOnGroups="Regression",priority=2)
	public void registerTest()
	{
		System.out.println("Register Test");
	}
	
	@Test(description="This test is depends on above group", dependsOnGroups="Regression",priority=3)
	public void searchTest()
	{
		System.out.println("Search Test");
	}
	
	@Test(dependsOnGroups="Regression",priority=4)
	public void contactTest()
	{
		System.out.println("Contact Test");
	}
	
	@Test(dependsOnGroups="Regression",priority=5)
	public void addToCartTest()
	{
		System.out.println("Add to cart page");
	}
	
	@Test(dependsOnGroups="Regression",priority=6)
	public void paymentTest()
	{
		System.out.println("Payment test");
	}
	
	@Test(description="This is for performance testing", priority=7, groups="Performance")
	public void doMultipleLoginTest()
	{
		System.out.println("Multiple login success");
	}
	
	@Test(priority=8, dependsOnGroups="Performance")
	public void createMultipleUserTest()
	{
		System.out.println("Multiple user create success");
	}
	
	@Test(priority=9,dependsOnGroups="Performance")
	public void searchMultipleTest()
	{
		System.out.println("Search multiple test success");
	}
}
