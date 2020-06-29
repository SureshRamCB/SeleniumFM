package com.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver  idriver;
	public LoginPage(WebDriver rdriver) {
		idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "txtUsername")
	WebElement txtusername;
	
	@FindBy(id = "txtPassword")
	WebElement txtpassword;
	
	@FindBy(id = "btnLogin")
	WebElement btnLogin;
	
	public void setUserName(String username) {
		txtusername.sendKeys(username);
	}
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void clickOnLogin() {
		btnLogin.click();
	}
}
