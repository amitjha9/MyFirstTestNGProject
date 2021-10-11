package com.practice.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {
	
	/*
	 * 
	 * Output
	 * This is before suite
       This is before test
       This is before class
       This is before method
       This is test case method
       This is after method
       This is after class
       This is after test
       PASSED: testNGTest
	 * 
	 * Pre-conditions annotation start with @Before and post conditions annotation start with @After annotation. 
	 * 
	 */
	
	@BeforeSuite
	public void setUP()
	{
		System.out.println("Set up system property for chrome");
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("Launch chrome browser");
	}
	
	@BeforeClass
	public void login()
	{
		System.out.println("Login into application");
	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("Entered URL");
	}
	
	@Test
	public void googleTitleTest()
	{
		System.out.println("Google title test");
	}
	
	@Test
	public void googleLogoTest()
	{
		System.out.println("Google logo test");
	}
	
	@Test(priority=1)
	public void searchPageTest()
	{
		System.out.println("Search page test");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("Log out from application");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close chrome browser");
	}

	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("Delete all cookies");
	}
}
