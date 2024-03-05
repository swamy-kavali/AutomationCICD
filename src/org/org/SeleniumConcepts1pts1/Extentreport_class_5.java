package org.org.SeleniumConcepts1pts1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport_class_5 {

	public static void main(String[] args) throws IOException {
	
	ExtentReports ext = new ExtentReports();
	ExtentSparkReporter ExtSpark = new ExtentSparkReporter("report.html");
	ext.attachReporter(ExtSpark);
	ext.createTest("swamy")
	.log(Status.FAIL,"<b>test case is failed>/b>")// test will come in bold
	.log(Status.SKIP, "Test case is skipped")
	.log(Status.WARNING, "Test case giving warning")
	.log(Status.PASS, "<i>Test case is passed</i>")// test will come in italic
	.log(Status.INFO, "<b><i>This is not a correcttest case</b></i>");// Bold and italic
	ext.flush();
	Desktop.getDesktop().browse(new File("report.html").toURI());
	
	
	
	}

}
