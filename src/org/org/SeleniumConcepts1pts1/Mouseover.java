package org.org.SeleniumConcepts1pts1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mouseover {
	WebDriver driver;
	String url = "https://sellglobal.ebay.in/seller-center/";
	String url2 = "https://demo.guru99.com/test/simple_context_menu.html";
	String url3 = "https://www.globalsqa.com/demo-site/draganddrop/";

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get(url3);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void case1() {
		// over and over
		Actions action = new Actions(driver);
		
		/*
		 * action.moveToElement(driver.findElement(By.
		 * xpath("(//a[text() ='Selling'])[3]"))).perform(); driver.findElement(By.
		 * xpath("(//span[text() ='Setting up your eBay Store'])[3]")).click(); Sy s
		 * System.out.println(driver.getTitle());
		 */
		/*
		 * WebElement ele =
		 * driver.findElement(By.xpath("//span[text()= 'right click me']"));
		 * //ele.sendKeys(Keys.ARROW_RIGHT). action.contextClick(ele).perform();
		 * driver.findElement(By.xpath("//span[text()= 'Edit']")).click(); Alert alt =
		 * driver.switchTo().alert(); System.out.println(alt.getText()); alt.accept();
		 */
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"demo-frame lazyloaded\"]")));
		WebElement source =  driver.findElement(By.xpath(" //div[@class=\"ui-widget ui-helper-clearfix\"]//ul/li[2]"));
		
			WebElement destination = driver.findElement(By.xpath(" //div[@id=\"trash\"]"));
			action.dragAndDrop( source, destination).build().perform();
		}
		//WebElement source = driver.findElement(By.xpath("  //div[@class=\"ui-widget ui-helper-clearfix\"]//ul/li[2]"));
		
		
}
