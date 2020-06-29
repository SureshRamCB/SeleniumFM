package com.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.selenium.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseUrl=readconfig.getApplicationUrl();
	public String userName=readconfig.getUserName();
	public String passWord=readconfig.getPassword();
	public static WebDriver driver;
	Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	
	public void setUp(String browser) {
		
		logger=Logger.getLogger("Selenium");
		PropertyConfigurator.configure("log4j.properties");
		
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		default:
			Assert.assertTrue(false,"Given "+browser+"is invalid.browser not launched");
			logger.info("Give browser is invalid");
			break;
		}
		logger.info("Browser launched");
		
		driver.get(baseUrl);
		logger.info("Application launched sucessfully");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(readconfig.IMPLICIT_TIME_OUT,TimeUnit.SECONDS);
	
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
