package org.org.SeleniumConcepts1pts1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport_screenshot {
	static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.manage().window().maximize();
	}
  @Test
  public void extentReport() throws IOException {
	  ExtentReports extReport = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
	  extReport.attachReporter(spark);
	  String path = screenshot("google.png");
	  String base64 =screenshot();
	  extReport.createTest("normal screenshot")
	  .addScreenCaptureFromPath(path, "google picture");
	  extReport.createTest("base64 screenshot")
	  .addScreenCaptureFromBase64String(base64, "google base64");
	  extReport.flush();
	  Desktop.getDesktop().browse(new File("report.htms").toURI());	  
  }
  @Test
 public static String screenshot(String path) throws IOException {
	  TakesScreenshot screenshot=(TakesScreenshot)driver;
	  File src = screenshot.getScreenshotAs(OutputType.FILE);
	  File Dest = new File("./screenshots"+path);
	  FileUtils.copyFile(src, Dest);
	  return Dest.getAbsolutePath();	  
  }
  @Test
  public static String screenshot() throws IOException {
 	  TakesScreenshot screenshot=(TakesScreenshot)driver;
 	  String Base64 = screenshot.getScreenshotAs(OutputType.BASE64);
 	 System.out.println("screenshot sucessfully captured");
 	  return Base64;
   }
}
