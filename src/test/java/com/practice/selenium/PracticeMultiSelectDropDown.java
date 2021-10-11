package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeMultiSelectDropDown {
	
	public static WebDriver driver;
	
	public void testDropDownWithMultiSelect() throws InterruptedException
	{
		String url="https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		WebElement ele = driver.findElement(By.name("States"));
		Select select = new Select(ele);
		
		//Perform action 
		select.selectByIndex(4);
		
		select.selectByValue("New York");
		
		select.selectByVisibleText("New Jersey");
		
		Thread.sleep(3000);
		select.deselectByIndex(4);
		
		//Now get all selected element
		List<WebElement> allSelected=select.getAllSelectedOptions();
		for(int i=0; i<allSelected.size(); i++)
		{
			System.out.println("Selected Values are:=======>" +allSelected.get(i).getText());
		}
		
		//Now get all the options from drop down
		List<WebElement>allOptions=select.getOptions();
		for(WebElement e: allOptions)
		{
			System.out.println("All Values from list are:=========>"+e.getText());
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		PracticeMultiSelectDropDown pd = new PracticeMultiSelectDropDown();
        pd.testDropDownWithMultiSelect();
	}
}
