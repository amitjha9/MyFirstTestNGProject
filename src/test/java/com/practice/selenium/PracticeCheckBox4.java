package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeCheckBox4 {

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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		

		//boolean flag=false;
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox' and @class='cb1-element']"));
		int size = checkBox.size();
        System.out.println("Size is:" +size);
		for(int i=0; i<size; i++)
		{
			String val=checkBox.get(i).getText();
			System.out.println("Value is:" +val);
		}

		Thread.sleep(3000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		PracticeCheckBox4 pc = new PracticeCheckBox4();
		pc.testCheckBox();
	}

}
