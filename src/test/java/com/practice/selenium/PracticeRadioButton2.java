package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeRadioButton2 {
	
	public static WebDriver driver;
	
	public void testRadioButton() throws InterruptedException
	{
		String url="https://www.seleniumeasy.com/test/basic-radiobutton-demo.html";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		boolean flag=false;
		WebElement getValue;
		String verifyText="";
		String value="";
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
		int size = radioButton.size(); 
		System.out.println("Total size is:" +size);
		
		//Get value from list and print the list
		for(int i=0; i<size; i++)
		{
			value=radioButton.get(i).getAttribute("value");
			System.out.println("Values are:===========>"+value);
		}
		
		for(int i=0; i<size; i++)
		{
			WebElement local_radio = radioButton.get(i);
			if(local_radio.isEnabled())
			{
				value = local_radio.getAttribute("value");
				if(value.equals("Male"))
				{
					local_radio.click();
					System.out.println("Radion button selected");
					getValue=driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
					getValue.click();
					verifyText=driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
					System.out.println("Verification text is:" +verifyText);
					flag=true;
				}
				
			}
		}
		
		if(flag==true && verifyText.equals("Sex : '"+value+"'"))
		{
			System.out.println("Test has passed successfully");
		}
		else {
			System.out.println("Test has failed, PLease check");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		PracticeRadioButton2 prb = new PracticeRadioButton2();
		prb.testRadioButton();
	}
}
