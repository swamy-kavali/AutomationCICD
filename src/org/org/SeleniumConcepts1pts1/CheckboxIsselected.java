package org.org.SeleniumConcepts1pts1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxIsselected {
  @Test
  public void setup() throws IOException {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	  driver.manage().deleteAllCookies();
	  driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
	  driver.manage().window().getSize();
	  driver.manage().window().maximize();
	WebElement ele = driver.findElement(By.xpath("//*[@value=\"red\"]"));
	boolean selected = ele.isSelected();
	File file = ele.getScreenshotAs(OutputType.FILE);
	File location = new File(".//Demo/Screenshots//pagescreen.png");
	FileUtils.copyFile(file, location);
	if(ele.isSelected()) {
	System.out.println("is not selected"+selected);
	  
  }else {
	  ele.click();
	  System.out.println("is selected"+selected);
}}}
