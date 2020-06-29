package com.selenium.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pageObjects.LoginPage;


public class Tc_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		
		logger.info("Url is opend");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Enterd User name");
		
		lp.setpassword(passWord);
		logger.info("Enterd password");
		
		lp.clickOnLogin();
		logger.info("clicked on login Button");
		
		if(driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			logger.info("login test passed and Title verefied");
			
		}else {
			Assert.assertTrue(false);
			logger.info("login failed");
			
		}
	}

}
