package com.practice.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeRadioButton1 {

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

		boolean flag=false;
		String val="";
		String verifyOutput="";
		WebElement getCheckedValue;
		WebElement verifyText;
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio' and @name='optradio']"));
		int size = radioButton.size();
		System.out.println("Total button are==>" +size);

		//Now print the value
		for(int i=0; i<size; i++)
		{
			String value = radioButton.get(i).getAttribute("value");
			System.out.println("Values are:======>"+value);
		}

		//Now select the radio button
		for(int i=0; i<size; i++)
		{
			WebElement local_radio = radioButton.get(i);
			if(local_radio.isEnabled()) {
				val = local_radio.getAttribute("value");
				if(val.equals("Female"))
				{
					local_radio.click();
					System.out.println("Radio button selected");
					getCheckedValue=driver.findElement(By.xpath("//button[contains(text(),'Get Checked value')]"));
					getCheckedValue.click();
					verifyText=driver.findElement(By.xpath("//p[@class='radiobutton']"));
					verifyOutput=verifyText.getText();
					System.out.println("Verify Output Text is:" +verifyOutput);
					flag=true;
				}
			}
		}
		
		//Check if the test has passed or failed
		if(flag && verifyOutput.equals("Radio button '"+val+"' is checked"))
		{
			System.out.println("Test has passed successfully");
		}
		else {
			System.out.println("Test failed, Please check error log");
		}

		Thread.sleep(3000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		PracticeRadioButton1 rb = new PracticeRadioButton1();
		rb.testRadioButton();
	}

}
