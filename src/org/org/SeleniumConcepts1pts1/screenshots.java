package org.org.SeleniumConcepts1pts1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshots {
	@Test
	public void launch() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		/*
		 * TakesScreenshot screenshot = (TakesScreenshot)driver; 
		 * File
		 * src=screenshot.getScreenshotAs(OutputType.FILE); File location = new
		 * File(".\\Screenshots.png"); FileUtils.copyFile(src, location) ;
		 */
		WebElement ele = driver.findElement(By.xpath("//form[@id = 'u_0_2_p3']"));
		//TakesScreenshot sc = (TakesScreenshot)driver;
		File src =ele.getScreenshotAs(OutputType.FILE);
		File location = new File("//.Screenshots//sectionSC.png");
		FileUtils.copyFile(src, location);
		

	}
}
