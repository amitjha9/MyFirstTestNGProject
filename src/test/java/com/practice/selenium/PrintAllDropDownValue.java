package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllDropDownValue {
	
	public static WebDriver driver;
	
	public List<WebElement> getAllDropDownValue()
	{
		String url="https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		WebElement dropDown = driver.findElement(By.id("select-demo"));
		Select select = new Select(dropDown);
		
		//Get all the value into list
		List<WebElement> allListOption=select.getOptions();
		return allListOption;
	}
	
	//Function which will take list of web element as a input and print the list
	public static void printListOption(List<WebElement> data) throws InterruptedException
	{
		try {
			if(data.size()==0)
			{
				return;
			}
			else {
				for(int i=0; i<data.size(); i++)
				{
					String options = data.get(i).getText();
					System.out.println("Values from list are:===========>"+options);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		PrintAllDropDownValue pd = new PrintAllDropDownValue();
        List<WebElement> outputData=pd.getAllDropDownValue();
        if(outputData.size()!=0)
        {
        	PrintAllDropDownValue.printListOption(outputData);
        }
	}
}
