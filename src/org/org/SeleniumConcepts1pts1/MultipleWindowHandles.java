package org.org.SeleniumConcepts1pts1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandles {
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";
  @BeforeMethod
  public void setup() {
	  
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get(url);
	  //driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	  driver.manage().window().maximize();
  }
  @Test
  public void case1() {
	//adding new line for jenkins build run
        //for jenkins 
	 driver.findElement(By.xpath("//button[@id=\"newWindowsBtn\"]")).click();
	 String mainWindow = driver.getWindowHandle();
	 System.out.println("main window id: "+mainWindow);
	 Set<String>  windows = driver.getWindowHandles();
	 System.out.println("multiple window id: "+windows);
	 for (String multipleHandle : windows) {
		 System.out.println(multipleHandle);
		System.out.println("get multiple title: "+driver.getTitle());
		if (!multipleHandle.equals(mainWindow)) {
			driver.switchTo().window(multipleHandle);
			driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("hello");
			driver.close();
		}
	 }
			driver.switchTo().window(mainWindow);
			driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("how are you");
		
	
	  
  }
  @AfterMethod
  public void tearDown() {
	  driver.close();
  }
}
