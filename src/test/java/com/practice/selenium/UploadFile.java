package com.practice.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	
	public static WebDriver driver;
	
	public void uploadFile()
	{
		try {
			String url="http://demo.guru99.com/test/upload/";
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
			
			WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
			chooseFile.sendKeys("C:\\Users\\ajha\\Desktop\\Task.txt");
			
			boolean flag = false;
			String fileName="Task.txt";
			String expectedValue=driver.findElement(By.xpath("//input[@type='file']")).getAttribute("value");
			Thread.sleep(5000);
			if(expectedValue.equals(fileName))
			{
				flag=true;
			}
			
			if(flag)
			{
				System.out.println("File uploaded successfully");
			}
			else {
				System.out.println("File not uploaded");
			}
			
			driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		UploadFile uploadFile = new UploadFile();
        uploadFile.uploadFile();
	}

}
