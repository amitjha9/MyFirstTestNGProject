package com.practice.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GoogleTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUP()
	{
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		//driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=2,groups="Title")
	public void googleTitleTest()
	{
		String googleTitle=driver.getTitle();
		System.out.println("Title is:" +googleTitle);
	}
	
	@Test(priority=1,groups="Logo")
	public void googleLogoTest()
	{
		boolean flag=driver.findElement(By.xpath("//img[@class=\"lnXdpd\"]")).isDisplayed();
		if(flag)
		{
			System.out.println("google logo found");
		}
	}
	
	@Test(priority=3,groups="Link")
	public void googleGmailLinkTest()
	{
		boolean flag=driver.findElement(By.xpath("//a[text()=\"Gmail\"]")).isDisplayed();
		if(flag)
		{
			System.out.println("Gmail link found");
		}
	}
	
	@Test(priority=4,groups="Test")
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test(priority=5,groups="Test")
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(priority=6,groups="Test")
	public void test3()
	{
		System.out.println("test3");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
