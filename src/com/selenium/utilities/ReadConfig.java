package com.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File scr=new File("./configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(scr);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	public String getUserName() {
		String username=pro.getProperty("userName");
		return username;
	}
	public  String getPassword() {
		String password=pro.getProperty("passWord");
		return password;
	}
	
	public final int IMPLICIT_TIME_OUT=20;

}

