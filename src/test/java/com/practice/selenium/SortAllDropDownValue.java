package com.practice.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortAllDropDownValue {
	
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
	
	//Function which will take list of web element as a input and sort the list
	
	public static void getSortedList(List<WebElement> input) throws InterruptedException
	{
		for(int i=0; i<input.size(); i++)
		{
			String options = input.get(i).getText();
			System.out.println("Values from list before sort are:===========>"+options);
		}
		
		List<String> arrList = new ArrayList<String>();
		for(int i=0; i<input.size(); i++)
		{
			arrList.add(input.get(i).getText());
		}
	
		//Sort the list using collection class
		Collections.sort(arrList);
		
		//Print the list
		System.out.println("Values from list after sorting are:======>");
		for(int i=0; i<arrList.size(); i++)
		{
			System.out.print(arrList.get(i) + " ");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		SortAllDropDownValue sd = new SortAllDropDownValue();
        List<WebElement> outPut=sd.getAllDropDownValue();
        if(outPut.size()!=0)
        {
        	SortAllDropDownValue.getSortedList(outPut);
        }
	}
}
