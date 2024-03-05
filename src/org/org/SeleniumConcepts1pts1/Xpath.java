package org.org.SeleniumConcepts1pts1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Xpath {
  @Test
  public void setUp() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.facebook.com/");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.resizeTo(1000,250)");
	  //driver.manage().window().maximize(); 
	  js.executeScript("document.getElementById('email').value='swamy'"); 
	  WebElement ele = (WebElement) js.executeScript("return document.getElementById('email')");
	  ele.clear();
	  ele.sendKeys("hello");
	  //driver.close();
	  
  }
}
