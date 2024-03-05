package org.org.SeleniumConcepts1pts1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*text -- Bold, italic
Html, Json
list, map and set
higlighed 
exception
*/
public class Extentreport_JSON_HTML {
	public static void main(String[] args) throws IOException {
		ExtentReports ext = new ExtentReports();
		ExtentSparkReporter extSparker = new ExtentSparkReporter("report.html");
		ext.attachReporter(extSparker);
		String HtmlData = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		String JsonData = "{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";

		/*
		 * ext.createTest("Html") .pass(HtmlData); ext.createTest("Json")
		 * .info(JsonData);
		 */
		ext.createTest("Html")
		.pass(MarkupHelper.createCodeBlock(HtmlData, CodeLanguage.XML));
		ext.createTest("Json")
		.log(Status.INFO, MarkupHelper.createCodeBlock(JsonData, CodeLanguage.JSON));
		/*
		 * List<String> list = new ArrayList<>(); list.add("swamy"); list.add("kavali");
		 * list.add("riya");
		 */
		Map<Integer, String> map = new HashMap<>();
		map.put(101, "swamy");
		map.put(102, "kavali");
		map.put(103, "riya");
		Set<Integer> set = map.keySet();
		/*
		 * ext.createTest("List") .info(MarkupHelper.createOrderedList(list))
		 * .info(MarkupHelper.createUnorderedList(list));
		 */
		ext.createTest("Map")
		.info(MarkupHelper.createOrderedList(map))
		.info(MarkupHelper.createUnorderedList(map));
		ext.createTest("set")
		.info(MarkupHelper.createOrderedList(set))
		.info(MarkupHelper.createUnorderedList(set));
		ext.createTest("highlight the test case")
		.info(MarkupHelper.createLabel("hello how are you", ExtentColor.GREEN));
		try {
			int a = 5/0;
		} catch (Exception e) {
			ext.createTest("exception logs")
			.info(e);
		}
		Throwable t = new RuntimeException("customised exception");
		ext.createTest("exception handling").info(t);
		ext.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
