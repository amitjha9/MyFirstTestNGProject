package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchWithoutTextTest {

	public static WebDriver driver;

	public void searchGoogleWithoutTextTest() throws InterruptedException
	{
		try {
			String url="https://www.google.com/";
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);

			WebElement searchText = driver.findElement(By.xpath("//input[@type='text']"));
			searchText.click();

			boolean flag=false;
			String actualText="covid 19 coronavirus cases";
			List<WebElement> searchItem = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
			int size = searchItem.size();

			//Print the complete list here
			for(int i=0; i<size; i++)
			{
				String data = searchItem.get(i).getText();
				System.out.println("Values are:========>:" +data);
			}

			for(int i=0; i<size; i++)
			{
				String text = searchItem.get(i).getText();
				if(text.equals(actualText))
				{
					System.out.println("Text is:" +text);
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("Test has passed successfully");
			}
			else {
				System.out.println("Test has failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		GoogleSearchWithoutTextTest test = new GoogleSearchWithoutTextTest();
		test.searchGoogleWithoutTextTest();
	}
}
