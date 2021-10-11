package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	public static WebDriver driver;
	
	public void googleSearchTest() throws InterruptedException
	{
		String url="https://www.google.com/";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		WebElement searchText = driver.findElement(By.xpath("//input[@type='text']"));
		searchText.sendKeys("python");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		int totalSearch=list.size();
		System.out.println("Total number of search is:" +totalSearch);
		
		//Now print one by one value
		for(int i=0; i<totalSearch; i++)
		{
			String value = list.get(i).getText();
			System.out.println("Values from the search list are==========>" +value);
		}
		Thread.sleep(3000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		GoogleSearchTest gst = new GoogleSearchTest();
		gst.googleSearchTest();

	}

}
