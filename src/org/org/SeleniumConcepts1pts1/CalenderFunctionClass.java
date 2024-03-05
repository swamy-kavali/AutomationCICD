package org.org.SeleniumConcepts1pts1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderFunctionClass {

	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/calendar-practice.html";

	@BeforeMethod
	public void setUP() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void test1() throws Exception {
		String date = "28/june/2025";
		Calendar calender = Calendar.getInstance();
		Date formatedTargetDate;
		try {
			SimpleDateFormat targetDateFormate = new SimpleDateFormat("dd/MMM/yyyy");
			targetDateFormate.setLenient(false);
			formatedTargetDate = targetDateFormate.parse(date);
		} catch (Exception e) {
			throw new Exception("enter valid date");
		}
		System.out.println(formatedTargetDate);
		calender.setTime(formatedTargetDate);
		int targetMonth = calender.get(calender.MONTH);
		int targetYear = calender.get(calender.YEAR);
		driver.findElement(By.id("first_date_picker")).click();
		// January 2024
		String curentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(curentDate);
		calender.setTime(new SimpleDateFormat("MMM yyyy").parse(curentDate));
		int currentMonth = calender.get(calender.MONTH);
		int currentYear = calender.get(calender.YEAR);
		while (currentMonth < targetMonth || currentYear < targetYear) {
			driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-header')]//a[2]")).click();
			curentDate = driver.findElement(By.className("ui-datepicker-title")).getText();
			//System.out.println(curentDate);
			calender.setTime(new SimpleDateFormat("MMM yyyy").parse(curentDate));
			currentMonth = calender.get(calender.MONTH);
			currentYear = calender.get(calender.YEAR);
		}
		if(currentMonth==targetMonth && currentYear==targetYear) {
			driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//a[text()='1']")).click();
		}else 
			throw new Exception("Enter the valid date");		
	}
}
