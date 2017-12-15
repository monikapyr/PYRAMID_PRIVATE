package com.docker;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class docker {

	public static void main(String args[]) throws IOException {

		Capabilities chromeCapabilities = DesiredCapabilities.chrome();
		Capabilities firefoxCapabilities = DesiredCapabilities.firefox();

		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), chromeCapabilities);
		WebDriver firefox = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), firefoxCapabilities);
		//WebDriver firefox1 = new RemoteWebDriver(new URL("http://192.168.99.100:32768/wd/hub"), firefoxCapabilities);

		TakesScreenshot scrShot =((TakesScreenshot)driver);

		driver.get("https://www.codechef.com/");

		System.out.println(driver.getTitle());

		driver.findElement(By.id("edit-name")).clear();
		File SrcFile1=scrShot.getScreenshotAs(OutputType.FILE);
		driver.findElement(By.id("edit-name")).sendKeys("asd");
		driver.findElement(By.id("edit-pass")).clear();
		File SrcFile2=scrShot.getScreenshotAs(OutputType.FILE);
		driver.findElement(By.id("edit-pass")).sendKeys("zxc");
		File SrcFile3=scrShot.getScreenshotAs(OutputType.FILE);
		driver.findElement(By.id("edit-submit")).click();

		File DestFile1=new File("E://test1.png");
		File DestFile2=new File("E://test2.png");
		File DestFile3=new File("E://test3.png");
		//Copy file at destination

		FileUtils.copyFile(SrcFile1, DestFile1);
		FileUtils.copyFile(SrcFile2, DestFile2);
		FileUtils.copyFile(SrcFile3, DestFile3);


		// run against firefox
		TakesScreenshot scrShot1 =((TakesScreenshot)firefox);
		firefox.get("https://www.google.com");
		File SrcFile4=scrShot1.getScreenshotAs(OutputType.FILE);
		//File DestFile4=new File("E://test4.png");
		File DestFile4=new File("/.docker//machine//cache//test4.png");
		FileUtils.copyFile(SrcFile4, DestFile4);			
		System.out.println(firefox.getTitle());
		
		firefox.quit();
	}
}