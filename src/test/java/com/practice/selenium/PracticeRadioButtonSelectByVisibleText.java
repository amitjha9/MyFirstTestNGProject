package com.practice.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeRadioButtonSelectByVisibleText {
	
	public static WebDriver driver;
	
	public void testRadioButtonByVisibleText() throws InterruptedException
	{
		String url="https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		int count=0;
		String toBeSelected = "Tuesday";
		String toBeValidated="Day selected :- "+toBeSelected+"";
		WebElement dropDown = driver.findElement(By.id("select-demo"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Tuesday");
		
		WebElement validation = driver.findElement(By.xpath("//p[contains(text(),'Day selected :- "+toBeSelected+"')]"));
		String testOutPut=validation.getText();
		
		if(testOutPut.equals(toBeValidated))
		{
			count++;
		}
		
		if(count!=0)
		{
			System.out.println("Test has passed successfully");
		}
		else {
			System.out.println("Test has failed");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		PracticeRadioButtonSelectByVisibleText pd = new PracticeRadioButtonSelectByVisibleText();
        pd.testRadioButtonByVisibleText();
	}

}
