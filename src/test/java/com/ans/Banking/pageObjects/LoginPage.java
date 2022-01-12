package com.ans.Banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Create driver object
	WebDriver driver;
	
	//write constructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(xpath ="//input[@name='uid']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement pasword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement LoginButton;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement ResetButton;
	
	
    //Action Methods
	public void setUsername(String uname) {
		userName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		pasword.sendKeys(pswd);
	}
	
	public void clickOnLoginBtn() {
		LoginButton.click();
	}
	
	public void clickOnResetBtn() {
		ResetButton.click();
	}
}