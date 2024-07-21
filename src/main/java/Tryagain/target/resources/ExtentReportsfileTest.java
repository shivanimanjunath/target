package Tryagain.target.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsfileTest {

	public static ExtentReports Extentmethod()
	{
		String filepath= System.getProperty("user.dir")+"\\reports\\newport.html";
		ExtentSparkReporter es= new ExtentSparkReporter(filepath);
		es.config().setReportName("Automation Results");
		es.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(es);
		extent.setSystemInfo("Tester", "Shivani");
		
		return extent;
		
	}
}
