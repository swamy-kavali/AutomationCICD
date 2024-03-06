package org.org.SeleniumConcepts1pts1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteCookies {
  @Test
  public void cookies() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20, 0));
   //adding new line for git modify
	  driver.get("https://google.com");
	  driver.manage().window().maximize();
	  //driver.manage().deleteCookieNamed("NID");
	  driver.manage().deleteAllCookies();
	  Set<Cookie> cookies = driver.manage().getCookies();
	  for (Cookie AllCookies : cookies) {
		System.out.println(AllCookies);
	}
  }
}
