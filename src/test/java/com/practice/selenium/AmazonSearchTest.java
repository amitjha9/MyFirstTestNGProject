package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest {
	
	public static WebDriver driver;
	
	public void amazonSearchTest() throws InterruptedException
	{
		String url="https://www.amazon.in/";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		String searchString="iphone 12";
		WebElement searchText=driver.findElement(By.xpath("//input[@type='text']"));
		searchText.sendKeys(searchString);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='suggestions-template']//div/descendant::span[@class='s-heavy']"));
		int totalSearch=list.size();
		System.out.println("Total search list are:" +totalSearch);
		
		//Now print all the search value
		for(int i=0; i<totalSearch; i++)
		{
			String searchValue = list.get(i).getText();
			String xpathValue=searchString+" "+searchValue;
			System.out.println("Total Search are============>" +xpathValue);
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		AmazonSearchTest ast = new AmazonSearchTest();
        ast.amazonSearchTest();
	}

}
