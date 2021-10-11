package com.practice.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeCheckBox3 {
	
	public static WebDriver driver;
	
	public void testCheckBox() throws InterruptedException
	{
		String url="https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		
		boolean flag=false;
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox' and @id='isAgeSelected']"));
		if(!checkBox.isSelected())
		{
			checkBox.click();
			flag=true;
		}
		
		String actualText="Success - Check box is checked";
		if(flag==true)
		{
			WebElement validation = driver.findElement(By.xpath("//div[contains(text(),'Success - Check box is checked')]"));
			String getText = validation.getText();
			System.out.println("Text is:" +getText);
			Assert.assertEquals(getText, actualText);
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		PracticeCheckBox3 pc = new PracticeCheckBox3();
        pc.testCheckBox();
	}
}
