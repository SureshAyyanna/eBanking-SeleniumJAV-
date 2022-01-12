package com.ans.Banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ans.Banking.pageObjects.LoginPage;

public class LoginTest_001 extends TestBase{

	
	@Test
	public void LoginValidUSer() throws IOException {
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		//logger.info("USername is entered");
		
		lp.setPassword(password);
	//	logger.info("Password is entered");
		
		lp.clickOnLoginBtn();
		//logger.info("Clicked on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			//logger.info("Titles matched");
		}
		else
			captureScreenshot(driver, " LoginValidUser");
			Assert.assertTrue(false);
		//logger.info("Title not matched - Failed");
		}
}
