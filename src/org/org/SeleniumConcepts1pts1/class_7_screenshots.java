package org.org.SeleniumConcepts1pts1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class class_7_screenshots {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		ChromeOptions chromoptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chromoptions);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("report.html");
		extReport.attachReporter(extSpark);
		String base64 = captureScreenshot();
		String path = captureScreenshot("google.png");
		extReport.createTest("test case1","this is screenshot for google")
		.info("info message")
		.addScreenCaptureFromPath(path);
		extReport.createTest("test case1","this is screenshot for google")
		.info("info message")
		.addScreenCaptureFromBase64String(base64);
		driver.close();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	public static String captureScreenshot() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		String Base64 = screenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("screenshot sucessfully taken");
		return Base64;	
	}

	public static String captureScreenshot(String filepath) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots"+filepath);
		FileUtils.copyFile(srcFile, destFile);
		return destFile.getAbsolutePath();	

	}

}
