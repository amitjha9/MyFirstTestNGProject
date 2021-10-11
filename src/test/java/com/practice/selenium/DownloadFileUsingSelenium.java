package com.practice.selenium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFileUsingSelenium {

	public static WebDriver driver;
	File folder;

	public void downloadFile()
	{
		try {
			folder=new File(UUID.randomUUID().toString());
			folder.mkdir();

			String url="https://www.browserstack.com/test-on-the-right-mobile-devices";
			WebDriverManager.chromedriver().setup();

			//Chrome Options
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popus", 0);
			prefs.put("download.default_directory", folder.getAbsolutePath());

			options.setExperimentalOption("prefs", prefs);
			DesiredCapabilities dsc = DesiredCapabilities.chrome();
			dsc.setCapability(ChromeOptions.CAPABILITY, options);

			driver=new ChromeDriver(dsc);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
			
			driver.findElement(By.xpath("//button[contains(text(),'Accept All')]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,350)", "");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@target='_blank' and @class='icon-csv']")).click();
			Thread.sleep(5000);

			File getList[]=folder.listFiles();
			if(getList.length>0)
			{
				System.out.println("File downloaded successfully");
			}

			driver.quit();
			for(File file:folder.listFiles())
			{
				file.delete();
			}
			folder.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) {

		DownloadFileUsingSelenium dfs = new DownloadFileUsingSelenium();
		dfs.downloadFile();
	}
}
