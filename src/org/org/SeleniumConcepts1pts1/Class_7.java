package org.org.SeleniumConcepts1pts1;

import static org.testng.Assert.fail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Class_7 {
	
	public static void main(String[] args) throws IOException {
		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
		extReport.attachReporter(spark);
		extReport.createTest("test1","differeant attributes")
		.assignAuthor("swamy")
		.assignCategory("smoke")
		.assignDevice("chrom 121")
		.pass("suscessfully executed");
		
		
		extReport.createTest("test2","differeant attributes")
		.assignAuthor("hasini")
		.assignCategory("regression")
		.assignDevice("chrom 121")
		.fail("test case failed");
		extReport.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
