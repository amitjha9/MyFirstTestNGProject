package com.practice.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	
	public static WebDriver driver;
	
	public void explicitWait() throws InterruptedException
	{
		String url="https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(url);
		
		//For Alert validation
		String actualText="I got opened after 5 secods";
		WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'Click me, to Open an alert after 5 seconds')]"));
		ele.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		String getText=driver.switchTo().alert().getText();
		System.out.println("Alert text is:" +getText);
		
		//If the alert present then accept the alert
		if(getText.equals(actualText))
		{
			driver.switchTo().alert().accept();
			System.out.println("Test has passed successfully");
		}
		else {
			System.out.println("Test has failed");
		}
		
		//For get text validation
		WebElement ele1 = driver.findElement(By.xpath("//button[contains(text(),'Change Text to Selenium Webdriver')]"));
		ele1.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 12);
		WebElement text=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Selenium Webdriver')]")));
		
		if(text.isDisplayed())
		{
			System.out.println("Updated text is:" +text.getText());
		}
		
		//For Button validation
		boolean flag=false;
		WebElement ele2 = driver.findElement(By.xpath("//button[contains(text(),'Display button after 10 seconds')]"));
		ele2.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 12);
		WebElement button=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Enabled')]")));
		
		if(button.isDisplayed())
		{
			flag=true;
			System.out.println("Button got enabled");
		}
		
		if(flag)
		{
			System.out.println("Test has passed successfully");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		
		ExplicitWait exp = new ExplicitWait();
		exp.explicitWait();
	}
}
