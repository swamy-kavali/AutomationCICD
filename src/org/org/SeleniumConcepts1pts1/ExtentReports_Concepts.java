package org.org.SeleniumConcepts1pts1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports_Concepts {
  @Test
  public void setUp() throws IOException {
	  
	  ExtentReports extReport = new ExtentReports();
	  ExtentSparkReporter sparkreport = new ExtentSparkReporter("C:\\Users\\User\\eclipse-workspace\\Demo\\report.html");// No need to give absolute path,directly give "report.html"
	  extReport.attachReporter(sparkreport);
	  extReport.createTest("test 1").pass("test case is passed");
	  extReport.createTest("test 2").log(Status.FAIL, "test case is failed");
	  extReport.createTest("test 3").skip("test case intensionally skipped");
	  extReport.flush();
	  Desktop.getDesktop().browse(new File("report.html").toURI());
	  
  }
}
