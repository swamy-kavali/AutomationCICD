package org.org.SeleniumConcepts1pts1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Calender {
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/calendar-practice.html";
	String url2 = "https://ewclaims-uat.tataaig.com/login";
	int day = 31;

	@BeforeMethod
	public void setUP() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void test2() {
		driver.findElement(By.xpath("//input[@id=\"second_date_picker\"]")).click();
		WebElement ele = driver
				.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td[not(contains(@class, 'ui-datepicker-other-month'))]/a[text()="+day+"]"));
		ele.click();

	}

	@Test(priority = 1)
	public void test1() {
		driver.findElement(By.xpath("//input[@id= \"first_date_picker\"]")).click();
		WebElement ele = driver
				.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//a[text()=" + day + "]"));
		ele.click();
		System.out.println(ele.getText());
	}

}
