package com.selenium.utilities;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting
{
	ExtentReports extentreports;
	ExtentTest test;
	@BeforeTest
	public void beforeTest() {
		String filepath=System.getProperty("user.dir")+"\\reports\\testReport.html";
		File file=new File(filepath);
		
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(file);
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setDocumentTitle("Document report title");
		
		extentreports=new ExtentReports();
		extentreports.attachReporter(htmlreport);
		extentreports.setSystemInfo("Suresh", "QA");
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		 test= extentreports.createTest(method.getName());
	}
	@Test
	public void testMethod1() {
		
		 test.log(Status.PASS, "login sucessfull");
		 test.log(Status.PASS, "launching sucessfull");
		 
	}
	@Test
	public void testMethod2() {
		
		 test.log(Status.PASS, "login1 sucessfull");
		 test.log(Status.PASS, "launching1 sucessfull");
		 
	}
	@AfterTest
	public void aftreTest() {
		 extentreports.flush();
	}
}
