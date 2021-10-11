package com.testNG.parameters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountWithTestNGParam {

	public static WebDriver driver;

	@BeforeMethod
	@Parameters({"url"})
	public void setUP(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test
	@Parameters({"fname","lname","email","mbno","subject"})
	public void createAccount(String firstName,String lastName,String emailID,String mobile,String subject)
	{
		driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys(emailID);
       
		List<WebElement> radio = driver.findElements(By.name("gender"));
		int size=radio.size();
		for(int i=0; i<size; i++)
		{
			String val=radio.get(i).getAttribute("value");
			System.out.println("Value is:" +val);
			if(val.equalsIgnoreCase("Male"))
			{
				System.out.println(radio.get(i));
				radio.get(i).click();
				break;	
			}
		}
	}

	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
