package com.testNG.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParameterTest {
	
	public static WebDriver driver;
	@BeforeMethod
	@Parameters({"url"})
	public void setUP(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@Test
	@Parameters({"email","password"})
	public void automationAppLoginTest(String emailID, String passwd)
	{
		driver.findElement(By.xpath("//a[@class=\"login\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@id=\"passwd\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"passwd\"]")).sendKeys(passwd);
		driver.findElement(By.xpath("//button[@id=\"SubmitLogin\"]"));
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		if(driver!=null)
		{
			Thread.sleep(2000);
			driver.quit();
		}
	}

}
